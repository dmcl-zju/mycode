package class08;

import java.util.HashSet;
import java.util.Set;

//字符串全排列
public class MyPrintPermutations {
	
	public static void printPermutations(String str) {
		if(str==null) {
			return;
		}
		char[] chs = str.toCharArray();
		//处理函数
		System.out.println("会重复的情况：");
		process1(chs,0);
		System.out.println("去重后：");
		process2(chs,0);
	}
	//思路1：不借助外部空间,存在问题：字符串中有相同字母会出现重复打印
	public static void process1(char[] chs,int i) {
		//终止条件
		if(i==chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		//数组的第i个位置依次填上后面的数
		for(int j=i;j<chs.length;j++) {
			swap(chs,i,j);
			//交换过后交给下一层处理
			process1(chs,i+1);
			//处理完后将位置恢复
			swap(chs,i,j);
		}
	}
	
	//思路2：不借助外部空间,存在问题：字符串中有相同字母会出现重复打印
	public static void process2(char[] chs,int i) {
		//终止条件
		if(i==chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		//利用Set来去重
		Set<Character> set = new HashSet<>();
		//数组的第i个位置依次填上后面的数
		for(int j=i;j<chs.length;j++) {
			//只处理不重复的字母，重复的不处理
			if(!set.contains(chs[j])) {
				set.add(chs[j]);
				swap(chs,i,j);
				//交换过后交给下一层处理
				process2(chs,i+1);
				//处理完后将位置恢复
				swap(chs,i,j);
			}
		}
	}
	
	public static void swap(char[] chs,int i,int j) {
		char temp = chs[i];
		chs[i] = chs[j];
		chs[j] = temp;
	}
	public static void main(String[] args) {
		printPermutations("acc");
	}
}
