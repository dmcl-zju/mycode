package class07;

import java.util.PriorityQueue;

/**
 * 切金条问题-----典型的哈夫曼编码问题
 * @author LIN
 *
 */
public class MyLessMoney {
	
	public static int lessMoney(int[] arr) {
		if(arr==null || arr.length<2) {
			return 0;
		}
		//默认情况是小根堆
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			queue.add(arr[i]);
		}
		int res = 0;
		int cur = 0;
		while(queue.size()>1) {
			//先从小根堆中取出两个
			 cur = queue.poll()+queue.poll();
			 res += cur;
			//将结果放回小根堆中
			queue.add(cur);
		}
		return res;
	}
	
	public static int lessMoney1(int[] arr) {
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			pQ.add(arr[i]);
		}
		int sum = 0;
		int cur = 0;
		while (pQ.size() > 1) {
			cur = pQ.poll() + pQ.poll();
			sum += cur;
			pQ.add(cur);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] arr = {10,20,30};
		System.out.println(lessMoney(arr));
	}
}
