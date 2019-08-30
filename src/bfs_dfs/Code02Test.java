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
		//�����ɾ���
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				m[i][j] = getElement(i, j, matrix, row, col);
			}
		}
		
		//�����������bfs
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				//��һ�����вŽ�����һ��
				if(m[i][j]==str[0] && dfs(i,j,str,0)) {
					//��һ���ɹ��ͷ���
					return true;
				}
			}
		}

		return false;
	}
	
	
	
	//dfs
	private static boolean dfs(int x,int y,char[] str,int index) {
		
		//System.out.println(x+"--"+y+"---"+index);
		//��ֹƥ��
		if(m[x][y] != str[index]) {
			//System.out.println("��ֹ�ڲ�ƥ��");
			return false;
		}
		
		//������ֹ
		if(index==str.length-1) {
			//���һ��Ҳƥ������
			return true;
		}
		
		//����Լ��Ѿ����ʹ�
		visited[x][y] = 1;
		for(int i=0;i<4;i++) {
			int nextX = x+dir[0][i];
			int nextY = y+dir[1][i];
			//��֤����ĺϷ���
			if(nextX>=0 && nextX<m.length && nextY>=0 && nextY<m[0].length && visited[nextX][nextY]==0) { 
				if(dfs(nextX, nextY, str, index+1)) {
					return true;
				}
			}
		}
		visited[x][y] = 0;
		//System.out.println("��ֹ�����ж���");
		return false;
	}
	
	
	

	//��ȡԪ��
	private static char getElement(int x,int y,char[] matrix,int row,int col) {
		if(x<0 || x>=row || y<0 || y>=col) {
			//��ʾ����
			return '!';
		}
		return matrix[x*col + y];
	}
	
	
	
	
}
