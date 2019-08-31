package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * ��ʵ���Ƕ������Ĳ������,�½�һ�����У����Ƚ����ڵ�Ž�ȥ��Ȼ��ֻҪ���в�Ϊ�վ�һֱѭ����
 * ѭ���е���һ��Ԫ�أ���ӡ��ֵ��Ȼ�������Һ��ӷŽ�ȥ�����ж��ǲ���Ϊ�գ�������ң���ѭ��������
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
