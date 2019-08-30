package dptest;

/**
 * ������Ӵ�����
 * @author lin
 *
 */
public class Code08 {
	
	public static void main(String[] args) {
		String str1 = "1AB2345CD";
		String str2 = "12345DE";
		System.out.println(process(str1, str2));
		
		
	}
	//dp[i][j]��ʾ��i��j��Ϊ--�����Ӵ�--�Ľ�β�õ�����Ӵ�����
	private static String process(String str1,String str2) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		
		int[][] dp = new int[chs1.length][chs2.length];
		//�����һ��
		for(int i=0;i<dp.length;i++) {
			//chs1��ֻ�к�chs2[0]��ȵĲ���1����������0
			if(chs1[i]==chs2[0]) {
				dp[i][0] = 1;
			}else {
				dp[i][0] = 0;
			}	
		}
		//���һ��
		for(int j=1;j<dp[0].length;j++) {
			//chs1��ֻ�к�chs2[0]��ȵĲ���1����������0
			if(chs2[j]==chs1[0]) {
				dp[0][j] = 1;
			}else {
				dp[0][j] = 0;
			}	
		}
		//��һ�����
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(chs1[i] == chs2[j]) {
					//���˵���ǹ����Ӵ��Ľ�β�����Ի���һ��
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					//ֻҪ�����˵�����ǹ����Ӵ��Ľ�β
					dp[i][j] = 0;
				}
			}
		}
		String res="";
		int max = 0;
		//��dp��������Ӵ��������ҵ�dpֵ����ֵ��Ȼ�������������ֵ���Ϳ��Եõ��Ӵ�
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(dp[i][j]>max) {
					//������Ӵ�
					res = str1.substring(i-dp[i][j]+1, i+1);
					max = dp[i][j];
				}
			}
		}
		return res;
	}
}
