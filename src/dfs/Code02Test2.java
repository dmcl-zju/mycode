package dfs;

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

public class Code02Test2 {
	
	public static void main(String[] args) {
		char[] matrix = "abcesfcsadee".toCharArray();
		char[] str = "abcceese".toCharArray();
		int row = 3;
		int col = 4;
		
		System.out.println(hasPath(matrix, str, row, col));
	
	}
	
	
	private static boolean hasPath(char[] matrix,char[] str,int row,int col) {
		//���ɾ���
		char[][] m = new char[row][col];
		visit = new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				m[i][j] = matrix[i*col+j];
			}
		}
		//��������ε�һ���Ϸ���dfs
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(m[i][j]==str[0]) {
					//����
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
		//ȫ��ƥ�����
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
				//���Խ�����һ��
				if(DFS(m, nextX, nextY, str, nextIndex)) {
					return true;
				}	
			}
		}
		visit[x][y] = 0;
	
		return false;
	}
	
	
	
}
