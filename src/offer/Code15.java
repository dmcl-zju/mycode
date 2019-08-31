package offer;

/**
 * 	·´×ªÁ´±í
 * @author LIN
 *
 */
/*class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Code15 {
	 
	 public ListNode ReverseList(ListNode head) {
		 if(null==head) {
			 return null;
		 }
		 ListNode pre = null;
		 ListNode next = null;
		 while(head != null) {
			 next = head.next;
			 head.next = pre;
			 pre = head;
			 head = next;
		 }
		return pre;
	 }
}
