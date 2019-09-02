package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *	���� �Թ�����
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
	//������Ͻǣ��յ����½�
	private static boolean process(int[][] m) {
		
		//���������Ƿ���ʹ�0Ϊû�з��ʹ���1Ϊ���ʹ�
		int[][] visit = new int[m.length][m[0].length];
		//�������
		Node start = new Node(0,0,0,null);
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		Node cur = null;
		while(!q.isEmpty()) {
			cur = q.poll();
			//��ʶ�Ѿ�������
			visit[cur.x][cur.y] = 1;
			//�ж��Ƿ񵽴��յ�
			if(cur.x==m.length-1 && cur.y==m[0].length-1) {
				break;
			}
			//�ж���������������
			//���
			if(cur.x-1>=0 && m[cur.x-1][cur.y] !=1 && visit[cur.x-1][cur.y] !=1) {
				q.offer(new Node(cur.x-1,cur.y,cur.deepth+1,cur));
			}
			//�ϱ�
			if(cur.y-1>=0 && m[cur.x][cur.y-1] !=1 && visit[cur.x][cur.y-1] !=1) {
				q.offer(new Node(cur.x,cur.y-1,cur.deepth+1,cur));
			}
			//�ұ�
			if(cur.x+1<m[0].length && m[cur.x+1][cur.y] !=1 && visit[cur.x+1][cur.y] !=1) {
				q.offer(new Node(cur.x+1,cur.y,cur.deepth+1,cur));
			}
			//�±�
			if(cur.y+1<m.length && m[cur.x][cur.y+1] !=1 && visit[cur.x][cur.y+1] !=1) {
				q.offer(new Node(cur.x,cur.y+1,cur.deepth+1,cur));
			}
		}
		if(cur.x!=m.length-1 || cur.y!=m[0].length-1) {
			System.out.println("�޷���ͨ");
			return false;
		}
		
		
		//����ѭ�����cur�������һ���ڵ㣬���Խ��ڵ���ջ��Ȼ���ӡ����
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
	//�൱�������ӡ����
	private static void printRes(Node node) {
		if(node==null) {
			return;
		}
		printRes(node.pre);
		System.out.println(node.x+"-"+node.y);
	}
	
	
}


