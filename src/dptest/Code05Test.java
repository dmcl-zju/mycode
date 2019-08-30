package dptest;

/**
 * 	换钱的方法数递归尝试
 * @author lin
 *
 */
public class Code05Test {
	
	public static void main(String[] args) {
		int[] arr = {5,10,25,1};
		System.out.println(process1(arr, arr.length-1,150));
		System.out.println(process2(arr, 0,150));
		System.out.println(dp1(arr,150));
		System.out.println(dp2(arr,150));
		System.out.println(dp3(arr,150));
		
		
//		int[] arr = {1,2,3};
//		
//		System.out.println(dp2(arr,4));
//		System.out.println(dp3(arr,4));
		
		
//		System.out.println(process1(arr, arr.length-1,4));
//		
//		System.out.println(dp1(arr,4));
	}
	//可变参数：给的钱--index及其之前的数组值，目标钱---aim
	//递归1：其之前包括自己都能使用，求方法数目 ,aim代表需要换的钱数
	private static int process1(int[] arr,int index,int aim) {
		//终止条件
		if(index==-1) {
			//没有可选的情况下，aim是不是0,是的话说明这整条走下来是可以换的，得到一种方法数
			return aim==0?1:0;
		}
		//常规情况
		//对每张钱只要不超过aim就尝试任意张
		int res = 0;
		for(int i=0;arr[index]*i<=aim;i++) {
			//每次尝试就扣掉自己的部分
			res += process1(arr, index-1, aim-arr[index]*i);
		}
		return res;
	}
	
	//转为动态规划
	private static int dp1(int[] arr,int aim) {
		//建表
		int[][] dp = new int[arr.length+1][aim+1];
		//填第一行，只有aim=0的时候为1，其他都为0
		dp[0][0] = 1;
		//填第一列
		for(int i=1;i<dp.length;i++) {
			dp[i][0] = 1;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				for(int k=0;arr[i-1]*k<=j;k++) {
					dp[i][j] += dp[i-1][j-arr[i-1]*k];
				}
			}
		}
		
		//打印dp表
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		return dp[dp.length-1][aim];	
	}
	
	//以index开始包括其在内之后的所有货币进行交换
	private static int process2(int[] arr,int index,int aim) {
		//没有货币了
		if(index==arr.length) {
			return aim==0?1:0;
		}
		
		//一般情况下
		int sum = 0;
		for(int i=0;arr[index]*i<=aim;i++) {
			sum += process2(arr, index+1, aim-arr[index]*i);
		}
		return sum;	
	}
	//改成动态规划
	private static int dp2(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		//先填最后一行,其他都为0就不填了
		dp[dp.length-1][0] = 1;
		
		//填第一列，都是1
		for(int i=0;i<dp.length-1;i++) {
			dp[i][0] = 1;
		}
		//普通行
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<dp[0].length;j++) {
				
				//累加起来
				for(int k=0;arr[i]*k<=j;k++) {
					dp[i][j] += dp[i+1][j-arr[i]*k];
				}
				
			}
		}
		
//		//打印dp表
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		return dp[0][dp[0].length-1];
	}
	
	//对dp2进行改进
	private static int dp3(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		//先填最后一行,其他都为0就不填了
		dp[dp.length-1][0] = 1;
		
		//填第一列，都是1
		for(int i=0;i<dp.length-1;i++) {
			dp[i][0] = 1;
		}
		//普通行
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<dp[0].length;j++) {
				
				//如果左边的格子存在
				dp[i][j] = dp[i+1][j];
				if(j-arr[i]>=0) {
					dp[i][j] += dp[i][j-arr[i]];
				}
			
			}
		}
		
//		//打印dp表
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		return dp[0][dp[0].length-1];
	}
}
