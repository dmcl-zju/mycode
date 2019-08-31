package offer;

import java.util.Stack;

/**
 * ����������ת��Ϊ˫������---�ݹ�汾�ͷǵݹ�汾
 * @author LIN
 *
 */
public class Code26 {
	
	/*
	 * �ݹ�汾
	 */
	TreeNode pre = null;
	TreeNode head = null;
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(null==pRootOfTree) {
			return null;
		}
		 Convert(pRootOfTree.left);
		 //������ز���
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
	 * �ǵݹ�汾
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
				//��ز���
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
