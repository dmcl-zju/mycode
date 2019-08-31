package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 	��ֻ����������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ������������7�� 
 * 	ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 * @author LIN
 *
 */
public class Code33 {
	
	//��������
	 public int GetUglyNumber_Solution(int index) {
		 	if(index<1) {
		 		return 0;
		 	}
		 	int num = 1;
		 	Queue<Integer> q2 = new LinkedList<>();
		 	Queue<Integer> q3 = new LinkedList<>();
		 	Queue<Integer> q5 = new LinkedList<>();
		 	for(int i=1;i<index;i++) {
		 		q2.add(num*2);
		 		q3.add(num*3);
		 		q5.add(num*5);
		 		num = Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
		 		if(q2.peek()==num) {
		 			q2.poll();
		 		}
		 		if(q3.peek()==num) {
		 			q3.poll();
		 		}
		 		if(q5.peek()==num) {
		 			q5.poll();
		 		}
		 	}
	        return num;
	 }
	 
	 //�Ľ�����
	 public int GetUglyNumber_Solution2(int index) {
		 	if(index<1) {
		 		return 0;
		 	}
		 	ArrayList<Integer> list = new ArrayList<>();
		 	int p2 = 0;
		 	int p3 = 0;
		 	int p5 = 0;
		 	list.add(1);
		 	while(list.size()<index) {
		 		int min = Math.min(list.get(p2)*2, Math.min(list.get(p3)*3, list.get(p5)*5));
		 		if(min==list.get(p2)*2) p2++;
		 		if(min==list.get(p3)*3) p3++;
		 		if(min==list.get(p5)*5) p5++;
		 		list.add(min);
		 	}
	        return list.get(list.size()-1);
	 }
	 public static void main(String[] args) {
		Code33 code = new Code33();
		int res = code.GetUglyNumber_Solution(25);
		System.out.println(res);
		int res2 = code.GetUglyNumber_Solution2(25);
		System.out.println(res2);
	}
}
