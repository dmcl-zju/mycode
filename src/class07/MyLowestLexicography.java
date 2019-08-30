package class07;

import java.util.Arrays;
import java.util.Comparator;

import class05.MyHashMap.compareAsc;
import utils.MyArrayUtil;

/**
 * ̰���㷨���ַ�������ƴ�ӵ���С�ֵ���
 * @author LIN
 *
 */
public class MyLowestLexicography {
	
	//�Զ���Ƚ���
	public static class MyComparator implements Comparator<String>{

		//̰�Ĳ��ԣ������ַ�������ĸ���ǰ��ʹ�ü�����С����ǰ��
		//compare���������ظ�������o1��ǰ�棬������o2��ǰ��
		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return (o1+o2).compareTo(o2+o1);
		}
		
	}
	//����С�ַ���
	public static String lowestString(String[] strs) {
		if(strs==null || strs.length==0) {
			return "";
		}
		Arrays.sort(strs,new MyComparator());
		//���ַ���ƴ������
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<strs.length;i++) {
			sb.append(strs[i]);
		}
		
		return sb.toString();
	}
	
	//����������
	public static void main(String[] args) {
		String[] strs= MyArrayUtil.getRandomStrArr(10, 10);
		MyArrayUtil.printArr(strs);
		System.out.println(lowestString(strs));
	}



}
