package offer;

/**
 * 	请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author lin
 *
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Code58 {
	
	//
	boolean isSymmetrical(TreeNode pRoot)
    {
		if(null==pRoot) {
			return true;
		}
		
		return process(pRoot.left,pRoot.right);
    }
	
	private boolean process(TreeNode left,TreeNode right) {
		if(null==left && null==right) {
			return true;
		}
		if(null==left || null==right) {
			return false;
		}
		//这里说明两个节点都存在
		if(left.val!=right.val) {
			return false;
		}
		return process(left.left,right.right)&&process(left.right,right.left);
	}
	
	
}
