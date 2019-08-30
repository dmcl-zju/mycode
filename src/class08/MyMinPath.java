package class08;

/**
 * �����е���С·��������
 * @author lin
 *
 */
public class MyMinPath {
	//������С·���ͱ����ݹ�汾
	public static int getMinPath1(int[][] matrix) {
		
		if(null==matrix || matrix.length==0 || matrix[0] ==null ||matrix[0].length==0) {
			return 0;
		}
		return process(matrix,0,0);
		
	}
	
	public static int process (int[][] matrix,int i,int j) {
		int res = matrix[i][j];
		//��ֹ����
		if(i==matrix.length-1 && j==matrix[i].length-1) {
			//�����յ��ˣ�ֱ�ӷ����Լ�
			return res;
		}
		//����������һ��
		if(i==matrix.length-1) {
			return res + process(matrix,i,j+1);
		}
		//����������һ��
		if(j==matrix[0].length-1) {
			return res + process(matrix,i+1,j);
		}
		//�������
		return res + Math.min(process(matrix,i,j+1),process(matrix,i+1,j));
	}
	
	public static int getMinPath2(int[][] matrix) {
		
		if(null==matrix || matrix.length==0 || matrix[0] ==null ||matrix[0].length==0) {
			return 0;
		}
		//����dp��ά��
		int[][] dp = new int[matrix.length][matrix[0].length];
		int cow = matrix.length-1;
		int col = matrix[0].length-1;
		//�������һ������
		dp[cow][col] = matrix[cow][col];
		//�����һ��
		for(int j=col-1;j>=0;j--) {
			//��ǰ���������ұߵ� ��С��
			dp[cow][j] = matrix[cow][j]+dp[cow][j+1];
		}
		//�����һ��
		for(int i=cow-1;i>=0;i--) {
			//��ǰ������������� ��С��
			//System.out.println(i+"-->"+col);
			dp[i][col] = matrix[i][col]+dp[i+1][col];
		}
		//�ӵ����ڶ��п�ʼ�����������
		for(int i=cow-1;i>=0;i--) {
			for(int j=col-1;j>=0;j--) {
				dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j], dp[i][j+1]);
			}
		}
		//ȫ���������˺󷵻ص�һ ��Ԫ��
		return dp[0][0];
	}
	
	public static void printArr(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m.length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}
	
	public static void testTime(int times) {
		int[][] m = generateRandomMatrix(10, 10);
		//dp
		long start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			getMinPath2(m);
		}
		long end = System.currentTimeMillis();
		//�����ݹ鷽��
		System.out.println("ִ�� "+times+" �Σ�dp��ʱ��"+(end-start)+"ms");
		start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			getMinPath1(m);
		}
		end = System.currentTimeMillis();
		System.out.println("ִ�� "+times+" �Σ������ݹ���ʱ��"+(end-start)+"ms");
	}
	
	public static void isEqual(int times) {
		int[][] m;
		for(int i=0;i<times;i++) {
			m = generateRandomMatrix(10, 10);
			if(getMinPath1(m) == getMinPath2(m)) {
				continue;
			}
			System.out.println("fuck!");
			System.out.println("�����ݹ飺"+getMinPath1(m));
			System.out.println("�����ݹ飺"+getMinPath2(m));
			return;
		}
		//ȫ��ִ������û�г���
		System.out.println("nice!");
	}

	public static void main(String[] args) {
		
//		int[][] m = generateRandomMatrix(10, 10);
//		System.out.println("�������飺");
//		printArr(m);
//		System.out.println("��������");
//		System.out.println("�����ݹ飺"+getMinPath1(m));
//		System.out.println("��̬�滮��"+getMinPath2(m));
		testTime(10000);
		isEqual(10000);
		
	}
}
