package offer;

/**
 * 	����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·����
 * 	�·���ĳ���Ϊ������ȡ�
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
    //����������ı���
    private void process(TreeNode root,int count) {
    	if(root==null) {
    		return;
    	}
    	//��ǰ�ڵ�Ĵ���
    	//�ȶԽڵ��������1
    	count++;
    	//�ж��ǲ��Ǹ��ڵ�
    	if(null==root.left && null==root.right) {
    		//�������µ����
    		max = Math.max(max, count);
    		//����ѡ��������ֱ���������أ�Ҳ���Բ�дֱ�������ߣ�����ֹ��������
    		count--;
    		return;
    	}
    	//��������
    	process(root.left,count);
    	process(root.right,count);
    	//�����ϲ�֮ǰ�ָ�count
    	count--;	
    }
    
    public int TreeDepth2(TreeNode root) {
    	if(null==root) {
    		return 0;
    	}
    	return process2(root);
    }
    
    //�з���ֵ�õݹ飬������������ں���
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
