package class08;

public class MyPrintSubStr {
	
	public static void printSubStr(String str) {
		if(str==null) {
			return;
		}
		//进行打印
		char[] chs = str.toCharArray();
		System.out.println("方法一：");
		process1(chs,0);
		System.out.println("方法二：");
		process2(chs,0,"");
	}
	//进行递归操作
	//思路1：对于参数i表示处理数组的第几个数，可以理解为层。
	//对于每一层只需要处理自己需不需要打印，因为这里没有引用其他内存直chs上处理，因此记得处理过后对其恢复原样
	public static void process1(char[] chs,int i) {
		//终止条件--当chs上的元素都处理完了，就执行打印操作
		if(i==chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		//当前元素要打印--就不作任何处理直接交给下一层
		process1(chs,i+1);
		//当前元素不打印,就在数组中换成0，首先记得先把原始数据保存下来，在函数出口前回复chs
		char temp = chs[i];
		chs[i] = 0;
		process1(chs,i+1);
		//该函数没有返回值，这里就是出口，回复chs
		chs[i] = temp;
	}
	//思路2：不对传入的chs数组进行任何改变，直接加入一个变量收集结果
	//这里注意 String是不可变长度字符串，因此每次加入字符都会自动生成新的字符串，因此不用向上面那样回复res,
	//因为递归中每个过程得到的都是不一样地址的res
	public static void process2(char[] chs,int i,String res) {
		if(i==chs.length) {
			System.out.println(res);
			return;
		}
		//要打印本层
		process2(chs,i+1,res+chs[i]);
		//不打印本层
		process2(chs,i+1,res);
	}
	public static void main(String[] args) {
		printSubStr("abc");
	}
}
