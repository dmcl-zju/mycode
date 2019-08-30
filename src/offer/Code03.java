package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @author lin
 *
 */

public class Code03 {
	
	public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
	}
	//方法1：利用栈辅助
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		if(null==listNode) {
			return list;
		}
		Stack<Integer> stack = new Stack<>();
		//遍历链表然后入栈
		while(listNode!=null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		//从栈中取出
		while(!stack.isEmpty()) {
			//System.out.println(stack.peek());
			list.add(stack.pop());
		}
		return list; 
	}
	
	//方法2：利用递归来做
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		if(null==listNode) {
			return list;
		}
		//调用递归处理
		process(listNode,list);
		return list;
	}
	private void process(ListNode listNode,ArrayList<Integer> list) {
		//递归出口
		if(listNode==null) {
			return;
		}
		process(listNode.next,list);
		list.add(listNode.val);
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		ArrayList<Integer> list = new Code03().printListFromTailToHead(node);
		for(int i:list) {
			System.out.println(i);
		}
		
	}
}
