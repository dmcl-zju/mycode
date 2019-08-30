package dptest;

/** 从递归出发到动态规划的做法
 * 	换钱的问题2：arr中的元素代表货币，可以0张或者1张，求组成目标的最小货币数
 * 	思路：和上一题code03的区别是如果选择的话只能是一张，前面是无限张,和Code02题目其实一样，要求更高了点
 * @author LIN
 *
 */
public class Code04Test {
	public static void main(String[] args) {
		int[] arr= {2,3,5,5,10};
		
		System.out.println(process(arr,0,9));
		System.out.println(dp(arr, 9));
	}
	
	private static int process(int[] arr,int index,int aim) {
		//没有货币可选了
		if(index==arr.length) {
			//说明符合条件
			if(aim==0) {
				return 0;
			}else {
				return Integer.MAX_VALUE;
			}
		}
		//一般情况
		//自己不入选的情况
		int min = process(arr, index+1, aim);
		//自己能入选吗
		if(aim-arr[index]>=0) {
			int temp = process(arr, index+1, aim-arr[index]);
			if(temp != Integer.MAX_VALUE) {
				min = Math.min(min, 1+process(arr, index+1, aim-arr[index]));
			}	
		}
		return min;
	}
	//改为动态规划
	private static int dp(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		int erro = Integer.MAX_VALUE;
		//第一列全部为0就不填了
		//最后一行
		for(int j=1;j<=aim;j++) {
			dp[dp.length-1][j] = erro;
		}
		//一般情况
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<=aim;j++) {
				dp[i][j] = dp[i+1][j];
				
				if(j-arr[i]>=0) {
					if(dp[i+1][j-arr[i]]!=erro) {
						dp[i][j]= Math.min(dp[i][j],1+dp[i+1][j-arr[i]]);
					}
				}
			}
		}
	
		return dp[0][aim]==erro?-1:dp[0][aim];
	}
	
	
}
