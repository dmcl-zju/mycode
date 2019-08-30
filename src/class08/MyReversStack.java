package class08;

import java.util.Stack;

public class MyReversStack {
	
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int i = getLastAndRemove(stack);
		reverse(stack);
		stack.push(i);
	}
	
	//���ջ�����һ��Ԫ�ز������һ��Ԫ��ɾ������������
	//�൱�ڴ�ջ����ʼ��ÿ��Ԫ�ض����������в�������ջ�ף���Ȼ��������ջ�׾�ֱ�ӷ��أ�������
	private static int getLastAndRemove(Stack<Integer> stack) {
		//�ϲ㺯���Ѿ���֤��
		int res = stack.pop();
		if(stack.isEmpty()) {
			//��������һ��Ԫ�ؾ�ֱ�ӷ���
			return res;
		}else {
			//������Ǿͼ������²�ȡ
			int last = getLastAndRemove(stack);
			//ȡ�����һ��Ҫ�����Ϊֻ����ջ�ײ�����������ȥ������ջΪ��
			stack.push(res);
			return last;
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
//		System.out.println("ջ�ĳ��ȣ�"+stack.size());
//		System.out.println("ջ��Ԫ�أ�"+getLastAndRemove(stack));
//		System.out.println("ջ�ĳ��ȣ�"+stack.size());
		reverse(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}
}
