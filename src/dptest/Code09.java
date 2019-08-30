package dptest;

import java.util.Stack;

/**
 * �����������
 * @author lin
 *
 */
public class Code09 {
	public static void main(String[] args) {
		String str1 = "1AB2345CD";
		String str2 = "12345DE";
		str1 = "1A2C3D4B56";
		str2 = "B1D23CA45B6A";
		System.out.println(process(str1, str2));
	}
	//dp[i][j]��ʾ��i��j��Ϊ--�����ַ���--�Ľ�β���õ���������еĳ���
	private static String process(String str1,String str2) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		
		int[][] dp = new int[chs1.length][chs2.length];
		//��һ��
		for(int i=0;i<dp.length;i++) {
			if(chs1[i]==chs2[0]) {
				dp[i][0] = 1;
			}else {
				dp[i][0] = 0;
			}
			if(i==0) {
				continue;
			}
			dp[i][0] = Math.max(dp[i][0], dp[i-1][0]);
		}
		//��һ��
		for(int j=1;j<dp[0].length;j++) {
			if(chs1[0]==chs2[j]) {
				dp[0][j] = 1;
			}else {
				dp[0][j] = 0;
			}
			dp[0][j] = Math.max(dp[0][j], dp[0][j-1]);
		}
		//һ�����:�����ֿ������
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(chs1[i]==chs2[j]) {
					//�����ȣ�dp[i-1][j-1]����ѡ��
					dp[i][j] = dp[i-1][j-1] +1;
				}
				dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
			}
		}
		//System.out.println("��Ӵ����ȣ�"+dp[dp.length-1][dp[0].length-1]);
//		System.out.println("��ӡdp:");
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[0].length;j++) {
//				System.out.print(dp[i][j]+"\t");
//			}
//			System.out.println();
//		}
		//��dp�лָ�������
		int row = dp.length-1;
		int col = dp[0].length -1;
//		Stack<Character> stack = new Stack<>();
//		while(row>=0 && col>=0) {
//			//ֻ��dp
//			if(row-1>=0 && dp[row][col]==dp[row-1][col]) {
//				row--;
//			}else if(col-1>=0 && dp[row][col]==dp[row][col-1]) {
//				col--;
//			}else {
//				stack.push(chs1[row]);
//				row--;
//				col--;
//			}
//		}
		char res[] = new char[dp[row][col]];
		int index = dp[row][col]-1;
		while(index>=0) {
			if(row-1>=0 && dp[row][col]==dp[row-1][col]) {
				row--;
			}else if(col-1>=0 && dp[row][col]==dp[row][col-1]) {
				col--;
			}else {
				res[index--] = chs1[row];
				row--;
				col--;
			}
		}
		return String.valueOf(res);
	}
}
