package offer;

/**
 *	 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 *	请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author lin
 *
 */
public class Code50 {
	
	// Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	if(null==numbers) {
    		return false;
    	}
    	int[] help = new int[length];
    	//类似于桶排序
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
    
    //改进空间复杂度的方法--其实和桶排序相似。
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
