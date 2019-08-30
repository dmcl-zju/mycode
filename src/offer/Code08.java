package com.zju.newcode;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author LIN
 *
 */
public class Code08 {
	//递归版本
	public int JumpFloor(int target) {
		if(target<=0) {
			return 0;
		}
		if(target<3) {
			return target;
		}
		return JumpFloor(target-1)+JumpFloor(target-2);
    }
	//动态规划
	public int JumpFloor2(int target) {
		int[] dp = new int[target+1];
		dp[0] = 0;
		int index=1;
		while(index<3 && index<=target) {
			dp[index] = index++;
		}
		for(int i=3;i<=target;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[target];
    }
	public static void main(String[] args) {
		Code08 code = new Code08();
		System.out.println(code.JumpFloor2(3));
	}
}
