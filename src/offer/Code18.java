package com.zju.newcode;

/**
 * 	���������Ķ�����������任ΪԴ�������ľ���
 * @author LIN
 *
 */
public class Code18 {
	
	 public void Mirror(TreeNode root) {
	     if(null==root) {
	    	 return;
	     }
	     //��ǰ����Ҫ���ģ������һ�����Ӵ��ھͽ���
	     if(root.left!=null || root.right!=null) {
	    	 TreeNode temp = root.left;
	    	 root.left = root.right;
	    	 root.right = temp;
	     }
	     //ʣ�µĽ����ӹ���
	     Mirror(root.left);
	     Mirror(root.right);
	 }
}
