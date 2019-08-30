package offer;

import java.util.LinkedList;
import java.util.Queue;

import offer.Code04.TreeNode;

/**
 * 	��ʵ�������������ֱ��������л��ͷ����л�������
 * @author lin
 *
 */
public class Code61 {
	
	 //��������ݹ鷽ʽ���л�
	 String Serialize(TreeNode root) {
		if(null==root) {
			return "#_";
		}
		//������
		String res = new String(root.val+"_");
		res += Serialize(root.left);
		res += Serialize(root.right);
		return res;
	  }
	 
	  TreeNode Deserialize(String str) {
		  if(null==str || str.trim().length()<1) {
			  return null;
		  }
		  String[] strs = str.split("_");
		  return process(strs);
	  }
	  
	  //����ȫ�ֱ�������ָ��
	  int index = 0;
	  private TreeNode process(String[] strs) {
		 if(strs[index].equals("#")) {
			 index++;
			 return null;
		 }
		 TreeNode root = new TreeNode(Integer.parseInt(strs[index++]));
		 root.left = process(strs);
		 root.right = process(strs);
		 return root; 
	  }
	  //���ö��д���
	  TreeNode Deserialize2(String str) {
		  if(null==str || str.trim().length()<1) {
			  return null;
		  }
		  String[] strs = str.split("_");
		  Queue<String> queue = new LinkedList<>();
		  for(String s:strs) {
			  queue.offer(s);
		  }
		  return  process2(queue);
	  }
	  //�ݹ鴦��
	  private TreeNode process2(Queue<String> queue) {
		 String s = queue.poll();
		 if(s.equals("#")) {
			 return null;
		 }
		 TreeNode root = new TreeNode(Integer.parseInt(s));
		 root.left = process2(queue);
		 root.right = process2(queue);
		 return root;
	  }
	  
	  //����������л�
	  String SerializeLevel(TreeNode root) {
		  if(null==root) {
			  return null;
		  }
		  String res = root.val+"_";
		  Queue<TreeNode> queue = new LinkedList<>();
		  queue.offer(root);
		  while(!queue.isEmpty()) {
			  root = queue.poll();
			  //����ϵ�Ǹ��ܲ���
			  if(null!=root.left) {
				  queue.offer(root.left);
				  res += root.left.val+"_";
			  }else {
				  res += "#_";
			  }
			  
			  if(null!=root.right) {
				  queue.offer(root.right);
				  res += root.right.val +"_";
			  }else {
				  res += "#_";
			  }
		  }
		return res;
     }
	  
	  //������������л�
	  TreeNode DeserializeLevel(String str) {
		  if(null==str || str.trim().length()<1) {
			  return null;
		  }
		  String[] strs = str.split("_");
		  int index = 0;
		  //���ɵ�һ���ڵ�
		  TreeNode root = new TreeNode(Integer.valueOf(strs[index++]));
		  Queue<TreeNode> queue = new LinkedList<>();
		  queue.offer(root);
		  TreeNode node = null;
		  while(!queue.isEmpty()) {
			  node = queue.poll();
			  //��������
			  if(!strs[index].equals("#")) {
				 //������ڵ� 
				 node.left = new TreeNode(Integer.valueOf(strs[index])); 
				 queue.offer(node.left);
				 index++;
			  }else {
				 node.left = null;
				 index++;
			  }
			  //�����Һ���
			  if(!strs[index].equals("#")) {
				 //�����ҽڵ�ڵ� 
				 node.right = new TreeNode(Integer.valueOf(strs[index]));
				 queue.offer(node.right);
				 index++;
			  }else {
				  node.right = null;
				  index++;
			  }
		  }
	      return root;
	  }
	  
	  
	  
	  

	  private static void printTree(TreeNode root) {
		  if(root==null) {
			  return;
		  }
		  System.out.print(root.val+" ");
		  printTree(root.left);
		  printTree(root.right);
	  }
	  
	  
	  public static void main(String[] args) {
			TreeNode root = new TreeNode(1);
			root.left = new TreeNode(2);
			root.right = new TreeNode(3);
			root.left.left = new TreeNode(4);
			root.left.right = new TreeNode(5);
			root.right.left = new TreeNode(6);
			root.right.right = new TreeNode(7);
//			root.left.left.left = new TreeNode(10);
//			root.left.left.right = new TreeNode(11);
//			root.right.right.left = new TreeNode(12);
//			root.right.right.right = new TreeNode(13);
			
			
			System.out.println("����������л���");
			String res = new Code61().Serialize(root);
			System.out.println(res);

			System.out.println("�������л���");
			TreeNode node = new Code61().Deserialize2(res);
			printTree(node);
			System.out.println("");
			
			System.out.println("����������л���");
			String res2 = new Code61().SerializeLevel(root);
			System.out.println(res2);
			
			System.out.println("�������л�(�����ӡ)��");
			node = new Code61().DeserializeLevel(res2);
			printTree(node);
			System.out.println("");
			
		}
}
