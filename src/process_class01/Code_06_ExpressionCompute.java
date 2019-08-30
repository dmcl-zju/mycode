package process_class01;

import java.util.LinkedList;

/**
 *	���ʽ��ֵ�ĺ���
 * @author lin
 *
 */
public class Code_06_ExpressionCompute {
	
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
	
	private static int getValue(String exp) {
		return process(exp.toCharArray(), 0)[0];
	}
	
	//�ݹ�������
	private static int[] process(char[] chs,int index) {
		LinkedList<String> list = new LinkedList<>();
		//���ý��
		int[] res = new int[2];
		//������ʱ���
		int[] temp;
		
		//�ռ�����
		int num = 0;
		while(index<chs.length && chs[index]!=')') {
			if(chs[index]>='0' && chs[index]<='9') {
				//������
				num = num*10+(chs[index++]-'0');
			}else if(chs[index]=='(') {
				//�������ţ����ݹ飬���û�����ſ���ʡ���ⲿ��
				temp = process(chs, index+1);
				num = temp[0];
				index = temp[1]+1;
			}else {
				//����ͨ����
				//֮ǰ�ռ������ַŽ�����
				addNum(list, num);
				//���ŷŽ�ȥ
				list.addLast(String.valueOf(chs[index++]));
				//���num
				num = 0;
			}
		}
		//�˳�ѭ��֮����һ����û����
		addNum(list, num);
		res[0] = getNum(list);
		res[1] = index;
		return res;
	}
	
	//���ֽ�ջ
	private static void addNum(LinkedList<String> list,int num) {
		if(list.isEmpty()) {
			list.addLast(String.valueOf(num));
			return;
		}
		
		String top = list.pollLast();
		if(top.equals("+")||top.equals("-")) {
			list.addLast(top);
		}else {
			int pre = Integer.parseInt(list.pollLast());
			if(top.equals("*")) {
				num = num*pre;
			}else {
				num = pre/num;
			}
		}
		list.addLast(String.valueOf(num));
	}
	
	//����������㣬����ֻ�мӼ�
	private static int getNum(LinkedList<String> list) {
		int res = 0;
		boolean isAdd = true;
		while(!list.isEmpty()) {
			String cur = list.pollFirst();
			if(cur.equals("+")) {
				isAdd = true;
			}else if(cur.equals("-")){
				isAdd = false;
			}else {
				//������
				int num = Integer.parseInt(cur);
				if(!isAdd) {
					num = -num;
				}
				res += num;
			}
		}
		return res;
	}
}
