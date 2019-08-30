package offer;

import java.util.Stack;

import offer.Code04.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @author lin
 *
 */
public class Code62 {
	
	 //思路1：中序遍历的第k个节点就是第k小
	 TreeNode KthNode(TreeNode pRoot, int k)
	 {
		if(null==pRoot) {
			return null;
		}
		int count = 0;
		 Stack<TreeNode> stack = new Stack<>();
		 while(!stack.isEmpty() || pRoot!=null) {
			 if(null!=pRoot) {
				 stack.push(pRoot);
				 pRoot = pRoot.left;
			 }else {
				//取出节点进行操作
				 pRoot = stack.pop();
				 count++;
				 if(count==k) {
					 return pRoot;
				 }
				// System.out.print(pRoot.val+" ");
				 //向右节点走
				 pRoot = pRoot.right;
			 }
		 }
		return null; 
	 }
	 
	 //二叉树中序遍历的非递归方式
	 private static void inTravelTree(TreeNode root) {
		 if(null==root) {
			 return;
		 }
		 Stack<TreeNode> stack = new Stack<>();
		 System.out.println("中序遍历：");
		 while(!stack.isEmpty() || null!=root) {
			 if(null!=root) {
				 //只要存在左孩子就一直压入
				 stack.push(root);
				 root = root.left;
			 }else {
				 //取出节点进行操作
				 root = stack.pop();
				 System.out.print(root.val+" ");
				 //向右节点走
				 root = root.right;
			 }
		 }
		 System.out.println(" ");
		 
	 }
	 
	 public static void main(String[] args) {
			
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
//		root.left.left.left = new TreeNode(10);
//		root.left.left.right = new TreeNode(11);
//		root.right.right.left = new TreeNode(12);
//		root.right.right.right = new TreeNode(13);
		
		inTravelTree(root);
		
		TreeNode node = new Code62().KthNode(root,5);
		System.out.println(node.val);
	}
	 
	 
}
