package com.zju.newcode;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author LIN
 *
 */
public class Code28 {
	/**
	 * 	思路：如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。在遍历数组时保存两个值：
	 * 	一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
	 *	同时增加一个boolean变量来指示是否换对象，若次数为0，则应该换对象，将其变为true.下一个循环就会保存下一个数字，
	 *	并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
	 */
	
	public int MoreThanHalfNum_Solution(int [] array) {
		if(null==array) {
			return 0;
		}
		//是否应该交换---即当前的数字排除掉了
		boolean change = true;
		int cur = 0;
		int times = 0;
		int res = 0;
		for(int i=0;i<array.length;i++) {
			if(change) {
				//将下一个数据作为候选人
				change = false;
				cur = array[i];
				times++;
				res = cur;
			}else {
				if(cur==array[i]) {
					times++;
				}else {
					times--;
					//判断是否要更换候选人
					if(times==0) {
						change=true;
					}
				}
			}
		}
		//判断一下上面选的这个人是不是过半了
		times=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]==res) {
				times++;
			}
		}
		//如果没有过半就返回0
		if(times>(array.length/2)) {
			return res;
		}else {
			return 0;
		}
    }
	
	public static void main(String[] args) {
		Code28 code = new Code28();
		int[] arr = {1,2,3,2,2,2,5,4,2};
		int res = code.MoreThanHalfNum_Solution(arr);
		System.out.println(res);
	}
}
