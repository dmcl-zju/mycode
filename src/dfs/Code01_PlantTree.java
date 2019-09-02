package dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目描述
	小多想在美化一下自己的庄园。他的庄园毗邻一条小河，他希望在河边种一排树，共 M 棵。小多采购了 N 个品种的树，每个品种的数量是 Ai (树的总数量恰好为 M)。但是他希望任意两棵相邻的树不是同一品种的。小多请你帮忙设计一种满足要求的种树方案。
	输入描述:
	第一行包含一个正整数 N，表示树的品种数量。
	第二行包含 N 个正整数，第 i (1 <= i <= N) 个数表示第 i 个品种的树的数量。
	数据范围：
	1 <= N <= 1000
	1 <= M <= 2000
	输出描述:
	输出一行，包含 M 个正整数，分别表示第 i 棵树的品种编号 (品种编号从1到 N)。若存在多种可行方案，则输出字典序最小的方案。若不存在满足条件的方案，则输出"-"。
	示例1
	输入
	复制
	3
	4 2 1
	输出
	复制
	1 2 1 2 1 3 1
 * @author lin
 *	
 *	思路：贪心+dfs的方式
 *	以每一个坑的角度上来看，每个坑都能从已有的数中来选择，因此每个坑的邻接节点就是除了自己以外的其他树，
 *	而在所有的树中，每次都从值最小的开始，在可选的条件下，优先选取进行插树，第一次成功就返回结果，这样得到的就是最小字典序。
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
		//遍历所有如果有一个树大于last的一半就不行
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>(last+1)/2) {
				return true;
			}
		}
		return false;
	}
	//index代表了插到了每个坑，从0开始
	private static boolean dfs(int index) {
		//提前终止判断---剪枝
		if(isFail(m-index)) {
			return false;
		}
		//终止条件,全部插完的情况
		if(m==index) {
			return true;
		}
		//邻接节点就是所有树木
		for(int i=1;i<arr.length;i++) {
			//判断能插入吗,idnex==0是特例，什么都没插入就可以直接插入
			//这个树还有剩下且这个树和上一个树不一样
			if(index==0 || (arr[i]>0 && i != Integer.valueOf(list.get(index-1).trim()))) {
				//插入树
				list.add(i+" ");
				arr[i]--;
				//进入下一层搜索
				if(dfs(index+1)) {
					return true;
				}
				//如果不成功，恢复原状
				list.remove(index);
				arr[i]++;
			}
		}
		return false;
	}
	
	
	
	
}






















