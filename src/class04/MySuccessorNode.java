package class04;

//找二叉树一个节点的后继节点。（即中序遍历顺序中，每个节点的下一个节点称为其后继节点）
//思路1：可以通过给定节点的父节点一直往上找到头节点，然后进行中序遍历，找到给定的节点，那么其下一个节点就是后继节点。
//思路2：这个题分两种情况讨论，通过判断如果当前节点有右子树，那么为情况1，如果没有就是情况2.
//	          在情况1中，其后继节点就是其右子树的最左的那个节点。
//	          情况2中，往上找其父节点，如果当前节点是其父节点的右子节点就继续往上，直到当节点为父节点的左子节点则父节点为其后继节点，
//		同时还要考虑一种情况就是往上一直找到父节点为null,那么说明该节点为中序遍历的最后一个元素，没有后继节点。
		
public class MySuccessorNode {
	
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}
	//找后继节点
	public static Node getSuccessorNode(Node node) {
		if(node == null) {
			return null;
		}
		if(node.right!=null) {
			//情况一
			return getLeftMost(node.right);
		}else {
			//情况二
			Node parent = node.parent;
			//如果没有符合终止条件就一直循环
			while(parent!=null&&parent.right==node) {
				//跟新node
				node = parent;
				parent = node.parent;
			}
			//如果出现了parent=null或者parent.left=node就返回
			//这里因为parent是通过node.parent得到的，所以node一定是parent的孩子
			//那么不是右孩子的话就一定是左孩子
			return parent;
		}
	}
	
	//给一个节点，返回其左边最深的节点
	public static Node getLeftMost(Node node) {
		if(node==null) {
			return null;
		}
		while(node.left!=null) {
			node = node.left;
		}
		return node;
	}
	
	public static void main(String[] args) {
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.left.right.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode(test));
	}
	
}
