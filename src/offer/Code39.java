package offer;

import offer.Code38.TreeNode;

/**
 * 	输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author lin
 *
 */
public class Code39 {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/**
	 * 	思路：按照后续遍历的思路：先在左子树转一圈收集信息，然后再右子树转一圈收集信息，最后在本节点判断。
	 * @param root
	 * @return
	 */
	//分装返回值
	public static class Res{
		//是不是平衡
		public boolean isBalance;
		//树的深度
		public int level;
		
		public Res(boolean isBalance,int level) {
			this.isBalance = isBalance;
			this.level = level;
		}
	}
	public boolean IsBalanced_Solution(TreeNode root) {
		return process(root).isBalance;
    }
	
	//进行递归，以后续遍历为框架
	private Res process(TreeNode root) {
		if(null==root) {
			return new Res(true,0);
		}
		Res left = process(root.left);
		if(!left.isBalance) {
			return new Res(false,0);
		}
		Res right = process(root.right);
		if(!right.isBalance) {
			return new Res(false, 0);
		}
		//说明左右子树都是平衡的
		//判断层数---这个时候层数才用用，因此上面只要不是平衡的层数可以随便填
		if(Math.abs(left.level-right.level)>1) {
			return new Res(false,0);
		}
		//说明包括当前节点在内都是平衡的
		return new Res(true,Math.max(left.level, right.level)+1);
	}
	
	public static void main(String[] args) {
		Code39 code = new Code39();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		root.right.right.right = new TreeNode(1);
		
		System.out.println(code.IsBalanced_Solution(root));
		
	}
}
