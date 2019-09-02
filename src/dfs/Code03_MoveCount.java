package dfs;



/**
 * 剑指offer Code66
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author lin
 *
 */
public class Code03_MoveCount {
	
	
	static boolean[][] visited;
	static int count;
	static int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
	
	
	public static void main(String[] args) {
		System.out.println(new Code03_MoveCount().movingCount(10, 3, 3));
	}

	public  int movingCount(int threshold, int rows, int cols)
    {
		visited = new boolean[rows][cols];
//		dfs(threshold, 0, 0, rows, cols);
//		System.out.println(count);
		
		return dfs2(threshold, 0, 0, rows, cols);
    }
	
	//有返回值
	private static int dfs2(int threshold,int i,int j,int rows,int cols) {
			
			//终止条件,越界或者不符合，终止搜索
			if(i<0 || j<0 || i>=rows || j>=cols || visited[i][j] || (getSumOfBit(i)+getSumOfBit(j)>threshold)) {
				return 0;
			}
			//标记自己
			visited[i][j] = true;
			//这一层的初始步数
			int res = 1;
			//遍历邻接节点
			for(int k=0;k<4;k++) {
				res += dfs2(threshold, i+dir[0][k], j+dir[1][k], rows, cols);
			}
			return res;
		}
	
//	//没有返回值。利用全局变量
//	private static void dfs(int threshold,int i,int j,int rows,int cols) {
//		
//		//终止条件,越界或者不符合，终止搜索
//		if(i<0 || j<0 || i>=rows || j>=cols || visited[i][j] || (getSumOfBit(i)+getSumOfBit(j)>threshold)) {
//			return;
//		}
//		//标记自己
//		visited[i][j] = true;
//		//增加步数
//		count++;
//		//遍历邻接节点
//		for(int k=0;k<4;k++) {
//			dfs(threshold, i+dir[0][k], j+dir[1][k], rows, cols);
//		}
//	}
	
	//求出位数之和
	private static int getSumOfBit(int num) {
		int res = 0;
		while(num>0) {
			res += num%10;
			num = num/10;
		}
		return res;
	}
	
	
}
