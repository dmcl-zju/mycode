package bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * �Թ�������ϰ----bfs��dfs
 * @author lin
 *
 */

public class Code01_FindWayTest2 {
	
	
	private static int[][]  m = {
			{0, 1, 0, 0, 0},
			{0, 1, 0, 1, 0},
			{0, 0, 0, 0, 0},
			{0, 1, 0, 1, 0},
			{0, 0, 0, 0, 0},
		 };
	
	private static class Node{
		int x;
		int y;
		int deepth;
		Node pre;
		public Node(int x,int y,int deepth){
			this.x = x;
			this.y = y;
			this.deepth  = deepth;
		}
		//Ҫ��·����ʱ����
		public Node(int x,int y, int deepth,Node pre) {
			this.x = x;
			this.y = y;
			this.pre = pre;
			this.deepth  = deepth;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("������ȱ���================================");
		System.out.println(BFS(m, 0, 0, m.length-1, m[0].length-1));
		
		System.out.println("������ȱ���================================");
		System.out.println(DFS(m, 0, 0, m.length-1, m[0].length-1));

	}
	//BFS�����·��---
	//���򣺽��������ʱ�����ǲ��ǵ�������ֱ�ӷ��أ�û�в������
	//     �ڽ������ʱ���ǣ�������ȡ�����е�ʱ����
	private static int BFS(int[][] m,int sX,int sY,int eX,int eY) {
		int rows = m.length;
		int cols = m[0].length;
		int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
		
		Node cur = new Node(sX,sY,0,null);
		Node end = null;
		Queue<Node> q = new LinkedList<>();
		int[][] visit = new int[rows][cols];
		//��һ������
		q.add(cur);
		visit[sX][sY] = 1;
		
		outer:while(!q.isEmpty()) {
			
			cur = q.poll();
			//������ز���
			
			//����һ�����
			for(int i=0;i<4;i++) {
				//��ȡ��һ��
				int nextX = cur.x+dir[0][i];
				int nextY = cur.y+dir[1][i];
				
				//System.out.println(cur.x+","+cur.y+"====="+nextX+"-"+nextY);
				
				//�ж���һ����������𣬿��Ծͷ������
				if(nextX>=0 && nextX<rows && nextY>=0 &&nextY<cols && m[nextX][nextY]==0 && visit[nextX][nextY]==0) {
					
					//���ж���ֹ���
					if(nextX==eX && nextY==eY) {
						end = new Node(nextX,nextY,cur.deepth+1,cur);
						break outer;
					}
					//�������
					q.add(new Node(nextX,nextY,cur.deepth+1,cur));
					visit[nextX][nextY] = 1;
				}
				
			}
		}
		
		if(end==null) {
			return -1;
		}else {
			//printPath(end);
			return end.deepth;
		}
	}
	
	
	
	//ȫ�ֱ���������¼��С
	private static Node end;
	private static int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
	//DFS����
	private static int DFS(int[][] m,int startX,int startY,int endX,int endY) {
		int[][] visit = new int[m.length][m[0].length];
		Node cur = new Node(startX,startY,0,null);
		
		process(m, visit, cur, endX, endY);
		
		if(end==null) {
			return -1;
		}else {
			//printPath(end);
			return end.deepth;
		}
	}
	
	//�������������������ǺϷ���
	private static void process(int[][] m,int[][] visit,Node cur,int endX,int endY) {
		//˵�������յ���
		if(cur.x==endX && cur.y==endY) {
			if(end==null) {
				end = cur;
			}else {
				if(cur.deepth<end.deepth) {
					end = cur;
				}
			}
		}
		//��־�Ѿ��߹�
		visit[cur.x][cur.y] = 1;
		//��һ��
		for(int i=0;i<4;i++) {
			int nextX = cur.x+dir[0][i];
			int nextY = cur.y+dir[1][i];
			
			if(nextX>=0 && nextX<m.length && nextY>=0 && nextY<m[0].length && m[nextX][nextY]==0 && visit[nextX][nextY]==0) {
				process(m, visit, new Node(nextX,nextY,cur.deepth+1,cur), endX, endY);
			}
		}
		
		//��������·û�����˴����ﷵ�س�ȥ,��ȥ֮ǰ�ָ���־λ
		visit[cur.x][cur.y] = 0;
		
		
	}
	
	
	//��ӡ���·��
	private static void printPath(Node cur) {
		if(cur==null) {
			return;
		}
		
		printPath(cur.pre);
		System.out.println(cur.x+","+cur.y);
	}
	
	
	
	
	
}



