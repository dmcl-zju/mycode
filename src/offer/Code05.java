package offer;

import java.util.Stack;

/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint����
 * @author LIN
 *
 */
public class Code05 {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(stack1.isEmpty()&&stack2.isEmpty()) {
    		System.out.println("�����쳣");
    	}
    	//����һ��ת��
    	if(stack2.isEmpty()) {
    		while(!stack1.isEmpty()) {
    			stack2.push(stack1.pop());
    		}
    	}
		return stack2.pop();
    }
    
    public static void main(String[] args) {
    	 Code05 queue = new Code05();
    	 queue.push(1);
    	 queue.push(2);
    	 queue.push(3);
    	 for(int i=0;i<3;i++) {
    		 System.out.println(queue.pop());
    	 }
    	 
	}
	
}
