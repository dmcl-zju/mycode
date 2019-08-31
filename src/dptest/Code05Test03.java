package dptest;
/**
 * 	换钱的问题3：arr中的元素代表货币，可以取任意张，求组成目标换钱方法数
 * @author LIN
 *
 */
public class Code05Test03 {
	public static void main(String[] args) {
		int[] arr = {5,10,25,1};
		int aim = 33;
		System.out.println(process(arr, arr.length-1, aim));
		System.out.println(dp(arr, aim));
		System.out.println(dp2(arr, aim));
		System.out.println(dp3(arr, aim));
	}
	
	//暴力递归
	private static int process(int[] arr,int index,int aim) {
		
		if(aim==0) {
			return 1;
		}
		if(index==0) {
			return aim%arr[index]==0?1:0;
		}
		
		int res = 0;
		//一般情况,遍历能换的所有可能
		for(int i=0;arr[index]*i<=aim;i++) {
			res += process(arr, index-1, aim-arr[index]*i);
		}
		return res;
	}
	
	//直接动态规划
	private static int dp(int[] arr,int aim) {
		int rows = arr.length;
		int cols = aim+1;
		int[][] dp = new int[rows][cols];
		//第一列都是1
		for(int i=0;i<rows;i++) {
			dp[i][0] = 1;
		}
		//第一行
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[0][j] = 1;
			}
		}
		//一般情况
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				int sum = 0;
				for(int k=0;arr[i]*k<=j;k++) {
					sum += dp[i-1][j-arr[i]*k];
				}
				dp[i][j] = sum;
			}
		}
		return dp[rows-1][cols-1];
	}
	//时间改进
	private static int dp2(int[] arr,int aim) {
		int rows = arr.length;
		int cols = aim+1;
		int[][] dp = new int[rows][cols];
		//第一列都是1
		for(int i=0;i<rows;i++) {
			dp[i][0] = 1;
		}
		//第一行
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[0][j] = 1;
			}
		}
		//一般情况
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				dp[i][j] = dp[i-1][j];
				if(j-arr[i]>=0) {
					dp[i][j] += dp[i][j-arr[i]];
				}
			}
		}
		return dp[rows-1][cols-1];
	}
	//进一步改进空间
	private static int dp3(int[] arr,int aim) {
		int rows = arr.length;
		int cols = aim+1;
		int[] dp = new int[cols];
		//第一列都是1
		dp[0] = 1;
		//第一行
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[j] = 1;
			}
		}
		//一般情况
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				//代表取上一格的值，不用写，这里便于理解
				//dp[j] = dp[j];
				//取左边的格子，为已经更新过后的
				if(j-arr[i]>=0) {
					dp[j] += dp[j-arr[i]];
				}
			}
		}
		return dp[cols-1];
	}
}
