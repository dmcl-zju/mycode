package class07;

import java.util.PriorityQueue;

/**
 * �н�������-----���͵Ĺ�������������
 * @author LIN
 *
 */
public class MyLessMoney {
	
	public static int lessMoney(int[] arr) {
		if(arr==null || arr.length<2) {
			return 0;
		}
		//Ĭ�������С����
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			queue.add(arr[i]);
		}
		int res = 0;
		int cur = 0;
		while(queue.size()>1) {
			//�ȴ�С������ȡ������
			 cur = queue.poll()+queue.poll();
			 res += cur;
			//������Ż�С������
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
