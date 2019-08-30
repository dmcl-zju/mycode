package com.zju.newcode;

/**	leetcode中有
 * 	例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 	给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @author LIN
 *
 */
public class Code30 {
	
	//采用递归解决
	public int FindGreatestSumOfSubArray1(int[] array) {
		if(null==array || array.length==0) {
			return 0;
		}
		int max = array[0];
		for(int i=0;i<array.length;i++) {
			max = Math.max(max, process(array,i));
		}
		return max;
    }
	private int process(int[] array,int index) {
		if(index==0) {
			return array[0];
		}
	  return Math.max(array[index],array[index]+process(array,index-1));	
	}
	
	//递归改动态规划
	public int FindGreatestSumOfSubArray2(int[] array) {
		if(null==array || array.length==0) {
			return 0;
		}
		int[] dp = new int[array.length];
		dp[0] = array[0];
		for(int i=1;i<dp.length;i++) {
			dp[i] = Math.max(array[i], array[i]+dp[i-1]);
		}
		int max = dp[0];
		for(int i=1;i<dp.length;i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
    }
	//分治解决
	public int FindGreatestSumOfSubArray3(int[] array) {
		if(null==array || array.length==0) {
			return 0;
		}
		return process(array,0,array.length-1);
	}
	
	private int process(int[] array,int left,int right) {
		if(left==right) {
			return array[left];
		}
		int mid = (left+right)/2;
		int maxLeft = process(array,left,mid);
		int maxRight = process(array,mid+1,right);
		int maxMerge = maxMerge(array, left, mid, right);
		return Math.max(maxLeft, Math.max(maxRight, maxMerge));
	}
	
	private int maxMerge(int[] array,int left,int mid,int right) {
		int maxLeft = array[mid];
		int sum = 0;
		for(int i=mid;i>=left;i--) {
			sum += array[i];
			if(sum>maxLeft) {
				maxLeft = sum;
			}
		}
		int maxRight = array[mid+1];
		sum=0;
		for(int i=mid+1;i<=right;i++) {
			sum += array[i];
			if(sum>maxRight) {
				maxRight = sum;
			}
		}
		return maxLeft+maxRight;
	}
	//最优化的方法
	/**
	 * 	思路：sum代表几个数累加组成的前缀，因为最大的那个子数组不可能以负的为前缀，因此只要sum出现的负的值就归0，就不可能成为最大
	 * 	和的子数组的前缀，因此将其归零，意思是抛弃之前累加的那几个数，重新开始组成子数组。而整个过程用全局max记录下了整体的最大值，因此
	 * 	最大和子数组不会被错过。
	 * @param array
	 * @return
	 */
	public int FindGreatestSumOfSubArray4(int[] array) {
		if(null==array || array.length==0) {
			return 0;
		}
		int max = array[0];
		int sum = 0;
		for(int i=0;i<array.length;i++) {
			sum += array[i];
			if(sum>max) {
				max = sum;
			}
			if(sum<0) {
				sum = 0;
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		Code30 code = new Code30();
		int[] arr= {-84,-87,-78,-16,-94,-36,-87,-93,-50,-22,-63,-28,-91,-60,-64,-27,
				-41,-27,-73,-37,-12,-69,-68,-30,-83,-31,-63,-24,-68,-36,-30,-3,-23,
				-59,-70,-68,-94,-57,-12,-43,-30,-74,-22,-20,-85,-38,-99,-25,-16,-71,
				-14,-27,-92,-81,-57,-74,-63,-71,-97,-82,-6,-26,-85,-28,-37,-6,-47,
				-30,-14,-58,-25,-96,-83,-46,-15,-68,-35,-65,-44,-51,-88,-9,-77,-79,
				-89,-85,-4,-52,-55,-100,-33,-61,-77,-69,-40,-13,-27,-87,-95,-40};
		int[] array = {6,-3,-2,7,-15,1,2,2};
		int res = code.FindGreatestSumOfSubArray4(arr);
		System.out.println(res);
	
	}
	
}
