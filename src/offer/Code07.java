package com.zju.newcode;

/**
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
 * @author LIN
 *
 */
public class Code07 {
	//�ݹ�汾
	 public int Fibonacci(int n) {
		 if(n<=0) {
			 return 0;
		 }
	     if(n<3) {
	    	 return 1;
	     }
	     return Fibonacci(n-1)+Fibonacci(n-2);
	 }
	 //��̬�滮�汾
	 public int Fibonacci2(int n) {
	     int[] dp = new int[n+1];
		 dp[0] = 0;
		 int index = 1;
		 while(index<3 && index<=n) {
			 dp[index++] = 1;
		 }
		 for(int i=3;i<=n;i++) {
			 dp[i] = dp[i-1]+dp[i-2];
		 }
		return dp[n];
	 }
	 
	 public static void main(String[] args) {
		Code07 c = new Code07();
		//System.out.println(c.Fibonacci(39));
		System.out.println(c.Fibonacci2(2));
	}
}
