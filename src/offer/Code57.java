package offer;


/**
 * 	����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * @author lin
 *
 */
public class Code57 {
	public static class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	//����һ�������෽��
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
		if(null==pNode) {
			return null;
		}
		//���������������������������ڵ�
		//���û���������������ҵ��Լ���Ϊ���ӵĸ��ڵ�
		if(pNode.right!=null) {
			pNode = pNode.right;
			while(pNode.left!=null) {
				pNode = pNode.left;
			}
			return pNode;
		}else {
			//�����Ҹ��ڵ�
			TreeLinkNode father = pNode.next;
			while(null!=father && father.right == pNode) {
				pNode = father;
				father = pNode.next;
			}
			return father;
		}
    }
	
	
	
	
	//���������ҵ�root��Ȼ����������Ϳ����ҵ�
	public TreeLinkNode GetNext2(TreeLinkNode pNode)
    {	
		if(null==pNode) {
			return null;
		}
		TreeLinkNode curNode = pNode;
		//�ҵ����ڵ�
		while(curNode.next!=null) {
			curNode = curNode.next;
		}
		System.out.println(curNode.val);
		//�Ӹ��ڵ㿪ʼ�������
		getNext(curNode, pNode);
		return next;
    }
	boolean flag = false;
	TreeLinkNode next = null;
	private void getNext(TreeLinkNode root,TreeLinkNode dest) {
		if(null==root) {
			return;
		}
		getNext(root.left, dest);
		if(flag) {
			//��ȡ��̽ڵ�
			
			next = root;
			System.out.println("������"+next.val);
			flag = false;
			return;
		}
		if(root==dest) {
			flag = true;
		}
		getNext(root.right,dest);
	}
	

	public static void main(String[] args) {
	    TreeLinkNode head = new TreeLinkNode(6);
		head.next = null;
		head.left = new TreeLinkNode(3);
		head.left.next = head;
		head.left.left = new TreeLinkNode(1);
		head.left.left.next = head.left;
		head.left.left.right = new TreeLinkNode(2);
		head.left.left.right.next = head.left.left;
		head.left.right = new TreeLinkNode(4);
		head.left.right.next = head.left;
		head.left.right.right = new TreeLinkNode(5);
		head.left.right.right.next = head.left.right;
		head.right = new TreeLinkNode(9);
		head.right.next = head;
		head.right.left = new TreeLinkNode(8);
		head.right.left.next = head.right;
		head.right.left.left = new TreeLinkNode(7);
		head.right.left.left.next = head.right.left;
		head.right.right = new TreeLinkNode(10);
		head.right.right.next = head.right;
		
		Code57 code = new Code57();
		TreeLinkNode res = code.GetNext(head.left.left.right);
		System.out.println(res.val);
		
	}
	
	
}
