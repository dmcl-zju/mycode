package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import offer.Code04.TreeNode;

/**
 * 	从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author lin
 *
 */
public class Code60 {
	
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
		if(null==pRoot) {
			return listAll;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);
		ArrayList<Integer> list = new ArrayList<>();
		int toBePrint = 1;
		int nextLevel = 0;
		while(!queue.isEmpty()) {
			pRoot = queue.poll();
			list.add(pRoot.val);
			toBePrint--;
			if(null!=pRoot.left) {
				queue.add(pRoot.left);
				nextLevel++;
			}
			if(null!=pRoot.right) {
				queue.add(pRoot.right);
				nextLevel++;
			}
			if(toBePrint==0) {
				listAll.add(new ArrayList<>(list));
				list.clear();
				toBePrint = nextLevel;
				nextLevel = 0;
			}
		}
		return listAll;
    }
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(10);
		root.left.left.right = new TreeNode(11);
		root.right.right.left = new TreeNode(12);
		root.right.right.right = new TreeNode(13);
		
		ArrayList<ArrayList<Integer>> listAll = new Code60().Print(root);
		System.out.println("list输出测试"+listAll.get(0).size());
		for(ArrayList<Integer> list:listAll) {
			for(int i:list) {
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}
}
