package class08;

import java.util.Stack;

public class MyReversStack {
	
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int i = getLastAndRemove(stack);
		reverse(stack);
		stack.push(i);
	}
	
	//获得栈的最后一个元素并把最后一个元素删除，其他不变
	//相当于从栈顶开始，每个元素都弹出，进行操作（找栈底），然后回填，但是栈底就直接返回，不回填
	private static int getLastAndRemove(Stack<Integer> stack) {
		//上层函数已经验证了
		int res = stack.pop();
		if(stack.isEmpty()) {
			//如果是最后一个元素就直接返回
			return res;
		}else {
			//如果不是就继续往下层取
			int last = getLastAndRemove(stack);
			//取玩最后一个要回填，因为只弹出栈底部，如果不填回去则整个栈为空
			stack.push(res);
			return last;
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
//		System.out.println("栈的长度："+stack.size());
//		System.out.println("栈底元素："+getLastAndRemove(stack));
//		System.out.println("栈的长度："+stack.size());
		reverse(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}
}
