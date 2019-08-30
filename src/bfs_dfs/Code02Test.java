package bfs_dfs;

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
public class Code02Test {
	
	private static char[][] m;
	private static int[][] visited;
	private static int[][] dir = {{1,0,-1,0},{0,1,0,-1}};

	public static void main(String[] args) {
		 int row = 3;
		 int col = 4;
		 char[] matrix = "abcesfcsadee".toCharArray();
		 char[] str = "abccee".toCharArray();
		 
		boolean res = process(matrix, row, col, str);
		 System.out.println(res);
		
		
	}
	
	private static boolean process(char[] matrix,int row,int col,char[] str) {
		
		m = new char[row][col];
		visited = new int[row][col];
		//先做成矩阵
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				m[i][j] = getElement(i, j, matrix, row, col);
			}
		}
		
		//遍历矩阵调用bfs
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				//第一个命中才进行下一个
				if(m[i][j]==str[0] && dfs(i,j,str,0)) {
					//有一条成功就返回
					return true;
				}
			}
		}

		return false;
	}
	
	
	
	//dfs
	private static boolean dfs(int x,int y,char[] str,int index) {
		
		//System.out.println(x+"--"+y+"---"+index);
		//终止匹配
		if(m[x][y] != str[index]) {
			//System.out.println("终止于不匹配");
			return false;
		}
		
		//条件终止
		if(index==str.length-1) {
			//最后一个也匹配完了
			return true;
		}
		
		//标记自己已经访问过
		visited[x][y] = 1;
		for(int i=0;i<4;i++) {
			int nextX = x+dir[0][i];
			int nextY = y+dir[1][i];
			//保证输入的合法性
			if(nextX>=0 && nextX<m.length && nextY>=0 && nextY<m[0].length && visited[nextX][nextY]==0) { 
				if(dfs(nextX, nextY, str, index+1)) {
					return true;
				}
			}
		}
		visited[x][y] = 0;
		//System.out.println("终止于所有都无");
		return false;
	}
	
	
	

	//获取元素
	private static char getElement(int x,int y,char[] matrix,int row,int col) {
		if(x<0 || x>=row || y<0 || y>=col) {
			//表示错误
			return '!';
		}
		return matrix[x*col + y];
	}
	
	
	
	
}
