package dptest;
/**
 * 	换钱的问题2：arr中的元素代表货币，可以0张或者1张，求组成目标的最小货币数
 * 	思路：和上一题code03的区别是如果选择的话只能是一张，前面是无限张,和Code02题目其实一样，要求更高了点
 * @author LIN
 *
 */
public class Code04 {
	public static void main(String[] args) {
		int[] arr= {2,3,5,5,10};
		System.out.println(process(arr, 10));
	}
	private static int process(int[] arr,int aim) {
		int[][] dp = new int[arr.length][aim+1];
		int max = Integer.MAX_VALUE;
		//因为初始化就是0，这里可以不写
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		for(int j=1;j<dp[0].length;j++) {
			//只有相等的情况才能换，且货币数为1
			if(j==arr[0]) {
				dp[0][j]=1;
				continue;
			}
			dp[0][j] = max;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(j-arr[i]>=0 && max!=dp[i-1][j-arr[i]]) {
					dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-arr[i]]+1);
				}else {
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
		
		
		return dp[dp.length-1][dp[0].length-1]==max?-1:dp[dp.length-1][dp[0].length-1];	
	}
}
