package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *	经典 迷宫问题
 * @author lin
 *
 */
public class Code01_FindWay {
	public static class Node{
		int x;
		int y;
		int deepth;
		Node pre;
		public Node(int x,int y,int deepth,Node pre) {
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
						{0, 1, 0, 0, 0},
						{0, 1, 0, 1, 0},
						{0, 0, 0, 1, 0},
					 };
		
		process(m);
	}
	//起点左上角，终点右下角
	private static boolean process(int[][] m) {
		
		//定义矩阵存是否访问过0为没有访问过，1为访问过
		int[][] visit = new int[m.length][m[0].length];
		//定义起点
		Node start = new Node(0,0,0,null);
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		Node cur = null;
		while(!q.isEmpty()) {
			cur = q.poll();
			//标识已经来过了
			visit[cur.x][cur.y] = 1;
			//判断是否到达终点
			if(cur.x==m.length-1 && cur.y==m[0].length-1) {
				break;
			}
			//判断上下左右能走吗
			//左边
			if(cur.x-1>=0 && m[cur.x-1][cur.y] !=1 && visit[cur.x-1][cur.y] !=1) {
				q.offer(new Node(cur.x-1,cur.y,cur.deepth+1,cur));
			}
			//上边
			if(cur.y-1>=0 && m[cur.x][cur.y-1] !=1 && visit[cur.x][cur.y-1] !=1) {
				q.offer(new Node(cur.x,cur.y-1,cur.deepth+1,cur));
			}
			//右边
			if(cur.x+1<m[0].length && m[cur.x+1][cur.y] !=1 && visit[cur.x+1][cur.y] !=1) {
				q.offer(new Node(cur.x+1,cur.y,cur.deepth+1,cur));
			}
			//下边
			if(cur.y+1<m.length && m[cur.x][cur.y+1] !=1 && visit[cur.x][cur.y+1] !=1) {
				q.offer(new Node(cur.x,cur.y+1,cur.deepth+1,cur));
			}
		}
		if(cur.x!=m.length-1 || cur.y!=m[0].length-1) {
			System.out.println("无法走通");
			return false;
		}
		
		
		//跳出循环后的cur就是最后一个节点，可以将节点入栈，然后打印出来
		//System.out.println(cur.deepth+"----"+cur.x+"-----"+cur.y);
		
//		Stack<Node> stack = new Stack<>();
//		while(cur != null) {
//			stack.push(cur);
//			cur = cur.pre;	
//		}
//		while(!stack.isEmpty()) {
//			cur = stack.pop();
//			System.out.println(cur.x+"-"+cur.y);
//		}
		
		printRes(cur);
		return true;
	}
	//相当于逆序打印链表
	private static void printRes(Node node) {
		if(node==null) {
			return;
		}
		printRes(node.pre);
		System.out.println(node.x+"-"+node.y);
	}
	
	
}


