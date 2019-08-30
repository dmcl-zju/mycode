package dptest;

/**
 * 	�ɻ������ţ���Ǯ����С������
 * @author lin
 *
 */
public class Code03Test {
	public static void main(String[] args) {
		int[] arr = {2,3,6};
		int aim = 1001;
		System.out.println(process(arr, 0, aim));
		System.out.println(dp1(arr, aim));
		System.out.println(dp2(arr, aim));
	}
	
	private static int process(int[] arr,int index,int aim) {
		//û��Ǯ��ѡ������aim����0�������ֵ��ʾ���ܻ�
		if(index==arr.length) {
			return aim==0?0:Integer.MAX_VALUE;
		}
		//�ڲ���������³���
		int min = Integer.MAX_VALUE;
		for(int i=0;arr[index]*i<=aim;i++) {
			//�Լ�����i��
			int cur = process(arr, index+1, aim-arr[index]*i);
			if(cur==Integer.MAX_VALUE) {
				//˵�����ַ�������
				continue;
			}
			//˵�����ԣ�������Сֵ�ж�
			cur += i;
			min = Math.min(min,cur);
		}
		return min;
	}
	
	//�ĳɶ�̬�滮
	private static int dp1(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		int erro = Integer.MAX_VALUE;
		
		//�������һ��
		for(int j=1;j<=aim;j++) {
			dp[dp.length-1][j] = erro;
		}
		//���һ�У�����0
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		
		//�������
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<=aim;j++) {
				
				//�������С
				dp[i][j] = erro;
				for(int k=0;arr[i]*k<=j;k++) {
					//���Ϸ�
					if(dp[i+1][j-arr[i]*k]==erro) {
						continue;
					}
					//�Ϸ���ֵ
					dp[i][j] = Math.min(dp[i][j], k+dp[i+1][j-arr[i]*k]);
				}
					
			}
		}
		return dp[0][aim];
	}
	
	//��̬�滮�ĸĽ�
	private static int dp2(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		int erro = Integer.MAX_VALUE;
		
		//�������һ��
		for(int j=1;j<=aim;j++) {
			dp[dp.length-1][j] = erro;
		}
		//���һ�У�����0
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		
		//�������
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<=aim;j++) {
				
				//�������С
				dp[i][j] = dp[i+1][j];
				//ǰһ�������ҺϷ�
				if(j-arr[i]>=0 && dp[i][j-arr[i]]!=erro ) {
					//�����һ��ָ���ǵ�ǰѡ��һ��
					dp[i][j] = Math.min(dp[i][j], 1+dp[i][j-arr[i]]);
				}
			}
		}
		return dp[0][aim];
	}
	
	
	
}
