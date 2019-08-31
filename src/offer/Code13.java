package offer;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * @author LIN
 *
 */
public class Code13 {
	//��֤��������
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
	
	//����֤����---���ŵ�һ������һ��
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
