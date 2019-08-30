package com.zju.newcode;

/**
 *	 ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * @author LIN
 *
 */


public class Code16 {
	
	
	
	//����ⷨ
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
	
	//�ݹ�ⷨ:
	//��С��ģ��һ���ڵ�ѡ������ô���Խ������ڵ㿴��ͷ�ڵ����һ���µ�����͵ڶ�������Ƚ�
	//basecase:��һ��Ϊ�գ���ֱ�ӽ���һ�����أ���������
	//�õ����Ӵ�������ô�ã�ֱ�Ӱ��Ӵ������ӵ���ǰ�ڵ��
	public ListNode Merge2(ListNode list1,ListNode list2) {
		//��ֹ����
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
