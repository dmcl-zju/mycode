package com.zju.newcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 	תȦ��ӡ����
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
	
	//��ӡһȦ�ĺ���
	public void process(int[][] matrix,int Lr,int Lc,int Rr,int Rc,ArrayList<Integer> list){
		//���ֻ��һ�е����
		int curR = Lr;
		int curC = Lc;
		if(Lr==Rr) {
			while(curC <= Rc) {
				list.add(matrix[Lc][curC++]);
				//System.out.print(matrix[Lc][curC++]+" ");
			}
			return;
		}
		//ֻ��һ�е����
		if(Lc==Rc) {
			while(curR <= Rr) {
				list.add(matrix[curR++][Rc]);
				//System.out.print(matrix[curR++][Rc]+" ");
			}
			return;
		}
		//�������
		curR = Lr;
		curC = Lc;
		//��ӡ�ϱ߽�
		while(curC != Rc) {
			list.add(matrix[Lr][curC++]);
			//System.out.print(matrix[Lr][curC++]+" ");
		}
		//��ӡ�ұ߽�
		while(curR != Rr) {
			list.add(matrix[curR++][Rc]);
			//System.out.print(matrix[curR++][Rc]+" ");
		}
		//��ӡ�±߽�
		while(curC != Lc) {
			list.add(matrix[Rr][curC--]);
			//System.out.print(matrix[Rr][curC--]+" ");
		}
		//��ӡ��߽�
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
