package com.zju.newcode;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * @author LIN
 *
 */
public class Code07 {
	//递归版本
	 public int Fibonacci(int n) {
		 if(n<=0) {
			 return 0;
		 }
	     if(n<3) {
	    	 return 1;
	     }
	     return Fibonacci(n-1)+Fibonacci(n-2);
	 }
	 //动态规划版本
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
