package dptest;

import java.util.List;
import java.util.Stack;

/**
 * 	����·���ĵݹ鷽ʽ
 * @author lin
 *
 */
public class Code01Test01 {
	public static void main(String[] args) {
		int[][] m = {{1,3,5,9},
					 {8,1,3,4},
					 {5,0,6,1},
					 {8,8,4,0}};
		
		
		System.out.println(process(m, m.length-1, m[0].length-1));
		System.out.println(dp(m));
		System.out.println(dp2(m));
	}
	
	//xy��ʾ��Ŀ�ĵ�
	public static int process(int[][] m,int x,int y) {
		
		if(x==0 && y==0) {
			return m[0][0];
		}
		
		//����ڵ�һ��
		if(x==0) {
			return m[0][y]+process(m, 0, y-1);
		}
		//����ڵ�һ��
		if(y==0) {
			return m[x][0]+process(m, x-1, 0);
		}
		//һ�������
		return m[x][y]+Math.min(process(m, x, y-1), process(m, x-1, y));		
	}
	
	//��̬�滮---���Դ�ӡ·��
	public static int dp(int[][] m) {
		int rows = m.length;
		int cols = m[0].length;
		int[][] dp = new int[rows][cols];
		
		dp[0][0] = m[0][0];
		for(int i=1;i<rows;i++) {
			dp[i][0] = m[i][0]+dp[i-1][0];
		}
		for(int j=1;j<cols;j++) {
			dp[0][j] = m[0][j]+dp[0][j-1];
		}
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				dp[i][j] = m[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
			}
		}
		
		//��ӡ·��
		int row = dp.length-1;
		int col = dp[0].length-1;
		Stack<Integer> stack = new Stack<>();
		stack.push(m[row][col]);
		while(row>=0&&col>=0) {
			int temp = dp[row][col]-m[row][col];
			if(row-1>=0 && temp==dp[row-1][col]) {
				//˵����ѡ���ϱ�
				stack.push(m[row-1][col]);
				row--;
			}else if(col-1>=0){
				//˵�����������
				stack.push(m[row][col-1]);
				col--;
			}else {
				break;
			}
		}
		System.out.print("���·��Ϊ��");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+"     ");
		}
		System.out.println();
		return dp[rows-1][cols-1];
	}
	
	//��̬�滮�ռ�Ľ�-----�޷���ӡ·��
	public static int dp2(int[][] m) {
		int rows = m.length;
		int cols = m[0].length;
		int[] dp = new int[cols];
		//��һ��
		dp[0] = m[0][0];
		for(int j=1;j<cols;j++) {
			dp[j] = m[0][j]+dp[j-1];
		}
		
		//������
		for(int i=1;i<rows;i++) {
			//��һ�����ر���
			dp[0] = m[i][0]+dp[0];
			for(int j=1;j<cols;j++) {
				//�����dp[j-1]��Ϊ֮ǰ�����ˣ���������ߣ�dp[j]��δ��������Ϊ�ϱ�
				dp[j] = m[i][j]+Math.min(dp[j-1], dp[j]);
			}
		}
		return dp[cols-1];
	}
}
