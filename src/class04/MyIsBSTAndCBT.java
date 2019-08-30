package class04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



/**
 * �ж�һ�����Ƿ�����������������ȫ������
 * @author LIN
 *
 */
public class MyIsBSTAndCBT {
	//�ڵ�
	public static class Node{
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	//˼·����������ķǵݹ���ʽ,��ԭ����ӡ�������ɱȽϣ���Ҫ��pre�ĳ�ʼ������
	public static boolean isBST(Node head) {
		if(null==head) {
			return true;
		}
		boolean isFirst = true;
		Stack<Node> stack = new Stack<>();
		Node pre = null;
		while(!stack.isEmpty()||head!=null) {
			//ֻҪ�о�һֱ�������
			if(head!=null) {
				stack.push(head);
				head = head.left;
			}else {
				head = stack.pop();
				//����ǵ�һ�ξͳ�ʼ��pre
				if(isFirst) {
					pre = head;
					isFirst = false;
				}
				//����Ա�
				if(head.value<pre.value) {
					return false;
				}
				pre = head;
				System.out.print(head.value+" ");
				head = head.right;
			}
			
		}
		return true;
	}
	
	public static boolean isCBT(Node head) {
		if(head==null) {
			return true;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(head);
		//�������涼Ҫ��Ҷ�ڵ����
		boolean leafStage = false;
		Node l = null;
		Node r = null;
		while(!q.isEmpty()) {
			head = q.poll();
			System.out.print(head.value+" ");
			l = head.left;
			r = head.right;
			//���
			if((l==null&&r!=null)||(leafStage&&(l!=null||r!=null))) {
				return false;
			}
			if(l != null) {
				q.add(head.left);
			}
			if(r != null) {
				q.add(head.right);
			}
			//����Ҷ�ڵ�ʱ��
			if((l==null&&r==null)||(l!=null&&r==null)) {
				leafStage=true;
			}
			
		}
		return true;
	}
	
	// for test -- print tree
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	
	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);
		printTree(head);
		
		System.out.println(isBST(head));
		System.out.println(isCBT(head));
		
	}
}
