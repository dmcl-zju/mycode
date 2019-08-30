package offer;


/**
 * 	给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
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
	//方法一：基础班方法
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
		if(null==pNode) {
			return null;
		}
		//如果有右子树就找右子树的最左节点
		//如果没有右子树就往上找到自己作为左孩子的父节点
		if(pNode.right!=null) {
			pNode = pNode.right;
			while(pNode.left!=null) {
				pNode = pNode.left;
			}
			return pNode;
		}else {
			//往上找父节点
			TreeLinkNode father = pNode.next;
			while(null!=father && father.right == pNode) {
				pNode = father;
				father = pNode.next;
			}
			return father;
		}
    }
	
	
	
	
	//方法二：找到root，然后中序遍历就可以找到
	public TreeLinkNode GetNext2(TreeLinkNode pNode)
    {	
		if(null==pNode) {
			return null;
		}
		TreeLinkNode curNode = pNode;
		//找到父节点
		while(curNode.next!=null) {
			curNode = curNode.next;
		}
		System.out.println(curNode.val);
		//从父节点开始中序遍历
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
			//获取后继节点
			
			next = root;
			System.out.println("进入了"+next.val);
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
