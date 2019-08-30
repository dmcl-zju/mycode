package class08;

/**
 * 母牛问题
 * @author lin
 *
 */
public class MyCows {
	//输入年份
	public static int countCows(int n) {
		if(n<1) {
			return 0;
		}
		if(n==1||n==2||n==3) {
			return n;
		}
		//当前的母牛数量由去年母牛数量加上三年前的母牛数量组成
		return countCows(n-1)+countCows(n-3);
	}
	
	//输入年份n,去年出生
	public static int countCows2(int n) {
		return n;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(countCows(5));
	}
	
}
