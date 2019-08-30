package process_class01;

import java.util.LinkedList;

/**
 * �������ڵ����ֵ
 * @author lin
 *
 */
public class Code_04_GetMaxWindows {
	public static int[] getMaxWindows(int[] arr , int w)
	{
		int[] list = new int[arr.length - w + 1];//������
		LinkedList<Integer> deque = new LinkedList<>();//����һ��������Ϊ�Ӵ�С��˫�˶��С�ֵΪ������±�
		int index = 0;
		
		//�����i�������Ϊ���ڵ��Ҷˣ����ﲻ������ˣ�ͨ��w���ж����
		for(int i = 0; i < arr.length; i++)
		{
			//����Ҷ˵�Ԫ�رȵ�ǰҪ�����Ԫ���£���һֱ����
			while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i])
			{
				deque.pollLast();
			}
			//�����ε�i����
			deque.add(i);
			//�����ڵ�ɾ��,��ֵ�ȵ�ǰ�����Ҷ�С���Ҵﵽ˫�˶��е����ֵ������ߵ�����
			if(i - deque.peekFirst() == w)
			{
				deque.pollFirst();
			}
			if(i >= w - 1)//���ﵽ�������ڵ�ֵʱ����ʼ�ռ�
			{
				list[index++] = arr[deque.peekFirst()];//���ֵ�ռ�����
			}
			
		}
		return list;
	}
	
	
	//ʹ������ָ���-----�����һ�㲽�裬�����Ǹ�ֻ������������Ż�
	public static int[] getMaxWindows2(int[] arr , int w)
	{
		int[] list = new int[arr.length - w + 1];//������
		LinkedList<Integer> dq = new LinkedList<>();//����һ��������Ϊ�Ӵ�С��˫�˶��С�ֵΪ������±�
		int index = 0;
		
		//һ��ʼ���ھͼ���һ��ֵ
		//����
		int left = 0;
		//����
		int right = 0;
		
		while(right<arr.length) {
			////////////��right��ֵ���봰�ڵ����
			//���������ֵ����С�ڵ��ڵĵ���
			while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[right]) {
				dq.pollLast();
			}
			//�����Լ�
			dq.addLast(right);
			////////////////////////////////////
			
			///////////////////////���ͷ���������
			if(left>dq.peekFirst()) {
				//����ͷ���
				dq.pollFirst();
			}
			//////////////////////////////////////
			
			//�жϴ����γ���û
			if(right-left+1==w) {
				//���м�¼
				list[index++] = arr[dq.peekFirst()];
				//�Ѿ��γɴ�СΪ3�Ĵ����ˣ�ÿ��
				right++;
				left++;
			}else {
				//��δ�γɣ���������
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
