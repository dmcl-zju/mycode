package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ������ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
 * @author lin
 *
 */
public class Code63 {
	
	//ʹ��С����
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	//ʹ�ô����
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}
	});
	
	//����˼·����������ȥ������������Ŀ
	public void Insert(Integer num) {
	    if(maxHeap.isEmpty() || num<=maxHeap.peek()) {
	    	maxHeap.offer(num);
	    }else {
	    	minHeap.offer(num);
	    }
	    //�������ѽ��е�����������ܳ���1,������λ�����������Ѷ�
	    while(Math.abs(minHeap.size()-maxHeap.size())>1) {
	    	if(maxHeap.size()>minHeap.size()) {
	    		minHeap.offer(maxHeap.poll());
	    	}else {
	    		maxHeap.offer(minHeap.poll());
	    		//System.out.println(minHeap.peek()+"----���Ե���----"+maxHeap.peek()+"---"+maxHeap.size());
	    	}
	    }
    }
    public Double GetMedian() {
    	int count = minHeap.size()+maxHeap.size();
    	if(count==0) {
    		//���û��������ʲô��
    		return (double) -1;
    	}
    	if(minHeap.size()==0) {
    		return (double)maxHeap.peek();
    	}
    	double res1 = maxHeap.peek();
    	double res2 = minHeap.peek();
    	if(count%2==0) {
    		return (res1+res2)/2;
    	}else {
    		return maxHeap.size()>minHeap.size()? res1:res2;
    	}
    }
    
    
    public static void main(String[] args) {
    	Code63 code = new Code63();
    	int[] arr = {1,2,3,4,5,1};
    	for(int i:arr) {
    		code.Insert(i);
    		System.out.println("������"+i+"��λ���ǣ�"+code.GetMedian());
    	}
	}
    
    
    
}
