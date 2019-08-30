package offer;

import java.util.ArrayList;

/**
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
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
					//����list
					list.clear();
					list.add(array[left]);
					list.add(array[right]);
					//������Сֵ
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
