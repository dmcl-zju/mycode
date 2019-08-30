package dptest;

/**字节跳动：2019春招汇总--旅行商问题
 * 小明目前在做一份毕业旅行的规划。打算从北京出发，分别去若干个城市，然后再回到北京，每个城市之间均乘坐高铁，且每个城市只去一次。由于经费有限，
 * 希望能够通过合理的路线安排尽可能的省一些路上的花销。给定一组城市和每对城市之间的火车票的价钱，找到每个城市只访问一次并返回起点的最小车费花销。

	输入描述:
	城市个数n（1<n≤20，包括北京）
	
	城市间的车票价钱 n行n列的矩阵 m[n][n]
	
	输出描述:
	最小车费花销 s
	
	输入例子1:
	4
	0 2 6 5
	2 0 4 4
	6 4 0 2
	5 4 2 0
	
	输出例子1:
	13
	
	例子说明1:
	共 4 个城市，城市 1 和城市 1 的车费为0，城市 1 和城市 2 之间的车费为 2，城市 1 和城市 3 之间的车费为 6，城市 1 和城市 4 之间的车费为 5，依次类推。
	假设任意两个城市之间均有单程票可购买，且票价在1000元以内，无需考虑极端情况。
 * @author lin
 *
 */

/**
 * 	思路：旅行商问题，参考https://www.cnblogs.com/youmuchen/p/6879579.html
 * @author lin
 *
 */
public class Code07 {
	public static void main(String[] args) {
		int[][] m = {{0,2,6,5},{2,0,4,4},{6,4,0,2},{5,4,2,0}};
		System.out.println(process(m));
	}
	
	private static int process(int[][] m) {
		//城市个数
		int n = m.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][1<<(n-1)];
		//先填第一列
		for(int i=0;i<dp.length;i++) {
			if(i==0) {
				//从0回到0是非法操作
				dp[i][0] = max;
				continue;
			}
			dp[i][0] = m[i][0];
		}
		//填写剩下的列，根据依赖关系，后边的列要依赖前面的列，因此从上到下从左到右填
		for(int j=1;j<dp[0].length;j++) {
			//内部也是逐行填
			for(int i=0;i<dp.length;i++) {
				//先赋最大值
				dp[i][j] = max;
				//看下剩下的地点中有没有自己
				if((j>>(i-1)&1)==1) {
					continue;
				}
				//循环找出j中包含的所有目的地,k代表从右到左第k位置,这里也刚好可以看成地点标号
				for(int k=1;k<dp.length;k++) {
					//如果不存在该地点则跳过
					if((j>>(k-1)&1)==0) {
						continue;
					}
					//说明存在则进行计算
					//第一部分：从i位置到k位置的花费
					int c1 = m[i][k];
					//第二部分：从k位置到经过剩下地点然后再回到0的花费
					int c2 = dp[k][j^(1<<(k-1))];
					//更新当前位置为最小
					dp[i][j] = dp[i][j]>(c1+c2)?(c1+c2):dp[i][j];
				}
			}
		}
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		return dp[0][dp[0].length-1];
	}
}
