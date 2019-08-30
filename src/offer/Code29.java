package com.zju.newcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *	 ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * @author LIN
 *
 */
public class Code29 {
	
	public static class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}
		
	}
	/**
	 * 	˼·���ô�����ȱ��������ǰk��������������С��k������Ȼ����������ʣ��Ԫ�أ�
	 * 	����ȶѶ�С�ͽ��Ѷ��������������ѣ�����ȴ��ڵ��ڶѶ�������
	 * @param input
	 * @param k
	 * @return
	 */
	 public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		 ArrayList<Integer> list = new ArrayList<>();
		 if(null==input || input.length==0 || k>input.length || k<1) {
			 return list;
		 }
		 Queue<Integer> q = new PriorityQueue<>(new MyComparator());
		 for(int i=0;i<k;i++) {
			 q.offer(input[i]);
		 }
		 for(int i=k;i<input.length;i++) {
			 if(q.peek()>input[i]) {
				 q.poll();
				 q.offer(input[i]);
			 }
		 }
		 while(!q.isEmpty()) {
			 list.add(q.poll());
		 }
		 return list;
	 }
	/**
	 * 	������Ԫ����С���ѣ�Ȼ�󵯳�k����������С��k����ʱ�临�ӶȲ�
	 * @param input
	 * @param k
	 * @return
	 */
	 public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
		 ArrayList<Integer> list = new ArrayList<>();
		 if(null==input || input.length==0 || k>input.length || k<1) {
			 return list;
		 }
		 Queue<Integer> q = new PriorityQueue<>();
		 for(int i=0;i<input.length;i++) {
			 q.offer(input[i]);
		 }
		 for(int i=0;i<k;i++) {
			 list.add(q.poll());
		 }
		return list;  
	 }
	 
	 public static void main(String[] args) {
		Code29 code = new Code29();
		int[] arr = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> list = code.GetLeastNumbers_Solution(arr, 4);
		for(int i:list) {
			System.out.print(i+" ");
		}
	}
}
