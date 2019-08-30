package offer;

/**
 * 	给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * @author lin
 *
 */
public class Code51 {
	
	
	//利用剑指offer中的思路做
	public int[] multiply(int[] A) {
		if(null==A) {
			return null;
		}
		int[] B = new int[A.length];
		if(A.length<1) {
			return B;
		}
		//先让B[0]暂时为1
		B[0] = 1;
		//填下三角
		for(int i=1;i<B.length;i++) {
			B[i] = B[i-1]*A[i-1];
		}
		//填下三角
		//用于存放累乘的积
		int temp = 1;
		for(int i=B.length-2;i>=0;i--) {
			temp *= A[i+1];
			B[i] *= temp;
		}
		return B;
    }
	public static void main(String[] args) {
		int[] A = {1,2,3};
		int[] B = new Code51().multiply(A);
		for(int i:B) {
			System.out.println(i);
		}
	}
}
