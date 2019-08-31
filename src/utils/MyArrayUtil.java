package utils;

import java.util.Random;

public class MyArrayUtil {
	public static void main(String[] args) {
		
		//printMatrix(getRandomMatrix(10,10, 9));
		//printMatrix(getRandomMatrix(10,9));
		//printArr(getRandomArr(10, 10));
		printArr(getRandomStrArr(10, 10));
		
	}

//-------------------------------------------------һά����--------------------------------------------
	//�������һλ����
	public static int[] getRandomArr(int maxSize,int maxValue) {
		if (maxSize < 0 ) {
			return null;
		}
		int[] result = new int[(int)(maxSize*Math.random())+1];
		for (int i = 0; i != result.length; i++) {
			result[i] = (int) (Math.random() * (maxValue+1));
	
		}
		return result;
	}
	
	//��ӡһλ����
	public static void printArr(int[] m) {
		System.out.print("[");
		for(int i=0;i<m.length;i++) {
			if(i==m.length-1) {
				System.out.print(m[i]);
			}else {
				System.out.print(m[i]+",");
			}
		}
		System.out.println("]");
	}
	
	public static void printArr(String[] m) {
		System.out.print("[");
		for(int i=0;i<m.length;i++) {
			if(i==m.length-1) {
				System.out.print(m[i]);
			}else {
				System.out.print(m[i]+",");
			}
		}
		System.out.println("]");
	}
	
	public static void printArr(boolean[] m) {
		System.out.print("[");
		for(int i=0;i<m.length;i++) {
			if(i==m.length-1) {
				System.out.print(m[i]);
			}else {
				System.out.print(m[i]+",");
			}
		}
		System.out.println("]");
	}
	
//-------------------------------------------------��ά����--------------------------------------------	
	//��ά�����ӡ
	public static void printMatrix(int[][] m) {
		System.out.println("��ά���飺");
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+"  ");
			}
			System.out.println("");
		}
	}
	//��ά�����ӡ
	public static void printMatrix(boolean[][] m) {
		System.out.println("��ά���飺");
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+"  ");
			}
			System.out.println("");
		}
	}
	
	
	//�������ⶨ��
	public static int[][] getRandomMatrix(int maxRowSize, int maxColSize,int maxValue) {
		if (maxRowSize < 0 || maxColSize < 0) {
			return null;
		}
		int[][] result = new int[(int)(maxRowSize*Math.random())+1][(int)(maxColSize*Math.random())+1];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * (maxValue+1));
			}
		}
		return result;
	}
	//�������ⶨ��
	public static int[][] getRandomMatrix(int maxColSize,int maxValue) {
		if (maxColSize < 0) {
			return null;
		}
		int[][] result = new int[2][(int)(maxColSize*Math.random())+1];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				//������������0
				result[i][j] = (int) (Math.random()*(maxValue)+1);
			}
		}
		return result;
	}
//-------------------------------------------------��ά����--------------------------------------------
	

	
	
//-----------------------------------------�ַ������ַ�������-------------------------------------------	
	
	//��������ַ�������--�ַ����������󳤶�  ��  �ַ�������󳤶�(������ַ���)
	public static String[] getRandomStrArr(int maxArrSize,int maxStrSize) {
		String[] strs = new String[(int)((maxArrSize+1)*Math.random())];
		for(int i=0;i<strs.length;i++) {
			strs[i] = getRanomStr(maxStrSize);
		}
		return strs;
	}
	
	//�����ַ�����󳤶�--��������ַ���---�����˿��ַ���
	public static String getRanomStr(int maxStrSize) {
		//�����п��ܳ��ֵķŵ��ַ�����
		String str = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
		//String str = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		Random random = new Random();
		//��������ַ�
		//char c = str.charAt(random.nextInt(str.length()));
		//�����ַ������������
		//���ﳤ��
		int stringSize = random.nextInt(maxStrSize+1);
		//��������ַ���
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<stringSize;i++) {
			sb.append(str.charAt(random.nextInt(str.length())));
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}
