package offer;

/**
 * 	输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author LIN
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

public class Code17 {
	
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		if(null==root1 || null==root2) {
			return false;
		}
		boolean res = false;
		//如果当前节点相同就去详细比较
		if(root1.val==root2.val) {
			res = compare(root1,root2);
		}
		//如果上面没有匹配成功，缩小范围
		if(!res) {
			res = HasSubtree(root1.left,root2);
		}
		if(!res) {
			res = HasSubtree(root1.right,root2);
		}
		return res;
    }
	
	public boolean compare(TreeNode root1,TreeNode root2) {
		//二节点为空说明这个位置比较通过
		if(null == root2) {
			return true;
		}
		//隐藏条件是root2!=null;
		if(null == root1) {
			return false;
		}
		if(root1.val != root2.val) {
			return false;
		}
		//左孩子和右孩子都成功说明成功匹配
		return compare(root1.left,root2.left)&&compare(root1.right,root2.right);
	}
}
