package offer;

/**
 * 	将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 	要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * @author lin
 *
 */
public class Code49 {
	
	 public int StrToInt(String str) {
        if(null==str || str.trim().isEmpty() ){
            return 0;
        }
        char[] chs = str.toCharArray();
        //判断是不是负数
        boolean flag = false;
        int temp = 0;
        int sum = 0;
        int start = 0;
        if(chs[0] == '-') {
        	flag = true;
        	start = 1;
        }else if(chs[0] == '+') {
        	start = 1;
        }
        for(int i=start;i<chs.length;i++) {
        	//判断是不是合法输入
        	if(chs[i]<'0' || chs[i]>'9') {
        		System.out.println("输入不合法");
        		return 0;
        	}
        	
        	sum = sum*10+(chs[i]-'0');
        	//检查数据溢出
        	if((sum-(chs[i]-'0'))/10!=temp) {
        		System.out.println("数据溢出");
        		return 0;
        	}
        	//缓存上一次的sum值
        	temp = sum;
        }
		return flag?(sum*(-1)):sum;
	  }
	 
	 
	 public static void main(String[] args) {
		
		System.out.println(new Code49().StrToInt("0")); 
	}
}
