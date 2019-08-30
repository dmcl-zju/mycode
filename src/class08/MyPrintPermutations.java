package class08;

import java.util.HashSet;
import java.util.Set;

//�ַ���ȫ����
public class MyPrintPermutations {
	
	public static void printPermutations(String str) {
		if(str==null) {
			return;
		}
		char[] chs = str.toCharArray();
		//������
		System.out.println("���ظ��������");
		process1(chs,0);
		System.out.println("ȥ�غ�");
		process2(chs,0);
	}
	//˼·1���������ⲿ�ռ�,�������⣺�ַ���������ͬ��ĸ������ظ���ӡ
	public static void process1(char[] chs,int i) {
		//��ֹ����
		if(i==chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		//����ĵ�i��λ���������Ϻ������
		for(int j=i;j<chs.length;j++) {
			swap(chs,i,j);
			//�������󽻸���һ�㴦��
			process1(chs,i+1);
			//�������λ�ûָ�
			swap(chs,i,j);
		}
	}
	
	//˼·2���������ⲿ�ռ�,�������⣺�ַ���������ͬ��ĸ������ظ���ӡ
	public static void process2(char[] chs,int i) {
		//��ֹ����
		if(i==chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		//����Set��ȥ��
		Set<Character> set = new HashSet<>();
		//����ĵ�i��λ���������Ϻ������
		for(int j=i;j<chs.length;j++) {
			//ֻ�����ظ�����ĸ���ظ��Ĳ�����
			if(!set.contains(chs[j])) {
				set.add(chs[j]);
				swap(chs,i,j);
				//�������󽻸���һ�㴦��
				process2(chs,i+1);
				//�������λ�ûָ�
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
