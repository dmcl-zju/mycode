package mypractice;

/**
 * 换钱的最少货币数
 * @author lin
 *
 */
public class MyCoinsTest {
	public static void main(String[] args) {
		int[] arr = {2,3,8,4,5,5,10};
		int aim = 23;
		
		System.out.println(process(arr, arr.length-1, aim));
		System.out.println(dp(arr, aim));
		System.out.println(dp2(arr, aim));
		
	}
	
	private static int process(int[] arr,int index,int aim) {
		//已经换好了
		if(aim==0) {
			return 0;
		}
		
		//只剩下一张了
		if(index==0) {
			return arr[0]==aim?1:Integer.MAX_VALUE;
		}
		
		//两个选择
		int res = process(arr, index-1, aim);
		if(arr[index]<=aim) {
			int temp = process(arr, index-1, aim-arr[index]);
			if(temp != Integer.MAX_VALUE) {
				temp++;
			}
			res = Math.min(res, temp);
		}
		return res;
	}
	
	//dp
	private static int dp(int[] arr,int aim) {
		int rows = arr.length;
		int cols = aim+1;
		int erro = Integer.MAX_VALUE;
		int[][] dp = new int[rows][cols];
		//第一列都是0就不用填了
		for(int j=1;j<cols;j++) {
			if(arr[0]==aim) {
				dp[0][j] = 1;
			}else {
				dp[0][j] = erro;
			}
		}
		//其他列
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				dp[i][j] = dp[i-1][j];
				if(arr[i]<=j) {
					int temp = dp[i-1][j-arr[i]];
					if(temp!=erro) {
						temp++;
					}
					dp[i][j] = Math.min(dp[i][j], temp);
				}
			
			}
		}
		return dp[arr.length-1][aim];
	}
	//空间改进
	private static int dp2(int[] arr,int aim) {
		int rows = arr.length;
		int cols = aim+1;
		int erro = Integer.MAX_VALUE;
		int[] dp = new int[cols];
		//第一列都是0就不用填了
		for(int j=1;j<cols;j++) {
			if(arr[0]==aim) {
				dp[j] = 1;
			}else {
				dp[j] = erro;
			}
		}
		//其他列
		for(int i=1;i<rows;i++) {
			for(int j=cols-1;j>=1;j--) {
				dp[j] = dp[j];
				if(arr[i]<=j) {
					int temp = dp[j-arr[i]];
					if(temp!=erro) {
						temp++;
					}
					dp[j] = Math.min(dp[j], temp);
				}
			
			}
		}
		return dp[aim];
	}
	
	
	
	
}
