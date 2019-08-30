package dptest;

/**
 * 数组元素组成和递归
 * @author lin
 *
 */
public class Code02Test {
	public static void main(String[] args) {
		int[] arr = {2,2,5,4};
		int aim = 4;
		System.out.println(process(arr, 0, aim));
		System.out.println(dp(arr, aim));
		
	}
	
	//以index开始包括index在内都可选
	private static boolean process(int[] arr,int index,int aim) {
		
		//如果没有可选项了
		if(index==arr.length) {
			return aim==0;
		}
		//常规情况进行尝试,只有两种情况，自己不加入，自己加入
		return process(arr, index+1, aim) || process(arr, index+1, aim-arr[index]);
	}
	
	//改为动态规划
	private static boolean dp(int[] arr,int aim) {
		boolean[][] dp = new boolean[arr.length+1][aim+1];
		//填最后行
		//只有第一个为true,其他都为false默认的
		dp[dp.length-1][0] = true;
		
		//常规情况
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=0;j<=aim;j++) {
				dp[i][j] = dp[i+1][j];
				if(j-arr[i]>=0) {
					dp[i][j] = dp[i][j] || dp[i+1][j-arr[i]];
				}
			}
		}
		return dp[0][aim];
		
	}
	
}
