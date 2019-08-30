package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import offer.Code04.TreeNode;

/**
 * 	��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 * @author lin
 *
 */
public class Code59 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
		if(null==pRoot) {
			return listAll;
		}
		
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(pRoot);
		int level = 1;
		ArrayList<Integer> list = new ArrayList<>();
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			if(level%2==1) {
				//������
				pRoot = s1.pop();
				list.add(pRoot.val);
				//System.out.print(pRoot.val);
				if(pRoot.left!=null) {
					s2.push(pRoot.left);
				}
				if(pRoot.right!=null) {
					s2.push(pRoot.right);
				}
				if(s1.isEmpty()) {
					//�����ӡ
					level++;
					//System.out.println(list.size());
					//�����ύ��
					listAll.add(new ArrayList<>(list));
					list.clear();
				}
			}else {
				//ż����
				pRoot = s2.pop();
				list.add(pRoot.val);
				//System.out.print(pRoot.val);
				if(pRoot.right!=null) {
					s1.push(pRoot.right);
				}
				if(pRoot.left!=null) {
					s1.push(pRoot.left);
				}
				if(s2.isEmpty()) {
					//�����ӡ
					level++;
					//System.out.println(list.size());
					listAll.add(new ArrayList<>(list));
					list.clear();
				}
			}
		}
		return listAll;
    }
	
	
	
	//���Բ������
	private static void levelPrint(TreeNode root) {
		if(null==root) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int toPrint = 1;
		int nextLevel = 0;
		while(!queue.isEmpty()) {
			root = queue.poll();
			toPrint--;
			System.out.print(root.val);
			if(root.left!=null) {
				queue.offer(root.left);
				nextLevel++;
			}
			if(root.right!=null) {
				queue.offer(root.right);
				nextLevel++;
			}
			if(toPrint==0) {
				toPrint = nextLevel;
				nextLevel = 0;
				System.out.println("");
			}
		}
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
		//levelPrint(root);
		ArrayList<ArrayList<Integer>> listAll = new Code59().Print(root);
		
		System.out.println("list�������"+listAll.get(0).size());
		for(ArrayList<Integer> list:listAll) {
			for(int i:list) {
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}
}
