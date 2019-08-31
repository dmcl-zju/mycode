package offer;

import java.util.Stack;

/**
 * 二叉搜索树转换为双向链表---递归版本和非递归版本
 * @author LIN
 *
 */
public class Code26 {
	
	/*
	 * 递归版本
	 */
	TreeNode pre = null;
	TreeNode head = null;
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(null==pRootOfTree) {
			return null;
		}
		 Convert(pRootOfTree.left);
		 //进行相关操作
		 if(null==pre) {
			 head = pRootOfTree;
			 pre = pRootOfTree;
		 }else {
			 pre.right = pRootOfTree;
			 pRootOfTree.left = pre;
			 pre = pRootOfTree;
		 }
		 Convert(pRootOfTree.right);
	
		return head;
    }
	
	/*
	 * 非递归版本
	 */
	public TreeNode Convert2(TreeNode pRootOfTree) {
		if(null==pRootOfTree) {
			return null;
		}
		TreeNode head = null;
		TreeNode pre = null;
		TreeNode root = pRootOfTree;
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty()||root!=null) {
			if(null!=root) {
				stack.push(root);
				root = root.left;
			}else {
				root = stack.pop();
				//相关操作
				if(null==head) {
					head=root;
					pre = root;
				}else {
					pre.right = root;
					root.left = pre;
					pre = root;
				}
				root = root.right;
			}
		}
		return head;
    }

}
