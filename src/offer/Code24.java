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
	 
	 //�ݹ鴦��
	 public void process(TreeNode root,int target, ArrayList<Integer> list,ArrayList<ArrayList<Integer>> listAll) {
		 if(root==null) {
			 return;
		 }
		 list.add(root.val);
		 //������˸��ڵ�
		 if(root.left==null && root.right==null) {
			 //������˸��ڵ�ֱ���ж�
			 if(target==root.val) {
				 listAll.add(new ArrayList<Integer>(list));
			 }
			 //���˸��ڵ���
			 list.remove(list.size()-1);
			 return;
		 }
		 //�������
		 process(root.left, target-root.val, list, listAll);
		 process(root.right, target-root.val, list, listAll);
		 //����Ҳ��һ�����ڣ����ܽṹ��ô����Ҫ�Ƴ���ǰԪ��
		 list.remove(list.size()-1);
	 }
}
