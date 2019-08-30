package dptest;

/**
 * 	�����е�ĳЩԪ�صĺ�Ϊָ������������,������ǻ�Ǯ�ڶ��ֵļ򻯰汾
 * @author LIN
 *
 */
public class Code02 {
	public static void main(String[] args) {
		int[] arr = {2,2,5,4};
		System.out.println(process(arr, 7));
	}
	
	private static boolean process(int[] arr,int aim) {
		boolean[][] dp = new boolean[arr.length][aim+1];
		//��һ��dp[i][0]:����arr�д�����0-i����ȡ�����ۼӳ�0�𣬵�Ȼ���ԣ�ֻҪ����ȡ
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = true;
		}
		//��һ��dp[0][j]:����arr[0ȡ0�κ�ȡ1��]�����ۼӳ�aim���ڵĺ�����֪����arr[0]�������������Ϊfalse
		for(int j=1;j<dp[0].length;j++) {
			if(arr[0]==j) {
				dp[0][j] = true;
			}else {
				dp[0][j] = false;
			}
		}
		//����һ�����
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				//ֻҪ��Խ�磬��ǰԪ�ؾ�������ѡ���Լ�������ͺͲ��������
				if(j-arr[i]>=0) {
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
				}else {
					//Խ����˵���Լ��޷�������ͣ�һ����;͹�����
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];	
	}
}
