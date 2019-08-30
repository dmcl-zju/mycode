package dptest;

/**
 * 背包问题
 * @author lin
 *
 */
public class Code06_BackPackTest {
	public static void main(String[] args) {
		int[] m = {10,5,6};
		int[] p = {10,2,8};
		int bag = 16;
		
		System.out.println(process1(m, p, 0, bag));
		System.out.println(dp1(m, p, bag));
		System.out.println(process2(m, p, m.length-1, bag));
		System.out.println(dp2(m, p, bag));
		System.out.println(dp3(m, p, bag));
	
	}
	//index及其之后的都可选，返回最大值
	private static int process1(int[] m,int[] p,int index,int bag) {
		//背包全部选完了
		if(index==m.length) {
			return 0;
		}
		
		//当前处理
		int res = process1(m, p, index+1, bag);
		
		if(bag-m[index]>=0) {
			res =Math.max(res,p[index]+process1(m, p, index+1, bag-m[index]));
		}
		return res;
	}
	
	private static int dp1(int[] m,int[] p,int bag) {
		int[][] dp = new int[m.length+1][bag+1];
		int rows = dp.length;
		int cols = dp[0].length;
		//最后一行和第一列都为0，所以不填
		for(int i=rows-2;i>=0;i--) {
			for(int j=1;j<cols;j++) {
				dp[i][j] = dp[i+1][j];
				if(j-m[i]>=0) {
					dp[i][j] = Math.max(dp[i][j], p[i]+dp[i+1][j-m[i]]);
				}
			}
		}
		return dp[0][cols-1];
	}
	
	//方式二：index及其之前的可以选
	private static int process2(int[] m,int[] p,int index,int bag) {
		
		if(index==0) {
			return bag>=m[index]?p[index]:0;
		}
		
		int res = process2(m, p, index-1, bag);
		if(bag-m[index]>=0) {
			res = Math.max(res, p[index]+process2(m, p, index-1, bag-m[index]));
		}
		return res;
	}
	
	private static int dp2(int[] m,int[] p,int bag) {
		int[][] dp = new int[m.length][bag+1];
		int rows = dp.length;
		int cols = dp[0].length;
		//第一行
		for(int j=1;j<cols;j++) {
			if(j>=m[0]) {
				dp[0][j] = m[0];
			}
		}
		
		//其他
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				dp[i][j] = dp[i-1][j];
				if(j-m[i]>=-0) {
					dp[i][j] = Math.max(dp[i][j],p[i]+dp[i-1][j-m[i]]);
				}
			}
		}
		return dp[rows-1][cols-1];
	}
	
	//方式三：在方式二上空间优化,每个格子依赖于的都在上一行，可以优化
	private static int dp3(int[] m,int[] p,int bag) {
		int[] dp = new int[bag+1];
		int cols = dp.length;
		int rows = m.length;
		//第一行
		for(int j=1;j<cols;j++) {
			if(j>=m[0]) {
				dp[j] = m[0];
			}
		}
//		//其他行--这样写便于理解
//		for(int i=1;i<rows;i++) {
//			for(int j=cols-1;j>=0;j--) {
//				int max = dp[j];
//				if(j-m[i]>=0) {
//					max = Math.max(max, p[i]+dp[j-m[i]]);
//				}
//				dp[j] = max;
//			}
//		}
		//可以写成这样
		for(int i=1;i<rows;i++) {
			for(int j=cols-1;j>=0;j--) {
				if(j-m[i]>=0) {
					dp[j] = Math.max(dp[j], p[i]+dp[j-m[i]]);
				}
			}
		}
		return dp[cols-1];
	}
	
	
	
	
	
}
