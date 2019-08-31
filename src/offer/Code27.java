package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c
 * �������г����������ַ���abc,acb,bac,bca,cab��cba���п����ظ�)
 * @author LIN
 *
 */
public class Code27 {
	
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<>();
		if(null==str) {
			return list;
		}
		char[] chs = str.toCharArray();
		process(chs,0,list);
		//��list��һ����
		Collections.sort(list);
		return list;
	       
    }
	//�ݹ鴦��
	public static void process(char[] chs,int index,ArrayList<String> list) {
		if(index==chs.length-1) {
			list.add(String.valueOf(chs));
		}
		Set<Character> set = new HashSet<>();
		for(int i=index;i<chs.length;i++) {
			if(!set.contains(chs[i])) {
				set.add(chs[i]);
				swap(chs,index,i);
				process(chs,index+1,list);
				swap(chs,index,i);
			}	
		}
	}
	
	private static void swap(char[] chs,int i,int j) {
		char temp = chs[i];
		chs[i] = chs[j];
		chs[j] = temp;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = Permutation("abc");
		for(String s:list) {
			System.out.println(s);
		}
	}
	
}
