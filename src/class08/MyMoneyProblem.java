package class08;

/**
 * ��������������Ƿ��ܵõ�ָ���ĺ�
 * @author lin
 *
 */
public class MyMoneyProblem {
	public static boolean moneyProblem1(int[] arr,int aim) {
		if(arr==null || arr.length==0) {
			return false;
		}
		//���еݹ����
		int count = 0;
		return process(arr,0,0,aim);
	}
	
	public static boolean process(int[] arr,int i,int sum,int aim) {
		//ֻ�ж��������һ�������������֤--�������Կ������м��������Ҳ����ѡ��ƥ�䵽����ǰ��ֹ
		if(sum==aim) {
			return true;
		}else if(sum>aim) {
			return false;
		}
		if(i==arr.length) {
			return false;
		}
		//�����Լ���������ѡ�񣺲�����ͣ����������
		return process(arr,i+1,sum,aim) || process(arr,i+1,sum+arr[i],aim);
	}
	
	//���ݱ����ݹ�ĵĶ�̬�滮
	public static boolean moneyProblem2(int[] arr,int aim) {
		if(arr==null || arr.length==0) {
			return false;
		}
		//����dp��
		boolean[][] dp = new boolean[arr.length+1][aim+1];
		int row = dp.length-1;
		int col = dp[0].length-1;
		//���
		//�������һ��
		for(int i=0;i<=row;i++) {
			dp[i][col] = true;
		}
		//�����һ��,�������һ������
		for(int j=0;j<col;j++) {
			dp[row][j] = false;
		}
		//�������
		for(int i=row-1;i>=0;i--) {
			for(int j=0;j<col;j++) {
				if(j+arr[i]>aim) {
					dp[i][j] = dp[i+1][j];
				}else {
					dp[i][j] = dp[i+1][j] || dp[i+1][j+arr[i]];
				}
			}
		}
		//printArr(dp);
		//���ȫ�����꣬����
		return dp[0][0];
		
	}
	
	
//----------------------------------------------����-----------------------------------------------
	
	
	//��ӡ����
	public static void printArr(boolean[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
	}
	//��ȡ�������
	public static int[] getRandomArr(int maxSize,int maxValue) {
		int[] arr = new int[(int)((maxSize+1)*Math.random())];
		for(int i=0;i<arr.length;i++) {
			arr[i] = (int)((maxValue+1)*Math.random());
		}
		return arr;
	}
	//����������
	public static void isEqual(int times) {
		int[] arr;
		int aim;
		for(int i=0;i<times;i++) {
			arr = getRandomArr(30, 10);
			//aim = (int)(100*Math.random());
			aim = 100;
			if(moneyProblem1(arr, aim)==moneyProblem2(arr, aim)) {
				continue;
			}else {
				System.out.println("fuck!");
				System.out.print("����Ϊ��[");
				for(int a:arr) {
					System.out.print(a+" ");
				}
				System.out.println("]");
				System.out.println("Ŀ��ֵΪ��"+aim);
				System.out.println("�����ݹ�����"+moneyProblem1(arr, aim));
				System.out.println("��̬�滮�����"+moneyProblem2(arr, aim));
				return;
			}
		}
		System.out.println("nice!");
	}
	
	public static void testTime(int times) {
		int[] arr = getRandomArr(100, 10);
		//int aim = (int)(50*Math.random());
		int aim = 100;
		//dp
		long start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			arr = getRandomArr(30, 10);
			//aim = (int)(500*Math.random());
			moneyProblem2(arr, aim);
		}
		long end = System.currentTimeMillis();
		//�����ݹ鷽��
		System.out.println("ִ�� "+times+" �Σ�dp��ʱ��"+(end-start)+"ms");
		start = System.currentTimeMillis();
		for(int i=0;i<times;i++) {
			arr = getRandomArr(30, 10);
			//aim = (int)(500*Math.random());
			moneyProblem1(arr, aim);
		}
		end = System.currentTimeMillis();
		System.out.println("ִ�� "+times+" �Σ������ݹ���ʱ��"+(end-start)+"ms");
	}
	
	public static void main(String[] args) {
		isEqual(100);
		testTime(100);
		
	}
}
