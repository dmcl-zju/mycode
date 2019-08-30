package process_class01;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 	����ջӦ�ã��Ӿ������ֵ
 * @author lin
 *
 */
public class Code_05_GetMaxRec {
	
	public static void main(String[] args) {
		int[] arr = {4,3,3,3,5};
		
		System.out.println(getMaxArea(arr));
		
		int[][] m = {{1,0,1,1},{1,1,1,1},{1,0,1,1}};
		
		System.out.println(getMaxSubRec(m));
		
		
		
//		System.out.println("�ұ����ֵ");
//		printArr(getRightBig(arr));
//		System.out.println("������ֵ");
//		printArr(getLeftBig(arr));
//		
//		System.out.println("�ұ���Сֵ");
//		printArr(getRightSmall(arr));
//		System.out.println("�����Сֵ");
//		printArr(getLeftSmall(arr));

	}
	
	
	//���Ӿ�������
	private static int getMaxSubRec(int[][] m) {
		int[] temp = m[0];
		int max = getMaxArea(temp);
		for(int i=1;i<m.length;i++) {
			//����temp
			for(int j=0;j<m[0].length;j++) {
				if(m[i][j]==0) {
					temp[j] = 0;
					continue;
				}
				temp[j] += m[i][j];
			}
			//�������ֵ
			max = Math.max(max, getMaxArea(temp));
		}
		return max;
	}
	
	
	
	//ֵ��ͼ����
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
	
	
	
//////////////////////////////////////����������������Բ��ÿ�����������ͬʱ��Ĵ���
	//���ұߵ�һ�����Լ��������������ͬ����ѹ��ջ����ɷ���
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
		//ʣ�µĶ����ұ�û�д����
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			res[cur] = arr.length;
		}
		return res;
	}
	//����ߵ�һ�����Լ��������������ͬ��������Ϊ�����ϣ�Ҫ�ȵ���ջ
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
		//ʣ�µĶ����ұ�û�д����
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			int left = stack.isEmpty()?-1:stack.peek();
			res[cur] = left;
		}
		return res;
	}
///////////////////////////////////////////////////////////////////////////	


	//���ұߵ�һ�����Լ�С������������ͬ����ѹ��ջ����ɷ���
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
		//ʣ�µĶ����ұ�û�д����
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			res[cur] = arr.length;
		}
		return res;
	}
	//����ߵ�һ�����Լ��������������ͬ��������Ϊ�����ϣ�Ҫ�ȵ���ջ
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
		//ʣ�µĶ����ұ�û�д����
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			int left = stack.isEmpty()?-1:stack.peek();
			res[cur] = left;
		}
		return res;
	}
//////////////////////////////////////////////////////////////////////	
	

////////////////////////////////////////////////��ӡ
	private static void printArr(int[] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
	
	
	
	
	
}
