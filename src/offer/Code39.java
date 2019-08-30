package offer;

import offer.Code38.TreeNode;

/**
 * 	����һ�ö��������жϸö������Ƿ���ƽ���������
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
	 * 	˼·�����պ���������˼·������������תһȦ�ռ���Ϣ��Ȼ����������תһȦ�ռ���Ϣ������ڱ��ڵ��жϡ�
	 * @param root
	 * @return
	 */
	//��װ����ֵ
	public static class Res{
		//�ǲ���ƽ��
		public boolean isBalance;
		//�������
		public int level;
		
		public Res(boolean isBalance,int level) {
			this.isBalance = isBalance;
			this.level = level;
		}
	}
	public boolean IsBalanced_Solution(TreeNode root) {
		return process(root).isBalance;
    }
	
	//���еݹ飬�Ժ�������Ϊ���
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
		//˵��������������ƽ���
		//�жϲ���---���ʱ����������ã��������ֻҪ����ƽ��Ĳ������������
		if(Math.abs(left.level-right.level)>1) {
			return new Res(false,0);
		}
		//˵��������ǰ�ڵ����ڶ���ƽ���
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
