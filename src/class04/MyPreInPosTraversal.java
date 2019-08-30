package class04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//�������ı���--���ֱ����ĵݹ�ͷǵݹ��㷨
public class MyPreInPosTraversal {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	//--------------�ݹ鷽ʽ------------------
	//˼·��ֻҪ���˵ݹ飬���������ֱ�����ʽ��ÿ���ڵ㶼�ᱻ����3�Σ���һ���ǴӸ��ڵ����ģ��ڶ������������ӣ��������������Һ���
	//������Ҫ���ľ�������һ�η��ʵ�ʱ����������Ӧ�Ĳ����������Ǵ�ӡ�����ͻ������������ַ���
	//�������
	public static void preOrderRecur(Node head) {
		if(null==head) {
			return;
		}
		//��һ�η��ʵ�ǰ�ڵ��ʱ���ӡ
		System.out.print(head.value+" ");
		//��������
		preOrderRecur(head.left);
		//�����Һ���
		preOrderRecur(head.right);
	}
	//�������
	public static void inOrderRecur(Node head) {
		if(null==head) {
			return;
		}
		//��������
		inOrderRecur(head.left);
		//�ڶ��η��ʵ�ǰ�ڵ��ʱ���ӡ
		System.out.print(head.value+" ");
		//�����Һ���
		inOrderRecur(head.right);
	}
	//��������
	public static void posOrderRecur(Node head) {
		if(null==head) {
			return;
		}
		//��������
		posOrderRecur(head.left);
		//�����Һ���
		posOrderRecur(head.right);
		//�����η��ʵ�ǰ�ڵ��ʱ���ӡ
		System.out.print(head.value+" ");
	}
	
	//--------------�ǵݹ鷽ʽ------------------
	//�ݹ���ϵͳ��ѹջ��������Ҫ�Լ�ѹջ
	//�������------�ܲ���ȱ�������ֻ�ǲ���������ö���
	public static void preOrderUnrecur(Node head) {
		if(null==head) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		//�Ƚ�ͷѹ��ջ
		stack.push(head);
		//һֱѭ��֪��ջ����˵���Ѿ�������һ��
		while(!stack.isEmpty()) {
			//����head�Ǹ��ñ���
			head = stack.pop();
			System.out.print(head.value+" ");
			//���ﰴ��ջ�������Ƚ��Һ���ѹ��ȥ��ѹ����
			if(null!=head.right) {
				stack.push(head.right);
			}
			if(null!=head.left) {
				stack.push(head.left);
			}
		}
	}
	//�������
	public static void inOrderUnrecur(Node head) {
		if(null==head) {
			return;
		}
		//������������ھ�һֱ��������ջ
		Stack<Node> stack = new Stack<>();
		while(!stack.isEmpty()||head!=null) {
			if(head!=null){
				stack.push(head);
				head = head.left;
			}else{
				//�Ѿ�������������ջ
				head = stack.pop();
				System.out.print(head.value+" ");
				//���ұ���
				head = head.right;
			}
		}
	}
	//��������---�Ƚϸ���
	//˼·������������˳���������У�����ʵ�֣������������˼·���������һ���������ʵ��������Ȼ�����һ������ջ��ʵ������
	public static void posOrderUnrecur(Node head) {
		if(null==head) {
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(head);
		while(!stack1.isEmpty()) {
			head = stack1.pop();
			//����ѹ��stack2��
			stack2.push(head);
			if(null!=head.left) {
				stack1.push(head.left);
			}
			if(null!=head.right) {
				stack1.push(head.right);
			}
		}
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().value+" ");
		}
	}
	//�������
	public static void levelOrder(Node head) {
		if(head==null) {
			return;
		}
		//����һ������
		Queue<Node> q = new LinkedList<>();
		q.add(head);
		while(!q.isEmpty()) {
			head = q.poll();
			System.out.print(head.value+" ");
			if(null!=head.left) {
				q.add(head.left);
			}
			if(null!=head.right) {
				q.add(head.right);
			}
		}
		
	}
	//---------------------��ӡ���Ľṹ----------------------
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
	//---------------------��ӡ���Ľṹ----------------------
	
	
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
		
		//System.out.println("��ӡ���Ľṹ");
		//printTree(head);
		
		
		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();

		// recursive
		System.out.println("==============unrecursive==============");
		System.out.print("pre-order: ");
		preOrderUnrecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderUnrecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderUnrecur(head);
		System.out.println();
		System.out.print("level-order: ");
		levelOrder(head);
		System.out.println();

	}
}
