package offer;

import java.util.Stack;

/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1��
 * ��ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 * @author LIN
 *
 */
public class Code21 {
	/**
		    ˼·����һ��ջ���и����жϣ����ȸ���ѹջ˳����ѹջѭ������ѹջѭ����
		    ÿѹ��һ�������г�ջ��飬���ջ��Ԫ�ض�ӦΪ��ջ˳��ǰ��Ԫ�أ������
		    ��ջ��Ȼ���ٳ�ջָ������ƶ�һλ���ٽ����жϣ���������������ջֱ��Ϊ
		    ջΪ�գ����ѹջѭ��������ջ����Ϊ�������䵯������
	 */
	 public boolean IsPopOrder(int [] pushA,int [] popA) {
		 if(null==pushA || null == popA || pushA.length==0 || popA.length==0) {
			 return false;
		 }
		 Stack<Integer> stack = new Stack<>();
		 int j = 0;
		 for(int i=0;i<pushA.length;i++) {
			 stack.push(pushA[i]);
			 //��ջ���
			 while(!stack.isEmpty()) {
				 if(stack.peek()==popA[j]) {
					stack.pop();
					j++;
				 }else {
					 break;
				 }
			 }
		 }
		return stack.isEmpty();
	 }
	 //�Ϻ�д��
	 public boolean IsPopOrder2(int [] pushA,int [] popA) {
	      if(null == pushA || null==popA || pushA.length == 0){
	          return false;
	      }
	      Stack<Integer> stack = new Stack<>();
	      int popIndex = 0;
	      //���ջ��Ԫ�ز��ǵ�ǰ����������һֱ��ջֱ�����н���
	        //ע��㣺Ҫ����ջ�����ж�
	      for(int i=0;i<pushA.length;i++){
	          stack.push(pushA[i]);
	          while(!stack.isEmpty() && stack.peek() == popA[popIndex]){
	              stack.pop();
	              popIndex++;
	          }
	      }
	     return stack.isEmpty();
	  }
	 
	 
	 public static void main(String[] args) {
		 Code21 code = new Code21();
		 int[] pushA= {1,2,3,4,5};
		 int[] popA = {4,3,5,1,2};
		 boolean res = code.IsPopOrder2(pushA, popA);
		 System.out.println(res);
	}
}
