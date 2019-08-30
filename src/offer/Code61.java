package offer;

import java.util.LinkedList;
import java.util.Queue;

import offer.Code04.TreeNode;

/**
 * 	请实现两个函数，分别用来序列化和反序列化二叉树
 * @author lin
 *
 */
public class Code61 {
	
	 //采用先序递归方式序列化
	 String Serialize(TreeNode root) {
		if(null==root) {
			return "#_";
		}
		//先序处理
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
	  
	  //利用全局变量索引指针
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
	  //利用队列处理
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
	  //递归处理
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
	  
	  //层序遍历序列化
	  String SerializeLevel(TreeNode root) {
		  if(null==root) {
			  return null;
		  }
		  String res = root.val+"_";
		  Queue<TreeNode> queue = new LinkedList<>();
		  queue.offer(root);
		  while(!queue.isEmpty()) {
			  root = queue.poll();
			  //进行系那个管才做
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
	  
	  //层序遍历反序列化
	  TreeNode DeserializeLevel(String str) {
		  if(null==str || str.trim().length()<1) {
			  return null;
		  }
		  String[] strs = str.split("_");
		  int index = 0;
		  //生成第一个节点
		  TreeNode root = new TreeNode(Integer.valueOf(strs[index++]));
		  Queue<TreeNode> queue = new LinkedList<>();
		  queue.offer(root);
		  TreeNode node = null;
		  while(!queue.isEmpty()) {
			  node = queue.poll();
			  //构造左孩子
			  if(!strs[index].equals("#")) {
				 //存在左节点 
				 node.left = new TreeNode(Integer.valueOf(strs[index])); 
				 queue.offer(node.left);
				 index++;
			  }else {
				 node.left = null;
				 index++;
			  }
			  //构造右孩子
			  if(!strs[index].equals("#")) {
				 //存在右节点节点 
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
			
			
			System.out.println("先序遍历序列化：");
			String res = new Code61().Serialize(root);
			System.out.println(res);

			System.out.println("先序反序列化：");
			TreeNode node = new Code61().Deserialize2(res);
			printTree(node);
			System.out.println("");
			
			System.out.println("层序遍历序列化：");
			String res2 = new Code61().SerializeLevel(root);
			System.out.println(res2);
			
			System.out.println("层序反序列化(先序打印)：");
			node = new Code61().DeserializeLevel(res2);
			printTree(node);
			System.out.println("");
			
		}
}
