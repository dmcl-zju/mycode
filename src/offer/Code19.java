package com.zju.newcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 	转圈打印矩阵
 * @author LIN
 *
 */
public class Code19 {
	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		if(null==matrix || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
			return list; 
		}
		int Lr = 0;
		int Lc = 0;
		int Rr = matrix.length-1;
		int Rc = matrix[0].length-1;
		while(Lr<=Rr && Lc<=Rc) {
			process(matrix, Lr++, Lc++, Rr--, Rc--, list);
		}
		
		return list;	       
    }
	
	//打印一圈的函数
	public void process(int[][] matrix,int Lr,int Lc,int Rr,int Rc,ArrayList<Integer> list){
		//如果只有一行的情况
		int curR = Lr;
		int curC = Lc;
		if(Lr==Rr) {
			while(curC <= Rc) {
				list.add(matrix[Lc][curC++]);
				//System.out.print(matrix[Lc][curC++]+" ");
			}
			return;
		}
		//只有一列的情况
		if(Lc==Rc) {
			while(curR <= Rr) {
				list.add(matrix[curR++][Rc]);
				//System.out.print(matrix[curR++][Rc]+" ");
			}
			return;
		}
		//常规情况
		curR = Lr;
		curC = Lc;
		//打印上边界
		while(curC != Rc) {
			list.add(matrix[Lr][curC++]);
			//System.out.print(matrix[Lr][curC++]+" ");
		}
		//打印右边界
		while(curR != Rr) {
			list.add(matrix[curR++][Rc]);
			//System.out.print(matrix[curR++][Rc]+" ");
		}
		//打印下边界
		while(curC != Lc) {
			list.add(matrix[Rr][curC--]);
			//System.out.print(matrix[Rr][curC--]+" ");
		}
		//打印左边界
		while(curR != Lr) {
			list.add(matrix[curR--][Lc]);
			//System.out.print(matrix[curR--][Lc]+" ");
		}
	}
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		 Code19 code = new  Code19();
		 List<Integer> list = code.printMatrix(matrix);
		 for(int i:list) {
			 System.out.print(i+" ");
		 }
	}
	
}
