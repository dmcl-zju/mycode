package dptest;

/**
 * 最大子序列和
 * @author lin
 *
 */
public class Code11 {
	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(process2(arr));
	}
	//动态规划方法
	private static int process(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
		}
		//输出dp表
//		System.out.println("dp表：");
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
	//取巧的方法
	private static int process2(int[] nums) {

		int max = nums[0];
		int cur = 0;
		for(int i=0;i<nums.length;i++) {
			cur += nums[i];
			//更新max
			max = Math.max(max, cur);
			//因为最大和子串不可能出现前缀为负数，因此累加出了负数就舍弃掉前面的结果，从0开始，
			//又因为已经用max记录了结果，所以舍弃掉对max没有影响
			if(cur<0) {
				cur=0;
			}	
		}
		return max;
	}
	
	
	
}
