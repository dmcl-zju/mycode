package dptest;
/**
 * 	换钱的问题3：arr中的元素代表货币，可以取任意张，求组成目标换钱方法数
 * @author LIN
 *
 */
public class Code05Test {
	public static void main(String[] args) {
		int[] arr = {5,10,25,1};
		int aim = 25;
		System.out.println(process(arr, 0, aim));
		System.out.println(dp1(arr, aim));
		System.out.println(dp2(arr, aim));
	}
	
	private static int process(int[] arr,int index,int aim) {
		//没有钱可以选了
		if(index==arr.length) {
			return aim==0?1:0;
		}
		//一般情况,遍历所有可能
		int sum = 0;
		for(int i=0;arr[index]*i<=aim;i++) {
			sum += process(arr, index+1, aim-arr[index]*i);
		}
		return sum;
	}
	
	//直接改成dp
	private static int dp1(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		
		//填最后一行,只有第一个为1
		dp[dp.length-1][0] = 1;
		//第一列
		for(int i=0;i<dp.length-1;i++) {
			dp[i][0] = 1;
		}
		//常规情况
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<dp[0].length;j++) {
				
				for(int k=0;arr[i]*k<=j;k++) {
					dp[i][j] += dp[i+1][j-arr[i]*k];
				}
			}
		}

//		//打印dp
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		return dp[0][aim];
	}
	
	//直接改成dp的优化
	private static int dp2(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		
		//填最后一行,只有第一个为1
		dp[dp.length-1][0] = 1;
		//第一列
		for(int i=0;i<dp.length-1;i++) {
			dp[i][0] = 1;
		}
		//常规情况
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<dp[0].length;j++) {
				//前一个存在吗
				if(j-arr[i]>=0) {
					dp[i][j] += dp[i][j-arr[i]];
				}
				dp[i][j] += dp[i+1][j];
			}
		}

//			//打印dp
//			for(int i=0;i<dp.length;i++) {
//				for(int j=0;j<dp[0].length;j++) {
//					System.out.print(dp[i][j]+" ");
//				}
//				System.out.println();
//			}
		return dp[0][aim];
	}
}
