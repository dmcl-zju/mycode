package class08;

import java.util.Arrays;

import utils.MyArrayUtil;


/**
 * ��������
 * @author lin
 *
 */
public class MybackPack {
	public static int value;
	
	//�����ݹ�2
	public static int getMaxValue1(int[] w,int[] v,int bag) {
		if(w==null || v== null || w.length==0 || v.length==0 || w.length!=v.length) {
			return -1;
		}
		//���еݹ����
//		process1(w,v,0,0,0,bag);
//		return value;
		return process2(w, v, 0, 0, bag);
		
	}
	//���������汾1--����ȫ�ֱ���
	public static void process1(int[] w,int[] v,int i,int sum,int alreadyWeight,int bag) {
		//��ֹ����--������������˷���0��   ���߶���ȡ���˷���0��ʾ��ֹ
		if(i==w.length) {
			//ȫ������һ�����ж�
			if(sum>value && alreadyWeight<=bag) {
				value = sum;
			}
			return;
		}
		//�Լ����ӽ�ȥ
		process1(w,v,i+1,sum,alreadyWeight,bag);
		//�Լ��ӽ�ȥ
		process1(w,v,i+1,sum+v[i],alreadyWeight+w[i],bag);
	}
	
	//�ݹ������ֵ
	public static int process2(int[] w,int[] v,int i,int alreadyWeight,int bag) {
		//��ֹ����
		if(i == w.length) {
			return 0;
		}
		//�������Լ�
		int res =  process2(w,v,i+1,alreadyWeight,bag);
		//Ҫ�����Լ����ж�һ��
		if(alreadyWeight+w[i]<=bag) {
			res = Math.max(res,v[i]+ process2(w,v,i+1,alreadyWeight+w[i],bag));
		}
		return res;
	}
	
	//��̬�滮����
	public static int getMaxValue2(int[] w,int v[],int bag) {
		if(w==null || v== null || w.length==0 || v.length==0 || w.length!=v.length) {
			return -1;
		}
		//����dp��
		int[][] dp = new int[w.length+1][bag+1];
		int row = dp.length-1;
		int col = dp[0].length-1;
		//���
		//�������һ��
		for(int j=0;j<dp[0].length;j++) {
			dp[row][j] = 0;
		}
		//�����һ��
		for(int i=0;i<row;i++) {
			dp[i][col] = 0;
		}
		//����һ�����
		for(int i=row-1;i>=0;i--) {
			for(int j=0;j<col;j++) {
				//�������������񣬾Ͳ����룬ֱ�ӵ�����һ��
				if(j+w[i]>bag) {
					dp[i][j] = dp[i+1][j];
				}else {
					//�ڱ��Χ����ȡ���������ֵ
					dp[i][j] = Math.max(dp[i+1][j], v[i]+dp[i+1][j+w[i]]);
				}
			}
		}
		//printArr(dp);
		return dp[0][0];
	}
	
////----------------------------------����----------------------------------
	//�����Ƿ����
	public static void isEqual(int times) {
		int[][] arr;
		int bag;
		for(int i=0;i<times;i++) {
			arr = MyArrayUtil.getRandomMatrix(10, 10);
			bag = (int)(20*Math.random()+1);
			if(getMaxValue1(arr[0], arr[1], bag)==getMaxValue2(arr[0], arr[1], bag)) {
				continue;
			}else {
				System.out.println("fuck!");
				MyArrayUtil.printMatrix(arr);
				System.out.println("������С�� "+bag);
				System.out.println("�����ݹ����� "+getMaxValue1(arr[0], arr[1], bag));
				System.out.println("��̬�滮����� "+getMaxValue2(arr[0], arr[1], bag));
				return;
			}
		}
		System.out.println("�Ա���"+times+"�γɹ�,nice!");
	}
	//��������ʱ��
	public static void testTime(int times) {
		int[][] arr;
		int bag;
		long start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			arr = MyArrayUtil.getRandomMatrix(30, 10);
			bag = (int)(20*Math.random()+1);	
			getMaxValue2(arr[0], arr[1], bag);
		}
		long end = System.currentTimeMillis();
		System.out.println("ִ�� "+times+" �Σ���̬�滮��ʱ��"+(end-start)+"ms");
		start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			arr = MyArrayUtil.getRandomMatrix(30, 10);
			bag = (int)(20*Math.random()+1);	
			getMaxValue1(arr[0], arr[1], bag);
		}
		end = System.currentTimeMillis();
		System.out.println("ִ�� "+times+" �Σ������ݹ���ʱ��"+(end-start)+"ms");
	}
		
	public static void main(String[] args) {
		//isEqual(1000000);
		testTime(10000);
	}
}
