package offer;


/**
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 * @author lin
 *
 */
public class Code66 {
	 //����ͳ�Ƹ�����
	 private int count = 0;
	 public int movingCount(int threshold, int rows, int cols)
	 {
		 //���ڽ����־�ж�
		boolean[][] flag = new boolean[rows][cols]; 
		 //�ݹ鴦��
//		process(threshold, rows, cols, 0, 0, flag);
//		return count;  
		return process2(threshold, rows, cols, 0, 0, flag);
	 }
	 
	 //�ݹ鴦��
	 private void process(int threshold, int rows, int cols,int i,int j,boolean[][] flag) {
		 //��ֹ����
		 if(i<0 || j<0 || i>=rows || j>=cols || (getBitSum(i)+getBitSum(j))>threshold || flag[i][j]) {
			 return;
		 }
		 //˵����ǰ���ӿ��룬���ñ�־λ
		 flag[i][j] = true;
		 count++;
		 //ȡ�ܱߵĸ���
		 process(threshold, rows, cols, i+1, j, flag);
		 process(threshold, rows, cols, i-1, j, flag);
		 process(threshold, rows, cols, i, j+1, flag);
		 process(threshold, rows, cols, i, j-1, flag);
	 }
	 //������ֵ�õݹ鴦��
	 private int process2(int threshold, int rows, int cols,int i,int j,boolean[][] flag) {
		 //��ֹ����
		 if(i<0 || j<0 || i>=rows || j>=cols || (getBitSum(i)+getBitSum(j))>threshold || flag[i][j]) {
			 return 0;
		 }
		 //˵����ǰ���ӿ��룬���ñ�־λ
		 flag[i][j] = true;
		 int count2 = 1;
		 //ȡ�ܱߵĸ���
		 count2 += process2(threshold, rows, cols, i+1, j, flag);
		 count2 += process2(threshold, rows, cols, i-1, j, flag);
		 count2 += process2(threshold, rows, cols, i, j+1, flag);
		 count2 += process2(threshold, rows, cols, i, j-1, flag);
		 return count2;
	 }
	 //ͳ�����ֵĸ�λ��
	 private int getBitSum(int num) {
		 int sum = 0;
		 while(num>0) {
			 sum += num%10;
			 num /= 10;
		 }
		return sum;
	 }
	 
	 
	 public static void main(String[] args) {
		
	}
}
