package dptest;

/**
 * �����������
 * @author lin
 *
 */
public class Code12 {
	public static void main(String[] args) {
		int[] arr = {2,1,5,3,6,4,8,9,7};
		process(arr);
	}
	
	//dp[i]��ʾ�ĺ���Ϊ����������arr[i]��β�����õ���������У�����һ�����Ӵ��ĺͺ�������
	private static int process(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for(int i=1;i<dp.length;i++) {
			//����ǰ��ȵ�ǰ����С����
			int max = 1;
			for(int j=0;j<i;j++) {
				//ֻ�бȵ�ǰ��С������ɵ�������
				if(arr[i]>arr[j]) {
					max=Math.max(max, dp[j]+1);
				}
			}
			dp[i] = max;
		}
		//���dp��
		System.out.println("dp��");
		for(int i=0;i<dp.length;i++) {
			System.out.print(dp[i]+" ");
		}
		System.out.println();
		
		//����dp���鸴ԭ��������
		int len = 0;
		int index = 0;
		for(int i=0;i<dp.length;i++) {
			if(dp[i]>len) {
				len = dp[i];
				index = i;
			}
		}
		//System.out.println(len+"---"+index);
		int[] res = new int[len];
		res[--len] = arr[index];
		//����ԭʼ����
		for(int i=index;i>=0;i--) {
			
			if(arr[i]<arr[index] && dp[i]+1==dp[index]) {
				res[--len] = arr[i];
				index = i;
			}
		}
		
		//���dp��
		System.out.println("�����У�");
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
		System.out.println();
		
		
		return 0;
	}
	
	
	
}
