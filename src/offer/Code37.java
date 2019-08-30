package offer;

/**
 *	 统计一个数字在排序数组中出现的次数。
 * @author lin
 *
 */
public class Code37 {
	//思路1：采用二分法
	 public int GetNumberOfK(int [] array , int k) {
		 if(null==array || array.length<1) {
			 return 0;
		 }
		 int index = getIndex(array,k);
		 if(index==-1) {
			 return 0;
		 }
		 int cur = index;
		 int count = 0;
		 while(cur<array.length && array[cur]==k) {
			 count++;
			 cur++;
		 }
		 cur = index-1;
		 while(cur>=0 && array[cur]==k) {
			 count++;
			 cur--;
		 }
		return count;  
	 }

	 //假设递增数据，二分查找
	 private int getIndex(int[] arr,int k) {
		int left = 0;
		int right = arr.length-1;
		int mid;
		while(left<=right) {
			mid = (left+right)/2;
			if(arr[mid]==k) {
				return mid;
			}else if(arr[mid]>k) {
				right = mid-1;
			}else {
				left = mid +1;
			}
		}
		return -1;
	 }
	 
	//思路2：在二分法中改进
	 public int GetNumberOfK2(int [] array , int k) {
		 if(null==array || array.length<1) {
			 return 0;
		 }
		 int first = getFirstIndex(array, k);
		 int last = getLastIndex(array, k,0,array.length-1);
		 if(first!=-1 && last!=-1) {
			 return last-first+1;
		 }
		return 0;
	 }
	 //采用循环写法
	 private int getFirstIndex(int[] arr,int k) {
		 int start = 0;
		 int end = arr.length-1;
		 int mid ;
		 while(start<=end) {
			 mid = (start+end)/2;
			 if(arr[mid]>k) {
				 end = mid-1;
			 }else if(arr[mid]<k) {
				 start = mid+1;
			 }else if(mid-1>=0 && arr[mid-1]==k) {
				 end = mid -1;
			 }else {
				 return mid;
			 }
		 }
		return -1;
	 }
	 //采用递归写法
	 private int getLastIndex(int[] arr,int k,int start,int end) {
		 if(start>end) {
			 return -1;
		 }
		 int mid = (start+end)/2;
		 if(arr[mid]>k) {
			 return getLastIndex(arr, k, start, mid-1);
		 }else if(arr[mid]<k) {
			 return getLastIndex(arr, k, mid+1, end);
		 }else if(mid+1<=end && arr[mid+1]==k) {
			 return getLastIndex(arr, k, mid+1, end);
		 }else {
			 return mid;
		 }	 
	 }
	 
	 
	 
	 public static void main(String[] args) {
		int[] arr={1,3,3,3,3,4,5};
		Code37 code = new Code37();
		System.out.println(code.getIndex(arr, 2));
		System.out.println(code.getFirstIndex(arr, 2));
		System.out.println(code.getLastIndex(arr, 2,0,arr.length));
		int res = code.GetNumberOfK2(arr, 2);
		System.out.println(res);
	}
	
}
