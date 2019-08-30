package offer;

import java.util.Stack;

import offer.Code04.TreeNode;

/**
 * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
 * @author lin
 *
 */
public class Code62 {
	
	 //˼·1����������ĵ�k���ڵ���ǵ�kС
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
				//ȡ���ڵ���в���
				 pRoot = stack.pop();
				 count++;
				 if(count==k) {
					 return pRoot;
				 }
				// System.out.print(pRoot.val+" ");
				 //���ҽڵ���
				 pRoot = pRoot.right;
			 }
		 }
		return null; 
	 }
	 
	 //��������������ķǵݹ鷽ʽ
	 private static void inTravelTree(TreeNode root) {
		 if(null==root) {
			 return;
		 }
		 Stack<TreeNode> stack = new Stack<>();
		 System.out.println("���������");
		 while(!stack.isEmpty() || null!=root) {
			 if(null!=root) {
				 //ֻҪ�������Ӿ�һֱѹ��
				 stack.push(root);
				 root = root.left;
			 }else {
				 //ȡ���ڵ���в���
				 root = stack.pop();
				 System.out.print(root.val+" ");
				 //���ҽڵ���
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
