package dptest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * �ֽ�������2018��̨�����ڶ���
 * �����⡿�ַ���S��Сд��ĸ���ɣ�����Ϊn������һ�ֲ�����ÿ�ζ�������ѡ�ַ��������������������ĸ���н�����ѯ�������ཻ��m��֮���ַ���������ж��ٸ�������λ���ϵ���ĸ��ͬ��

	��������:
	��һ��Ϊһ���ַ���S��һ���Ǹ�����m��(1 <= |S| <= 1000, 1 <= m <= 1000000)
	
	�������:
	һ���Ǹ���������ʾ����֮�����������ͬ��ĸ������
	
	��������1:
	abcbaa 2
	
	�������1:
	2
	
	����˵��1:
	ʹ2����ĸa�������֣�������Ҫ3�β��������ѵ�1��λ���ϵ�a�ƶ�����4��λ�á�
	�������������2�ε�����£����ֻ��ʹ2��b��2��a�������֡�
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
		//���ȵõ����в�ͬ����ĸ
		for(int i=0;i<str.length();i++) {
			set.add(str.charAt(i));
		}
		//����set��ÿ���ַ����д���
		for(char c:set) {
			//����ͬ�ַ�����������list��
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)==c) {
					list.add(i);
				}
			}
			//������Ԫ��֮����һ��ֱ������
			if(list.size()==1) {
				list.clear();
				continue;
			}
			//list��Ӻ��ˣ����ж�̬�滮����
			int temp = getRes(list, m);
			//�������ֵ
			res = res<temp?temp:res;
			//���list,����ڶ����ַ�
			list.clear();
		}
		return res;
	}
	
	
	
	/**
	 * list�б�����һ����ͬ�ַ���ԭ���ַ����е���������ababa,�����ʱ�������a�ַ�����list�д����{0,2,4}
	 * dp[i][j]��ʾ�ڶ�list�У��ӵ������±�i��ʼ�������±�j������Ӧ���������ַ��ƶ���һ������Ҫ����С�������裬��˴����������
	 * 1����j<i����������ڣ���Ϊ�����趨iΪlist�����㣬jΪlist���յ���˲����Ϊ0
	   2����i=j�������������ͬһ���ַ���Ϊ0��Ҳ�������dp[1][1]��ʾ�ı�ʾ�ľ����м���Ǹ�a
	   3����j = i+1������£�dp[i][i+1] = list.get(i+1)-list.get(i)-1;��Ϊ��������ͬ�ַ��м�û���������ַ�����˾��������ľ���
	   4��һ������£���Ϊ�����м��ƶ��ǲ�����С�ģ�����뽫�м��ƶ��ŵõ���С����dp[i+1][j-1]��Ȼ����ǽ�i��j��Ӧ���ַ��ƶ����м���Ѿ��ƶ��õ��ǶζԽӡ�
	   	  list.get(j)-list.get(i)-1��ʾ���ַ�����������a�ľ��룬j-i-1��ʾ��i��j�л����м���a�������Ҫ�ƶ��Ĳ��������������Ĳ�
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
		//��j<i����������ڣ���˲����Ϊ0
		//��i=j�������������ͬһ���ַ���Ϊ0��Ҳ�����
		//��j = i+1������£�˵����������ͬ�ַ��м�û���������ַ�����˾��������ľ��룬
		for(int i=0;i<dp.length-1;i++) {
			dp[i][i+1] = list.get(i+1)-list.get(i)-1; 
		}
		//ʣ�µ�Ϊһ�����,Ӧ�ô������£�����������
		for(int j=2;j<dp.length;j++) {
			for(int i=0;i<j-1;i++) {
				dp[i][j] = dp[i+1][j-1]+(list.get(j)-list.get(i)-1)-(j-i-1);
			}
		}
		//�����������ҵ���������������ظ���ĸ����
		for(int i=0;i<dp.length-1;i++) {
			for(int j=i+1;j<dp.length;j++) {
				if(dp[i][j]<=m) {
					//��i��j�м����ַ��ظ�
					int temp = j-i+1;
					res = temp>res?temp:res;
				}
			}
		}
		return res;
	}
	
	
}
