package com.zju.newcode;

/**
 *	 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author LIN
 *
 */


public class Code16 {
	
	
	
	//常规解法
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(null==list1) {
			return list2;
		}
		if(null==list2) {
			return list1;
		}
		ListNode head = null;
		ListNode cur = null;
		if(list1.val>list2.val) {
			head = list2;
			list2 = list2.next;
		}else {
			head = list1;
			list1 = list1.next;
		}
		cur = head;
		while(list1!=null && list2!=null) {
			if(list1.val>list2.val) {
				cur.next = list2;
				list2 = list2.next;
			}else {
				cur.next = list1;
				list1 = list1.next;
			}
			cur = cur.next;
		}
		
		while(list1!=null) {
			cur.next = list1;
			list1 = list1.next;
			cur = cur.next;
		}
		while(list2!=null) {
			cur.next = list2;
			list2 = list2.next;
			cur = cur.next;
		}
		return head;
    }
	
	//递归解法:
	//缩小规模：一个节点选定后，那么可以将其后面节点看成头节点组成一个新的链表和第二个链表比较
	//basecase:有一个为空，就直接将另一个返回，不用连了
	//得到了子处理结果怎么用：直接把子处理结果接到单前节点后。
	public ListNode Merge2(ListNode list1,ListNode list2) {
		//终止条件
		if(null == list1) {
			return list2;
		}
		if(null == list2) {
			return list1;
		}
		if(list1.val<list2.val) {
			list1.next = Merge2(list1.next,list2);
			return list1;
		}else {
			list2.next = Merge2(list1,list2.next);
			return list2;
		}
	}
	
	
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(3);
		list1.next.next = new ListNode(5);
		/*list1.next.next.next = new ListNode(7);
		list1.next.next.next.next = new ListNode(9);*/
		
		ListNode list2 = new ListNode(2);
		list2.next = new ListNode(4);
		list2.next.next = new ListNode(6);
		
		ListNode head = new Code16().Merge2(list1,list2);
		while(head != null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
}
