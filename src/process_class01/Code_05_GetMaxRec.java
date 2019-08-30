package process_class01;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 	单调栈应用，子矩阵最大值
 * @author lin
 *
 */
public class Code_05_GetMaxRec {
	
	public static void main(String[] args) {
		int[] arr = {4,3,3,3,5};
		
		System.out.println(getMaxArea(arr));
		
		int[][] m = {{1,0,1,1},{1,1,1,1},{1,0,1,1}};
		
		System.out.println(getMaxSubRec(m));
		
		
		
//		System.out.println("右边最大值");
//		printArr(getRightBig(arr));
//		System.out.println("左边最大值");
//		printArr(getLeftBig(arr));
//		
//		System.out.println("右边最小值");
//		printArr(getRightSmall(arr));
//		System.out.println("左边最小值");
//		printArr(getLeftSmall(arr));

	}
	
	
	//求子矩阵问题
	private static int getMaxSubRec(int[][] m) {
		int[] temp = m[0];
		int max = getMaxArea(temp);
		for(int i=1;i<m.length;i++) {
			//更新temp
			for(int j=0;j<m[0].length;j++) {
				if(m[i][j]==0) {
					temp[j] = 0;
					continue;
				}
				temp[j] += m[i][j];
			}
			//更新最大值
			max = Math.max(max, getMaxArea(temp));
		}
		return max;
	}
	
	
	
	//值方图问题
	private static int getMaxArea(int[] arr) {
		int max = Integer.MIN_VALUE;
		int[] R = getRightSmall(arr);
		int[] L = getLeftSmall(arr);
		
		for(int i=0;i<arr.length;i++) {
			int width = R[i]-L[i]-1;
			max = Math.max(max, width*arr[i]);
		}
		return max;
	}
	
	
	
//////////////////////////////////////分两个函数来求可以不用考虑两个数相同时候的处理
	//求右边第一个比自己大的数，碰到相同的数压到栈里，当成符合
	private static int[] getRightBig(int[] arr) {
		int[] res = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			
			while(!stack.isEmpty()&& arr[stack.peek()]<arr[i]) {
				int cur = stack.pop();
				res[cur] = i;
			}
			stack.push(i);	
		}
		//剩下的都是右边没有大的了
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			res[cur] = arr.length;
		}
		return res;
	}
	//求左边第一个比自己大的数，碰到相同的数，认为不符合，要先弹出栈
	private static int[] getLeftBig(int[] arr) {
		int[] res = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			
			while(!stack.isEmpty()&& arr[stack.peek()]<=arr[i]) {
				int cur = stack.pop();
				int left = stack.isEmpty()?-1:stack.peek();
				res[cur] = left;
			}
			stack.push(i);	
		}
		//剩下的都是右边没有大的了
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			int left = stack.isEmpty()?-1:stack.peek();
			res[cur] = left;
		}
		return res;
	}
///////////////////////////////////////////////////////////////////////////	


	//求右边第一个比自己小的数，碰到相同的数压到栈里，当成符合
	private static int[] getRightSmall(int[] arr) {
		int[] res = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			
			while(!stack.isEmpty()&& arr[stack.peek()]>arr[i]) {
				int cur = stack.pop();
				res[cur] = i;
			}
			stack.push(i);	
		}
		//剩下的都是右边没有大的了
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			res[cur] = arr.length;
		}
		return res;
	}
	//求左边第一个比自己大的数，碰到相同的数，认为不符合，要先弹出栈
	private static int[] getLeftSmall(int[] arr) {
		int[] res = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			
			while(!stack.isEmpty()&& arr[stack.peek()]>=arr[i]) {
				int cur = stack.pop();
				int left = stack.isEmpty()?-1:stack.peek();
				res[cur] = left;
			}
			stack.push(i);	
		}
		//剩下的都是右边没有大的了
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			int left = stack.isEmpty()?-1:stack.peek();
			res[cur] = left;
		}
		return res;
	}
//////////////////////////////////////////////////////////////////////	
	

////////////////////////////////////////////////打印
	private static void printArr(int[] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
	
	
	
	
	
}
