package class04;

import java.util.LinkedList;
import java.util.Queue;




//�����������л��ͷ����л�
public class MySerializeAndReconstruct {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	//����������л�
	public static String preSerialize(Node head) {
		if(null==head) {
			return "#_";
		}
		String res = head.value+"_";
		res += preSerialize(head.left);
		res += preSerialize(head.right);
		return res;
	}
	//������������л�
	public static Node reconByString(String preStr) {
		//���Ƚ��ַ����ֽ����������
		String[] values = preStr.split("_");
		Queue<String> q = new LinkedList<>();
		//�Ƚ���浽������
		for(int i=0;i<values.length;i++) {
			q.offer(values[i]);
		}
		return reconPreOrder(q);
	}
	
	//��һ���ַ������У��������������������
	public static Node reconPreOrder(Queue<String> q) {
		if(q==null) {
			return null;
		}
		String str = q.poll();
		if(str.equals("#")) {
			return null;
		}
		//�����µĽڵ�
		Node newNode = new Node(Integer.valueOf(str));
		newNode.left = reconPreOrder(q);
		newNode.right = reconPreOrder(q);
		return newNode;
	}
	
	//����������л�
	public static String SerializeByLevel(Node head) {
		if(head==null) {
			return null;
		}
		String res = head.value+"_";
		Queue<Node> q = new LinkedList<>();
		q.add(head);
		while(!q.isEmpty()) {
			//ȡ��
			head = q.poll();
			if(null != head.left) {
				res += head.left.value+"_";
				q.add(head.left);
			}else {
				res += "#_";
			}
			if(null != head.right) {
				res += head.right.value+"_";
				q.add(head.right);
			}else {
				res += "#_";
			}
		}
		return res;
	}
	//������������л�
	public static Node reconByLevel(String levelStr) {
		String[] values = levelStr.split("_");
		int index = 0;
		Node head = generateNodeByString(values[index++]);
		Queue<Node> queue = new LinkedList<>();
		if(head != null) {
			queue.add(head);
		}
		Node node = null;
		while(!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNodeByString(values[index++]);
			node.right = generateNodeByString(values[index++]);
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
		return head;
	}
	
	public static Node generateNodeByString(String val) {
		if (val.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(val));
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
	
	//����������
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.right = new Node(5);
		printTree(head);

		String pre = preSerialize(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = reconByString(pre);
		System.out.print("reconstruct tree by pre-order, ");
		printTree(head);
		String level = SerializeByLevel(head);
		System.out.println("serialize tree by level: " + level);
		head = reconByLevel(level);
		System.out.print("reconstruct tree by level, ");
		printTree(head);
	}
}
