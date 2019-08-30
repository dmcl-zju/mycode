package process_class01;

import java.util.LinkedList;

/**
 * 求一个数组的中最大值减去最小值小于M的子数组的个数
 * @author lin
 *
 */
public class Code_04_GetNum {
	public static void main(String[] args) {
		int[] arr = {1,3,6};
		System.out.println(getNum(arr, 2));
		System.out.println(getNum2(arr, 2));
	}
	
	private static int getNum(int[] arr,int m) {
		LinkedList<Integer> qmin = new LinkedList<>();
		LinkedList<Integer> qmax = new LinkedList<>();
		
		int res = 0;
		int left = 0;
		int right = 0;
		while(left < arr.length) {
			//右边跑到第一次不符合条件的位置
			while(right<arr.length) {
				//进链表
				while(!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[right]) {
					qmin.pollLast();
				}
				while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[right]) {
					qmax.pollLast();
				}
				//加入
				qmin.addLast(right);
				qmax.addLast(right);
			
				//判断当前的最大和最小值是不是合法
				if(arr[qmax.peekFirst()]-arr[qmin.peekFirst()]>m) {
					break;
				}
				right++;
			}
			
			//更新结果---因为right是在合法的下一个的位置
			res += right-left;
			//左边缩小
			left++;
			//检测更新最大最小值
			if(left>qmin.peekFirst()) {
				qmin.pollFirst();
			}
			if(left>qmax.peekFirst()) {
				qmax.pollFirst();
			}
		}
		return res;
	}
	
	//暴力解法 O(N^3)
	private static int getNum2(int[] arr,int Num) {
		int count = 0;
		//穷举所有子数组
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(getMaxMin(arr, i, j)<=Num) {
					count++;
				}
			}
		}
		return count;
	}
	private static int getMaxMin(int[] arr,int left,int right) {
		int Min = arr[left];
		int Max = arr[left];
		for(int i=left+1;i<=right;i++) {
			if(arr[i]<Min) {
				Min = arr[i];
			}
			if(arr[i]>Max) {
				Max = arr[i];
			}
		}
		return Max-Min;
	}
	
	
	
}
