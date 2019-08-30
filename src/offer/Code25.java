package com.zju.newcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������ĸ���---�㷨����������
 * @author LIN
 *
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Code25 {
	
	
	//����һ������map����
	public RandomListNode Clone(RandomListNode pHead) {
		if(null == pHead) {
			return null;
		}
		Map<RandomListNode,RandomListNode> map = new HashMap<>();
		RandomListNode cur = pHead;
		while(cur!=null) {
			map.put(cur, new RandomListNode(cur.label));
			cur = cur.next;
		}
		//����ָ��
		cur = pHead;
		while(cur!=null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		return map.get(pHead);
	}
	
	//����������ռ�ÿռ�
	public RandomListNode Clone1(RandomListNode pHead) {
		if(null == pHead) {
			return null;
		}
		//����������������
		RandomListNode cur = pHead;
		RandomListNode copy = null;
		RandomListNode next = null;
		while(cur!=null) {
			next = cur.next;
			copy = new RandomListNode(cur.label);
			cur.next = copy;
			copy.next = next;
			cur = next;
		}
		//�������ָ��
		cur = pHead;
		while(cur!=null) {
			copy = cur.next;
			copy.random = cur.random==null?null:cur.random.next;
			cur = cur.next.next;
		}
		//��������
		cur = pHead;
		RandomListNode copyHead = cur.next;
		while(cur!=null) {
			next = cur.next.next;
			copy = cur.next;
			cur.next = next;
			copy.next = next==null?null:next.next;
			cur = next;
		}
		return copyHead;
		
	}
}
