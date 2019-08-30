package offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入
 * 这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不
 * 包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 * @author lin
 *
 */
public class Code65 {
	
	/**
	 * 链接：https://www.nowcoder.com/questionTerminal/c61c6999eecb4b8f88a98f66b273a3cc
		来源：牛客网
		回溯
		基本思想：
		0.根据给定数组，初始化一个标志位数组，初始化为false，表示未走过，true表示已经走过，不能走第二次
		1.根据行数和列数，遍历数组，先找到一个与str字符串的第一个元素相匹配的矩阵元素，进入judge
		2.根据i和j先确定一维数组的位置，因为给定的matrix是一个一维数组
		3.确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都直接false，说明这条路不通
		4.若k，就是待判定的字符串str的索引已经判断到了最后一位，此时说明是匹配成功的
		5.下面就是本题的精髓，递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到k到达末尾或者不满足递归条件就停止。
		6.走到这一步，说明本次是不成功的，我们要还原一下标志位数组index处的标志位，进入下一轮的判断。
	 * @param matrix
	 * @param rows
	 * @param cols
	 * @param str
	 * @return
	 */
	 public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	 {
		 if(null==matrix || null==str) {
			 return false;
		 }
		 //用来判断是不是经过
		 boolean[] flag = new boolean[matrix.length];
		 //遍历整个矩阵，寻找任意一个位置开头的所有情况
		 for(int i=0;i<rows;i++) {
			 for(int j=0;j<cols;j++) {
				 if(process(matrix, rows, cols, i, j, flag, str, 0))
					 return true;
			 }
		 }
		return false;
	 }
	 //进行递归处理--最后一个参数表示匹配到了字符串的索引
	 private boolean process(char[] matrix,int rows,int cols,int i,int j,boolean[] flag,char[] str,int k) {
		 //获取矩阵中元素在数组的索引
		 int index = i*cols+j;
		 //递归终止条件：越界（四个边界）、值不符合、已经走过
		 if(i<0 || j<0 || i>=rows || j>=cols || matrix[index]!=str[k] || flag[index]) {
			 return false;
		 }
		 //到这里说明当前元素也是匹配成功的，如果已经匹配到最后一个元素就是找到了，终止任务
		 if(k==str.length-1) {
			 return true;
		 }
		 //对当前矩阵元素操作--设置为已经走过
		 flag[index] = true;
		 //找自己的四个孩子--不存在的也算，会在终止条件中直接返回
		 if(process(matrix, rows, cols, i+1, j, flag, str, k+1) ||
		    process(matrix, rows, cols, i-1, j, flag, str, k+1) ||
		    process(matrix, rows, cols, i, j+1, flag, str, k+1) ||
		    process(matrix, rows, cols, i, j-1, flag, str, k+1)) {
			 //只要有一条找到了，就是true
			 return true;
		 }
		 //当前被选中的路径都不可行，回溯到上一层,恢复进来时候的数据
		 flag[index] = false;
		 return false;
	 }
	 
	 public static void main(String[] args) {
		 
		char[] matrix = "abcesfcsadee".toCharArray();
		char[] str = "bcced".toCharArray();
		Code65 code = new Code65();
		boolean res = code.hasPath(matrix, 3, 4, str);
		System.out.println(res);

		
		
	}
}
