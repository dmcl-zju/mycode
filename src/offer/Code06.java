package com.zju.newcode;
/**
 * 
 * @author LIN
 *	��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���Ǽ�����������һ����ת��
 *  �����ת�������СԪ�ء� ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE��
 *  ����������Ԫ�ض�����0���������СΪ0���뷵��0��
 */
public class Code06 {
	public int minNumberInRotateArray(int [] array) {
		if(null==array || array.length==0) {
			return 0;
		}
		int left = 0;
		int right = array.length -1;
		int mid = 0;
		while(left<right) {
			if(left+1==right) {
				break;
			}
			mid = (right+left)/2;
			if(array[mid]>=array[left]) {
				left = mid;
			}else {
				right = mid;
			}
		}
		return array[right];
    }
}
