package dptest;

import java.util.List;
import java.util.Stack;

/**
 * 	矩阵路径的递归方式
 * @author lin
 *
 */
public class Code01Test01 {
	public static void main(String[] args) {
		int[][] m = {{1,3,5,9},
					 {8,1,3,4},
					 {5,0,6,1},
					 {8,8,4,0}};
		
		
		System.out.println(process(m, m.length-1, m[0].length-1));
		System.out.println(dp(m));
		System.out.println(dp2(m));
	}
	
	//xy表示其目的地
	public static int process(int[][] m,int x,int y) {
		
		if(x==0 && y==0) {
			return m[0][0];
		}
		
		//如果在第一行
		if(x==0) {
			return m[0][y]+process(m, 0, y-1);
		}
		//如果在第一列
		if(y==0) {
			return m[x][0]+process(m, x-1, 0);
		}
		//一般情况下
		return m[x][y]+Math.min(process(m, x, y-1), process(m, x-1, y));		
	}
	
	//动态规划---可以打印路径
	public static int dp(int[][] m) {
		int rows = m.length;
		int cols = m[0].length;
		int[][] dp = new int[rows][cols];
		
		dp[0][0] = m[0][0];
		for(int i=1;i<rows;i++) {
			dp[i][0] = m[i][0]+dp[i-1][0];
		}
		for(int j=1;j<cols;j++) {
			dp[0][j] = m[0][j]+dp[0][j-1];
		}
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				dp[i][j] = m[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
			}
		}
		
		//打印路径
		int row = dp.length-1;
		int col = dp[0].length-1;
		Stack<Integer> stack = new Stack<>();
		stack.push(m[row][col]);
		while(row>=0&&col>=0) {
			int temp = dp[row][col]-m[row][col];
			if(row-1>=0 && temp==dp[row-1][col]) {
				//说明是选的上边
				stack.push(m[row-1][col]);
				row--;
			}else if(col-1>=0){
				//说明是左边来的
				stack.push(m[row][col-1]);
				col--;
			}else {
				break;
			}
		}
		System.out.print("最短路径为：");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+"     ");
		}
		System.out.println();
		return dp[rows-1][cols-1];
	}
	
	//动态规划空间改进-----无法打印路径
	public static int dp2(int[][] m) {
		int rows = m.length;
		int cols = m[0].length;
		int[] dp = new int[cols];
		//第一行
		dp[0] = m[0][0];
		for(int j=1;j<cols;j++) {
			dp[j] = m[0][j]+dp[j-1];
		}
		
		//其他行
		for(int i=1;i<rows;i++) {
			//第一个数特别处理
			dp[0] = m[i][0]+dp[0];
			for(int j=1;j<cols;j++) {
				//这里的dp[j-1]因为之前更新了，所以是左边，dp[j]还未更新所有为上边
				dp[j] = m[i][j]+Math.min(dp[j-1], dp[j]);
			}
		}
		return dp[cols-1];
	}
}
