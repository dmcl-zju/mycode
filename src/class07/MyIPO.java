package class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *	̰���㷨���������
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

		//�������������
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o2.profit-o1.profit;
		}
		
	}
	
	public static class MinComparator implements Comparator<Node>{

		//�������������
		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.cost-o2.cost;
		}
		
	}
	
	//̰�Ĳ��ԣ�ÿ�������������������Ŀ
	public static int getMaxMoney(int w,int k,int[] cost,int[] profits) {
		if(null==cost || null==profits || cost.length<1 || profits.length<1 || cost.length!=profits.length) {
			return 0;
		}
		//��������С����
		PriorityQueue<Node> costPQ = new PriorityQueue<>(new MinComparator());
		//������������
		PriorityQueue<Node> profitPQ = new PriorityQueue<>(new MaxComparator());
		//��ÿ����Ŀ����������С����
		for(int i=0;i<cost.length;i++) {
			costPQ.add(new Node(cost[i],profits[i]));
		}
		//ģ������Ŀ
		for(int i=0;i<k;i++) {
			//����������Ŀ��������
			while(!costPQ.isEmpty() && costPQ.peek().cost<=w) {
				profitPQ.add(costPQ.poll());
			}
			//�Ӵ������ȡ������������Ŀ����
			if(!profitPQ.isEmpty()) {
				w += profitPQ.poll().profit;
			}else {
				//����Ѿ����˾���ֹ������ѭ��
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
