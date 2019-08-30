package process_class01;

import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 * @author lin
 *
 */
public class Code_04_GetMaxWindows {
	public static int[] getMaxWindows(int[] arr , int w)
	{
		int[] list = new int[arr.length - w + 1];//保存结果
		LinkedList<Integer> deque = new LinkedList<>();//保存一个从左到右为从大到小的双端队列。值为数组的下标
		int index = 0;
		
		//这里的i可以理解为窗口的右端，这里不设置左端，通过w来判断左端
		for(int i = 0; i < arr.length; i++)
		{
			//如果右端的元素比当前要加入的元素下，就一直弹出
			while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i])
			{
				deque.pollLast();
			}
			//将本次的i加入
			deque.add(i);
			//将过期的删除,（值比当前的最右端小，且达到双端队列的最大值，则左边弹出）
			if(i - deque.peekFirst() == w)
			{
				deque.pollFirst();
			}
			if(i >= w - 1)//当达到滑动窗口的值时，开始收集
			{
				list[index++] = arr[deque.peekFirst()];//最大值收集出来
			}
			
		}
		return list;
	}
	
	
	//使用两个指针对-----这个是一般步骤，上面那个只适用于这题的优化
	public static int[] getMaxWindows2(int[] arr , int w)
	{
		int[] list = new int[arr.length - w + 1];//保存结果
		LinkedList<Integer> dq = new LinkedList<>();//保存一个从左到右为从大到小的双端队列。值为数组的下标
		int index = 0;
		
		//一开始窗口就加入一个值
		//包括
		int left = 0;
		//包括
		int right = 0;
		
		while(right<arr.length) {
			////////////将right的值归入窗口的情况
			//往链表插入值，有小于等于的弹出
			while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[right]) {
				dq.pollLast();
			}
			//加入自己
			dq.addLast(right);
			////////////////////////////////////
			
			///////////////////////检查头结点过期情况
			if(left>dq.peekFirst()) {
				//弹出头结点
				dq.pollFirst();
			}
			//////////////////////////////////////
			
			//判断窗口形成了没
			if(right-left+1==w) {
				//进行记录
				list[index++] = arr[dq.peekFirst()];
				//已经形成大小为3的窗口了，每个
				right++;
				left++;
			}else {
				//还未形成，单独增加
				right++;
			}
		}
		return list;
	}
	

	public static void main(String[] args) {
		int[] arr = {4,3,5,4,3,3,6,7};
		int[] maxWindows = getMaxWindows(arr, 3);
		for(int i = 0; i < maxWindows.length; i++)
		{
			System.out.print(maxWindows[i] + " ");
		}
		
	}

}
