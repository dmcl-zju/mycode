package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ��Ŀ����
	����һ��̽�ռұ������˵ص׵��Թ�֮�У�Ҫ�ӵ�ǰλ�ÿ�ʼ�ҵ�һ��ͨ���Թ����ڵ�·�����Թ�������һ����ά������ɣ��еĲ�����ǽ���еĲ�����·��
	�Թ�֮���е�·�ϻ����ţ�ÿ���Ŷ����Թ���ĳ���ط�����֮ƥ���Կ�ף�ֻ�����õ�Կ�ײ��ܴ��š������һ���㷨������̽�ռ��ҵ����������·����
	��ǰ�������Թ���ͨ��һ����ά�����ʾ�ģ�ÿ��Ԫ�ص�ֵ�ĺ������� 0-ǽ��1-·��2-̽�ռҵ���ʼλ�ã�3-�Թ��ĳ��ڣ���д��ĸ-�ţ�Сд��ĸ-��Ӧ
	��д��ĸ��������ŵ�Կ��
	��������:
	�Թ��ĵ�ͼ���ö�ά�����ʾ����һ���Ǳ�ʾ���������������M��N
	�����M���Ǿ�������ݣ�ÿһ�ж�Ӧ������һ�У��м�û�пո񣩡�M��N��������100, �Ų�����10�ȡ�
	�������:
	·���ĳ��ȣ���һ������
	ʾ��1
	����
	����
	5 5
	02111
	01a0A
	01003
	01001
	01111
	���
	����
	7
 * @author lin
 *	���ӣ�https://www.nowcoder.com/questionTerminal/e3fc4f8094964a589735d640424b6a47?f=discussion
	��Դ��ţ����
	���������ͨ��bfs���ˡ�Կ�ס����״̬
	 ����book[x][y][key]��������� ������Ϊx,������Ϊy,Կ��״̬Ϊkey�ĵ��Ƿ���ʹ�
	 Կ�׵�״̬ ���ö���������ʾ ���10 ��Կ�� �Ǿ���1024
	 �����������еڶ���Կ�׺͵��İ�Կ��  ��ô�ҵ�Կ��״̬���� 0101000000 Ҳ���� 320
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
		//�������ֶ��������浱ǰ��ȡԿ�׵�״̬
		int[][][] visit = new int[rows][cols][1024];
		
		int sx = 0;
		int sy = 0;
		//�ҵ����
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
			
			//Ѱ�ҽ�������·��
			for(int i=0;i<4;i++) {
				int nextX = cur.x+dir[0][i];
				int nextY = cur.y+dir[1][i];
				
				//System.out.println("����"+nextX+"=="+nextY);
				//��һ��
				//һ��Ƿ����
				if(nextX<0 || nextX>=rows || nextY<0 || nextY>=cols || m[nextX][nextY]=='0' || visit[nextX][nextY][cur.key]==1) {
					//System.out.println("ʧ��"+nextX+"=="+nextY);
					continue;
				}
				
				//System.out.println("�ɹ�"+nextX+"=="+nextY);
				
				//�ж���һ���ǲ����յ�
				if(m[nextX][nextY]=='3') {
					return cur.deepth+1;
				}
				
				//��һ����Կ��
				if(m[nextX][nextY]>='a' && m[nextX][nextY]<='z') {
					//����Կ��
					int newkey = cur.key | (1<<(m[nextX][nextY]-'a'));
					visit[nextX][nextY][newkey] = 1;
					q.offer(new Node(nextX, nextY, newkey, cur.deepth+1));
					continue;
				}
				//��һ������
				if(m[nextX][nextY]>='A' && m[nextX][nextY]<='Z') {
					//��Կ�׿��ţ�����ǰ��
					if((cur.key & (1<<(m[nextX][nextY]-'A')))!=0) {
						visit[nextX][nextY][cur.key] = 1;
						q.offer(new Node(nextX, nextY, cur.key, cur.deepth+1));
					}
					continue;
				}
				//�������
				visit[nextX][nextY][cur.key] = 1;
				q.offer(new Node(nextX, nextY, cur.key, cur.deepth+1));
			}	
		}
		
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
