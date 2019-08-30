package bfs_dfs;

import java.util.LinkedList;

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
public class Code01Test {
	
	private static LinkedList<Integer> list;
	private static int m;
	
	
	public static void main(String[] args) {
		int N = 3;
		//最前面这个0是冗余设计
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
	
	//在下层验证合法性(二叉树遍历的思路)，最后一个aim表示想要插入第aim种树到index上
	private static boolean dfs2(int[] arr,int index,int aim) {
		
		//终止条件
		if(index==m) {
			return true;
		}
		
		//验证合法性
		if(arr[aim]<=0 || (index!=0 && list.get(list.size()-1)==aim)) {
			return false;
		}
		
		//合法的，进行插入
		list.add(aim);
		arr[aim]--;
		//选择下一层
		for(int i=1;i<arr.length;i++) {
			if(dfs2(arr, index+1, i)) {
				return true;
			}	
		}
		//全部都失败了就恢复原样
		list.remove(list.size()-1);
		arr[aim]++;
		return false;
	}
	
	
	
	//这里index表示在插哪个坑-----先验证合法性再给到下层（深搜模板提供的，这个对于）
	private static boolean dfs(int[] arr,int index) {
		
		//如果坑满了
		if(index==m) {
			return true;
		}

		//遍历所有可能,这里的i表示第i种树
		for(int i=1;i<arr.length;i++) {
			//第一个坑什么都能填，之后要有，且和前一个不一样
			//0号树是不存在的，因此对下面没有筛选性质
			int last = 0;
			if(index !=0) {
				last = list.get(list.size()-1);
			}
			//如果有树且不和前面一样才能填
			if(arr[i]>0 && (index==0 || last!=i)){
				//擦回到坑里，树苗减1
				list.add(i);
				arr[i]--;
				if(dfs(arr, index+1)) {
					return true;
				}
				//说明失败
				list.remove(list.size()-1);
				arr[i]++;
			}
			
		}
		//如果上面的选择都不成功，返或false
		return false;
	}
	
	
	private static void printList() {
		for(int i:list) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
	
}
