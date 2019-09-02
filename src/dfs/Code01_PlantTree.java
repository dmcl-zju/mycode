package dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ��Ŀ����
	С����������һ���Լ���ׯ԰������ׯ԰����һ��С�ӣ���ϣ���ںӱ���һ�������� M �á�С��ɹ��� N ��Ʒ�ֵ�����ÿ��Ʒ�ֵ������� Ai (����������ǡ��Ϊ M)��������ϣ�������������ڵ�������ͬһƷ�ֵġ�С�������æ���һ������Ҫ�������������
	��������:
	��һ�а���һ�������� N����ʾ����Ʒ��������
	�ڶ��а��� N ������������ i (1 <= i <= N) ������ʾ�� i ��Ʒ�ֵ�����������
	���ݷ�Χ��
	1 <= N <= 1000
	1 <= M <= 2000
	�������:
	���һ�У����� M �����������ֱ��ʾ�� i ������Ʒ�ֱ�� (Ʒ�ֱ�Ŵ�1�� N)�������ڶ��ֿ��з�����������ֵ�����С�ķ����������������������ķ����������"-"��
	ʾ��1
	����
	����
	3
	4 2 1
	���
	����
	1 2 1 2 1 3 1
 * @author lin
 *	
 *	˼·��̰��+dfs�ķ�ʽ
 *	��ÿһ���ӵĽǶ���������ÿ���Ӷ��ܴ����е�������ѡ�����ÿ���ӵ��ڽӽڵ���ǳ����Լ��������������
 *	�������е����У�ÿ�ζ���ֵ��С�Ŀ�ʼ���ڿ�ѡ�������£�����ѡȡ���в�������һ�γɹ��ͷ��ؽ���������õ��ľ�����С�ֵ���
 *
 */
public class Code01_PlantTree {
	static int[] arr;
	static ArrayList<String> list;
	static int n,m;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = s.nextInt();
			m += arr[i];
		}
		s.close();
		list = new ArrayList<>();
		if(dfs(0)) {
			for(String str:list) {
				System.out.print(str);
			}
		}else {
			System.out.println("-");
		}
		
		
	}
	
	
	private static boolean isFail(int last) {
		//�������������һ��������last��һ��Ͳ���
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>(last+1)/2) {
				return true;
			}
		}
		return false;
	}
	//index�����˲嵽��ÿ���ӣ���0��ʼ
	private static boolean dfs(int index) {
		//��ǰ��ֹ�ж�---��֦
		if(isFail(m-index)) {
			return false;
		}
		//��ֹ����,ȫ����������
		if(m==index) {
			return true;
		}
		//�ڽӽڵ����������ľ
		for(int i=1;i<arr.length;i++) {
			//�ж��ܲ�����,idnex==0��������ʲô��û����Ϳ���ֱ�Ӳ���
			//���������ʣ�������������һ������һ��
			if(index==0 || (arr[i]>0 && i != Integer.valueOf(list.get(index-1).trim()))) {
				//������
				list.add(i+" ");
				arr[i]--;
				//������һ������
				if(dfs(index+1)) {
					return true;
				}
				//������ɹ����ָ�ԭ״
				list.remove(index);
				arr[i]++;
			}
		}
		return false;
	}
	
	
	
	
}






















