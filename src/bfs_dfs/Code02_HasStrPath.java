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
public class Code02_HasStrPath {
	
	static char[][] m;
	static boolean[][] visited;
	//方向
	static int[][] dir = {{1,0,-1,0},
						  {0,1,0,-1}};
	

	 public static void main(String[] args) {
		char[] matrix = "abcesfcsadee".toCharArray();
		char[] str = "abccee".toCharArray();
		Code02_HasStrPath code = new Code02_HasStrPath();
		boolean res = code.hasPath(matrix, 3, 4, str);
		System.out.println(res);
		
	}
	
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
    	//先做成矩阵
    	m = new char[rows][cols];
    	visited = new boolean[rows][cols];
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			m[i][j] = matrix[cols*i+j];
    		}
    	}
        
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			System.out.print(m[i][j]+" ");
    		}
    		System.out.println();
    	}
    	
    	for(int i=0;i<rows;i++) {
    		for(int j=0;j<cols;j++) {
    			if(dfs(str,0,i,j)) {
    				return true;
    			};
    		}
    	}
    	
    	
    	
		return false;
    }
    
    
    
    
    private static boolean dfs(char[] str,int index,int i,int j) {
    	int rows = m.length;
    	int cols = m[0].length;
    
    	//不进入
		if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || m[i][j]!=str[index]) {
    		return false;
    	}
    	//没有出界，且已经遍历完成，终止条件
    	if(index==str.length-1) {
    		return true;
    	}
    	
    	//标记进入过
    	visited[i][j] = true;
    	System.out.println(i+"------"+j);
    	//遍历上下左右
    	for(int k=0;k<4;k++) {
    		if(dfs(str, index+1, i+dir[0][k], j+dir[1][k])) {
    			return true;
    		}	
    	}
    	//恢复现场
		visited[i][j] = false;
		return false;
    }

}
