package class08;

import java.util.Arrays;

import utils.MyArrayUtil;


/**
 * 背包问题
 * @author lin
 *
 */
public class MybackPack {
	public static int value;
	
	//暴力递归2
	public static int getMaxValue1(int[] w,int[] v,int bag) {
		if(w==null || v== null || w.length==0 || v.length==0 || w.length!=v.length) {
			return -1;
		}
		//进行递归操作
//		process1(w,v,0,0,0,bag);
//		return value;
		return process2(w, v, 0, 0, bag);
		
	}
	//暴力遍历版本1--利用全局变量
	public static void process1(int[] w,int[] v,int i,int sum,int alreadyWeight,int bag) {
		//终止条件--如果背包超重了返回0，   或者东西取完了返回0表示终止
		if(i==w.length) {
			//全部在这一层做判断
			if(sum>value && alreadyWeight<=bag) {
				value = sum;
			}
			return;
		}
		//自己不加进去
		process1(w,v,i+1,sum,alreadyWeight,bag);
		//自己加进去
		process1(w,v,i+1,sum+v[i],alreadyWeight+w[i],bag);
	}
	
	//递归带返回值
	public static int process2(int[] w,int[] v,int i,int alreadyWeight,int bag) {
		//终止条件
		if(i == w.length) {
			return 0;
		}
		//不加入自己
		int res =  process2(w,v,i+1,alreadyWeight,bag);
		//要加入自己先判断一下
		if(alreadyWeight+w[i]<=bag) {
			res = Math.max(res,v[i]+ process2(w,v,i+1,alreadyWeight+w[i],bag));
		}
		return res;
	}
	
	//动态规划方法
	public static int getMaxValue2(int[] w,int v[],int bag) {
		if(w==null || v== null || w.length==0 || v.length==0 || w.length!=v.length) {
			return -1;
		}
		//创建dp表
		int[][] dp = new int[w.length+1][bag+1];
		int row = dp.length-1;
		int col = dp[0].length-1;
		//填表
		//先填最后一行
		for(int j=0;j<dp[0].length;j++) {
			dp[row][j] = 0;
		}
		//填最后一列
		for(int i=0;i<row;i++) {
			dp[i][col] = 0;
		}
		//对于一般情况
		for(int i=row-1;i>=0;i--) {
			for(int j=0;j<col;j++) {
				//如果重量超出表格，就不参与，直接等于下一层
				if(j+w[i]>bag) {
					dp[i][j] = dp[i+1][j];
				}else {
					//在表格范围内则取两个的最大值
					dp[i][j] = Math.max(dp[i+1][j], v[i]+dp[i+1][j+w[i]]);
				}
			}
		}
		//printArr(dp);
		return dp[0][0];
	}
	
////----------------------------------测试----------------------------------
	//测试是否相等
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
				System.out.println("背包大小： "+bag);
				System.out.println("暴力递归结果： "+getMaxValue1(arr[0], arr[1], bag));
				System.out.println("动态规划结果： "+getMaxValue2(arr[0], arr[1], bag));
				return;
			}
		}
		System.out.println("对比了"+times+"次成功,nice!");
	}
	//测试运行时间
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
		System.out.println("执行 "+times+" 次，动态规划用时："+(end-start)+"ms");
		start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			arr = MyArrayUtil.getRandomMatrix(30, 10);
			bag = (int)(20*Math.random()+1);	
			getMaxValue1(arr[0], arr[1], bag);
		}
		end = System.currentTimeMillis();
		System.out.println("执行 "+times+" 次，暴力递归用时："+(end-start)+"ms");
	}
		
	public static void main(String[] args) {
		//isEqual(1000000);
		testTime(10000);
	}
}
