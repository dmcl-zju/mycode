package class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ����������
 * @author LIN
 *
 */
public class MyBestArrange {
	public static class program{
		public int start;
		public int end;
		public program(int start,int end){
			this.start = start;
			this.end = end;
		}
	}
	
	public static class MyComparator implements Comparator<program>{

		@Override
		public int compare(program o1, program o2) {
			// TODO Auto-generated method stub
			return o1.end-o2.end;
		}
		
	}
	
	public static int getBestArrage(program[] programs,int start) {
		if(null==programs || programs.length<1) {
			return 0;
		}
		int res = 0;
		//��������ʱ�����С����
		PriorityQueue<program> PQ = new PriorityQueue<>(new MyComparator());
		for(int i=0;i<programs.length;i++) {
			PQ.add(programs[i]);
		}
		
		while(!PQ.isEmpty()) {
			//���ó�һ��
			program p = PQ.poll();
			//��������ܿ�
			if(start<=p.start) {
				res++;
				start = p.end;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		program[] ps = new program[3];
		ps[0] = new program(10,12);
		ps[1] = new program(8,11);
		ps[2] = new program(11,16);
		
		System.out.println(getBestArrage(ps, 8));
	}
}
