package class08;

/**
 * ĸţ����
 * @author lin
 *
 */
public class MyCows {
	//�������
	public static int countCows(int n) {
		if(n<1) {
			return 0;
		}
		if(n==1||n==2||n==3) {
			return n;
		}
		//��ǰ��ĸţ������ȥ��ĸţ������������ǰ��ĸţ�������
		return countCows(n-1)+countCows(n-3);
	}
	
	//�������n,ȥ�����
	public static int countCows2(int n) {
		return n;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(countCows(5));
	}
	
}
