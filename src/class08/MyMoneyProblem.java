package class08;

/**
 * 数组中任意个数是否能得到指定的和
 * @author lin
 *
 */
public class MyMoneyProblem {
	public static boolean moneyProblem1(int[] arr,int aim) {
		if(arr==null || arr.length==0) {
			return false;
		}
		//进行递归查找
		int count = 0;
		return process(arr,0,0,aim);
	}
	
	public static boolean process(int[] arr,int i,int sum,int aim) {
		//只有都到了最后一个数计算完才验证--这样可以看到底有几组符合们也可以选择匹配到就提前终止
		if(sum==aim) {
			return true;
		}else if(sum>aim) {
			return false;
		}
		if(i==arr.length) {
			return false;
		}
		//对于自己来数两个选择：参与求和，不参与求和
		return process(arr,i+1,sum,aim) || process(arr,i+1,sum+arr[i],aim);
	}
	
	//根据暴力递归改的动态规划
	public static boolean moneyProblem2(int[] arr,int aim) {
		if(arr==null || arr.length==0) {
			return false;
		}
		//创建dp表
		boolean[][] dp = new boolean[arr.length+1][aim+1];
		int row = dp.length-1;
		int col = dp[0].length-1;
		//填表
		//先填最后一列
		for(int i=0;i<=row;i++) {
			dp[i][col] = true;
		}
		//填最后一行,除了最后一个不填
		for(int j=0;j<col;j++) {
			dp[row][j] = false;
		}
		//常规情况
		for(int i=row-1;i>=0;i--) {
			for(int j=0;j<col;j++) {
				if(j+arr[i]>aim) {
					dp[i][j] = dp[i+1][j];
				}else {
					dp[i][j] = dp[i+1][j] || dp[i+1][j+arr[i]];
				}
			}
		}
		//printArr(dp);
		//表格全部填完，返回
		return dp[0][0];
		
	}
	
	
//----------------------------------------------测试-----------------------------------------------
	
	
	//打印数组
	public static void printArr(boolean[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
	}
	//获取随机数组
	public static int[] getRandomArr(int maxSize,int maxValue) {
		int[] arr = new int[(int)((maxSize+1)*Math.random())];
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)((maxValue+1)*Math.random());
		}
		return arr;
	}
	//多样本测试
	public static void isEqual(int times) {
		int[] arr;
		int aim;
		for(int i=0;i<times;i++) {
			arr = getRandomArr(30, 10);
			//aim = (int)(100*Math.random());
			aim = 100;
			if(moneyProblem1(arr, aim)==moneyProblem2(arr, aim)) {
				continue;
			}else {
				System.out.println("fuck!");
				System.out.print("数组为：[");
				for(int a:arr) {
					System.out.print(a+" ");
				}
				System.out.println("]");
				System.out.println("目标值为："+aim);
				System.out.println("暴力递归结果："+moneyProblem1(arr, aim));
				System.out.println("动态规划结果："+moneyProblem2(arr, aim));
				return;
			}
		}
		System.out.println("nice!");
	}
	
	public static void testTime(int times) {
		int[] arr = getRandomArr(100, 10);
		//int aim = (int)(50*Math.random());
		int aim = 100;
		//dp
		long start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			arr = getRandomArr(30, 10);
			//aim = (int)(500*Math.random());
			moneyProblem2(arr, aim);
		}
		long end = System.currentTimeMillis();
		//暴力递归方法
		System.out.println("执行 "+times+" 次，dp用时："+(end-start)+"ms");
		start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			arr = getRandomArr(30, 10);
			//aim = (int)(500*Math.random());
			moneyProblem1(arr, aim);
		}
		end = System.currentTimeMillis();
		System.out.println("执行 "+times+" 次，暴力递归用时："+(end-start)+"ms");
	}
	
	public static void main(String[] args) {
		isEqual(100);
		testTime(100);
		
	}
}
