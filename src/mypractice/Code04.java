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
///////////////////////////////////////第一种方式的测试		
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

	
//////////////////////////////////////////////////////////////////////////////////////////dfs最容易想到的方式，用全局变量来实现
	static LinkedList<Integer> list = new LinkedList<>();
	
	static LinkedList<Character> action = new LinkedList<>();
	
	static LinkedList<LinkedList<Character>> res = new LinkedList<>();
	
	private static void dfs(int[] arr1,int[] arr2,int index) {
		if(index==arr1.length) {
			//System.out.println("进入清算");
			//清算
			if(list.size()==arr2.length) {
				for(int i=0;i<list.size();i++) {
					if(list.get(i)!=arr2[i]) {
						return;
					}
				}
				//通过检验,加入结果集
				res.add(new LinkedList<Character>(action));
			}
			return;
		}
		//三种操作,这种优先匹配字典序小的
		//丢弃
		action.add('d');
		dfs(arr1, arr2, index+1);
		action.removeLast();
		
		//左边
		action.add('l');
		list.addFirst(arr1[index]);
		dfs(arr1, arr2, index+1);
		list.removeFirst();
		action.removeLast();
		
		//右边
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
	
	//不用全局变量的dfs
	//说明：进入每一层的action、s都是一个新的对象，因此不用回退，进入每一层的result都是同一个对象，因此最终到了最后一层收集好就行，看成全局变量来用
	private static void dfs2(String act,String ori,String aim,int index,String s,List<String> result) {
		//设置提前终止
		if(s.length()>aim.length()) {
			return;
		}
		
		if(index==ori.length()){
			//清算
			if(s.equals(aim)) {
				result.add(act);
			}
			return;
		}
		//三种操作
		//丢弃
		dfs2(act+"d ", ori, aim, index+1, s, result);
		//左边
		dfs2(act+"l ", ori, aim, index+1, ori.charAt(index)+s, result);
		//右边
		dfs2(act+"r ", ori, aim, index+1, s+ori.charAt(index), result);
	}
}
