package process_class01;

import java.util.LinkedList;

/**
 *	���ʽ��ֵ�ĺ���
 * @author lin
 *
 */
public class Code_06_MyExpressionCompute {
	public static int getValue(String str) {
		return value(str.toCharArray(), 0)[0];
	}

	
	//�ݹ���⣬�ݹ�����������
	//ÿһ�������ֹ�ǵ��ַ���β����������������
	public static int[] value(char[] str, int i) {
		//��˫�˶��в���ջ����ΪҪ�������ʱ�򷽱�
		LinkedList<String> que = new LinkedList<String>();
		//�����ռ�����
		int pre = 0;
		//��¼��ǰ��һ��Ľ����--��һ��ļ���������һ��Ҫ�����λ��
		int[] bra = null;
		while (i < str.length && str[i] != ')') {
			if (str[i] >= '0' && str[i] <= '9') {
				//��������֣���pre�����ռ�����Ϊ���ֿ����Ƕ�λ��
				pre = pre * 10 + str[i++] - '0';
			} else if (str[i] != '(') {
				//˵���������֣�Ҳ���������ţ���ֻ���ǼӼ��˳�
				//�Ȱ�֮ǰ���������
				addNum(que, pre);
				//��ǰ���������
				que.addLast(String.valueOf(str[i++]));
				//������֣�׼������һ����
				pre = 0;
			} else {
				//˵�������������ţ����еݹ鴦��
				bra = value(str, i + 1);
				pre = bra[0];
				i = bra[1] + 1;
			}
		}
		//����һ������������ǰ�������е�ǰ
		addNum(que, pre);
		return new int[] { getNum(que), i };
	}
	
	//���ּ���ջ��
	public static void addNum(LinkedList<String> que, int num) {
		if (!que.isEmpty()) {
			int cur = 0;
			//����β�����������Ϊջ����һ���Ǹ������
			String top = que.pollLast();
			if (top.equals("+") || top.equals("-")) {
				que.addLast(top);
			} else {
				cur = Integer.valueOf(que.pollLast());
				num = top.equals("*") ? (cur * num) : (cur / num);
			}
		}
		que.addLast(String.valueOf(num));
	}
	
	//���������н������㣬��ʱ��ֻ�мӺͼ�
	public static int getNum(LinkedList<String> que) {
		int res = 0;
		boolean add = true;
		String cur = null;
		int num = 0;
		while (!que.isEmpty()) {
			cur = que.pollFirst();
			if (cur.equals("+")) {
				add = true;
			} else if (cur.equals("-")) {
				add = false;
			} else {
				num = Integer.valueOf(cur);
				res += add ? num : (-num);
			}
		}
		return res;
	}

	
	
	public static void main(String[] args) {
		String exp = "48*((70-65)-43)+8*1";
		System.out.println(getValue(exp));

		exp = "4*(6+78)+53-9/2+45*8";
		System.out.println(getValue(exp));

		exp = "10-5*3";
		System.out.println(getValue(exp));

		exp = "-3*4";
		System.out.println(getValue(exp));

		exp = "3+1*4";
		System.out.println(getValue(exp));

	}
}
