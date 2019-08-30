package com.zju.newcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制---算法基础课上有
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
	
	
	//方法一：利用map辅助
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
		//复制指针
		cur = pHead;
		while(cur!=null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).random = map.get(cur.random);
			cur = cur.next;
		}
		return map.get(pHead);
	}
	
	//方法二：不占用空间
	public RandomListNode Clone1(RandomListNode pHead) {
		if(null == pHead) {
			return null;
		}
		//复制链表插入其后面
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
		//复制随机指针
		cur = pHead;
		while(cur!=null) {
			copy = cur.next;
			copy.random = cur.random==null?null:cur.random.next;
			cur = cur.next.next;
		}
		//解耦链表
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
