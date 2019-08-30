package class04;

public class MyCompleteTreeNodeNum {
	//���ڵ�
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}
	//
	public static int nodeNum(Node head) {
		if(null==head) {
			return 0;
		}
		return bs(head,1,mostLevel(head,1));
	}
	//��������ǵ�ǰ�ڵ㣬��ǰ�ڵ�Ĳ������������ĸ߶ȣ���ʵ��һ��������������ȫ�ֱ���������
	//���ص��ǵ�ǰ�ڵ�Ϊͷ����ȫ�������Ľڵ���
	public static int bs(Node node,int l,int h) {
		//����������ý��п�ָ���жϣ���Ϊ��mostLevel�м��
		if(l==h) {
			//˵���ýڵ��Ѿ��������һ���ˣ��Ǿ���һ���ڵ�
			return 1;
		}
		if(mostLevel(node.right,l+1)==h) {
			//˵������������������������Ϊh-l��ֱ�����ù�ʽ2��h-l�η�-1����ô����������ͷ�ڵ����2��h-l�η�
			return (1<<(h-l))+bs(node.right,l+1,h);
		}else {
			//˵������������������������Ϊh-l-1��ֱ�����ù�ʽ2��h-l-1�η�-1����ô����������ͷ�ڵ����2��h-l-1�η�
			//����˵������Ϊ��ȫ�������Ĳ���������ֻ��1
			return (1<<(h-l-1))+bs(node.left,l+1,h);
		}
	}
	
	//��һ���ڵ㣬�Լ��ýڵ����������Ĳ����������Ըýڵ�Ϊͷ������������Ҷ�ڵ�Ĳ���
	public static int mostLevel(Node node,int level) {
		while(node!=null) {
			level++;
			//��Ϊ����ȫ���������������������Ҳ����ȫ����������������������ڵ�����һ��������
			node = node.left;
		}
		return level-1;
	}
	//���Ժ���
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}
}
