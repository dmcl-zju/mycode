package dptest;

/**
 * ��������к�
 * @author lin
 *
 */
public class Code11 {
	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(process2(arr));
	}
	//��̬�滮����
	private static int process(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
		}
		//���dp��
//		System.out.println("dp��");
//		for(int i=0;i<dp.length;i++) {
//			System.out.print(dp[i]+" ");
//		}
//		System.out.println();
		
		int max = arr[0];
		for(int i=0;i<dp.length;i++) {
			max = dp[i]>max?dp[i]:max;
		}
		return max;
	}
	//ȡ�ɵķ���
	private static int process2(int[] nums) {

		int max = nums[0];
		int cur = 0;
		for(int i=0;i<nums.length;i++) {
			cur += nums[i];
			//����max
			max = Math.max(max, cur);
			//��Ϊ�����Ӵ������ܳ���ǰ׺Ϊ����������ۼӳ��˸�����������ǰ��Ľ������0��ʼ��
			//����Ϊ�Ѿ���max��¼�˽����������������maxû��Ӱ��
			if(cur<0) {
				cur=0;
			}	
		}
		return max;
	}
	
	
	
}
