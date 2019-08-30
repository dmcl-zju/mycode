package dptest;

/**
 * 	��Ǯ������3��arr�е�Ԫ�ش�����ң�����ȡ�����ţ������Ŀ�껻Ǯ������
 * @author LIN
 *
 */
public class Code05 {
	public static void main(String[] args) {
		int[] arr = {5,10,25,1};
		System.out.println(process(arr, 150));
		
		System.out.println(process2(arr, 150));
	}
	//���ֽ����Ϸ��Ķ�λ-1
	private static int process(int[] arr,int aim) {
		int[][] dp = new int[arr.length][aim+1];
		int erro = -1;
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 1;
		}
		for(int j=1;j<dp[0].length;j++) {
			if(j-arr[0]>=0 && erro!=dp[0][j-arr[0]]) {
				dp[0][j] = 1;
			}else {
				dp[0][j] = erro;
			}
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//�Լ��ܲ���һ�����ϣ����ۼ��Ϸ�����
				if(j-arr[i]>=0 && erro!=dp[i][j-arr[i]]) {
					dp[i][j] = dp[i][j-arr[i]];
				}
				//�Լ������룬�������Ϸ�����������Ϸ���
				if(erro!=dp[i-1][j]) {
					dp[i][j] += dp[i-1][j];
				}
				if(dp[i][j]==0) {
					dp[i][j] = erro;
				}
			}
		}
		
		System.out.println("��ӡdp:");
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		
		return dp[dp.length-1][dp[0].length-1]==erro?-1:dp[dp.length-1][dp[0].length-1];	
	}
	
	//��������������ֱ�Ӳ������Ϸ��ģ�����0��������
	private static int process2(int[] arr,int aim) {
		int[][] dp = new int[arr.length][aim+1];
		int erro = -1;
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 1;
		}
		for(int j=1;j<dp[0].length;j++) {
			if(j-arr[0]>=0) {
				dp[0][j] += dp[0][j-arr[0]];
			}
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//�Լ��ܲ���һ�����ϣ����ۼ��Ϸ�����
				if(j-arr[i]>=0) {
					dp[i][j] = dp[i][j-arr[i]];
				}
				//�Լ������룬�������Ϸ�����������Ϸ���
				dp[i][j] += dp[i-1][j];
			}
		}
		
		System.out.println("��ӡdp:");
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		
		return dp[dp.length-1][dp[0].length-1]==erro?-1:dp[dp.length-1][dp[0].length-1];	
	}
	
}
