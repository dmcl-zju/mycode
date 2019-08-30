package com.zju.newcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 	在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 	输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 	 即输出P%1000000007
 * @author LIN
 *
 */
public class Code35 {
	
	//逆序对问题采用归并来做
	public int InversePairs(int [] array) {
		if(null==array || array.length<2) {
			return 0;
		}
		
		return (int) (process(array,0,array.length-1)%1000000007);
    }
	
	//递归处理
	public long process(int[] array,int left,int right) {
		if(left==right) {
			return 0;
		}
		int mid = (left+right)/2;
		//求左半部分的逆序对
		long lcount = process(array,left,mid);
		//求右半部分的逆序对
		long rcount = process(array,mid+1,right);
		//求出两个合并后的逆序对
		long mcount = merge(array,left,mid,right);
		return lcount+rcount+mcount;
	}
	//进行外排
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
		//将数组拷贝回去
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
		System.out.println("逆序对："+res);
		res = code.InversePairs(arr);
		System.out.println("逆序对："+res);
		
		
	}
	
}
