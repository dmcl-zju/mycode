package class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *	贪心算法求最大利润
 * @author LIN
 *
 */
public class MyIPO {
	
	public static class Node{
		public int cost;
		public int profit;
		
		public Node(int cost,int profit) {
			this.cost = cost;
			this.profit = profit;
		}
		
		
	}
	
	public static class MaxComparator implements Comparator<Node>{

		//以利润最大排序
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o2.profit-o1.profit;
		}
		
	}
	
	public static class MinComparator implements Comparator<Node>{

		//以利润最大排序
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.cost-o2.cost;
		}
		
	}
	
	//贪心策略：每次做能做的利润最大项目
	public static int getMaxMoney(int w,int k,int[] cost,int[] profits) {
		if(null==cost || null==profits || cost.length<1 || profits.length<1 || cost.length!=profits.length) {
			return 0;
		}
		//创建花费小根堆
		PriorityQueue<Node> costPQ = new PriorityQueue<>(new MinComparator());
		//创建利润大根堆
		PriorityQueue<Node> profitPQ = new PriorityQueue<>(new MaxComparator());
		//将每个项目创建并加入小根堆
		for(int i=0;i<cost.length;i++) {
			costPQ.add(new Node(cost[i],profits[i]));
		}
		//模拟做项目
		for(int i=0;i<k;i++) {
			//将能做的项目放入大根堆
			while(!costPQ.isEmpty() && costPQ.peek().cost<=w) {
				profitPQ.add(costPQ.poll());
			}
			//从大根堆中取出利润最大的项目来做
			if(!profitPQ.isEmpty()) {
				w += profitPQ.poll().profit;
			}else {
				//如果已经空了就终止，跳出循环
				break;
			}
		}
		return w;
	}
	
	public static void main(String[] args) {
		int[] cost = {9,8,13};
		int[] profits= {6,7,15};
		int res = getMaxMoney(10, 2, cost, profits);
		System.out.println(res);
	}
}
