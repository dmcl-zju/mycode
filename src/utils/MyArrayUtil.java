package utils;

import java.util.Random;

public class MyArrayUtil {
	public static void main(String[] args) {
		
		//printMatrix(getRandomMatrix(10,10, 9));
		//printMatrix(getRandomMatrix(10,9));
		//printArr(getRandomArr(10, 10));
		printArr(getRandomStrArr(10, 10));
		
	}

//-------------------------------------------------一维数组--------------------------------------------
	//产生随机一位数组
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
	
	//打印一位数组
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
	
//-------------------------------------------------二维数组--------------------------------------------	
	//二维数组打印
	public static void printMatrix(int[][] m) {
		System.out.println("二维数组：");
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+"  ");
			}
			System.out.println("");
		}
	}
	//二维数组打印
	public static void printMatrix(boolean[][] m) {
		System.out.println("二维数组：");
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+"  ");
			}
			System.out.println("");
		}
	}
	
	
	//背包问题定制
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
	//背包问题定制
	public static int[][] getRandomMatrix(int maxColSize,int maxValue) {
		if (maxColSize < 0) {
			return null;
		}
		int[][] result = new int[2][(int)(maxColSize*Math.random())+1];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				//产生的数大于0
				result[i][j] = (int) (Math.random()*(maxValue)+1);
			}
		}
		return result;
	}
//-------------------------------------------------二维数组--------------------------------------------
	

	
	
//-----------------------------------------字符串和字符串数组-------------------------------------------	
	
	//产生随机字符串数组--字符串数组的最大长度  和  字符串的最大长度(允许空字符串)
	public static String[] getRandomStrArr(int maxArrSize,int maxStrSize) {
		String[] strs = new String[(int)((maxArrSize+1)*Math.random())];
		for(int i=0;i<strs.length;i++) {
			strs[i] = getRanomStr(maxStrSize);
		}
		return strs;
	}
	
	//输入字符串最大长度--返回随机字符串---包含了空字符串
	public static String getRanomStr(int maxStrSize) {
		//将所有可能出现的放到字符串中
		String str = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
		//String str = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
		Random random = new Random();
		//生成随机字符
		//char c = str.charAt(random.nextInt(str.length()));
		//产生字符串的随机长度
		//这里长度
		int stringSize = random.nextInt(maxStrSize+1);
		//构造随机字符串
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<stringSize;i++) {
			sb.append(str.charAt(random.nextInt(str.length())));
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}
