package offer;

/**
 *	 ��������ĵ�����k���ڵ�
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
	 * 	˼·���������ƿ���ָ��ķ��������ÿ�ָ��������ָ��k����Ȼ���ָ�����ָ��ͬ���ߣ�����ָ�뵽��null��ʱ����ָ�뵽��Ŀ�ĵ�
	 * 	��Ҫע����Ƕ�kֵ��Խ��Ҫ���жϣ�С��1�ų���k���ڽڵ���������ڿ�ָ���һ���ߵ�ʱ���ж��ų�
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
