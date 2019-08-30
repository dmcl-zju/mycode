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
	
	
	
	
	// O(N)---��ȡ����ǰKС����,���������kС����֮���ٱ���һ�飬�൱��2��O(N)�㷨
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
	
	
	
/////////////////////////////////////////һ��ΪBFPRT�㷨	////////////////////////////////////////////////////	
	
	//��ȡ�����е�K����--ֻҪ��k���б任����
	public static int getMaxKthByBFPRT(int[] arr, int K) {
		if(K<1 || K>arr.length) {
			System.out.println("�Ƿ�����");
			return -1;
		}
		K = arr.length-K;
		return select(arr, 0, arr.length - 1, K);
	}
	
	
	//��ȡ��������С��KС��
	public static int getMinKthByBFPRT(int[] arr, int K) {
		if(K<1 || K>arr.length) {
			System.out.println("�Ƿ�����");
			return -1;
		}
		return select(arr, 0, arr.length - 1, K - 1);
	}
	
	
	
	
	//BFPRT�ݹ����---���Ÿ�һ��
	public static int select(int[] arr, int begin, int end, int i) {
		if (begin == end) {
			return arr[begin];
		}
		int pivot = medianOfMedians(arr, begin, end);
		int[] pivotRange = partition(arr, begin, end, pivot);
		
		//���kС����
		if (i >= pivotRange[0] && i <= pivotRange[1]) {
			return arr[i];
			
		} else if (i < pivotRange[0]) {
			return select(arr, begin, pivotRange[0] - 1, i);
		} else {
			return select(arr, pivotRange[1] + 1, end, i);
		}
				
//		//���kС����
//		if (i >= pivotRange[0] && i <= pivotRange[1]) {
//			return arr[i];
//			
//		} else if (i < pivotRange[0]) {
//			return select(arr, begin, pivotRange[0] - 1, i);
//		} else {
//			return select(arr, pivotRange[1] + 1, end, i);
//		}
	
	}
	
	//partition�Ĺ���---�Ϳ���һ��
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


 /////////// �����ⲿ����BFPRT�ڿ��Ż�����������	//////////////////////////////
	
	//���ݷ��飬��ȡ����������λ����ɵ����飬�ٻ�ȡ��λ������partion��Ϊ�ֽ��
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
	//�����������ȡ��λ��
	public static int getMedian(int[] arr, int begin, int end) {
		//�������������ҿ��ģ������end+1
		Arrays.sort(arr, begin, end+1);
		int sum = end + begin;
		//ż����ʱ��ȡ�Ŀ��ҵĵ�
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
