package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @author lin
 *
 */
public class Code63 {
	
	//使用小根堆
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	//使用大根堆
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}
	});
	
	//基本思路：用两个堆去做，基础班题目
	public void Insert(Integer num) {
	    if(maxHeap.isEmpty() || num<=maxHeap.peek()) {
	    	maxHeap.offer(num);
	    }else {
	    	minHeap.offer(num);
	    }
	    //对两个堆进行调整，个数差不能超过1,这样中位数就是两个堆顶
	    while(Math.abs(minHeap.size()-maxHeap.size())>1) {
	    	if(maxHeap.size()>minHeap.size()) {
	    		minHeap.offer(maxHeap.poll());
	    	}else {
	    		maxHeap.offer(minHeap.poll());
	    		//System.out.println(minHeap.peek()+"----测试调整----"+maxHeap.peek()+"---"+maxHeap.size());
	    	}
	    }
    }
    public Double GetMedian() {
    	int count = minHeap.size()+maxHeap.size();
    	if(count==0) {
    		//如果没有数返回什么？
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
    		System.out.println("加入了"+i+"中位数是："+code.GetMedian());
    	}
	}
    
    
    
}
