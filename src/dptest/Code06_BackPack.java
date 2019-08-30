package dptest;

/**
 * 	��������
 * @author LIN
 *
 */
public class Code06_BackPack {
	public static void main(String[] args) {
		int[] m = {10,5,6};
		int[] p = {10,2,8};
		System.out.println(process(p, m, 16));
	}
	
	private static int process(int[] p,int[] m,int bag) {
		int[][] dp = new int[p.length][bag+1];
		//��һ�У���������Ϊ0����Ϊ0
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		//��һ��
		for(int j=1;j<dp[0].length;j++) {
			//ֻҪ��װ�ϣ����������Ʒ�ļ�ֵ
			if(j-m[0]>=0) {
				dp[0][j] = p[0];
			}else {
				dp[0][j] = 0;
			}
		}
		//һ�����
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//��ǰ��Ʒ��װ��
				if(j-m[i]>=0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-m[i]]+p[i]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}
