package bfs;

import java.util.LinkedList;
import java.util.Queue;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 迷宫问题练习----bfs和dfs
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
		//要看路径的时候用
		public Node(int x,int y, int deepth,Node pre) {
			this.x = x;
			this.y = y;
			this.pre = pre;
			this.deepth  = deepth;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("广度优先遍历================================");
		System.out.println(BFS(m, 0, 0, m.length-1, m[0].length-1));
		
		System.out.println("深度优先遍历================================");
		System.out.println(DFS(m, 0, 0, m.length-1, m[0].length-1));

	}
	//BFS求最短路径---
	//规则：结点放入队列时候检查是不是到达，到达就直接返回，没有才入队列
	//     在结点加入的时候标记，而不是取出队列的时候标记
	private static int BFS(int[][] m,int sX,int sY,int eX,int eY) {
		int rows = m.length;
		int cols = m[0].length;
		int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
		
		Node cur = new Node(sX,sY,0,null);
		Node end = null;
		Queue<Node> q = new LinkedList<>();
		int[][] visit = new int[rows][cols];
		//第一个放入
		q.add(cur);
		visit[sX][sY] = 1;
		
		outer:while(!q.isEmpty()) {
			
			cur = q.poll();
			//进行相关操作
			
			//找下一个结点
			for(int i=0;i<4;i++) {
				//获取下一步
				int nextX = cur.x+dir[0][i];
				int nextY = cur.y+dir[1][i];
				
				//System.out.println(cur.x+","+cur.y+"====="+nextX+"-"+nextY);
				
				//判断下一个点可以走吗，可以就放入队列
				if(nextX>=0 && nextX<rows && nextY>=0 &&nextY<cols && m[nextX][nextY]==0 && visit[nextX][nextY]==0) {
					
					//先判断终止情况
					if(nextX==eX && nextY==eY) {
						end = new Node(nextX,nextY,cur.deepth+1,cur);
						break outer;
					}
					//加入队列
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
	
	
	
	//全局变量用来记录最小
	private static Node end;
	private static int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
	//DFS搜索
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
	
	//首先这个函数的输入就是合法的
	private static void process(int[][] m,int[][] visit,Node cur,int endX,int endY) {
		//说明到了终点了
		if(cur.x==endX && cur.y==endY) {
			if(end==null) {
				end = cur;
			}else {
				if(cur.deepth<end.deepth) {
					end = cur;
				}
			}
		}
		//标志已经走过
		visit[cur.x][cur.y] = 1;
		//下一层
		for(int i=0;i<4;i++) {
			int nextX = cur.x+dir[0][i];
			int nextY = cur.y+dir[1][i];
			
			if(nextX>=0 && nextX<m.length && nextY>=0 && nextY<m[0].length && m[nextX][nextY]==0 && visit[nextX][nextY]==0) {
				process(m, visit, new Node(nextX,nextY,cur.deepth+1,cur), endX, endY);
			}
		}
		
		//最终这条路没得走了从这里返回出去,出去之前恢复标志位
		visit[cur.x][cur.y] = 0;
		
		
	}
	
	
	//打印最短路径
	private static void printPath(Node cur) {
		if(cur==null) {
			return;
		}
		
		printPath(cur.pre);
		System.out.println(cur.x+","+cur.y);
	}
	
	
	
	
	
}



