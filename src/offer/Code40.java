package offer;

import java.util.HashSet;


/**
 * 	一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author lin
 *
 */
public class Code40 {
	//num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    	if(array==null) {
    		return;
    	}
        HashSet<Integer> set = new HashSet<>();
        for(int i:array) {
        	if(set.contains(i)) {
        		set.remove(i);
        	}else {
        		set.add(i);
        	}
        }
       num1[0] = set.iterator().next();
       set.remove(num1[0]);
       num2[0] = set.iterator().next();
     //  System.out.println(num1[0]+"---"+num2[0]);
 
        
    }
    
    //方法2：时间复杂度为O(1);
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
    	if(array==null || array.length<2) {
    		return;
    	}
    	int temp = array[0];
    	for(int i=1;i<array.length;i++) {
    		temp ^= array[i];
    	}
    	//找到temp的第一个为1的位数
    	int index = getFirstBit(temp);
    	//将数据分组，index位上的数为0或者为1进行区分
    	num1[0] = 0;
    	num2[0] = 0;
    	for(int i=0;i<array.length;i++) {
    		if(isBit1(array[i], index)) {
    			System.out.println("该位为1："+array[i]);
    			num1[0] ^= array[i];
    		}else {
    			System.out.println("该位为0："+array[i]);
    			num2[0] ^= array[i];
    		}
    	}
    	System.out.println(num1[0]+"---"+num2[0]);
    }
    //获取从右开始首次为1的位数
    private int getFirstBit(int temp) {
    	int i = 1;
    	int count = 1;
    	while((temp&i)==0) {
    		count++;
    		i = i<<1;
    	}
		return count;
    }
    
    private boolean isBit1(int num,int index) {
    	int i = 1;
    	i = i<<(index-1);
    	if((num&i)==0) {
    		return false;
    	}
    	return true;
    }
    
    
    public static void main(String[] args) {
		int[] arr = {5,4,4,5,6,1,1,7,8,8};
		Code40 code = new Code40();
		code.FindNumsAppearOnce2(arr,new int[1], new int[1]);
		
	}
}
