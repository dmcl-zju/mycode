package offer;

/**
 * 	�������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
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
		//�����ǰ�ڵ���ͬ��ȥ��ϸ�Ƚ�
		if(root1.val==root2.val) {
			res = compare(root1,root2);
		}
		//�������û��ƥ��ɹ�����С��Χ
		if(!res) {
			res = HasSubtree(root1.left,root2);
		}
		if(!res) {
			res = HasSubtree(root1.right,root2);
		}
		return res;
    }
	
	public boolean compare(TreeNode root1,TreeNode root2) {
		//���ڵ�Ϊ��˵�����λ�ñȽ�ͨ��
		if(null == root2) {
			return true;
		}
		//����������root2!=null;
		if(null == root1) {
			return false;
		}
		if(root1.val != root2.val) {
			return false;
		}
		//���Ӻ��Һ��Ӷ��ɹ�˵���ɹ�ƥ��
		return compare(root1.left,root2.left)&&compare(root1.right,root2.right);
	}
}
