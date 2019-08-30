package dptest;

/**
 * 	��Ǯ������1��arr�е�Ԫ�ش�����ң�����ȡ�����ţ������Ŀ�����С������
 * @author LIN
 *
 */
public class Code03 {
	public static void main(String[] args) {
		int[] arr = {2,3,5};
		System.out.println(process(arr, 15));
	}
	
	
	private static int process(int[] arr,int aim) {
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[arr.length][aim+1];
		//��һ�У�dp[i][0]:ȡ���������0����Ȼ����������ģ����һ���������0
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		//��һ�У�dp[0][i]:ֻ��arr[0]������ȡ���j,��Ϊ�ڵ�һ�У�ֻ���Լ�����һ�ż�����
		for(int j=1;j<dp[0].length;j++) {
			dp[0][j] = max;
			if((j-arr[0]>=0 && max!=dp[0][j-arr[0]])) {
				dp[0][j] = dp[0][j-arr[0]]+1;
			}
		}
		//����һ�����
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//����Լ��ܲ���һ������
				if((j-arr[i]>=0 && max!=dp[i][j-arr[i]])) {
					dp[i][j] = Math.min(dp[i-1][j],dp[i][j-arr[i]]+1);
				}else {
					//����Լ�һ�ζ�������,��ô���������ͺ�i-1���һ��
					dp[i][j] = dp[i-1][j];
				}
			}
		}
//		System.out.println("��ӡdp:");
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+"\t");
//			}
//			System.out.println();
//		}
		return dp[dp.length-1][dp[0].length-1];
	}
}
