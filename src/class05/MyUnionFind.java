package class05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//并查集结构
public class MyUnionFind {
	
	//随意定义内部属性，不需要指针
	public static class Node{
		String name;
		public Node(String name){
			this.name = name;
		}
	}
	
	public static class UnionFindSet{
		private Map<Node,Node> fatherMap;
		private Map<Node,Integer> sizeMap;
		
		//并查集一开始初始化的时候就要把所有的元素都放进去
		public UnionFindSet(List<Node> nodes) {
			init(nodes);
		}
		private void init(List<Node> nodes) {
			fatherMap = new HashMap<>();
			sizeMap = new HashMap<>();
			for(Node node:nodes) {
				fatherMap.put(node,node);
				sizeMap.put(node, 1);
			}
		}
		//找头部
		private Node findHead(Node node) {
			if(fatherMap.containsKey(node)) {
				Node father = fatherMap.get(node);
				if(father != node) {
					//如果没有到头部分一直递归
					father = fatherMap.get(father);
				}
				fatherMap.put(node, father);
				return father;
			}
			return null;
		}
		//是否一个集合
		public boolean isSameSet(Node node1,Node node2) {
//			System.out.println(node1.name+"-->"+node2.name);
//			System.out.println(findHead(node1)+"-->"+findHead(node2));
			return findHead(node1)==findHead(node2);
		}
		//合并集合
		public void union(Node a,Node b) {
			if(a==null || b==null) {
				return;
			}
			Node head1 = findHead(a);
			Node head2 = findHead(b);
			//对比大小
			if(sizeMap.get(head1)<sizeMap.get(head2)) {
				//head1加到head2中
				fatherMap.put(head1, head2);
				sizeMap.put(head2, sizeMap.get(head1)+sizeMap.get(head2));
			}else {
				//head2加到head1中
				fatherMap.put(head2, head1);
				sizeMap.put(head1, sizeMap.get(head1)+sizeMap.get(head2));
			}
		}
		
	}
	public static void main(String[] args) {
		List<Node> list = new ArrayList<>();
		Node n1 = new Node("a");
		Node n2 = new Node("b");
		Node n3 = new Node("c");
		Node n4 = new Node("d");
		Node n5 = new Node("e");
		Node n6 = new Node("f");
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		UnionFindSet set = new UnionFindSet(list);
		//合并前
		System.out.println("合并前："+set.isSameSet(n1, n3));
		//进行并集合
		set.union(n1,n3);
		//合并后
		System.out.println("合并后："+set.isSameSet(n1, n3));
		set.union(n3,n4);
		System.out.println("合三个并后："+set.isSameSet(n1, n4));
		
	}
}
