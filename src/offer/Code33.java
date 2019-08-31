package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 	把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 	习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @author LIN
 *
 */
public class Code33 {
	
	//基本方法
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
	 
	 //改进方法
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
