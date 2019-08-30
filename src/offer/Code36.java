package offer;
/**
 * 	输入两个链表，找出它们的第一个公共结点。
 * @author lin
 *
 */


public class Code36 {
	
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(null==pHead1 || null==pHead2) {
			return null;
		}
	
		return noLoop(pHead1, pHead2);
    }
	
	private ListNode noLoop(ListNode pHead1, ListNode pHead2) {
		int count = 0;
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		while(null!=p1.next) {
			count++;
			p1 = p1.next;
		}
		while(null != p2.next) {
			count--;
			p2 = p2.next;
		}
		if(p1!=p2) {
			return null;
		}
		//p1指向长的，先走
		p1 = count<0?pHead2:pHead1;
		p2 = p1==pHead1?pHead2:pHead1;
		count = Math.abs(count);
		while(count-- != 0) {
			p1 = p1.next;
		}
		//两个一起走
		while(p1!=p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		
		ListNode head2 = new ListNode(10);
		head2.next = new ListNode(9);
		head2.next.next = head1.next.next.next;
//		head2.next.next.next = new ListNode(4);
//		head2.next.next.next.next = new ListNode(5);
		
		Code36 code = new Code36();
		ListNode res = code.FindFirstCommonNode(head1, head2);
		System.out.println(res.val);
		
		
	}
}
