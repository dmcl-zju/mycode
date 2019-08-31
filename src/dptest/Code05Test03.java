package dptest;
/**
 * 	��Ǯ������3��arr�е�Ԫ�ش�����ң�����ȡ�����ţ������Ŀ�껻Ǯ������
 * @author LIN
 *
 */
public class Code05Test03 {
	public static void main(String[] args) {
		int[] arr = {5,10,25,1};
		int aim = 33;
		System.out.println(process(arr, arr.length-1, aim));
		System.out.println(dp(arr, aim));
		System.out.println(dp2(arr, aim));
		System.out.println(dp3(arr, aim));
	}
	
	//�����ݹ�
	private static int process(int[] arr,int index,int aim) {
		
		if(aim==0) {
			return 1;
		}
		if(index==0) {
			return aim%arr[index]==0?1:0;
		}
		
		int res = 0;
		//һ�����,�����ܻ������п���
		for(int i=0;arr[index]*i<=aim;i++) {
			res += process(arr, index-1, aim-arr[index]*i);
		}
		return res;
	}
	
	//ֱ�Ӷ�̬�滮
	private static int dp(int[] arr,int aim) {
		int rows = arr.length;
		int cols = aim+1;
		int[][] dp = new int[rows][cols];
		//��һ�ж���1
		for(int i=0;i<rows;i++) {
			dp[i][0] = 1;
		}
		//��һ��
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[0][j] = 1;
			}
		}
		//һ�����
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				int sum = 0;
				for(int k=0;arr[i]*k<=j;k++) {
					sum += dp[i-1][j-arr[i]*k];
				}
				dp[i][j] = sum;
			}
		}
		return dp[rows-1][cols-1];
	}
	//ʱ��Ľ�
	private static int dp2(int[] arr,int aim) {
		int rows = arr.length;
		int cols = aim+1;
		int[][] dp = new int[rows][cols];
		//��һ�ж���1
		for(int i=0;i<rows;i++) {
			dp[i][0] = 1;
		}
		//��һ��
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[0][j] = 1;
			}
		}
		//һ�����
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				dp[i][j] = dp[i-1][j];
				if(j-arr[i]>=0) {
					dp[i][j] += dp[i][j-arr[i]];
				}
			}
		}
		return dp[rows-1][cols-1];
	}
	//��һ���Ľ��ռ�
	private static int dp3(int[] arr,int aim) {
		int rows = arr.length;
		int cols = aim+1;
		int[] dp = new int[cols];
		//��һ�ж���1
		dp[0] = 1;
		//��һ��
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[j] = 1;
			}
		}
		//һ�����
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				//����ȡ��һ���ֵ������д������������
				//dp[j] = dp[j];
				//ȡ��ߵĸ��ӣ�Ϊ�Ѿ����¹����
				if(j-arr[i]>=0) {
					dp[j] += dp[j-arr[i]];
				}
			}
		}
		return dp[cols-1];
	}
}
