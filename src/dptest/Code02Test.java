package dptest;

/**
 * ����Ԫ����ɺ͵ݹ�
 * @author lin
 *
 */
public class Code02Test {
	public static void main(String[] args) {
		int[] arr = {2,2,5,4};
		int aim = 4;
		System.out.println(process(arr, 0, aim));
		System.out.println(dp(arr, aim));
		
	}
	
	//��index��ʼ����index���ڶ���ѡ
	private static boolean process(int[] arr,int index,int aim) {
		
		//���û�п�ѡ����
		if(index==arr.length) {
			return aim==0;
		}
		//����������г���,ֻ������������Լ������룬�Լ�����
		return process(arr, index+1, aim) || process(arr, index+1, aim-arr[index]);
	}
	
	//��Ϊ��̬�滮
	private static boolean dp(int[] arr,int aim) {
		boolean[][] dp = new boolean[arr.length+1][aim+1];
		//�������
		//ֻ�е�һ��Ϊtrue,������ΪfalseĬ�ϵ�
		dp[dp.length-1][0] = true;
		
		//�������
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=0;j<=aim;j++) {
				dp[i][j] = dp[i+1][j];
				if(j-arr[i]>=0) {
					dp[i][j] = dp[i][j] || dp[i+1][j-arr[i]];
				}
			}
		}
		return dp[0][aim];
		
	}
	
}
