package class07;

import java.util.Arrays;
import java.util.Comparator;

import class05.MyHashMap.compareAsc;
import utils.MyArrayUtil;

/**
 * 贪心算法求字符串数组拼接的最小字典序
 * @author LIN
 *
 */
public class MyLowestLexicography {
	
	//自定义比较器
	public static class MyComparator implements Comparator<String>{

		//贪心策略：两个字符串相加哪个在前面使得加起来小就排前面
		//compare函数：返回负数就让o1排前面，整数让o2排前面
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return (o1+o2).compareTo(o2+o1);
		}
		
	}
	//求最小字符串
	public static String lowestString(String[] strs) {
		if(strs==null || strs.length==0) {
			return "";
		}
		Arrays.sort(strs,new MyComparator());
		//将字符串拼接起来
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<strs.length;i++) {
			sb.append(strs[i]);
		}
		
		return sb.toString();
	}
	
	//主函数测试
	public static void main(String[] args) {
		String[] strs= MyArrayUtil.getRandomStrArr(10, 10);
		MyArrayUtil.printArr(strs);
		System.out.println(lowestString(strs));
	}



}
