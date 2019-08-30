package dptest;

import java.awt.List;
import java.util.Stack;

/**
 * 	�������С·����
 * @author LIN
 *
 */
public class Code01 {
	public static void main(String[] args) {
		int[][] m = {{1,3,5,9},
					 {8,1,3,4},
					 {5,0,6,1},
					 {8,8,4,0}};
		System.out.println("·����Ϊ��"+dp(m));
	}
	
	private static int dp(int[][] m) {
		if(null==m || m.length==0) {
			return 0;
		}
		int[][] dp = new int[m.length][m[0].length];
		dp[0][0] = m[0][0];
		//��һ��dp[i][0]ֻ���ܴ������������������ܴ�����߹���
		for(int i=1;i<dp.length;i++) {
			dp[i][0] = dp[i-1][0]+m[i][0];
		}
		//��һ��dp[0][j]ֻ���ܴ������������������ܴ�����߹���
		for(int j=1;j<dp.length;j++) {
			dp[0][j] = dp[0][j-1]+m[0][j];
		}
		//����һ�������ȡ�����������С·��
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+m[i][j];
			}
		}
		
		////////////////////////��ӡ��·��////////////////////
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
		
		return dp[dp.length-1][dp[0].length -1];	
	}
}
