package com.zju.newcode;

/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * @author LIN
 *
 */
public class Code08 {
	//�ݹ�汾
	public int JumpFloor(int target) {
		if(target<=0) {
			return 0;
		}
		if(target<3) {
			return target;
		}
		return JumpFloor(target-1)+JumpFloor(target-2);
    }
	//��̬�滮
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
