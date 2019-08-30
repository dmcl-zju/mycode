package offer;

/**
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��
 * ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���
 * ������ӡ� ���� a b c e s f c s a d e e ������3 X 4 �����а���һ���ַ���"bcced"��·�������Ǿ����в�
 * ����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø���
 * @author lin
 *
 */
public class Code65 {
	
	/**
	 * ���ӣ�https://www.nowcoder.com/questionTerminal/c61c6999eecb4b8f88a98f66b273a3cc
		��Դ��ţ����
		����
		����˼�룺
		0.���ݸ������飬��ʼ��һ����־λ���飬��ʼ��Ϊfalse����ʾδ�߹���true��ʾ�Ѿ��߹��������ߵڶ���
		1.�����������������������飬���ҵ�һ����str�ַ����ĵ�һ��Ԫ����ƥ��ľ���Ԫ�أ�����judge
		2.����i��j��ȷ��һά�����λ�ã���Ϊ������matrix��һ��һά����
		3.ȷ���ݹ���ֹ������Խ�磬��ǰ�ҵ��ľ���ֵ�����������Ӧλ�õ�ֵ���Ѿ��߹��ģ��������������ֱ��false��˵������·��ͨ
		4.��k�����Ǵ��ж����ַ���str�������Ѿ��жϵ������һλ����ʱ˵����ƥ��ɹ���
		5.������Ǳ���ľ��裬�ݹ鲻�ϵ�Ѱ����Χ�ĸ������Ƿ����������ֻҪ��һ�����ӷ����������ͼ�������������������ĸ��ӵ������Ƿ���ڷ��������ĸ��ӣ�ֱ��k����ĩβ���߲�����ݹ�������ֹͣ��
		6.�ߵ���һ����˵�������ǲ��ɹ��ģ�����Ҫ��ԭһ�±�־λ����index���ı�־λ��������һ�ֵ��жϡ�
	 * @param matrix
	 * @param rows
	 * @param cols
	 * @param str
	 * @return
	 */
	 public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	 {
		 if(null==matrix || null==str) {
			 return false;
		 }
		 //�����ж��ǲ��Ǿ���
		 boolean[] flag = new boolean[matrix.length];
		 //������������Ѱ������һ��λ�ÿ�ͷ���������
		 for(int i=0;i<rows;i++) {
			 for(int j=0;j<cols;j++) {
				 if(process(matrix, rows, cols, i, j, flag, str, 0))
					 return true;
			 }
		 }
		return false;
	 }
	 //���еݹ鴦��--���һ��������ʾƥ�䵽���ַ���������
	 private boolean process(char[] matrix,int rows,int cols,int i,int j,boolean[] flag,char[] str,int k) {
		 //��ȡ������Ԫ�������������
		 int index = i*cols+j;
		 //�ݹ���ֹ������Խ�磨�ĸ��߽磩��ֵ�����ϡ��Ѿ��߹�
		 if(i<0 || j<0 || i>=rows || j>=cols || matrix[index]!=str[k] || flag[index]) {
			 return false;
		 }
		 //������˵����ǰԪ��Ҳ��ƥ��ɹ��ģ�����Ѿ�ƥ�䵽���һ��Ԫ�ؾ����ҵ��ˣ���ֹ����
		 if(k==str.length-1) {
			 return true;
		 }
		 //�Ե�ǰ����Ԫ�ز���--����Ϊ�Ѿ��߹�
		 flag[index] = true;
		 //���Լ����ĸ�����--�����ڵ�Ҳ�㣬������ֹ������ֱ�ӷ���
		 if(process(matrix, rows, cols, i+1, j, flag, str, k+1) ||
		    process(matrix, rows, cols, i-1, j, flag, str, k+1) ||
		    process(matrix, rows, cols, i, j+1, flag, str, k+1) ||
		    process(matrix, rows, cols, i, j-1, flag, str, k+1)) {
			 //ֻҪ��һ���ҵ��ˣ�����true
			 return true;
		 }
		 //��ǰ��ѡ�е�·���������У����ݵ���һ��,�ָ�����ʱ�������
		 flag[index] = false;
		 return false;
	 }
	 
	 public static void main(String[] args) {
		 
		char[] matrix = "abcesfcsadee".toCharArray();
		char[] str = "bcced".toCharArray();
		Code65 code = new Code65();
		boolean res = code.hasPath(matrix, 3, 4, str);
		System.out.println(res);

		
		
	}
}
