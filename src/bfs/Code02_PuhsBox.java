package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ��һ�������ӵ���Ϸ, һ��ʼ���������ͼ:
	��ͼ��, '.' ��ʾ�ɵ����λ��, '#' ��ʾ���ɵ����λ�ã����� S ��ʾ����ʼ��λ��, 0��ʾ��ʼ���ӵ�λ��, E��ʾԤ�����ӵ�λ�ã�������ߵ����ӵ�������������һ��, ����������һ���ƶ�������ͼ�����������ƶ�һ��;
	..S0.. -> ...S0.
	
	ע�ⲻ�ܽ������ƶ���'#'��, Ҳ���ܽ������Ƴ��߽�;
	
	����, ������Ϸ�ĳ�ʼ����, ����Ҫ������ټ����ܹ������Ϸ, ����������, �����-1��
	
	��������:
	��һ��Ϊ2������,n, m, ��ʾ��Ϸ�����С��n ��m ��(5< n, m < 50);
	����Ϊn���ַ���,ÿ���ַ�����m�ַ�, ��ʾ��Ϸ����;
	
	�������:
	һ������,��ʾ���ټ����������Ϸ,�������,���-1;
	
	��������1:
	3 6
	
	.S#..E
	.#.0..
	......
	
	�������1:
	11
 *  �ο���https://blog.csdn.net/ansizhong9191/article/details/88370439
 * @author lin
 *
 */
public class Code02_PuhsBox {
	public static void main(String[] args) {
//		//����̨����
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
		//�����Բ�
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
	
	
	//�����ƶ��Ľ��
	private static class Node{
		//����λ��
		int bx;
		int by;
		//�˵�λ��
		int mx;
		int my;
		//���ߵĲ���
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
	
	//������ȱ���--�����ʼ�����ֹ��
	private static int bfs(int[][] m,int bx,int by,int ex,int ey,int mx,int my) {
		
		int rows = m.length;
		int cols = m[0].length;
		int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
		
		//��¼�ѵ���״̬
		//�����õ�����ά���飺������Ϊ���ӵ�λ��û�б䶯ʱ�������һ�Ŷ�ά�������Թ�һ�������ӵ�λ��һ���ƶ��ˣ�������˵�����һ���µĶ�ά��
		//��ΪvisitĿ��Ϊ�������Լ����߻�ͷ·����������Ѿ��ƶ��ˣ������е�·���൱�ڻָ���û�߹�����Ŀǰ��ʼ�������ƶ���������һ�������·��
		int[][][][] visited = new int[rows][cols][rows][cols];
		
		Node cur = new Node(bx, by, mx, my, 0);
		Queue<Node> q = new LinkedList<>();
		visited[mx][my][bx][by] = 1;
		q.offer(cur);
		
		while(!q.isEmpty()) {
			cur = q.poll();
			
			//Ѱ����һ��---�ĸ����򶼳���һ��
			for(int i=0;i<4;i++) {
				//�˵���һ��λ��
				int nMx = cur.mx+dir[0][i];
				int nMy = cur.my+dir[1][i];
				//���ӵ���һ��λ�ã���һ���õ���ֻ���ƵĹ��̲��õ�,���Ϊ�˵�ͬ�����ƶ�һ��
				int nBx = nMx+dir[0][i];
				int nBy = nMy+dir[1][i];
				
				
				//������֧���������ƶ��������£�����˵��ƶ�����һ���Ǻ��ӣ��ͺͺ���һ���ƶ�����Ȼ����ֻ���Լ��ƶ�
				//���һ�����ƶ�����һ��λ�ò������ӣ����Լ��ƶ����У����Թ��ҳ���һ�����һ��
				if(nMx>=0 &&nMx<rows && nMy>=0 && nMy<cols && m[nMx][nMy]!=1
				   && (nMx!=cur.bx || nMy!=cur.by) && visited[nMx][nMy][cur.bx][cur.by]!=1) {
					//System.out.println("men"+i);
					//������˵��ƶ�
					visited[nMx][nMy][cur.bx][cur.by] = 1;
					q.offer(new Node(cur.bx, cur.by, nMx, nMy, cur.depth+1));
					
				}else if(nBx>=0 && nBx<rows && nBy>=0 && nBy<cols && m[nBx][nBy]!=1
						&&(nMx==cur.bx && nMy==cur.by) && visited[nMx][nMy][nBx][nBy]!=1) {
					//��������˺�����һ���ƶ������ߵ������ӵ�λ������һ�����ߣ����Ҫ���������жϱ߽�
					
					//System.out.println("box");
					//�����ӱ䶯������£��ж�һ���Ƿ񵽴�Ŀ�ĵ�
					if(nBx==ex && nBy==ey) {
						//�������жϱ�������ж����Ŀ죬��ǰ��ֹ��������жϵĻ�Ҫ�ȵ����а�����ڵ㵯�����ܵ���
						//��1�Ǽ�����ζ���
						return cur.depth+1;
					}
					//û�е�����������
					visited[nMx][nMy][nBx][nBy]=1;
					q.offer(new Node(nBx, nBy, nMx, nMy, cur.depth+1));
				}
				
			}

		}
		//�����û�о����Ʋ���
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
