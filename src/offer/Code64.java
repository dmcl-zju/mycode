package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， 
 * {2,3,4,2,6,[2,5,1]}。
 * @author lin
 *
 */
public class Code64 {
	/**
	 * 参考左神P19,想清楚入队和出队，这两部做好就每次直接弹出队列头部就是每个滑动窗口的答案
	 * @param num
	 * @param size
	 * @return
	 */
	
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
		ArrayList<Integer> list = new ArrayList<>();
		if(null==num || num.length<size || size<1) {
			return list;
		}
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i=0;i<num.length;i++) {
			//进行入队
			while(!queue.isEmpty() && num[i]>=num[queue.peekLast()]) {
				//把小的这个弹出
				queue.pollLast();
			}
			//把下标直接入队就行
			queue.addLast(i);
			//进行出队操作(查看头是否过期)
			if(queue.peekFirst()==i-size) {
				queue.pollFirst();
			}
			if(i>=size-1) {
				//读取最大值
				list.add(num[queue.peekFirst()]);
			}
		}
		return list;
    }
	
	public static void main(String[] args) {
		Code64 code = new Code64();
		int[] num= {2,3,4,2,6,2,5,1};
		ArrayList<Integer> list = code.maxInWindows(num, 3);
		for(int i:list) {
			System.out.print(i+" ");
		}
	}
	
}
