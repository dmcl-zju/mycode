package offer;

import java.util.HashSet;

/**
 * 	给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author lin
 *
 */
public class Code55 {
	
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	//方法一：通过Set来做
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
		HashSet<ListNode> set = new HashSet<>();
		ListNode cur = pHead;
		while(cur!=null) {
			if(set.contains(cur)) {
				return cur;
			}
			set.add(cur);
			cur = cur.next;
		}
		return null;
    }
	
	//方法二：快慢指镇
	public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
		if(null==pHead || null==pHead.next || null==pHead.next.next) {
			return null;
		}
		//先各执行一次
		ListNode slow = pHead.next;
		ListNode fast = pHead.next.next;
		while(slow!=fast) {
			if(fast.next==null || fast.next.next==null) {
				return null;
			}
			slow = slow.next;
			//上面保证了fast不会得到null
			fast = fast.next.next;
		}
		fast = pHead;
		while(slow!=fast) {
			fast = fast.next;
			slow = slow.next;
		}

		return fast;
    }
	
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head.next.next;
		
		Code55 code = new Code55();
		ListNode node = code.EntryNodeOfLoop2(head);
		System.out.println(node.val);
		
	}
	
}
