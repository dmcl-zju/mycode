package bfs_dfs;


/**
 * ��ָoffer����Code65
 * ��Ŀ����
	�����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ���������
	���ң����ϣ������ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ� ���� a b c e s f c s a d e e ��
	����3 X 4 �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��
	·�������ٴν���ø��ӡ�
 * @author lin
 *
 */
public class Code02_HasStrPath {
	
	static char[][] m;
	static boolean[][] visited;
	//����
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
    	//�����ɾ���
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
    
    	//������
		if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j] || m[i][j]!=str[index]) {
    		return false;
    	}
    	//û�г��磬���Ѿ�������ɣ���ֹ����
    	if(index==str.length-1) {
    		return true;
    	}
    	
    	//��ǽ����
    	visited[i][j] = true;
    	System.out.println(i+"------"+j);
    	//������������
    	for(int k=0;k<4;k++) {
    		if(dfs(str, index+1, i+dir[0][k], j+dir[1][k])) {
    			return true;
    		}	
    	}
    	//�ָ��ֳ�
		visited[i][j] = false;
		return false;
    }

}
