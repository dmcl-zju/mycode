package offer;

import java.util.HashSet;


/**
 * 	һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 * @author lin
 *
 */
public class Code40 {
	//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
    //��num1[0],num2[0]����Ϊ���ؽ��
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
    
    //����2��ʱ�临�Ӷ�ΪO(1);
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
    	if(array==null || array.length<2) {
    		return;
    	}
    	int temp = array[0];
    	for(int i=1;i<array.length;i++) {
    		temp ^= array[i];
    	}
    	//�ҵ�temp�ĵ�һ��Ϊ1��λ��
    	int index = getFirstBit(temp);
    	//�����ݷ��飬indexλ�ϵ���Ϊ0����Ϊ1��������
    	num1[0] = 0;
    	num2[0] = 0;
    	for(int i=0;i<array.length;i++) {
    		if(isBit1(array[i], index)) {
    			System.out.println("��λΪ1��"+array[i]);
    			num1[0] ^= array[i];
    		}else {
    			System.out.println("��λΪ0��"+array[i]);
    			num2[0] ^= array[i];
    		}
    	}
    	System.out.println(num1[0]+"---"+num2[0]);
    }
    //��ȡ���ҿ�ʼ�״�Ϊ1��λ��
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
