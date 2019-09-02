package mypractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Code04 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.nextLine();
		for(int i=0;i<n;i++) {
			String ori = s.nextLine();
			String aim = s.nextLine();
			process(ori, aim);
		}
///////////////////////////////////////��һ�ַ�ʽ�Ĳ���		
//		int[] arr1  = {1,3,3};
//		int[] arr2 = {3};
//		
//		dfs(arr1, arr2, 0);
//		//System.out.println(res.size());
//		
//		for(LinkedList<Character> action:res) {
//			for(char c:action) {
//				System.out.print(c+" ");
//			}
//			System.out.println();
//		}
		

	}

	
//////////////////////////////////////////////////////////////////////////////////////////dfs�������뵽�ķ�ʽ����ȫ�ֱ�����ʵ��
	static LinkedList<Integer> list = new LinkedList<>();
	
	static LinkedList<Character> action = new LinkedList<>();
	
	static LinkedList<LinkedList<Character>> res = new LinkedList<>();
	
	private static void dfs(int[] arr1,int[] arr2,int index) {
		if(index==arr1.length) {
			//System.out.println("��������");
			//����
			if(list.size()==arr2.length) {
				for(int i=0;i<list.size();i++) {
					if(list.get(i)!=arr2[i]) {
						return;
					}
				}
				//ͨ������,��������
				res.add(new LinkedList<Character>(action));
			}
			return;
		}
		//���ֲ���,��������ƥ���ֵ���С��
		//����
		action.add('d');
		dfs(arr1, arr2, index+1);
		action.removeLast();
		
		//���
		action.add('l');
		list.addFirst(arr1[index]);
		dfs(arr1, arr2, index+1);
		list.removeFirst();
		action.removeLast();
		
		//�ұ�
		action.add('r');
		list.addLast(arr1[index]);
		dfs(arr1, arr2, index+1);
		list.removeLast();
		action.removeLast();
	}
	
	

	
/////////////////////////////////////////////////////////////////////////////////////////////////////	
	private static void process(String ori,String aim) {
		
		List<String> result = new ArrayList<>();
		dfs2("", ori, aim, 0, "", result);
		System.out.println("{");
		if(ori.equals(aim)) {
			System.out.println("");
		}
		for(String s:result) {
			System.out.println(s);
		}
		System.out.println("}");
		
	}
	
	//����ȫ�ֱ�����dfs
	//˵��������ÿһ���action��s����һ���µĶ�����˲��û��ˣ�����ÿһ���result����ͬһ������������յ������һ���ռ��þ��У�����ȫ�ֱ�������
	private static void dfs2(String act,String ori,String aim,int index,String s,List<String> result) {
		//������ǰ��ֹ
		if(s.length()>aim.length()) {
			return;
		}
		
		if(index==ori.length()){
			//����
			if(s.equals(aim)) {
				result.add(act);
			}
			return;
		}
		//���ֲ���
		//����
		dfs2(act+"d ", ori, aim, index+1, s, result);
		//���
		dfs2(act+"l ", ori, aim, index+1, ori.charAt(index)+s, result);
		//�ұ�
		dfs2(act+"r ", ori, aim, index+1, s+ori.charAt(index), result);
	}
}
