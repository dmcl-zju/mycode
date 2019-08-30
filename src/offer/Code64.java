package offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� 
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� 
 * {2,3,4,2,6,[2,5,1]}��
 * @author lin
 *
 */
public class Code64 {
	/**
	 * �ο�����P19,�������Ӻͳ��ӣ����������þ�ÿ��ֱ�ӵ�������ͷ������ÿ���������ڵĴ�
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
			//�������
			while(!queue.isEmpty() && num[i]>=num[queue.peekLast()]) {
				//��С���������
				queue.pollLast();
			}
			//���±�ֱ����Ӿ���
			queue.addLast(i);
			//���г��Ӳ���(�鿴ͷ�Ƿ����)
			if(queue.peekFirst()==i-size) {
				queue.pollFirst();
			}
			if(i>=size-1) {
				//��ȡ���ֵ
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
