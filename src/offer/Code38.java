package offer;

/**
 * 	输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 	最长路径的长度为树的深度。
 * @author lin
 *
 */
public class Code38 {
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	int max = 0;
    public int TreeDepth(TreeNode root) {
    	if(null==root) {
    		return 0;
    	}
    	int count = 0;
    	process(root,count);
		return max; 
	}
    //类似于先序的遍历
    private void process(TreeNode root,int count) {
    	if(root==null) {
    		return;
    	}
    	//当前节点的处理
    	//先对节点计数器加1
    	count++;
    	//判断是不是根节点
    	if(null==root.left && null==root.right) {
    		//更新最新的深度
    		max = Math.max(max, count);
    		//可以选择在这里直接跳出返回，也可以不写直接往下走，让终止条件返回
    		count--;
    		return;
    	}
    	//继续遍历
    	process(root.left,count);
    	process(root.right,count);
    	//返回上层之前恢复count
    	count--;	
    }
    
    public int TreeDepth2(TreeNode root) {
    	if(null==root) {
    		return 0;
    	}
    	return process2(root);
    }
    
    //有返回值得递归，这个方法类似于后续
    private int process2(TreeNode root) {
    	if(root==null) {
    		return 0;
    	}
    	/*if(root.left==null && root.right==null) {
    		return 1;
    	}*/
    	int left = process2(root.left);
    	int right = process2(root.right);
		return Math.max(left, right)+1;	
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		Code38 code = new Code38();
		int res = code.TreeDepth(root);
		System.out.println(res);
		int res2 = code.TreeDepth2(root);
		System.out.println(res2);
		
	}
}
