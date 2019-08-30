package process_class01;

import java.util.LinkedList;

/**
 *	表达式求值的函数
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
	
	//递归解决括号
	private static int[] process(char[] chs,int index) {
		LinkedList<String> list = new LinkedList<>();
		//放置结果
		int[] res = new int[2];
		//放置临时结果
		int[] temp;
		
		//收集数字
		int num = 0;
		while(index<chs.length && chs[index]!=')') {
			if(chs[index]>='0' && chs[index]<='9') {
				//是数字
				num = num*10+(chs[index++]-'0');
			}else if(chs[index]=='(') {
				//是左括号，进递归，如果没有括号可以省略这部分
				temp = process(chs, index+1);
				num = temp[0];
				index = temp[1]+1;
			}else {
				//是普通符号
				//之前收集的数字放进队列
				addNum(list, num);
				//符号放进去
				list.addLast(String.valueOf(chs[index++]));
				//情况num
				num = 0;
			}
		}
		//退出循环之后还有一个数没加入
		addNum(list, num);
		res[0] = getNum(list);
		res[1] = index;
		return res;
	}
	
	//数字进栈
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
	
	//结果进行清算，里面只有加减
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
				//是数字
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
