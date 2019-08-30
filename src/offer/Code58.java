package offer;

/**
 * 	��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
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
		//����˵�������ڵ㶼����
		if(left.val!=right.val) {
			return false;
		}
		return process(left.left,right.right)&&process(left.right,right.left);
	}
	
	
}
