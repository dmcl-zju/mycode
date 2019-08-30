package offer;

/**
 *	 ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
 *	���ҳ�����������һ���ظ������֡� ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * @author lin
 *
 */
public class Code50 {
	
	// Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	if(null==numbers) {
    		return false;
    	}
    	int[] help = new int[length];
    	//������Ͱ����
    	for(int i=0;i<length;i++) {
    		help[numbers[i]]++;
    	}
    	for(int i=0;i<help.length;i++) {
    		if(help[i]>1) {
    			duplication[0] = i;
    			return true;
    		}
    	}
		return false;
    }
    
    //�Ľ��ռ临�Ӷȵķ���--��ʵ��Ͱ�������ơ�
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
    	if(null==numbers) {
    		return false;
    	}
    	for(int i=0;i<length;i++) {
    		while(numbers[i]!=i) {
    			if(numbers[i]==numbers[numbers[i]]) {
    				duplication[0] = numbers[i];
    				return true;
    			}
    			swap(numbers,i,numbers[i]);
    		}
    	}
		return false;
    }
    
    private void swap(int[] arr,int i,int j) {
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
    public static void main(String[] args) {
		Code50 code = new Code50();
		int[] numbers = {1,0};
		int[] duplication = new int[1];
		System.out.println(code.duplicate2(numbers, numbers.length, duplication));
		System.out.println(duplication[0]);
	}
}
