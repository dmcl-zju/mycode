package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指offer Code66
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author lin
 *
 */
public class Code03Test {
	
	private static int m ;
	private static int n ;
	private static int[][] visited;
	private static int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
	
	
	public static void main(String[] args) {
		
		m = 3;
		n = 3;
		visited = new int[m][n];
		int k = 3;
		System.out.println(dfs(0, 0, k));
		
		//System.out.println(bfs(m, n, k));
		
		printM(visited);
		
	}
	
	
	
	
	
	
	//dfs---先验证再往下走
	private static int dfs(int x,int y,int k) {
		
		//说明合法
		//visited[x][y]  = 1;
		int res = 1;
		for(int i=0;i<4;i++) {
			int nextX = x+dir[0][i];
			int nextY = y+dir[1][i];
			//合法性验证,只有合法的才进入下一层
			if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && visited[nextX][nextY]==0 && getBitSum(nextX, nextY)<=k ) {
				visited[nextX][nextY] = 1;
				res += dfs(nextX, nextY, k);
			}
		}
		return res;
	}
	
	
	
	
//	//dfs--先往下走再验证
//	private static int dfs(int x,int y,int k) {
//		//合法性验证
//		if(x<0 || x>=m || y<0 || y>=n || visited[x][y]==1 || getBitSum(x, y)>k ) {
//			return 0;
//		}
//		//说明合法
//		visited[x][y]  = 1;
//		int res = 1;
//		for(int i=0;i<4;i++) {
//			res += dfs(x+dir[0][i], y+dir[1][i], k);
//		}
//		return res;
//	}
	
	
	
	
	//采用bfs
	private static class Node{
		int x;
		int y;
		/**
		 * @param x
		 * @param y
		 */
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	private static int bfs(int row,int col,int k) {
		int res = 0;
		int[][] visit = new int[row][col];
		Node cur = new Node(0,0);
		Queue<Node> q = new LinkedList<>();
		q.offer(cur);
		visit[0][0] = 1;
		while(!q.isEmpty()) {
			cur = q.poll();
			//进行操作
			res++;
			//找下一个层
			for(int i=0;i<4;i++) {
				int nextX = cur.x+dir[0][i];
				int nextY = cur.y+dir[1][i];
				//合法性验证
				if(nextX>=0 && nextX<row && nextY>=0 && nextY<col && visit[nextX][nextY]!=1 && getBitSum(nextX, nextY)<=k) {
					//System.out.println(nextX+"--"+nextY);
					visit[nextX][nextY] = 1;
					q.offer(new Node(nextX,nextY));
				}
				
			}
		}
		return res;
	}
	
	

	//两个数的数位和
	private static int getBitSum(int n1,int n2) {
		return getBit(n1)+getBit(n2);
	}

	//获取位数和
	private static int getBit(int num) {
		int sum = 0;
		while(num != 0) {
			sum += num%10;
			num = num/10;
		}
		return sum;
	}
	
	//打印矩阵
	private static void printM(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}