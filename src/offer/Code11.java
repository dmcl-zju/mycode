package com.zju.newcode;
/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * @author LIN
 *
 */
public class Code11 {
	
	//�ⷨ1:����һ������flag����ʼֵΪ������������ƶ�һλ��ԭ���Ķ����ȣ������flag�е�1�Ƴ���ȥ��ͻ���0
	//ע�ⲻ�ܰ�ԭ������n������Ȼ���1�룬��Ϊ�ڸ������������ǲ�1��
	public int NumberOf(int n) {
		int count = 0;
		int flag = 1;
		while(flag!=0) {
			if((flag & n)!=0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
    }
	//˼·2�����ӣ�https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8
	//���һ��������Ϊ0����ô�������������һλ��1��������ǰ����������1����ôԭ�������������ұߵ�1�ͻ��Ϊ0��
	//ԭ����1��������е�0������1(������ұߵ�1���滹��0�Ļ�)����������λ�������ܵ�Ӱ�졣
	public int NumberOf2(int n) {
		int count = 0;
		while(n!=0) {
			count++;
			n = n&(n-1);
		}
		return count;
    }
	public static void main(String[] args) {
		Code11 code = new Code11();
		int res = code.NumberOf(8);
		System.out.println(res);
		System.out.println(code.NumberOf2(8));
	}
}
