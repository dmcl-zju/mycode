package offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @author lin
 *
 */
public class Code42 {
	
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		if(null==array || array.length<2) {
			return list;
		}
		
		int left = 0;
		int right = array.length-1;
		int min = Integer.MAX_VALUE;
		while(left<right) {
			int temp = array[left]+array[right];
			if(temp==sum) {
				int cur = array[left]*array[right];
				if(cur<min) {
					//更新list
					list.clear();
					list.add(array[left]);
					list.add(array[right]);
					//更新最小值
					min = cur;
				}
				left++;
			}else if(temp>sum) {
				right--;
			}else {
				left++;
			}
		}
		return list;
    }
	
	public static void main(String[] args) {
		Code42 code = new Code42();
		int[] arr = {1,2,3,4,5};
		ArrayList<Integer> list = code.FindNumbersWithSum(arr, 5);
		for(int i:list) {
			System.out.println(i);
		}
	}
	
	
	
}
