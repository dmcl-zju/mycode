package process_class01;

import java.util.LinkedList;

/**
 *	表达式求值的函数
 * @author lin
 *
 */
public class Code_06_MyExpressionCompute {
	public static int getValue(String str) {
		return value(str.toCharArray(), 0)[0];
	}

	
	//递归求解，递归解决括号问题
	//每一层计算终止是到字符串尾部或者碰到右括号
	public static int[] value(char[] str, int i) {
		//用双端队列不用栈的因为要最后结算的时候方便
		LinkedList<String> que = new LinkedList<String>();
		//用来收集数字
		int pre = 0;
		//记录当前这一层的结果集--这一层的计算结果和下一个要计算的位置
		int[] bra = null;
		while (i < str.length && str[i] != ')') {
			if (str[i] >= '0' && str[i] <= '9') {
				//如果是数字，用pre进行收集，因为数字可能是多位的
				pre = pre * 10 + str[i++] - '0';
			} else if (str[i] != '(') {
				//说明不是数字，也不是左括号，就只能是加减乘除
				//先把之前的数入队列
				addNum(que, pre);
				//当前符号入队列
				que.addLast(String.valueOf(str[i++]));
				//清空数字，准备凑下一个数
				pre = 0;
			} else {
				//说明碰到了左括号，进行递归处理
				bra = value(str, i + 1);
				pre = bra[0];
				i = bra[1] + 1;
			}
		}
		//最后的一个数，有括号前或者所有的前
		addNum(que, pre);
		return new int[] { getNum(que), i };
	}
	
	//数字加入栈中
	public static void addNum(LinkedList<String> que, int num) {
		if (!que.isEmpty()) {
			int cur = 0;
			//队列尾部，可以理解为栈顶，一定是个运算符
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
	
	//对整个队列进行清算，此时就只有加和减
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
