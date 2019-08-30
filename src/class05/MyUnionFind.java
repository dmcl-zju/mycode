package class05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//���鼯�ṹ
public class MyUnionFind {
	
	//���ⶨ���ڲ����ԣ�����Ҫָ��
	public static class Node{
		String name;
		public Node(String name){
			this.name = name;
		}
	}
	
	public static class UnionFindSet{
		private Map<Node,Node> fatherMap;
		private Map<Node,Integer> sizeMap;
		
		//���鼯һ��ʼ��ʼ����ʱ���Ҫ�����е�Ԫ�ض��Ž�ȥ
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
		//��ͷ��
		private Node findHead(Node node) {
			if(fatherMap.containsKey(node)) {
				Node father = fatherMap.get(node);
				if(father != node) {
					//���û�е�ͷ����һֱ�ݹ�
					father = fatherMap.get(father);
				}
				fatherMap.put(node, father);
				return father;
			}
			return null;
		}
		//�Ƿ�һ������
		public boolean isSameSet(Node node1,Node node2) {
//			System.out.println(node1.name+"-->"+node2.name);
//			System.out.println(findHead(node1)+"-->"+findHead(node2));
			return findHead(node1)==findHead(node2);
		}
		//�ϲ�����
		public void union(Node a,Node b) {
			if(a==null || b==null) {
				return;
			}
			Node head1 = findHead(a);
			Node head2 = findHead(b);
			//�Աȴ�С
			if(sizeMap.get(head1)<sizeMap.get(head2)) {
				//head1�ӵ�head2��
				fatherMap.put(head1, head2);
				sizeMap.put(head2, sizeMap.get(head1)+sizeMap.get(head2));
			}else {
				//head2�ӵ�head1��
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
		//�ϲ�ǰ
		System.out.println("�ϲ�ǰ��"+set.isSameSet(n1, n3));
		//���в�����
		set.union(n1,n3);
		//�ϲ���
		System.out.println("�ϲ���"+set.isSameSet(n1, n3));
		set.union(n3,n4);
		System.out.println("����������"+set.isSameSet(n1, n4));
		
	}
}
