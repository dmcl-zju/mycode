package class04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//二叉树的遍历--几种遍历的递归和非递归算法
public class MyPreInPosTraversal {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	//--------------递归方式------------------
	//思路：只要用了递归，不管是哪种遍历方式，每个节点都会被访问3次，第一次是从父节点来的，第二次是走完左孩子，第三次是走完右孩子
	//接下来要做的就是在哪一次访问的时候对其进行相应的操作（这里是打印），就会有了以下三种方法
	//先序遍历
	public static void preOrderRecur(Node head) {
		if(null==head) {
			return;
		}
		//第一次访问当前节点的时候打印
		System.out.print(head.value+" ");
		//访问左孩子
		preOrderRecur(head.left);
		//访问右孩子
		preOrderRecur(head.right);
	}
	//中序遍历
	public static void inOrderRecur(Node head) {
		if(null==head) {
			return;
		}
		//访问左孩子
		inOrderRecur(head.left);
		//第二次访问当前节点的时候打印
		System.out.print(head.value+" ");
		//访问右孩子
		inOrderRecur(head.right);
	}
	//后续遍历
	public static void posOrderRecur(Node head) {
		if(null==head) {
			return;
		}
		//访问左孩子
		posOrderRecur(head.left);
		//访问右孩子
		posOrderRecur(head.right);
		//第三次访问当前节点的时候打印
		System.out.print(head.value+" ");
	}
	
	//--------------非递归方式------------------
	//递归是系统来压栈，这里需要自己压栈
	//先序遍历------很层序比遍历很像，只是层序遍历是用队列
	public static void preOrderUnrecur(Node head) {
		if(null==head) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		//先将头压入栈
		stack.push(head);
		//一直循环知道栈空了说明已经遍历了一遍
		while(!stack.isEmpty()) {
			//这里head是复用变量
			head = stack.pop();
			System.out.print(head.value+" ");
			//这里按照栈的逆序，先将右孩子压进去再压左孩子
			if(null!=head.right) {
				stack.push(head.right);
			}
			if(null!=head.left) {
				stack.push(head.left);
			}
		}
	}
	//中序遍历
	public static void inOrderUnrecur(Node head) {
		if(null==head) {
			return;
		}
		//如果左子树存在就一直遍历左入栈
		Stack<Node> stack = new Stack<>();
		while(!stack.isEmpty()||head!=null) {
			if(head!=null){
				stack.push(head);
				head = head.left;
			}else{
				//已经到了左边最深，出栈
				head = stack.pop();
				System.out.print(head.value+" ");
				//往右边走
				head = head.right;
			}
		}
	}
	//后续遍历---比较复杂
	//思路：后续遍历的顺序是左右中，不好实现，但是中右左的思路和先序遍历一样，因此先实现中右左，然后放入一个辅助栈中实现逆序
	public static void posOrderUnrecur(Node head) {
		if(null==head) {
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(head);
		while(!stack1.isEmpty()) {
			head = stack1.pop();
			//将其压入stack2中
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
	//层序遍历
	public static void levelOrder(Node head) {
		if(head==null) {
			return;
		}
		//创建一个队列
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
	//---------------------打印树的结构----------------------
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
	//---------------------打印树的结构----------------------
	
	
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
		
		//System.out.println("打印树的结构");
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
