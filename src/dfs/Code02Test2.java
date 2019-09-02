package dfs;

/**
 * 剑指offer倒数Code65
 * 题目描述
	请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，
	向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这
	样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
	路径不能再次进入该格子。
 * @author lin
 *
 */

public class Code02Test2 {
	
	public static void main(String[] args) {
		char[] matrix = "abcesfcsadee".toCharArray();
		char[] str = "abcceese".toCharArray();
		int row = 3;
		int col = 4;
		
		System.out.println(hasPath(matrix, str, row, col));
	
	}
	
	
	private static boolean hasPath(char[] matrix,char[] str,int row,int col) {
		//换成矩阵
		char[][] m = new char[row][col];
		visit = new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				m[i][j] = matrix[i*col+j];
			}
		}
		//遍历，如何第一个合法用dfs
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(m[i][j]==str[0]) {
					//搜索
					if (DFS(m, i, j, str, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	static int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
	static int[][] visit;
	
	private static boolean DFS(char[][] m,int x,int y,char[] str,int index) {
		//全部匹配完毕
		if(index==str.length-1) {
			return true;
		}
		
		visit[x][y] = 1;
		for(int i=0;i<4;i++) {
			int nextX = x+dir[0][i];
			int nextY = y+dir[1][i];
			int nextIndex = index+1;
			if(nextX>=0 && nextY>=0 && nextX<m.length && nextY<m[0].length && visit[nextX][nextY]!=1
				&& nextIndex<str.length && m[nextX][nextY]==str[nextIndex]) {
				//可以进入下一层
				if(DFS(m, nextX, nextY, str, nextIndex)) {
					return true;
				}	
			}
		}
		visit[x][y] = 0;
	
		return false;
	}
	
	
	
}
