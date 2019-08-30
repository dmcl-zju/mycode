package com.zju.newcode;

/**	leetcode����
 * 	����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * 	��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
 * @author LIN
 *
 */
public class Code30 {
	
	//���õݹ���
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
	
	//�ݹ�Ķ�̬�滮
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
	//���ν��
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
	//���Ż��ķ���
	/**
	 * 	˼·��sum���������ۼ���ɵ�ǰ׺����Ϊ�����Ǹ������鲻�����Ը���Ϊǰ׺�����ֻҪsum���ֵĸ���ֵ�͹�0���Ͳ����ܳ�Ϊ���
	 * 	�͵��������ǰ׺����˽�����㣬��˼������֮ǰ�ۼӵ��Ǽ����������¿�ʼ��������顣������������ȫ��max��¼������������ֵ�����
	 * 	���������鲻�ᱻ�����
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
