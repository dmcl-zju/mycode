package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * bfs和dfs基本练习--迷宫问题：从矩阵左上角走到右下角的最短路径，要求0为路，1为墙。
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
		
		//广度优先
		System.out.println("广搜");
		System.out.println(bfs(m));
		
		
		
		//深搜
		System.out.println("深搜");
		int[][] visited = new int[m.length][m[0].length];
		Node cur = new Node(0,0,0,null);
		dfs(m, visited, cur);
		System.out.println(end==null?-1:minPath);
		//printPath(end);

	}
	
	private static int minPath = Integer.MAX_VALUE;
	private static Node end;
	private static int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
	//dfs搜索
	private static void  dfs(int[][] m,int[][] visited,Node cur) {
		//如果走得通，更新最大值
		if(cur.x==m.length-1 && cur.y==m[0].length-1) {
			if(minPath>cur.deepth) {
				minPath = cur.deepth;
				end = cur;
			}
			return;
		}
		
		//标记访问
		visited[cur.x][cur.y] = 1;
		//查看可能性
		for(int i=0;i<4;i++) {
			int nextX = cur.x+dir[0][i];
			int nextY = cur.y+dir[1][i];
			//如果合法就进入下一层
			if(nextX>=0 && nextX<=m.length-1 && nextY>=0 && nextY<=m[0].length-1 && m[nextX][nextY]!=1 && visited[nextX][nextY]!=1) {      
				dfs(m, visited, new Node(nextX,nextY,cur.deepth+1,cur));
			}
			
		}
		//恢复标记为，这个标记位和bfs不一样，只为这一条探索服务，还要给其他的探索复用的
		visited[cur.x][cur.y] = 0;
		//这里也是一个返回，如果这条路最终走通了从最上面的终止条件返回，如果走不通就从这里返回
	}
		
	
	
	
	//注意点：加入队列之前就标记已经访问,如果出来后再标记会导致重复访问。
	private static int bfs(int[][] m) {
		int rows = m.length-1;
		int cols = m[0].length-1;
		
		int[][] visit = new int[m.length][m[0].length];
		//0/1/2/3----下右上左
		int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
		Queue<Node> q = new LinkedList<>();
		//起点加入
		Node cur = new Node(0,0,0,null);
		//标记已进入
		m[0][0] = 1;
		q.offer(cur);
		while(!q.isEmpty()) {
			cur = q.poll();
			//进行操作
			//是不是到了终点
			if(cur.x==rows && cur.y==cols) {
				break;
			}
		
			//四个方向尝试
			for(int i=0;i<4;i++) {
				int nextX = cur.x+dir[0][i];
				int nextY = cur.y+dir[1][i];
				
				if(nextX>=0 && nextX<=rows && nextY>=0 && nextY<=cols && m[nextX][nextY]!=1 && visit[nextX][nextY]!=1) {      
					//可以走
					visit[nextX][nextY] = 1;
					q.offer(new Node(nextX,nextY,cur.deepth+1,cur));
				}
			}
		}
		//说明走到最后都没到
		if(cur.x==rows && cur.y==cols) {
			//打印走的路径
			//printPath(cur);
			return cur.deepth;
		}else {
			return -1;
		}
	}
	

	
	//打印出路径----就是逆序打印链表
	private static void printPath(Node cur) {
		if(null==cur) {
			return;
		}
		printPath(cur.pre);
		System.out.println(cur.x+","+cur.y);
	}
	
	
	
	
}
