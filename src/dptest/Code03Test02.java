package dptest;

/**
 * 	可换任意张，换钱的最小货币数
 * @author lin
 *
 */
public class Code03Test02 {
	public static void main(String[] args) {
		int[] arr = {2,3,6};
		int aim = 1001;
		System.out.println(process(arr, arr.length-1, aim));
		System.out.println(dp(arr, aim));
		System.out.println(dp2(arr, aim));
		System.out.println(dp3(arr, aim));
	}
	
	//货币到index都是可以选的，返回最小货币数
	private static int process(int[] arr,int index,int aim) {
		
		//不用换了，达到目标了
		if(aim==0) {
			return 0;
		}
		
		//只有一张货币
		if(index==0) {
			if(aim%arr[0]==0) {
				return aim/arr[0];
			}else {
				return Integer.MAX_VALUE;
			}
		}
		
		//一般情况，在不超过的情况下自己在可选范围内都选一次
		int min = Integer.MAX_VALUE;
		for(int i=0;arr[index]*i<=aim;i++) {
			//这里不能直接加上，因为最大值加上东西会溢出，要先判断
			int temp = process(arr, index-1, aim-arr[index]*i);
			if(temp!=Integer.MAX_VALUE) {
				temp += i;
			}
			min = Math.min(min,temp);
		}
		return min;
	}
	

	private static int dp(int[] arr,int aim) {
		int[][] dp = new int[arr.length][aim+1];
		int rows = dp.length;
		int cols = dp[0].length;
		int erro = Integer.MAX_VALUE;
		//第一列都为0,不用填
		
		//填第一行
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[0][j] = j/arr[0];
			}else {
				dp[0][j] = erro;
			}
		}
		//其他行
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				int min = erro;
				for(int k=0;arr[i]*k<=j;k++) {
					int temp = dp[i-1][j-arr[i]*k];
					if(temp!=erro) {
						temp+=k;
					}
					min = Math.min(min, temp);
				}
				dp[i][j] = min;
			}
		}
		//printM(dp);
		return dp[rows-1][cols-1];
	}
	
	//时间复杂度的改进
	private static int dp2(int[] arr,int aim) {
		int[][] dp = new int[arr.length][aim+1];
		int rows = dp.length;
		int cols = dp[0].length;
		int erro = Integer.MAX_VALUE;
		//第一列都为0,不用填
		
		//填第一行
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[0][j] = j/arr[0];
			}else {
				dp[0][j] = erro;
			}
		}
		//其他行
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				int min=dp[i-1][j];
				if(j-arr[i]>=0) {
					int temp = dp[i][j-arr[i]];
					if(temp!=erro) {
						temp += 1;
					}
					min = Math.min(min,temp);	
				}
				dp[i][j] = min;
			}
		}
		return dp[rows-1][cols-1];
	}
	
	//空间复杂度的改进
	private static int dp3(int[] arr,int aim) {
		int[] dp = new int[aim+1];
		int rows = arr.length;
		int cols = dp.length;
		int erro = Integer.MAX_VALUE;
		//第一列都为0,不用填
		//填第一行
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[j] = j/arr[0];
			}else {
				dp[j] = erro;
			}
		}
		//其他行
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				int min=dp[j];
				if(j-arr[i]>=0) {
					int temp = dp[j-arr[i]];
					if(temp!=erro) {
						temp += 1;
					}
					min = Math.min(min,temp);	
				}
				dp[j] = min;
			}
		}
		//printM(dp);
		return dp[cols-1];
	}
	private static void printM(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
