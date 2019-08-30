package dptest;

/** �ӵݹ��������̬�滮������
 * 	��Ǯ������2��arr�е�Ԫ�ش�����ң�����0�Ż���1�ţ������Ŀ�����С������
 * 	˼·������һ��code03�����������ѡ��Ļ�ֻ����һ�ţ�ǰ����������,��Code02��Ŀ��ʵһ����Ҫ������˵�
 * @author LIN
 *
 */
public class Code04Test {
	public static void main(String[] args) {
		int[] arr= {2,3,5,5,10};
		
		System.out.println(process(arr,0,9));
		System.out.println(dp(arr, 9));
	}
	
	private static int process(int[] arr,int index,int aim) {
		//û�л��ҿ�ѡ��
		if(index==arr.length) {
			//˵����������
			if(aim==0) {
				return 0;
			}else {
				return Integer.MAX_VALUE;
			}
		}
		//һ�����
		//�Լ�����ѡ�����
		int min = process(arr, index+1, aim);
		//�Լ�����ѡ��
		if(aim-arr[index]>=0) {
			int temp = process(arr, index+1, aim-arr[index]);
			if(temp != Integer.MAX_VALUE) {
				min = Math.min(min, 1+process(arr, index+1, aim-arr[index]));
			}	
		}
		return min;
	}
	//��Ϊ��̬�滮
	private static int dp(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		int erro = Integer.MAX_VALUE;
		//��һ��ȫ��Ϊ0�Ͳ�����
		//���һ��
		for(int j=1;j<=aim;j++) {
			dp[dp.length-1][j] = erro;
		}
		//һ�����
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<=aim;j++) {
				dp[i][j] = dp[i+1][j];
				
				if(j-arr[i]>=0) {
					if(dp[i+1][j-arr[i]]!=erro) {
						dp[i][j]= Math.min(dp[i][j],1+dp[i+1][j-arr[i]]);
					}
				}
			}
		}
	
		return dp[0][aim]==erro?-1:dp[0][aim];
	}
	
	
}
