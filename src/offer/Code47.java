package offer;

/**
 * 	求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author lin
 *
 */
public class Code47 {
	
	//方法1：抛异常代替if判断
	public int Sum_Solution(int n) {
		//由于不能使用if,利用系统抛一个异常来判断n是不是0
		try {
			int i = 3/n;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return n+Sum_Solution(n-1);
    }
	
	//利用短路与，如果n==0的话后面就不执行了直接返回
	public int Sum_Solution2(int n) {
		int sum = n;
		boolean flag = (n>0)&&((sum=sum+Sum_Solution2(n-1))>0);
		return sum;
    }
	
	public static void main(String[] args) {
		Code47 code = new Code47();
		int res = code.Sum_Solution2(3);
		System.out.println(res);
	}
}
