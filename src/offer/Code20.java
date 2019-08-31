package offer;

import java.util.Stack;

/**
 * 	返回最小值的栈
 * @author LIN
 *
 */
public class Code20 {
	
	private Stack<Integer> data = new Stack<>();
	private Stack<Integer> min = new Stack<>();
	
	public void push(int node) {
		data.push(node);
		if(min.isEmpty()) {
			min.push(node);
		}else if(node<=min.peek()) {
			min.push(node);
		} 
    }
    
    public void pop() {
        if(!data.isEmpty()) {
        	if(data.peek()<=min.peek()) {
        		min.pop();
        	}
        	data.pop();
        }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int min() {
        return min.peek();
    }
}
