package dptest;
/**
 * 	��Ǯ������2��arr�е�Ԫ�ش�����ң�����0�Ż���1�ţ������Ŀ�����С������
 * 	˼·������һ��code03�����������ѡ��Ļ�ֻ����һ�ţ�ǰ����������,��Code02��Ŀ��ʵһ����Ҫ������˵�
 * @author LIN
 *
 */
public class Code04 {
	public static void main(String[] args) {
		int[] arr= {2,3,5,5,10};
		System.out.println(process(arr, 10));
	}
	private static int process(int[] arr,int aim) {
		int[][] dp = new int[arr.length][aim+1];
		int max = Integer.MAX_VALUE;
		//��Ϊ��ʼ������0��������Բ�д
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		for(int j=1;j<dp[0].length;j++) {
			//ֻ����ȵ�������ܻ����һ�����Ϊ1
			if(j==arr[0]) {
				dp[0][j]=1;
				continue;
			}
			dp[0][j] = max;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(j-arr[i]>=0 && max!=dp[i-1][j-arr[i]]) {
					dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-arr[i]]+1);
				}else {
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
		
		
		return dp[dp.length-1][dp[0].length-1]==max?-1:dp[dp.length-1][dp[0].length-1];	
	}
}
