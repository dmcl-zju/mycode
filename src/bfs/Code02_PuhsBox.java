package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 有一个推箱子的游戏, 一开始的情况如下图:
	上图中, '.' 表示可到达的位置, '#' 表示不可到达的位置，其中 S 表示你起始的位置, 0表示初始箱子的位置, E表示预期箱子的位置，你可以走到箱子的上下左右任意一侧, 将箱子向另一侧推动。如下图将箱子向右推动一格;
	..S0.. -> ...S0.
	
	注意不能将箱子推动到'#'上, 也不能将箱子推出边界;
	
	现在, 给你游戏的初始样子, 你需要输出最少几步能够完成游戏, 如果不能完成, 则输出-1。
	
	输入描述:
	第一行为2个数字,n, m, 表示游戏盘面大小有n 行m 列(5< n, m < 50);
	后面为n行字符串,每行字符串有m字符, 表示游戏盘面;
	
	输出描述:
	一个数字,表示最少几步能完成游戏,如果不能,输出-1;
	
	输入例子1:
	3 6
	
	.S#..E
	.#.0..
	......
	
	输出例子1:
	11
 *  参考：https://blog.csdn.net/ansizhong9191/article/details/88370439
 * @author lin
 *
 */
public class Code02_PuhsBox {
	public static void main(String[] args) {
//		//控制台输入
//		Scanner s = new Scanner(System.in);
//		int n = s.nextInt();
//		int m = s.nextInt();
//		int[][] mtrix = new int[n][m];
//		int bx = 0;
//		int by = 0;
//		int ex = 0;
//		int ey = 0;
//		int mx = 0;
//		int my = 0;
//		//PriorityQueue<Node> heap = new PriorityQueue<>();
//		String str = s.nextLine();
//		for(int i=0;i<mtrix.length;i++) {
//			str = s.nextLine();
//			for(int j=0;j<mtrix[0].length;j++) {
//				if(str.charAt(j)=='#') {
//					mtrix[i][j] = 1;
//				}else {
//					mtrix[i][j] = 0;
//					if(str.charAt(j)=='S') {
//						mx = i;
//						my = j;
//					}else if(str.charAt(j)=='E') {
//						ex = i;
//						ey = j;
//					}else if(str.charAt(j)=='0') {
//						bx = i;
//						by = j;
//					}
//				}
//				
//			}
//		}	
		//本地自测
		int[][]  m2 = {
				{0, 0, 1, 0, 0, 0},
				{0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0},
			  };
		
		int bx = 1;
		int by = 3;
		int ex = 0;
		int ey = 5;
		int mx = 0;
		int my = 1;
		System.out.println(bfs(m2, bx, by, ex, ey, mx, my));
		
//		System.out.println(bfs(mtrix, bx, by, ex, ey, mx, my));
	
		
	}
	
	
	//定义移动的结点
	private static class Node{
		//箱子位置
		int bx;
		int by;
		//人的位置
		int mx;
		int my;
		//人走的步数
		int depth;
		//Node pre;
		/**
		 * @param bx
		 * @param by
		 * @param mx
		 * @param my
		 * @param depth
		 */
		public Node(int bx, int by, int mx, int my, int depth) {
			super();
			this.bx = bx;
			this.by = by;
			this.mx = mx;
			this.my = my;
			this.depth = depth;
		}
	}
	
	//宽度优先遍历--传入初始点和终止点
	private static int bfs(int[][] m,int bx,int by,int ex,int ey,int mx,int my) {
		
		int rows = m.length;
		int cols = m[0].length;
		int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
		
		//记录已到达状态
		//这里用到了四维数组：可以认为箱子的位置没有变动时候，这就是一张二维表，和找迷宫一样，箱子的位置一旦移动了，对人来说这就是一张新的二维表
		//因为visit目的为了限制自己不走回头路，如果箱子已经推动了，那所有的路就相当于恢复到没走过，从目前开始重新算推动箱子走下一步的最短路径
		int[][][][] visited = new int[rows][cols][rows][cols];
		
		Node cur = new Node(bx, by, mx, my, 0);
		Queue<Node> q = new LinkedList<>();
		visited[mx][my][bx][by] = 1;
		q.offer(cur);
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			//寻找下一步---四个方向都尝试一下
			for(int i=0;i<4;i++) {
				//人的下一个位置
				int nMx = cur.mx+dir[0][i];
				int nMy = cur.my+dir[1][i];
				//箱子的下一个位置，不一定用到，只有推的过程采用到,因此为人的同方向移动一个
				int nBx = nMx+dir[0][i];
				int nBy = nMy+dir[1][i];
				
				
				//两个分支：在满足移动的条件下，如果人的移动的下一格是盒子，就和盒子一起移动，不然就是只有自己移动
				//情况一：人移动的下一个位置不是箱子，就自己移动就行，和迷宫找出口一样变成一样
				if(nMx>=0 &&nMx<rows && nMy>=0 && nMy<cols && m[nMx][nMy]!=1
				   && (nMx!=cur.bx || nMy!=cur.by) && visited[nMx][nMy][cur.bx][cur.by]!=1) {
					//System.out.println("men"+i);
					//常规的人的移动
					visited[nMx][nMy][cur.bx][cur.by] = 1;
					q.offer(new Node(cur.bx, cur.by, nMx, nMy, cur.depth+1));
					
				}else if(nBx>=0 && nBx<rows && nBy>=0 && nBy<cols && m[nBx][nBy]!=1
						&&(nMx==cur.bx && nMy==cur.by) && visited[nMx][nMy][nBx][nBy]!=1) {
					//情况二：人和箱子一起移动，人走的是箱子的位置所以一定能走，因此要以箱子来判断边界
					
					//System.out.println("box");
					//有箱子变动的情况下，判断一下是否到达目的地
					if(nBx==ex && nBy==ey) {
						//在这里判断比在外层判断来的快，提前终止，在外层判断的话要等到队列吧这个节点弹出才能到达
						//加1是加上这次动作
						return cur.depth+1;
					}
					//没有到达继续入队列
					visited[nMx][nMy][nBx][nBy]=1;
					q.offer(new Node(nBx, nBy, nMx, nMy, cur.depth+1));
				}
				
			}

		}
		//如果都没有就是推不到
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
