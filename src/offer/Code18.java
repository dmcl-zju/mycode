package com.zju.newcode;

/**
 * 	操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author LIN
 *
 */
public class Code18 {
	
	 public void Mirror(TreeNode root) {
	     if(null==root) {
	    	 return;
	     }
	     //当前过程要做的：如果有一个孩子存在就交换
	     if(root.left!=null || root.right!=null) {
	    	 TreeNode temp = root.left;
	    	 root.left = root.right;
	    	 root.right = temp;
	     }
	     //剩下的交给子过程
	     Mirror(root.left);
	     Mirror(root.right);
	 }
}
