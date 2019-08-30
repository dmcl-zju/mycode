package bfs_dfs;

import java.util.LinkedList;

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
public class Code01Test {
	
	private static LinkedList<Integer> list;
	private static int m;
	
	
	public static void main(String[] args) {
		int N = 3;
		//��ǰ�����0���������
		int[] arr = {0,4,3,1};
		for(int i=1;i<arr.length;i++) {
			m += arr[i];
		}
		list = new LinkedList<>();
		boolean res = dfs2(arr, 0, 1);
		if(res) {
			printList();
		}
		else {
			System.out.println("-");
		}
	}
	
	//���²���֤�Ϸ���(������������˼·)�����һ��aim��ʾ��Ҫ�����aim������index��
	private static boolean dfs2(int[] arr,int index,int aim) {
		
		//��ֹ����
		if(index==m) {
			return true;
		}
		
		//��֤�Ϸ���
		if(arr[aim]<=0 || (index!=0 && list.get(list.size()-1)==aim)) {
			return false;
		}
		
		//�Ϸ��ģ����в���
		list.add(aim);
		arr[aim]--;
		//ѡ����һ��
		for(int i=1;i<arr.length;i++) {
			if(dfs2(arr, index+1, i)) {
				return true;
			}	
		}
		//ȫ����ʧ���˾ͻָ�ԭ��
		list.remove(list.size()-1);
		arr[aim]++;
		return false;
	}
	
	
	
	//����index��ʾ�ڲ��ĸ���-----����֤�Ϸ����ٸ����²㣨����ģ���ṩ�ģ�������ڣ�
	private static boolean dfs(int[] arr,int index) {
		
		//���������
		if(index==m) {
			return true;
		}

		//�������п���,�����i��ʾ��i����
		for(int i=1;i<arr.length;i++) {
			//��һ����ʲô�����֮��Ҫ�У��Һ�ǰһ����һ��
			//0�����ǲ����ڵģ���˶�����û��ɸѡ����
			int last = 0;
			if(index !=0) {
				last = list.get(list.size()-1);
			}
			//��������Ҳ���ǰ��һ��������
			if(arr[i]>0 && (index==0 || last!=i)){
				//���ص���������1
				list.add(i);
				arr[i]--;
				if(dfs(arr, index+1)) {
					return true;
				}
				//˵��ʧ��
				list.remove(list.size()-1);
				arr[i]++;
			}
			
		}
		//��������ѡ�񶼲��ɹ�������false
		return false;
	}
	
	
	private static void printList() {
		for(int i:list) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
	
}
