package offer;

import java.util.ArrayList;

public class Code24 {
	
	 public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		 ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
		 if(null==root) {
			 return listAll;
		 }
		 ArrayList<Integer> list = new ArrayList<>();
		 process(root, target, list, listAll);
		 return listAll;   
	 }
	 
	 //递归处理
	 public void process(TreeNode root,int target, ArrayList<Integer> list,ArrayList<ArrayList<Integer>> listAll) {
		 if(root==null) {
			 return;
		 }
		 list.add(root.val);
		 //如果到了跟节点
		 if(root.left==null && root.right==null) {
			 //如果到了根节点直接判断
			 if(target==root.val) {
				 listAll.add(new ArrayList<Integer>(list));
			 }
			 //到了根节点了
			 list.remove(list.size()-1);
			 return;
		 }
		 //如果不是
		 process(root.left, target-root.val, list, listAll);
		 process(root.right, target-root.val, list, listAll);
		 //这里也是一个出口，不管结构怎么样都要移除当前元素
		 list.remove(list.size()-1);
	 }
}
