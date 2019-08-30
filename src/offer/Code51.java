package offer;

/**
 * 	����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 * @author lin
 *
 */
public class Code51 {
	
	
	//���ý�ָoffer�е�˼·��
	public int[] multiply(int[] A) {
		if(null==A) {
			return null;
		}
		int[] B = new int[A.length];
		if(A.length<1) {
			return B;
		}
		//����B[0]��ʱΪ1
		B[0] = 1;
		//��������
		for(int i=1;i<B.length;i++) {
			B[i] = B[i-1]*A[i-1];
		}
		//��������
		//���ڴ���۳˵Ļ�
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
