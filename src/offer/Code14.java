package offer;

/**
 *	 返回数组的倒数第k个节点
 * @author LIN
 *
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Code14 {
	/**
	 * 	思路：采用类似快慢指针的方法，先让快指针领先慢指针k步，然后快指针和慢指针同步走，最后快指针到达null的时候，慢指针到达目的地
	 * 	需要注意的是堆k值的越界要有判断，小于1排除，k大于节点个数可以在快指针第一次走的时候判断排除
	 * @param head
	 * @param k
	 * @return
	 */
	 public ListNode FindKthToTail(ListNode head,int k) {
		 if(k<1) {
			 return null;
		 }
		 ListNode fast = head;
		 ListNode slow = head;
		 for(int i=0;i<k;i++) {
			 if(null==fast) {
				 return null;
			 }
			 fast = fast.next;
		 }
		 while(fast!=null) {
			 fast = fast.next;
			 slow = slow.next;
		 }
		return slow;
	 }
	 public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		Code14 code = new Code14();
		System.out.println(code.FindKthToTail(head, 6));
	}
}
