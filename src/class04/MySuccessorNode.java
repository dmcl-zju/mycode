package class04;

//�Ҷ�����һ���ڵ�ĺ�̽ڵ㡣�����������˳���У�ÿ���ڵ����һ���ڵ��Ϊ���̽ڵ㣩
//˼·1������ͨ�������ڵ�ĸ��ڵ�һֱ�����ҵ�ͷ�ڵ㣬Ȼ���������������ҵ������Ľڵ㣬��ô����һ���ڵ���Ǻ�̽ڵ㡣
//˼·2������������������ۣ�ͨ���ж������ǰ�ڵ�������������ôΪ���1�����û�о������2.
//	          �����1�У����̽ڵ��������������������Ǹ��ڵ㡣
//	          ���2�У��������丸�ڵ㣬�����ǰ�ڵ����丸�ڵ�����ӽڵ�ͼ������ϣ�ֱ�����ڵ�Ϊ���ڵ�����ӽڵ��򸸽ڵ�Ϊ���̽ڵ㣬
//		ͬʱ��Ҫ����һ�������������һֱ�ҵ����ڵ�Ϊnull,��ô˵���ýڵ�Ϊ������������һ��Ԫ�أ�û�к�̽ڵ㡣
		
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
	//�Һ�̽ڵ�
	public static Node getSuccessorNode(Node node) {
		if(node == null) {
			return null;
		}
		if(node.right!=null) {
			//���һ
			return getLeftMost(node.right);
		}else {
			//�����
			Node parent = node.parent;
			//���û�з�����ֹ������һֱѭ��
			while(parent!=null&&parent.right==node) {
				//����node
				node = parent;
				parent = node.parent;
			}
			//���������parent=null����parent.left=node�ͷ���
			//������Ϊparent��ͨ��node.parent�õ��ģ�����nodeһ����parent�ĺ���
			//��ô�����Һ��ӵĻ���һ��������
			return parent;
		}
	}
	
	//��һ���ڵ㣬�������������Ľڵ�
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
