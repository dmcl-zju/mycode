package com.zju.newcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 	�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * 	����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ�������
 * 	 �����P%1000000007
 * @author LIN
 *
 */
public class Code35 {
	
	//�����������ù鲢����
	public int InversePairs(int [] array) {
		if(null==array || array.length<2) {
			return 0;
		}
		
		return (int) (process(array,0,array.length-1)%1000000007);
    }
	
	//�ݹ鴦��
	public long process(int[] array,int left,int right) {
		if(left==right) {
			return 0;
		}
		int mid = (left+right)/2;
		//����벿�ֵ������
		long lcount = process(array,left,mid);
		//���Ұ벿�ֵ������
		long rcount = process(array,mid+1,right);
		//��������ϲ���������
		long mcount = merge(array,left,mid,right);
		return lcount+rcount+mcount;
	}
	//��������
	public long merge(int[] array,int left,int mid,int right) {
		int[] help = new int[right-left+1];
		int index = 0;
		int lindex = left;
		int rindex = mid+1;
		long count = 0;
		while(lindex<=mid && rindex<=right) {
			if(array[lindex]<=array[rindex]) {
				help[index++] = array[rindex++];
			}else {
				count += (right-rindex+1);
				help[index++] = array[lindex++];
			}
		}
		while(lindex<=mid) {
			help[index++] = array[lindex++];
		}
		
		while(rindex<=right) {
			help[index++] = array[rindex++];
		}
		//�����鿽����ȥ
		for(int i=0;i<help.length;i++) {
			array[left+i] = help[i];
		}
		return count;
	}
	
	public static void main(String[] args) {

		Code35 code = new Code35();
		int[] arr = {1,2,3,4,5,6,7,0};
		int res = code.InversePairs(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println("����ԣ�"+res);
		res = code.InversePairs(arr);
		System.out.println("����ԣ�"+res);
		
		
	}
	
}
