package dptest;

/**
 * 	换钱的问题1：arr中的元素代表货币，可以取任意张，求组成目标的最小货币数
 * @author LIN
 *
 */
public class Code03 {
	public static void main(String[] args) {
		int[] arr = {2,3,5};
		System.out.println(process(arr, 15));
	}
	
	
	private static int process(int[] arr,int aim) {
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[arr.length][aim+1];
		//第一列：dp[i][0]:取任意张组成0，显然都是能满足的，而且货币数都是0
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		//第一行：dp[0][i]:只用arr[0]任意张取组成j,因为在第一行，只能自己参与一张及以上
		for(int j=1;j<dp[0].length;j++) {
			dp[0][j] = max;
			if((j-arr[0]>=0 && max!=dp[0][j-arr[0]])) {
				dp[0][j] = dp[0][j-arr[0]]+1;
			}
		}
		//对于一般情况
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//如果自己能参与一次以上
				if((j-arr[i]>=0 && max!=dp[i][j-arr[i]])) {
					dp[i][j] = Math.min(dp[i-1][j],dp[i][j-arr[i]]+1);
				}else {
					//如果自己一次都不参与,那么货币数量就和i-1情况一样
					dp[i][j] = dp[i-1][j];
				}
			}
		}
//		System.out.println("打印dp:");
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+"\t");
//			}
//			System.out.println();
//		}
		return dp[dp.length-1][dp[0].length-1];
	}
}
