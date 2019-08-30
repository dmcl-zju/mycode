package offer;

/**
 * 	��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
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
		 //�ǲ��ǵ�һ�������ظ���
		 boolean isFirst = false;
		 if(pHead.val==pHead.next.val) {
			 isFirst = true;
		 }
		 ListNode pre = pHead;
		 ListNode cur = pHead;
		 ListNode next = pHead.next;
		 while(next!=null) {
			 if(cur.val==next.val) {
				 //��ǰ��cur�������ظ�--���ظ��Ķ�ɾ����
				 while(next!=null && cur.val==next.val) {
					//next����ƶ���cur���䣬ͬʱɾ����ͬ
					 next = next.next;
					 cur.next = next;
				 }
				 //ȥ��������һ��ɾ���Լ�
				 cur = pre;
				 cur.next = next;
			 }else {
				 //��������ƶ�
				 pre = cur;
				 cur = next;
				 next = next.next;
			 }
		 }
		return isFirst?pHead.next:pHead;
	 }
	 
	 //���˼·�Ƚ����������ȶ���һ�������ͷfirst,����ͷ��֮ǰ������������������ظ�
	 public ListNode deleteDuplication2(ListNode pHead)
	 {
		 if(null==pHead) {
			 return null;
		 }
		 //��һ��ǰ�����
		 ListNode first = new ListNode(-1);
		 first.next = pHead;
		 
		 ListNode pre = first;
		 ListNode cur = pHead;
		 while(cur!=null && cur.next!=null) {
			if(cur.val==cur.next.val) {
				//һ�������ظ�����ȥ��,һֱ������ǰ�ڵ�,һֱ�������ظ���ֵ
				int val = cur.val;
				while(cur!=null && cur.val==val) {
					cur = cur.next;
				}
				pre.next = cur;				
			}else {
				//����ƶ�
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
