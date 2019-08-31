package dptest;

/**
 * 	�ɻ������ţ���Ǯ����С������
 * @author lin
 *
 */
public class Code03Test02 {
	public static void main(String[] args) {
		int[] arr = {2,3,6};
		int aim = 1001;
		System.out.println(process(arr, arr.length-1, aim));
		System.out.println(dp(arr, aim));
		System.out.println(dp2(arr, aim));
		System.out.println(dp3(arr, aim));
	}
	
	//���ҵ�index���ǿ���ѡ�ģ�������С������
	private static int process(int[] arr,int index,int aim) {
		
		//���û��ˣ��ﵽĿ����
		if(aim==0) {
			return 0;
		}
		
		//ֻ��һ�Ż���
		if(index==0) {
			if(aim%arr[0]==0) {
				return aim/arr[0];
			}else {
				return Integer.MAX_VALUE;
			}
		}
		
		//һ��������ڲ�������������Լ��ڿ�ѡ��Χ�ڶ�ѡһ��
		int min = Integer.MAX_VALUE;
		for(int i=0;arr[index]*i<=aim;i++) {
			//���ﲻ��ֱ�Ӽ��ϣ���Ϊ���ֵ���϶����������Ҫ���ж�
			int temp = process(arr, index-1, aim-arr[index]*i);
			if(temp!=Integer.MAX_VALUE) {
				temp += i;
			}
			min = Math.min(min,temp);
		}
		return min;
	}
	

	private static int dp(int[] arr,int aim) {
		int[][] dp = new int[arr.length][aim+1];
		int rows = dp.length;
		int cols = dp[0].length;
		int erro = Integer.MAX_VALUE;
		//��һ�ж�Ϊ0,������
		
		//���һ��
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[0][j] = j/arr[0];
			}else {
				dp[0][j] = erro;
			}
		}
		//������
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				int min = erro;
				for(int k=0;arr[i]*k<=j;k++) {
					int temp = dp[i-1][j-arr[i]*k];
					if(temp!=erro) {
						temp+=k;
					}
					min = Math.min(min, temp);
				}
				dp[i][j] = min;
			}
		}
		//printM(dp);
		return dp[rows-1][cols-1];
	}
	
	//ʱ�临�ӶȵĸĽ�
	private static int dp2(int[] arr,int aim) {
		int[][] dp = new int[arr.length][aim+1];
		int rows = dp.length;
		int cols = dp[0].length;
		int erro = Integer.MAX_VALUE;
		//��һ�ж�Ϊ0,������
		
		//���һ��
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[0][j] = j/arr[0];
			}else {
				dp[0][j] = erro;
			}
		}
		//������
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				int min=dp[i-1][j];
				if(j-arr[i]>=0) {
					int temp = dp[i][j-arr[i]];
					if(temp!=erro) {
						temp += 1;
					}
					min = Math.min(min,temp);	
				}
				dp[i][j] = min;
			}
		}
		return dp[rows-1][cols-1];
	}
	
	//�ռ临�ӶȵĸĽ�
	private static int dp3(int[] arr,int aim) {
		int[] dp = new int[aim+1];
		int rows = arr.length;
		int cols = dp.length;
		int erro = Integer.MAX_VALUE;
		//��һ�ж�Ϊ0,������
		//���һ��
		for(int j=1;j<cols;j++) {
			if(j%arr[0]==0) {
				dp[j] = j/arr[0];
			}else {
				dp[j] = erro;
			}
		}
		//������
		for(int i=1;i<rows;i++) {
			for(int j=1;j<cols;j++) {
				int min=dp[j];
				if(j-arr[i]>=0) {
					int temp = dp[j-arr[i]];
					if(temp!=erro) {
						temp += 1;
					}
					min = Math.min(min,temp);	
				}
				dp[j] = min;
			}
		}
		//printM(dp);
		return dp[cols-1];
	}
	private static void printM(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
