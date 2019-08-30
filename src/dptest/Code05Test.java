package dptest;

/**
 * 	��Ǯ�ķ������ݹ鳢��
 * @author lin
 *
 */
public class Code05Test {
	
	public static void main(String[] args) {
		int[] arr = {5,10,25,1};
		System.out.println(process1(arr, arr.length-1,150));
		System.out.println(process2(arr, 0,150));
		System.out.println(dp1(arr,150));
		System.out.println(dp2(arr,150));
		System.out.println(dp3(arr,150));
		
		
//		int[] arr = {1,2,3};
//		
//		System.out.println(dp2(arr,4));
//		System.out.println(dp3(arr,4));
		
		
//		System.out.println(process1(arr, arr.length-1,4));
//		
//		System.out.println(dp1(arr,4));
	}
	//�ɱ����������Ǯ--index����֮ǰ������ֵ��Ŀ��Ǯ---aim
	//�ݹ�1����֮ǰ�����Լ�����ʹ�ã��󷽷���Ŀ ,aim������Ҫ����Ǯ��
	private static int process1(int[] arr,int index,int aim) {
		//��ֹ����
		if(index==-1) {
			//û�п�ѡ������£�aim�ǲ���0,�ǵĻ�˵���������������ǿ��Ի��ģ��õ�һ�ַ�����
			return aim==0?1:0;
		}
		//�������
		//��ÿ��ǮֻҪ������aim�ͳ���������
		int res = 0;
		for(int i=0;arr[index]*i<=aim;i++) {
			//ÿ�γ��ԾͿ۵��Լ��Ĳ���
			res += process1(arr, index-1, aim-arr[index]*i);
		}
		return res;
	}
	
	//תΪ��̬�滮
	private static int dp1(int[] arr,int aim) {
		//����
		int[][] dp = new int[arr.length+1][aim+1];
		//���һ�У�ֻ��aim=0��ʱ��Ϊ1��������Ϊ0
		dp[0][0] = 1;
		//���һ��
		for(int i=1;i<dp.length;i++) {
			dp[i][0] = 1;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				for(int k=0;arr[i-1]*k<=j;k++) {
					dp[i][j] += dp[i-1][j-arr[i-1]*k];
				}
			}
		}
		
		//��ӡdp��
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		return dp[dp.length-1][aim];	
	}
	
	//��index��ʼ����������֮������л��ҽ��н���
	private static int process2(int[] arr,int index,int aim) {
		//û�л�����
		if(index==arr.length) {
			return aim==0?1:0;
		}
		
		//һ�������
		int sum = 0;
		for(int i=0;arr[index]*i<=aim;i++) {
			sum += process2(arr, index+1, aim-arr[index]*i);
		}
		return sum;	
	}
	//�ĳɶ�̬�滮
	private static int dp2(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		//�������һ��,������Ϊ0�Ͳ�����
		dp[dp.length-1][0] = 1;
		
		//���һ�У�����1
		for(int i=0;i<dp.length-1;i++) {
			dp[i][0] = 1;
		}
		//��ͨ��
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<dp[0].length;j++) {
				
				//�ۼ�����
				for(int k=0;arr[i]*k<=j;k++) {
					dp[i][j] += dp[i+1][j-arr[i]*k];
				}
				
			}
		}
		
//		//��ӡdp��
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		return dp[0][dp[0].length-1];
	}
	
	//��dp2���иĽ�
	private static int dp3(int[] arr,int aim) {
		int[][] dp = new int[arr.length+1][aim+1];
		//�������һ��,������Ϊ0�Ͳ�����
		dp[dp.length-1][0] = 1;
		
		//���һ�У�����1
		for(int i=0;i<dp.length-1;i++) {
			dp[i][0] = 1;
		}
		//��ͨ��
		for(int i=dp.length-2;i>=0;i--) {
			for(int j=1;j<dp[0].length;j++) {
				
				//�����ߵĸ��Ӵ���
				dp[i][j] = dp[i+1][j];
				if(j-arr[i]>=0) {
					dp[i][j] += dp[i][j-arr[i]];
				}
			
			}
		}
		
//		//��ӡdp��
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		return dp[0][dp[0].length-1];
	}
}
