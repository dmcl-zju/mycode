package dptest;

/**
 * 	可换任意张，换钱的最小货币数
 * @author lin
 *
 */
public class Code03Test {
	public static void main(String[] args) {
		int[] arr = {2,3,6};
		int aim = 1001;
		System.out.println(process(arr, 0, aim));
		System.out.println(dp1(arr, aim));
		System.out.println(dp2(arr, aim));
	}
	
	private static int process(int[] arr,int index,int aim) {
		//没有钱可选，若果aim不是0返回最大值表示不能换
		if(index==arr.length) {
			return aim==0?0:Integer.MAX_VALUE;
		}
		//在不超过情况下尝试
		int min = Integer.MAX_VALUE;
		for(int i=0;arr[index]*i<=aim;i++) {
			//自己用了i张
			int cur = process(arr, index+1, aim-arr[index]*i);
			if(cur==Integer.MAX_VALUE) {
				//说明这种方法不行
				continue;
			}
			//说明可以，加入最小值判定
			cur += i;
			min = Math.min(min,cur);
		}
		return min;
	}
	
	//改成动态规划
	private static int dp1(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		int erro = Integer.MAX_VALUE;
		
		//先填最后一行
		for(int j=1;j<=aim;j++) {
			dp[dp.length-1][j] = erro;
		}
		//填第一列，都是0
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		
		//常规情况
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<=aim;j++) {
				
				//多个求最小
				dp[i][j] = erro;
				for(int k=0;arr[i]*k<=j;k++) {
					//不合法
					if(dp[i+1][j-arr[i]*k]==erro) {
						continue;
					}
					//合法的值
					dp[i][j] = Math.min(dp[i][j], k+dp[i+1][j-arr[i]*k]);
				}
					
			}
		}
		return dp[0][aim];
	}
	
	//动态规划的改进
	private static int dp2(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		int erro = Integer.MAX_VALUE;
		
		//先填最后一行
		for(int j=1;j<=aim;j++) {
			dp[dp.length-1][j] = erro;
		}
		//填第一列，都是0
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		
		//常规情况
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<=aim;j++) {
				
				//多个求最小
				dp[i][j] = dp[i+1][j];
				//前一个存在且合法
				if(j-arr[i]>=0 && dp[i][j-arr[i]]!=erro ) {
					//这里的一张指的是当前选了一张
					dp[i][j] = Math.min(dp[i][j], 1+dp[i][j-arr[i]]);
				}
			}
		}
		return dp[0][aim];
	}
	
	
	
}
