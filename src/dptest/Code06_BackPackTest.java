package dptest;

/**
 * ��������
 * @author lin
 *
 */
public class Code06_BackPackTest {
	public static void main(String[] args) {
		int[] m = {10,5,6};
		int[] p = {10,2,8};
		int bag = 16;
		
		System.out.println(process1(m, p, 0, bag));
		System.out.println(dp1(m, p, bag));
		System.out.println(process2(m, p, m.length-1, bag));
		System.out.println(dp2(m, p, bag));
		System.out.println(dp3(m, p, bag));
	
	}
	//index����֮��Ķ���ѡ���������ֵ
	private static int process1(int[] m,int[] p,int index,int bag) {
		//����ȫ��ѡ����
		if(index==m.length) {
			return 0;
		}
		
		//��ǰ����
		int res = process1(m, p, index+1, bag);
		
		if(bag-m[index]>=0) {
			res =Math.max(res,p[index]+process1(m, p, index+1, bag-m[index]));
		}
		return res;
	}
	
	private static int dp1(int[] m,int[] p,int bag) {
		int[][] dp = new int[m.length+1][bag+1];
		int rows = dp.length;
		int cols = dp[0].length;
		//���һ�к͵�һ�ж�Ϊ0�����Բ���
		for(int i=rows-2;i>=0;i--) {
			for(int j=1;j<cols;j++) {
				dp[i][j] = dp[i+1][j];
				if(j-m[i]>=0) {
					dp[i][j] = Math.max(dp[i][j], p[i]+dp[i+1][j-m[i]]);
				}
			}
		}
		return dp[0][cols-1];
	}
	
	//��ʽ����index����֮ǰ�Ŀ���ѡ
	private static int process2(int[] m,int[] p,int index,int bag) {
		
		if(index==0) {
			return bag>=m[index]?p[index]:0;
		}
		
		int res = process2(m, p, index-1, bag);
		if(bag-m[index]>=0) {
			res = Math.max(res, p[index]+process2(m, p, index-1, bag-m[index]));
		}
		return res;
	}
	
	private static int dp2(int[] m,int[] p,int bag) {
		int[][] dp = new int[m.length][bag+1];
		int rows = dp.length;
		int cols = dp[0].length;
		//��һ��
		for(int j=1;j<cols;j++) {
			if(j>=m[0]) {
				dp[0][j] = m[0];
			}
		}
		
		//����
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				dp[i][j] = dp[i-1][j];
				if(j-m[i]>=-0) {
					dp[i][j] = Math.max(dp[i][j],p[i]+dp[i-1][j-m[i]]);
				}
			}
		}
		return dp[rows-1][cols-1];
	}
	
	//��ʽ�����ڷ�ʽ���Ͽռ��Ż�,ÿ�����������ڵĶ�����һ�У������Ż�
	private static int dp3(int[] m,int[] p,int bag) {
		int[] dp = new int[bag+1];
		int cols = dp.length;
		int rows = m.length;
		//��һ��
		for(int j=1;j<cols;j++) {
			if(j>=m[0]) {
				dp[j] = m[0];
			}
		}
//		//������--����д�������
//		for(int i=1;i<rows;i++) {
//			for(int j=cols-1;j>=0;j--) {
//				int max = dp[j];
//				if(j-m[i]>=0) {
//					max = Math.max(max, p[i]+dp[j-m[i]]);
//				}
//				dp[j] = max;
//			}
//		}
		//����д������
		for(int i=1;i<rows;i++) {
			for(int j=cols-1;j>=0;j--) {
				if(j-m[i]>=0) {
					dp[j] = Math.max(dp[j], p[i]+dp[j-m[i]]);
				}
			}
		}
		return dp[cols-1];
	}
	
	
	
	
	
}
