package com.zju.newcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 	����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * 	������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * @author LIN
 *
 */


public class Code32 {
	
	 //̰���㷨����
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
