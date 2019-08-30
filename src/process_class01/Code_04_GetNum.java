package process_class01;

import java.util.LinkedList;

/**
 * ��һ������������ֵ��ȥ��СֵС��M��������ĸ���
 * @author lin
 *
 */
public class Code_04_GetNum {
	public static void main(String[] args) {
		int[] arr = {1,3,6};
		System.out.println(getNum(arr, 2));
		System.out.println(getNum2(arr, 2));
	}
	
	private static int getNum(int[] arr,int m) {
		LinkedList<Integer> qmin = new LinkedList<>();
		LinkedList<Integer> qmax = new LinkedList<>();
		
		int res = 0;
		int left = 0;
		int right = 0;
		while(left < arr.length) {
			//�ұ��ܵ���һ�β�����������λ��
			while(right<arr.length) {
				//������
				while(!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[right]) {
					qmin.pollLast();
				}
				while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[right]) {
					qmax.pollLast();
				}
				//����
				qmin.addLast(right);
				qmax.addLast(right);
			
				//�жϵ�ǰ��������Сֵ�ǲ��ǺϷ�
				if(arr[qmax.peekFirst()]-arr[qmin.peekFirst()]>m) {
					break;
				}
				right++;
			}
			
			//���½��---��Ϊright���ںϷ�����һ����λ��
			res += right-left;
			//�����С
			left++;
			//�����������Сֵ
			if(left>qmin.peekFirst()) {
				qmin.pollFirst();
			}
			if(left>qmax.peekFirst()) {
				qmax.pollFirst();
			}
		}
		return res;
	}
	
	//�����ⷨ O(N^3)
	private static int getNum2(int[] arr,int Num) {
		int count = 0;
		//�������������
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(getMaxMin(arr, i, j)<=Num) {
					count++;
				}
			}
		}
		return count;
	}
	private static int getMaxMin(int[] arr,int left,int right) {
		int Min = arr[left];
		int Max = arr[left];
		for(int i=left+1;i<=right;i++) {
			if(arr[i]<Min) {
				Min = arr[i];
			}
			if(arr[i]>Max) {
				Max = arr[i];
			}
		}
		return Max-Min;
	}
	
	
	
}
