package class08;

/**
 * 矩阵中的最小路径和问题
 * @author lin
 *
 */
public class MyMinPath {
	//返回最小路径和暴力递归版本
	public static int getMinPath1(int[][] matrix) {
		
		if(null==matrix || matrix.length==0 || matrix[0] ==null ||matrix[0].length==0) {
			return 0;
		}
		return process(matrix,0,0);
		
	}
	
	public static int process (int[][] matrix,int i,int j) {
		int res = matrix[i][j];
		//终止条件
		if(i==matrix.length-1 && j==matrix[i].length-1) {
			//到了终点了，直接返回自己
			return res;
		}
		//如果到了最后一行
		if(i==matrix.length-1) {
			return res + process(matrix,i,j+1);
		}
		//如果到了最后一列
		if(j==matrix[0].length-1) {
			return res + process(matrix,i+1,j);
		}
		//正常情况
		return res + Math.min(process(matrix,i,j+1),process(matrix,i+1,j));
	}
	
	public static int getMinPath2(int[][] matrix) {
		
		if(null==matrix || matrix.length==0 || matrix[0] ==null ||matrix[0].length==0) {
			return 0;
		}
		//创建dp二维表
		int[][] dp = new int[matrix.length][matrix[0].length];
		int cow = matrix.length-1;
		int col = matrix[0].length-1;
		//先填最后一个格子
		dp[cow][col] = matrix[cow][col];
		//填最后一行
		for(int j=col-1;j>=0;j--) {
			//当前的数加上右边的 最小和
			dp[cow][j] = matrix[cow][j]+dp[cow][j+1];
		}
		//填最后一列
		for(int i=cow-1;i>=0;i--) {
			//当前的数加上下面的 最小和
			//System.out.println(i+"-->"+col);
			dp[i][col] = matrix[i][col]+dp[i+1][col];
		}
		//从倒数第二行开始往上逐行填表
		for(int i=cow-1;i>=0;i--) {
			for(int j=col-1;j>=0;j--) {
				dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j], dp[i][j+1]);
			}
		}
		//全部都填完了后返回第一 个元素
		return dp[0][0];
	}
	
	public static void printArr(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}
	
	public static void testTime(int times) {
		int[][] m = generateRandomMatrix(10, 10);
		//dp
		long start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			getMinPath2(m);
		}
		long end = System.currentTimeMillis();
		//暴力递归方法
		System.out.println("执行 "+times+" 次，dp用时："+(end-start)+"ms");
		start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			getMinPath1(m);
		}
		end = System.currentTimeMillis();
		System.out.println("执行 "+times+" 次，暴力递归用时："+(end-start)+"ms");
	}
	
	public static void isEqual(int times) {
		int[][] m;
		for(int i=0;i<times;i++) {
			m = generateRandomMatrix(10, 10);
			if(getMinPath1(m) == getMinPath2(m)) {
				continue;
			}
			System.out.println("fuck!");
			System.out.println("暴力递归："+getMinPath1(m));
			System.out.println("暴力递归："+getMinPath2(m));
			return;
		}
		//全部执行完了没有出错
		System.out.println("nice!");
	}

	public static void main(String[] args) {
		
//		int[][] m = generateRandomMatrix(10, 10);
//		System.out.println("输入数组：");
//		printArr(m);
//		System.out.println("输出结果：");
//		System.out.println("暴力递归："+getMinPath1(m));
//		System.out.println("动态规划："+getMinPath2(m));
		testTime(10000);
		isEqual(10000);
		
	}
}
