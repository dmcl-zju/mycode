package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目描述
	假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。
	迷宫之中有的路上还有门，每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。请设计一个算法，帮助探险家找到脱困的最短路径。
	如前所述，迷宫是通过一个二维矩阵表示的，每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，小写字母-对应
	大写字母所代表的门的钥匙
	输入描述:
	迷宫的地图，用二维矩阵表示。第一行是表示矩阵的行数和列数M和N
	后面的M行是矩阵的数据，每一行对应与矩阵的一行（中间没有空格）。M和N都不超过100, 门不超过10扇。
	输出描述:
	路径的长度，是一个整数
	示例1
	输入
	复制
	5 5
	02111
	01a0A
	01003
	01001
	01111
	输出
	复制
	7
 * @author lin
 *	链接：https://www.nowcoder.com/questionTerminal/e3fc4f8094964a589735d640424b6a47?f=discussion
	来源：牛客网
	这题就是普通的bfs多了‘钥匙’这个状态
	 所以book[x][y][key]的意义就是 横坐标为x,纵坐标为y,钥匙状态为key的点是否访问过
	 钥匙的状态 就用二进制数表示 最多10 把钥匙 那就是1024
	 比如我现在有第二把钥匙和第四把钥匙  那么我的钥匙状态就是 0101000000 也就是 320
 */
public class Code06_HasKeyMap {
	

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    int M = s.nextInt();
	    int N = s.nextInt();
	    char[][] m= new char[M][N];
	    s.nextLine();
	    for(int i=0;i<M;i++) {
	    	String str = s.nextLine();
	    	m[i] = str.toCharArray();
	    }
	    
//	    for(int i=0;i<M;i++) {
//	    	for(int j=0;j<N;j++) {
//	    		System.out.print(m[i][j]+" ");
//	    	}
//	    	System.out.println();
//	    }
	    
	    System.out.println(bfs(m));   
	}
	
	private static class Node{
		int x;
		int y;
		int key;
		int deepth;
		
		public Node(int x, int y, int key,int deepth) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
			this.deepth = deepth;
		}
	}
	
	private static int bfs(char[][] m) {
		int rows = m.length;
		int cols = m[0].length;
		int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
		//第三个字段用来保存当前获取钥匙的状态
		int[][][] visit = new int[rows][cols][1024];
		
		int sx = 0;
		int sy = 0;
		//找到起点
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(m[i][j]=='2') {
					sx = i;
					sy = j;
				}
			}
		}
		//System.out.println(sx+"=="+sy);
		
		Node cur = new Node(sx,sy,0,0);
		Queue<Node> q = new LinkedList<>();
		visit[cur.x][cur.y][cur.key] = 1;
		q.offer(cur);
		while(!q.isEmpty()) {
			
			cur = q.poll();
			
			//寻找接下来的路径
			for(int i=0;i<4;i++) {
				int nextX = cur.x+dir[0][i];
				int nextY = cur.y+dir[1][i];
				
				//System.out.println("尝试"+nextX+"=="+nextY);
				//下一步
				//一般非法情况
				if(nextX<0 || nextX>=rows || nextY<0 || nextY>=cols || m[nextX][nextY]=='0' || visit[nextX][nextY][cur.key]==1) {
					//System.out.println("失败"+nextX+"=="+nextY);
					continue;
				}
				
				//System.out.println("成功"+nextX+"=="+nextY);
				
				//判断下一步是不是终点
				if(m[nextX][nextY]=='3') {
					return cur.deepth+1;
				}
				
				//下一步是钥匙
				if(m[nextX][nextY]>='a' && m[nextX][nextY]<='z') {
					//拿起钥匙
					int newkey = cur.key | (1<<(m[nextX][nextY]-'a'));
					visit[nextX][nextY][newkey] = 1;
					q.offer(new Node(nextX, nextY, newkey, cur.deepth+1));
					continue;
				}
				//下一步是门
				if(m[nextX][nextY]>='A' && m[nextX][nextY]<='Z') {
					//有钥匙开门，就向前进
					if((cur.key & (1<<(m[nextX][nextY]-'A')))!=0) {
						visit[nextX][nextY][cur.key] = 1;
						q.offer(new Node(nextX, nextY, cur.key, cur.deepth+1));
					}
					continue;
				}
				//正常情况
				visit[nextX][nextY][cur.key] = 1;
				q.offer(new Node(nextX, nextY, cur.key, cur.deepth+1));
			}	
		}
		
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
