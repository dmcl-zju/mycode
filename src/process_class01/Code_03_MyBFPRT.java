package process_class01;

import java.util.Arrays;

public class Code_03_MyBFPRT {
	
	
	public static void main(String[] args) {
		int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
		
		// sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
		//printArray(getMinKNumsByBFPRT(arr, 10));
		
		System.out.println(getMaxKthByBFPRT(arr, 8));
		System.out.println(getMinKthByBFPRT(arr, 4));
	}
	
	
	
	
	// O(N)---获取数组前K小的数,就是求出第k小的数之后再遍历一遍，相当于2个O(N)算法
	public static int[] getMinKNumsByBFPRT(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			return arr;
		}
		int minKth = getMinKthByBFPRT(arr, k);
		int[] res = new int[k];
		int index = 0;
		for (int i = 0; i != arr.length; i++) {
			if (arr[i] < minKth) {
				res[index++] = arr[i];
			}
		}
		for (; index != res.length; index++) {
			res[index] = minKth;
		}
		return res;
	}
	
	
	
/////////////////////////////////////////一下为BFPRT算法	////////////////////////////////////////////////////	
	
	//获取数组中第K大数--只要堆k进行变换就行
	public static int getMaxKthByBFPRT(int[] arr, int K) {
		if(K<1 || K>arr.length) {
			System.out.println("非法输入");
			return -1;
		}
		K = arr.length-K;
		return select(arr, 0, arr.length - 1, K);
	}
	
	
	//获取数组中最小第K小数
	public static int getMinKthByBFPRT(int[] arr, int K) {
		if(K<1 || K>arr.length) {
			System.out.println("非法输入");
			return -1;
		}
		return select(arr, 0, arr.length - 1, K - 1);
	}
	
	
	
	
	//BFPRT递归调用---快排改一改
	public static int select(int[] arr, int begin, int end, int i) {
		if (begin == end) {
			return arr[begin];
		}
		int pivot = medianOfMedians(arr, begin, end);
		int[] pivotRange = partition(arr, begin, end, pivot);
		
		//求第k小的数
		if (i >= pivotRange[0] && i <= pivotRange[1]) {
			return arr[i];
			
		} else if (i < pivotRange[0]) {
			return select(arr, begin, pivotRange[0] - 1, i);
		} else {
			return select(arr, pivotRange[1] + 1, end, i);
		}
				
//		//求第k小的数
//		if (i >= pivotRange[0] && i <= pivotRange[1]) {
//			return arr[i];
//			
//		} else if (i < pivotRange[0]) {
//			return select(arr, begin, pivotRange[0] - 1, i);
//		} else {
//			return select(arr, pivotRange[1] + 1, end, i);
//		}
	
	}
	
	//partition的过程---和快排一样
	public static int[] partition(int[] arr, int begin, int end, int pivotValue) {
		int small = begin - 1;
		int cur = begin;
		int big = end + 1;
		while (cur != big) {
			if (arr[cur] < pivotValue) {
				swap(arr, ++small, cur++);
			} else if (arr[cur] > pivotValue) {
				swap(arr, cur, --big);
			} else {
				cur++;
			}
		}
		int[] range = new int[2];
		range[0] = small + 1;
		range[1] = big - 1;
		return range;
	}
	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}


 /////////// 下面这部分是BFPRT在快排基础上新增的	//////////////////////////////
	
	//数据分组，获取所有组内中位数组成的数组，再获取中位数，给partion作为分界点
	public static int medianOfMedians(int[] arr, int begin, int end) {
		int num = end - begin + 1;
		int offset = num % 5 == 0 ? 0 : 1;
		int[] mArr = new int[num / 5 + offset];
		for (int i = 0; i < mArr.length; i++) {
			int beginI = begin + i * 5;
			int endI = beginI + 4;
			mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
		}
		return select(mArr, 0, mArr.length - 1, mArr.length / 2);
	}
	//对数组排序获取中位数
	public static int getMedian(int[] arr, int begin, int end) {
		//这个函数是左闭右开的，因此用end+1
		Arrays.sort(arr, begin, end+1);
		int sum = end + begin;
		//偶数的时候取的靠右的点
		int mid = (sum / 2) + (sum % 2);
		return arr[mid];
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}


}
