package dptest;

/**
 * 最长公共子串问题
 * @author lin
 *
 */
public class Code08 {
	
	public static void main(String[] args) {
		String str1 = "1AB2345CD";
		String str2 = "12345DE";
		System.out.println(process(str1, str2));
		
		
	}
	//dp[i][j]表示把i、j作为--公共子串--的结尾得到的最长子串长度
	private static String process(String str1,String str2) {
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		
		int[][] dp = new int[chs1.length][chs2.length];
		//先填第一列
		for(int i=0;i<dp.length;i++) {
			//chs1中只有和chs2[0]相等的才是1，其他都是0
			if(chs1[i]==chs2[0]) {
				dp[i][0] = 1;
			}else {
				dp[i][0] = 0;
			}	
		}
		//填第一行
		for(int j=1;j<dp[0].length;j++) {
			//chs1中只有和chs2[0]相等的才是1，其他都是0
			if(chs2[j]==chs1[0]) {
				dp[0][j] = 1;
			}else {
				dp[0][j] = 0;
			}	
		}
		//填一般情况
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {
				if(chs1[i] == chs2[j]) {
					//相等说明是公共子串的结尾，各自回退一格
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					//只要不相等说明不是公共子串的结尾
					dp[i][j] = 0;
				}
			}
		}
		String res="";
		int max = 0;
		//从dp表中找最长子串，就是找到dp值最大的值，然后根据其索引及值，就可以得到子串
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(dp[i][j]>max) {
					//更新最长子串
					res = str1.substring(i-dp[i][j]+1, i+1);
					max = dp[i][j];
				}
			}
		}
		return res;
	}
}
