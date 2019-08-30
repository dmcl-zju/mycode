package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ָoffer Code66
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
	
	
	
	
	
	
	//dfs---����֤��������
	private static int dfs(int x,int y,int k) {
		
		//˵���Ϸ�
		//visited[x][y]  = 1;
		int res = 1;
		for(int i=0;i<4;i++) {
			int nextX = x+dir[0][i];
			int nextY = y+dir[1][i];
			//�Ϸ�����֤,ֻ�кϷ��ĲŽ�����һ��
			if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && visited[nextX][nextY]==0 && getBitSum(nextX, nextY)<=k ) {
				visited[nextX][nextY] = 1;
				res += dfs(nextX, nextY, k);
			}
		}
		return res;
	}
	
	
	
	
//	//dfs--������������֤
//	private static int dfs(int x,int y,int k) {
//		//�Ϸ�����֤
//		if(x<0 || x>=m || y<0 || y>=n || visited[x][y]==1 || getBitSum(x, y)>k ) {
//			return 0;
//		}
//		//˵���Ϸ�
//		visited[x][y]  = 1;
//		int res = 1;
//		for(int i=0;i<4;i++) {
//			res += dfs(x+dir[0][i], y+dir[1][i], k);
//		}
//		return res;
//	}
	
	
	
	
	//����bfs
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
			//���в���
			res++;
			//����һ����
			for(int i=0;i<4;i++) {
				int nextX = cur.x+dir[0][i];
				int nextY = cur.y+dir[1][i];
				//�Ϸ�����֤
				if(nextX>=0 && nextX<row && nextY>=0 && nextY<col && visit[nextX][nextY]!=1 && getBitSum(nextX, nextY)<=k) {
					//System.out.println(nextX+"--"+nextY);
					visit[nextX][nextY] = 1;
					q.offer(new Node(nextX,nextY));
				}
				
			}
		}
		return res;
	}
	
	

	//����������λ��
	private static int getBitSum(int n1,int n2) {
		return getBit(n1)+getBit(n2);
	}

	//��ȡλ����
	private static int getBit(int num) {
		int sum = 0;
		while(num != 0) {
			sum += num%10;
			num = num/10;
		}
		return sum;
	}
	
	//��ӡ����
	private static void printM(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}