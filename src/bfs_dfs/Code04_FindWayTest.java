package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs��dfs������ϰ--�Թ����⣺�Ӿ������Ͻ��ߵ����½ǵ����·����Ҫ��0Ϊ·��1Ϊǽ��
 * @author LIN
 *
 */
public class Code04_FindWayTest {
	
	
	private static class Node{
		int x;
		int y;
		int deepth;
		Node pre;
		public Node(int x, int y, int deepth, Node pre) {
			super();
			this.x = x;
			this.y = y;
			this.deepth = deepth;
			this.pre = pre;
		}
	}
	
	public static void main(String[] args) {
		int[][]  m = {
						{0, 1, 0, 0, 0},
						{0, 1, 0, 1, 0},
						{0, 1, 0, 1, 0},
						{0, 0, 0, 1, 0},
						{0, 0, 1, 1, 0},
					 };
		
		//�������
		System.out.println("����");
		System.out.println(bfs(m));
		
		
		
		//����
		System.out.println("����");
		int[][] visited = new int[m.length][m[0].length];
		Node cur = new Node(0,0,0,null);
		dfs(m, visited, cur);
		System.out.println(end==null?-1:minPath);
		//printPath(end);

	}
	
	private static int minPath = Integer.MAX_VALUE;
	private static Node end;
	private static int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
	//dfs����
	private static void  dfs(int[][] m,int[][] visited,Node cur) {
		//����ߵ�ͨ���������ֵ
		if(cur.x==m.length-1 && cur.y==m[0].length-1) {
			if(minPath>cur.deepth) {
				minPath = cur.deepth;
				end = cur;
			}
			return;
		}
		
		//��Ƿ���
		visited[cur.x][cur.y] = 1;
		//�鿴������
		for(int i=0;i<4;i++) {
			int nextX = cur.x+dir[0][i];
			int nextY = cur.y+dir[1][i];
			//����Ϸ��ͽ�����һ��
			if(nextX>=0 && nextX<=m.length-1 && nextY>=0 && nextY<=m[0].length-1 && m[nextX][nextY]!=1 && visited[nextX][nextY]!=1) {      
				dfs(m, visited, new Node(nextX,nextY,cur.deepth+1,cur));
			}
			
		}
		//�ָ����Ϊ��������λ��bfs��һ����ֻΪ��һ��̽�����񣬻�Ҫ��������̽�����õ�
		visited[cur.x][cur.y] = 0;
		//����Ҳ��һ�����أ��������·������ͨ�˴����������ֹ�������أ�����߲�ͨ�ʹ����ﷵ��
	}
		
	
	
	
	//ע��㣺�������֮ǰ�ͱ���Ѿ�����,����������ٱ�ǻᵼ���ظ����ʡ�
	private static int bfs(int[][] m) {
		int rows = m.length-1;
		int cols = m[0].length-1;
		
		int[][] visit = new int[m.length][m[0].length];
		//0/1/2/3----��������
		int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
		Queue<Node> q = new LinkedList<>();
		//������
		Node cur = new Node(0,0,0,null);
		//����ѽ���
		m[0][0] = 1;
		q.offer(cur);
		while(!q.isEmpty()) {
			cur = q.poll();
			//���в���
			//�ǲ��ǵ����յ�
			if(cur.x==rows && cur.y==cols) {
				break;
			}
		
			//�ĸ�������
			for(int i=0;i<4;i++) {
				int nextX = cur.x+dir[0][i];
				int nextY = cur.y+dir[1][i];
				
				if(nextX>=0 && nextX<=rows && nextY>=0 && nextY<=cols && m[nextX][nextY]!=1 && visit[nextX][nextY]!=1) {      
					//������
					visit[nextX][nextY] = 1;
					q.offer(new Node(nextX,nextY,cur.deepth+1,cur));
				}
			}
		}
		//˵���ߵ����û��
		if(cur.x==rows && cur.y==cols) {
			//��ӡ�ߵ�·��
			//printPath(cur);
			return cur.deepth;
		}else {
			return -1;
		}
	}
	

	
	//��ӡ��·��----���������ӡ����
	private static void printPath(Node cur) {
		if(null==cur) {
			return;
		}
		printPath(cur.pre);
		System.out.println(cur.x+","+cur.y);
	}
	
	
	
	
}
