package dptest;

/**
 * 	换钱的问题3：arr中的元素代表货币，可以取任意张，求组成目标换钱方法数
 * @author LIN
 *
 */
public class Code05 {
	public static void main(String[] args) {
		int[] arr = {5,10,25,1};
		System.out.println(process(arr, 150));
		
		System.out.println(process2(arr, 150));
	}
	//这种将不合法的定位-1
	private static int process(int[] arr,int aim) {
		int[][] dp = new int[arr.length][aim+1];
		int erro = -1;
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 1;
		}
		for(int j=1;j<dp[0].length;j++) {
			if(j-arr[0]>=0 && erro!=dp[0][j-arr[0]]) {
				dp[0][j] = 1;
			}else {
				dp[0][j] = erro;
			}
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//自己能参与一次以上，就累加上方法数
				if(j-arr[i]>=0 && erro!=dp[i][j-arr[i]]) {
					dp[i][j] = dp[i][j-arr[i]];
				}
				//自己不参与，如果上面合法就在其基础上方法
				if(erro!=dp[i-1][j]) {
					dp[i][j] += dp[i-1][j];
				}
				if(dp[i][j]==0) {
					dp[i][j] = erro;
				}
			}
		}
		
		System.out.println("打印dp:");
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		
		return dp[dp.length-1][dp[0].length-1]==erro?-1:dp[dp.length-1][dp[0].length-1];	
	}
	
	//很上面的区别就是直接不处理不合法的，当成0来看就行
	private static int process2(int[] arr,int aim) {
		int[][] dp = new int[arr.length][aim+1];
		int erro = -1;
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 1;
		}
		for(int j=1;j<dp[0].length;j++) {
			if(j-arr[0]>=0) {
				dp[0][j] += dp[0][j-arr[0]];
			}
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//自己能参与一次以上，就累加上方法数
				if(j-arr[i]>=0) {
					dp[i][j] = dp[i][j-arr[i]];
				}
				//自己不参与，如果上面合法就在其基础上方法
				dp[i][j] += dp[i-1][j];
			}
		}
		
		System.out.println("打印dp:");
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		
		return dp[dp.length-1][dp[0].length-1]==erro?-1:dp[dp.length-1][dp[0].length-1];	
	}
	
}
