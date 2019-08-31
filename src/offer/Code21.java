package offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是
 * 该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author LIN
 *
 */
public class Code21 {
	/**
		    思路：用一个栈进行辅助判断，首先根据压栈顺序建立压栈循环，在压栈循环中
		    每压入一个都进行出栈检查，如果栈顶元素对应为出栈顺序当前的元素，则进行
		    出栈，然后再出栈指针向后移动一位，再进行判断，如果符合则继续出栈直到为
		    栈为空，如果压栈循环结束后栈还不为空则不是其弹出序列
	 */
	 public boolean IsPopOrder(int [] pushA,int [] popA) {
		 if(null==pushA || null == popA || pushA.length==0 || popA.length==0) {
			 return false;
		 }
		 Stack<Integer> stack = new Stack<>();
		 int j = 0;
		 for(int i=0;i<pushA.length;i++) {
			 stack.push(pushA[i]);
			 //出栈检查
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
	 //较好写法
	 public boolean IsPopOrder2(int [] pushA,int [] popA) {
	      if(null == pushA || null==popA || pushA.length == 0){
	          return false;
	      }
	      Stack<Integer> stack = new Stack<>();
	      int popIndex = 0;
	      //如果栈顶元素不是当前弹出数字则一直入栈直到序列结束
	        //注意点：要先入栈后再判断
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
