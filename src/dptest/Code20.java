package dptest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 字节跳动：2018后台开发第二批
 * 编码题】字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？

	输入描述:
	第一行为一个字符串S与一个非负整数m。(1 <= |S| <= 1000, 1 <= m <= 1000000)
	
	输出描述:
	一个非负整数，表示操作之后，连续最长的相同字母数量。
	
	输入例子1:
	abcbaa 2
	
	输出例子1:
	2
	
	例子说明1:
	使2个字母a连续出现，至少需要3次操作。即把第1个位置上的a移动到第4个位置。
	所以在至多操作2次的情况下，最多只能使2个b或2个a连续出现。
 * @author lin
 *
 */
public class Code20 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		String m = s.next();
		System.out.println(process(str, Integer.parseInt(m)));
	}
	
	private static int process(String str,int m) {
		int res = 1;
		HashSet<Character> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		//首先得到所有不同的字母
		for(int i=0;i<str.length();i++) {
			set.add(str.charAt(i));
		}
		//遍历set对每个字符进行处理
		for(char c:set) {
			//将相同字符的索引放入list中
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)==c) {
					list.add(i);
				}
			}
			//如果这个元素之出现一次直接跳过
			if(list.size()==1) {
				list.clear();
				continue;
			}
			//list添加好了，进行动态规划处理
			int temp = getRes(list, m);
			//更新最大值
			res = res<temp?temp:res;
			//清空list,计算第二个字符
			list.clear();
		}
		return res;
	}
	
	
	
	/**
	 * list中保存了一个相同字符在原有字符串中的索引，如ababa,如果此时处理的是a字符，则list中存的是{0,2,4}
	 * dp[i][j]表示在对list中，从的索引下标i开始到索引下标j，将对应的这两个字符移动到一起所需要的最小交换步骤，因此存在以下情况
	 * 1、当j<i的情况不存在，因为我们设定i为list左端起点，j为list的终点因此不用填都为0
	   2、当i=j的情况，两个是同一个字符，为0，也不用填。如dp[1][1]表示的表示的就是中间的那个a
	   3、当j = i+1的情况下，dp[i][i+1] = list.get(i+1)-list.get(i)-1;因为这两个相同字符中间没有其他该字符，因此就是两个的距离
	   4、一般情况下：因为都往中间移动是步数最小的，因此想将中间移动号得到最小步数dp[i+1][j-1]，然后就是将i和j对应的字符移动到中间和已经移动好的那段对接。
	   	  list.get(j)-list.get(i)-1表示在字符串中这两个a的距离，j-i-1表示在i和j中还有有几个a，因此需要移动的步数就是这两个的差
	  	 dp[i][j] = dp[i+1][j-1]+(list.get(j)-list.get(i)-1)-(j-i-1);
	 * 
	 * 
	 * 
	 * @param list
	 * @param m
	 * @return
	 */
	private static int getRes(ArrayList<Integer> list,int m) {
		int res = 1;
		int[][] dp = new int[list.size()][list.size()];
		//当j<i的情况不存在，因此不用填都为0
		//当i=j的情况，两个是同一个字符，为0，也不用填。
		//当j = i+1的情况下，说明这两个相同字符中间没有其他该字符，因此就是两个的距离，
		for(int i=0;i<dp.length-1;i++) {
			dp[i][i+1] = list.get(i+1)-list.get(i)-1; 
		}
		//剩下的为一般情况,应该从上往下，从左往右填
		for(int j=2;j<dp.length;j++) {
			for(int i=0;i<j-1;i++) {
				dp[i][j] = dp[i+1][j-1]+(list.get(j)-list.get(i)-1)-(j-i-1);
			}
		}
		//遍历这个表格找到符合条件的最大重复字母个数
		for(int i=0;i<dp.length-1;i++) {
			for(int j=i+1;j<dp.length;j++) {
				if(dp[i][j]<=m) {
					//从i到j有几个字符重复
					int temp = j-i+1;
					res = temp>res?temp:res;
				}
			}
		}
		return res;
	}
	
	
}
