package class04;

//�ж�һ�����ǲ���ƽ�������
public class MyIsBalancedTree {
	//�ڵ�
	public static class Node{
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
		}
	}
	

	//���巵�ؽṹ---��һ��ÿһ����Ҫ�ռ�ʲô��Ϣ�������������һ�����������ƽ�����������ĸ߶ȣ�
	public static class Res{
		public int h;
		public boolean isBalance;
		public Res(boolean isBalance,int h) {
			this.h = h;
			this.isBalance = isBalance;
		}
	}
	
	//��㺯��
	public static boolean isBalancedTree(Node head) {
		return isBalance(head).isBalance;
	}
	
	
	public static Res isBalance(Node head) {
		if(null == head) {
			//����Ҳ��ƽ���
			return new Res(true,0);
		}
		//������������
		Res left = isBalance(head.left);
		if(!left.isBalance) {
			//����ĸ߶��Ѿ�û�������ˣ��߶�ֻ����״̬Ϊtrue������²Ż��������
			return new Res(false,0);
		}
		//������������
		Res right = isBalance(head.right);
		if(!right.isBalance) {
			//����ĸ߶��Ѿ�û�������ˣ��߶�ֻ����״̬Ϊtrue������²Ż��������
			return new Res(false,0);
		}
		//���������˵��������������ƽ��ģ��Ƚ���������
		if(Math.abs(left.h-right.h)>1) {
			//����ĸ߶��Ѿ�û�������ˣ��߶�ֻ����״̬Ϊtrue������²Ż��������
			return new Res(false,0);
		}
		//������˵���Ե�ǰ�ڵ�Ϊͷ��������ƽ������������ظ��ϼ���Ϣ����ǰ�ڵ�Ĳ���Ϊ�������������ϴ��߼�һ
		return new Res(true,Math.max(left.h, right.h)+1);
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		head.right.right.right = new Node(7);
		head.right.right.right.right = new Node(7);

		System.out.println(isBalancedTree(head));

	}
}
