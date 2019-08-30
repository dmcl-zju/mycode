package offer;

/**
 * 	请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 	 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author lin
 *
 */
public class Code53 {
	
	/**
	 * 	思路：遍历整个数组，对特殊字符进行特殊处理（参考回答第一个）
		1、e/E：只能出现一次，并且不能是最后一个出现
		2、+/-：第一次出现必须在第一个或者e后面，第二次出现必须是在e后面
		3、小数点：只能出现一次，不能出现在e后面
		
		
	 */
	
	
	public boolean isNumeric(char[] str) {
		if(null==str || str.length<1) {
			return false;
		}
		//出现e标志位
		boolean hasE = false;
		//出现符合标志位
		boolean sign = false;
		//出现小数点标志位
		boolean hasPoint = false;
		
		for(int i=0;i<str.length;i++) {
			//对特殊字符的情况进行处理
			if(str[i]=='e' || str[i]=='E') {
				if(i==str.length-1 || hasE) {
					return false;
				}
				hasE = true;
			}else if(str[i] == '.') {
				if(hasE || hasPoint) {
					return false;
				}
				hasPoint = true;
			}else if(str[i]=='+' || str[i]=='-') {
				//如果是第一次出现
				if(!sign &&i>0 && str[i-1]!='e'&&str[i-1]!='E') {
					return false;
				}
				//如果不是第一次出现
				if(sign && str[i-1]!='e' && str[i-1]!='E') {
					return false;
				}
				sign = true;
			}else if(str[i]<'0' || str[i]>'9') {
				return false;
			}
		}
		return true;
    }
	
	
	public static void main(String[] args) {
		String str = "123.45e+6";
		boolean res  = new Code53().isNumeric(str.toCharArray());
		System.out.println(res);
	}
}
