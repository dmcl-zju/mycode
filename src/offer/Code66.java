package offer;


/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author lin
 *
 */
public class Code66 {
	 //用于统计格子数
	 private int count = 0;
	 public int movingCount(int threshold, int rows, int cols)
	 {
		 //用于进入标志判断
		boolean[][] flag = new boolean[rows][cols]; 
		 //递归处理
//		process(threshold, rows, cols, 0, 0, flag);
//		return count;  
		return process2(threshold, rows, cols, 0, 0, flag);
	 }
	 
	 //递归处理
	 private void process(int threshold, int rows, int cols,int i,int j,boolean[][] flag) {
		 //终止条件
		 if(i<0 || j<0 || i>=rows || j>=cols || (getBitSum(i)+getBitSum(j))>threshold || flag[i][j]) {
			 return;
		 }
		 //说明当前格子可入，先置标志位
		 flag[i][j] = true;
		 count++;
		 //取周边的格子
		 process(threshold, rows, cols, i+1, j, flag);
		 process(threshold, rows, cols, i-1, j, flag);
		 process(threshold, rows, cols, i, j+1, flag);
		 process(threshold, rows, cols, i, j-1, flag);
	 }
	 //带返回值得递归处理
	 private int process2(int threshold, int rows, int cols,int i,int j,boolean[][] flag) {
		 //终止条件
		 if(i<0 || j<0 || i>=rows || j>=cols || (getBitSum(i)+getBitSum(j))>threshold || flag[i][j]) {
			 return 0;
		 }
		 //说明当前格子可入，先置标志位
		 flag[i][j] = true;
		 int count2 = 1;
		 //取周边的格子
		 count2 += process2(threshold, rows, cols, i+1, j, flag);
		 count2 += process2(threshold, rows, cols, i-1, j, flag);
		 count2 += process2(threshold, rows, cols, i, j+1, flag);
		 count2 += process2(threshold, rows, cols, i, j-1, flag);
		 return count2;
	 }
	 //统计数字的各位和
	 private int getBitSum(int num) {
		 int sum = 0;
		 while(num>0) {
			 sum += num%10;
			 num /= 10;
		 }
		return sum;
	 }
	 
	 
	 public static void main(String[] args) {
		
	}
}
