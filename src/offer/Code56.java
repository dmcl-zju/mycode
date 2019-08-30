package offer;

/**
 * 	在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author lin
 *
 */
public class Code56 {
	 public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	 }
	 public ListNode deleteDuplication(ListNode pHead)
	 {
		 if(null==pHead) {
			 return null;
		 }
		 if(null==pHead.next) {
			 return pHead;
		 }
		 //是不是第一个数就重复了
		 boolean isFirst = false;
		 if(pHead.val==pHead.next.val) {
			 isFirst = true;
		 }
		 ListNode pre = pHead;
		 ListNode cur = pHead;
		 ListNode next = pHead.next;
		 while(next!=null) {
			 if(cur.val==next.val) {
				 //当前的cur出现了重复--把重复的都删除。
				 while(next!=null && cur.val==next.val) {
					//next向后移动，cur不变，同时删除相同
					 next = next.next;
					 cur.next = next;
				 }
				 //去重完后回退一格，删除自己
				 cur = pre;
				 cur.next = next;
			 }else {
				 //否则都向后移动
				 pre = cur;
				 cur = next;
				 next = next.next;
			 }
		 }
		return isFirst?pHead.next:pHead;
	 }
	 
	 //这个思路比较清晰：首先定义一个虚拟的头first,接在头部之前，遍历链表如果出现重复
	 public ListNode deleteDuplication2(ListNode pHead)
	 {
		 if(null==pHead) {
			 return null;
		 }
		 //造一个前驱结点
		 ListNode first = new ListNode(-1);
		 first.next = pHead;
		 
		 ListNode pre = first;
		 ListNode cur = pHead;
		 while(cur!=null && cur.next!=null) {
			if(cur.val==cur.next.val) {
				//一旦出现重复首先去重,一直跳过当前节点,一直到不是重复的值
				int val = cur.val;
				while(cur!=null && cur.val==val) {
					cur = cur.next;
				}
				pre.next = cur;				
			}else {
				//向后移动
				pre = cur;
				cur = cur.next;
			}
		 }
		return first.next;
	 }
	 
	 
	
	 
	 public static void main(String[] args) {
		 ListNode head = new ListNode(1);
		 head.next = new ListNode(1);
//		 head.next.next = new ListNode(3);
//		 head.next.next.next = new ListNode(3);
//		 head.next.next.next.next = new ListNode(3);
//		 head.next.next.next .next.next= new ListNode(4);
//		 head.next.next.next.next .next.next = new ListNode(4);
//		 head.next.next.next.next.next .next.next = new ListNode(5);
		 
		 Code56 code = new Code56();
		 head = code.deleteDuplication2(head);
		// System.out.println(head);
		 while(head!=null) {
			 System.out.println(head.val);
			 head = head.next;
		 }
	}
	
}
