package dptest;

/**
 * 	数组中的某些元素的和为指定的数存在吗？,这个题是换钱第二种的简化版本
 * @author LIN
 *
 */
public class Code02 {
	public static void main(String[] args) {
		int[] arr = {2,2,5,4};
		System.out.println(process(arr, 7));
	}
	
	private static boolean process(int[] arr,int aim) {
		boolean[][] dp = new boolean[arr.length][aim+1];
		//第一列dp[i][0]:在数arr中从索引0-i任意取数能累加出0吗，当然可以，只要都不取
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = true;
		}
		//第一行dp[0][j]:对于arr[0取0次和取1次]可以累加出aim以内的和吗？易知除了arr[0]这个数，其他都为false
		for(int j=1;j<dp[0].length;j++) {
			if(arr[0]==j) {
				dp[0][j] = true;
			}else {
				dp[0][j] = false;
			}
		}
		//对于一般情况
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//只要不越界，当前元素就有两种选择：自己参与求和和不参与求和
				if(j-arr[i]>=0) {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
				}else {
					//越界了说明自己无法参与求和，一参与和就过大了
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];	
	}
}
