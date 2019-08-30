package dptest;

/**
 * 最长递增子序列
 * @author lin
 *
 */
public class Code12 {
	public static void main(String[] args) {
		int[] arr = {2,1,5,3,6,4,8,9,7};
		process(arr);
	}
	
	//dp[i]表示的含义为：子序列以arr[i]结尾，所得到的最长子序列，和上一题求子串的和含义类似
	private static int process(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		for(int i=1;i<dp.length;i++) {
			//遍历前面比当前的数小的数
			int max = 1;
			for(int j=0;j<i;j++) {
				//只有比当前的小才能组成递增序列
				if(arr[i]>arr[j]) {
					max=Math.max(max, dp[j]+1);
				}
			}
			dp[i] = max;
		}
		//输出dp表
		System.out.println("dp表：");
		for(int i=0;i<dp.length;i++) {
			System.out.print(dp[i]+" ");
		}
		System.out.println();
		
		//根据dp数组复原出子序列
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
		//遍历原始数组
		for(int i=index;i>=0;i--) {
			
			if(arr[i]<arr[index] && dp[i]+1==dp[index]) {
				res[--len] = arr[i];
				index = i;
			}
		}
		
		//输出dp表
		System.out.println("子序列：");
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+" ");
		}
		System.out.println();
		
		
		return 0;
	}
	
	
	
}
