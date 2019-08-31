package offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author LIN
 *
 */
public class Code13 {
	//保证有序的情况
	public void reOrderArray(int [] array) {
		if(null==array || array.length<2) {
			return;
		}
        int[] newArr = new int[array.length];
        int count = 0;
        for(int i=0;i<array.length;i++) {
        	if(array[i]%2 != 0) {
        		newArr[count++] = array[i];
        	}
        }
        for(int i=0;i<array.length;i++) {
        	if(array[i]%2 == 0) {
        		newArr[count++] = array[i];
        	}
        }
        for(int i=0;i<array.length;i++) {
        	array[i] = newArr[i];
        }
    }
	
	//不保证有序---快排的一个过程一样
	public void reOrderArray2(int [] array) {
		if(null==array || array.length<2) {
			return;
		}
		int index = 0;
		int odd = -1;
		int even = array.length;
		while(index<even) {
			if(array[index]%2 != 0) {
				swap(array,++odd,index++);
			}else {
				swap(array,--even,index);
			}
		}
	}
	
	private void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
	public static void main(String[] args) {
		Code13 code = new Code13();
		int[] arr = {1,2,3,4,5,6,7,8,9};
		code.reOrderArray(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println("");
		System.out.println("=============================");
		code.reOrderArray2(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
}
