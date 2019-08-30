package class04;

public class MyCompleteTreeNodeNum {
	//树节点
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}
	//
	public static int nodeNum(Node head) {
		if(null==head) {
			return 0;
		}
		return bs(head,1,mostLevel(head,1));
	}
	//输入参数是当前节点，当前节点的层数，整个树的高度（其实是一个常数，可以用全局变量来做）
	//返回的是当前节点为头的完全二叉树的节点数
	public static int bs(Node node,int l,int h) {
		//这个函数不用进行空指针判断，因为在mostLevel中检查
		if(l==h) {
			//说明该节点已经到了最后一层了，那就是一个节点
			return 1;
		}
		if(mostLevel(node.right,l+1)==h) {
			//说明左子树是满二叉树，层数为h-l，直接套用公式2的h-l次方-1，那么左子树加上头节点就是2的h-l次方
			return (1<<(h-l))+bs(node.right,l+1,h);
		}else {
			//说明右子树是满二叉树，层数为h-l-1，直接套用公式2的h-l-1次方-1，那么左子树减伤头节点就是2的h-l-1次方
			//层数说明：因为完全二叉树的层数相差最大只有1
			return (1<<(h-l-1))+bs(node.left,l+1,h);
		}
	}
	
	//给一个节点，以及该节点再整个树的层数，返回以该节点为头的子树的最深叶节点的层数
	public static int mostLevel(Node node,int level) {
		while(node!=null) {
			level++;
			//因为是完全二叉树，因此其任意子树也是完全二叉树，所以找子树的左节点最深一定是最深
			node = node.left;
		}
		return level-1;
	}
	//测试函数
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}
}
