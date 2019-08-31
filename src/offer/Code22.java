package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 其实就是二叉树的层序遍历,新建一个队列，首先将根节点放进去，然后只要队列不为空就一直循环，
 * 循环中弹出一个元素，打印其值，然后将其左右孩子放进去（先判断是不是为空，先左后右）。循环继续。
 * @author LIN
 *
 */
public class Code22 {
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		 ArrayList<Integer> list = new ArrayList<>();
		 if(null == root) {
			 return list;
		 }
		 Queue<TreeNode> queue = new LinkedList<>();
		 queue.add(root);
		 while(!queue.isEmpty()) {
			 TreeNode cur = queue.poll();
			 list.add(cur.val);
			 if(cur.left!=null) {
				 queue.add(cur.left);
			 }
			 if(cur.right!=null) {
				 queue.add(cur.right);
			 }
		 }
		return list;
	 }
}
