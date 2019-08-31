package mypractice;

/**
 * ��������
 * @author lin
 *
 */
public class BcakTest {
	public static void main(String[] args) {
		int[] m = {10,5,6};
		int[] p = {10,2,8};
		int bag = 16;
		System.out.println(process(m, p, m.length-1, bag));
		System.out.println(dp(m, p, bag));
		System.out.println(dp1(m, p, bag));
	}
	
	
	private static int process(int[] m,int[] p,int index,int bag) {
		if(bag==0) {
			return 0;
		}
		if(index==0) {
			if(bag>=m[0]) {
				return p[0];
			}
			return 0;
		}
		int max = process(m, p, index-1, bag);
		if(bag-m[index]>=0) {
			max = Math.max(max, p[index]+process(m, p, index-1, bag-m[index])); 
		}
		return max;
	}
	
	//��̬�滮
	private static int dp(int[] m,int[] p,int bag) {
		int rows = m.length;
		int cols = bag+1;
		int[][] dp = new int[rows][cols];
		//��һ�в�����
		//��һ��
		for(int j=1;j<cols;j++) {
			dp[0][j] = j>=m[0]?p[0]:0;
		}
		//������
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				dp[i][j] = dp[i-1][j];
				if(j-m[i]>=0) {
					dp[i][j] = Math.max(dp[i][j], p[i]+dp[i-1][j-m[i]]);
				}
			}
		}
	
		return dp[rows-1][cols-1];
	}
	//�ռ�Ľ�
	private static int dp1(int[] m,int[] p,int bag) {
		int rows = m.length;
		int cols = bag+1;
		int[] dp = new int[cols];
		//��һ�в�����
		//��һ��
		for(int j=1;j<cols;j++) {
			dp[j] = j>=m[0]?p[0]:0;
		}
		//������
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				if(j-m[i]>=0) {
					dp[j] = Math.max(dp[j], p[i]+dp[j-m[i]]);
				}
			}
		}
	
		return dp[cols-1];
	}
	
	
	
}
