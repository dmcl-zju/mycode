package com.zju.newcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 	输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 	例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author LIN
 *
 */


public class Code32 {
	
	 //贪心算法来做
	 public String PrintMinNumber(int [] numbers) {
		 if(null==numbers || numbers.length==0) {
			 return "";
		 }
		 Integer[] arr = new Integer[numbers.length];
		 for(int i=0;i<arr.length;i++) {
			 arr[i] = numbers[i];
		 }
		 Arrays.sort(arr,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return (""+o1+o2).compareTo(""+o2+o1);
			}
		 });
		 StringBuilder sb = new StringBuilder();
		 for(int i:arr) {
			 sb.append(String.valueOf(i));
		 }
		return sb.toString();
	 }
	 public static void main(String[] args) {
		Code32 code = new Code32();
		int[] arr = {3,32,321};
		String res = code.PrintMinNumber(arr);
		System.out.println(res);
	}
}
