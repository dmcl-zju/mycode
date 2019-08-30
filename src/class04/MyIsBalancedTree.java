package class04;

//判断一颗数是不是平衡二叉树
public class MyIsBalancedTree {
	//节点
	public static class Node{
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	

	//定义返回结构---想一下每一步需要收集什么信息（这里就两个，一个是这个数是平衡的吗，这个树的高度）
	public static class Res{
		public int h;
		public boolean isBalance;
		public Res(boolean isBalance,int h) {
			this.h = h;
			this.isBalance = isBalance;
		}
	}
	
	//外层函数
	public static boolean isBalancedTree(Node head) {
		return isBalance(head).isBalance;
	}
	
	
	public static Res isBalance(Node head) {
		if(null == head) {
			//空树也是平衡的
			return new Res(true,0);
		}
		//看左子树是吗
		Res left = isBalance(head.left);
		if(!left.isBalance) {
			//这里的高度已经没有意义了，高度只有在状态为true的情况下才会参与运算
			return new Res(false,0);
		}
		//看右子树是吗
		Res right = isBalance(head.right);
		if(!right.isBalance) {
			//这里的高度已经没有意义了，高度只有在状态为true的情况下才会参与运算
			return new Res(false,0);
		}
		//如果到这里说明左右子树都是平衡的，比较左右子树
		if(Math.abs(left.h-right.h)>1) {
			//这里的高度已经没有意义了，高度只有在状态为true的情况下才会参与运算
			return new Res(false,0);
		}
		//到这里说明以当前节点为头结点的数是平衡二叉树，返回给上级信息，当前节点的层数为左右子树层数较大者加一
		return new Res(true,Math.max(left.h, right.h)+1);
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		head.right.right.right = new Node(7);
		head.right.right.right.right = new Node(7);

		System.out.println(isBalancedTree(head));

	}
}
