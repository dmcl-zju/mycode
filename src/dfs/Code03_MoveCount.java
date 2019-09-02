package dfs;



/**
 * ��ָoffer Code66
 * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
 * @author lin
 *
 */
public class Code03_MoveCount {
	
	
	static boolean[][] visited;
	static int count;
	static int[][] dir = {{1,0,-1,0},{0,1,0,-1}};
	
	
	public static void main(String[] args) {
		System.out.println(new Code03_MoveCount().movingCount(10, 3, 3));
	}

	public  int movingCount(int threshold, int rows, int cols)
    {
		visited = new boolean[rows][cols];
//		dfs(threshold, 0, 0, rows, cols);
//		System.out.println(count);
		
		return dfs2(threshold, 0, 0, rows, cols);
    }
	
	//�з���ֵ
	private static int dfs2(int threshold,int i,int j,int rows,int cols) {
			
			//��ֹ����,Խ����߲����ϣ���ֹ����
			if(i<0 || j<0 || i>=rows || j>=cols || visited[i][j] || (getSumOfBit(i)+getSumOfBit(j)>threshold)) {
				return 0;
			}
			//����Լ�
			visited[i][j] = true;
			//��һ��ĳ�ʼ����
			int res = 1;
			//�����ڽӽڵ�
			for(int k=0;k<4;k++) {
				res += dfs2(threshold, i+dir[0][k], j+dir[1][k], rows, cols);
			}
			return res;
		}
	
//	//û�з���ֵ������ȫ�ֱ���
//	private static void dfs(int threshold,int i,int j,int rows,int cols) {
//		
//		//��ֹ����,Խ����߲����ϣ���ֹ����
//		if(i<0 || j<0 || i>=rows || j>=cols || visited[i][j] || (getSumOfBit(i)+getSumOfBit(j)>threshold)) {
//			return;
//		}
//		//����Լ�
//		visited[i][j] = true;
//		//���Ӳ���
//		count++;
//		//�����ڽӽڵ�
//		for(int k=0;k<4;k++) {
//			dfs(threshold, i+dir[0][k], j+dir[1][k], rows, cols);
//		}
//	}
	
	//���λ��֮��
	private static int getSumOfBit(int num) {
		int res = 0;
		while(num>0) {
			res += num%10;
			num = num/10;
		}
		return res;
	}
	
	
}
