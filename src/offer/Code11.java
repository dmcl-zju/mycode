package com.zju.newcode;
/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author LIN
 *
 */
public class Code11 {
	
	//解法1:定义一个变量flag（初始值为）不断往左边移动一位与原来的额数比，当这个flag中的1移除出去后就会变成0
	//注意不能把原来的数n向右移然后和1与，因为在负数情况下左边是补1。
	public int NumberOf(int n) {
		int count = 0;
		int flag = 1;
		while(flag!=0) {
			if((flag & n)!=0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
    }
	//思路2：链接：https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8
	//如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
	//原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
	public int NumberOf2(int n) {
		int count = 0;
		while(n!=0) {
			count++;
			n = n&(n-1);
		}
		return count;
    }
	public static void main(String[] args) {
		Code11 code = new Code11();
		int res = code.NumberOf(8);
		System.out.println(res);
		System.out.println(code.NumberOf2(8));
	}
}
