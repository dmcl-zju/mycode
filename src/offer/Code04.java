package offer;



/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author lin
 *
 */
public class Code04 {


	  public static class TreeNode {
		  int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(null==pre || pre.length==0 || null==in || in.length==0 || pre.length!=in.length) {
			return null;
		}
		return process(pre,in,0,pre.length-1,0,in.length-1);
        
    }
	
	private static TreeNode process(int[] pre,int[] in,int startPre,int endPre,int startIn,int endIn) {
		//错误方法：？？？递归出口--只剩下一个数了，直接创建节点并返回
//		if(startPre == endPre || startIn==endIn) {
//			//两个数组中的值必须是一样的
//			return new TreeNode(pre[startPre]);
//		}
		if(startPre>endPre || startIn>endIn) {
			return null;
		}
		//打印当前数组情况
//		System.out.print("先序数组：");
//		for(int i=startPre;i<=endPre;i++) {
//			System.out.print(pre[i]+"-");
//		}
//		System.out.println("");
//		System.out.print("中序数组：");
//		for(int i=startIn;i<=endIn;i++) {
//			System.out.print(in[i]+"-");
//		}
//		System.out.println("");
		//先创建自己----pre的第一个值一定是head
		TreeNode curNode = new TreeNode(pre[startPre]);
		//偏移值
		int index = getIndex(in, pre[startPre]);
		int offset = index-startIn;
		//System.out.println(pre[startPre]+"---"+offset);
		//创建孩子---关键是数组的索引来缩小问题
		curNode.left = process(pre,in,startPre+1,startPre+offset,startIn,index-1);
		curNode.right = process(pre,in,startPre+offset+1,endPre,index+1,endIn);
		return curNode;
	}
	//适用于没有重复数字的情况
	public static int getIndex(int[] arr,int value) {
		for(int i=0;i<arr.length;i++) {
			if(value==arr[i]){
				return i;
			}
		}
		//表示没有找到
		return -1;
	}
	
//-------------------------------------测试打印树--------------------------------------------
	public static void printTree(TreeNode head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(TreeNode head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.val + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
	
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in =  {4,7,2,1,5,3,8,6};
		TreeNode head = reConstructBinaryTree(pre, in);
		printTree(head);
 	}
	
}
