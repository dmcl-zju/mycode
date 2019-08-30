package offer;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author lin
 *
 */
public class Code43 {
	 
	 public String LeftRotateString(String str,int n) {
		 if(null==str || str.length()==0 || n<=0) {
			 return str;
		 }
		 //先取余数
		 n = n%str.length();
		//截取两段字符串
		 String substr1 = str.substring(0, n);
		 String substr2 = str.substring(n);
		return substr2+substr1;
	 }
	 //利用两次反转来做---剑指offer
	 public String LeftRotateString2(String str,int n) {
		 if(null==str || str.length()==0 || n<=0) {
			 return str;
		 }
		 //先取余数
		 n = n%str.length();
		 char[] chs = str.toCharArray();
		 reverse(chs,0,n-1);
		 reverse(chs,n,chs.length-1);
		 reverse(chs,0,chs.length-1);
		 
		 return new String(chs);
	
	 }
	 private void reverse(char[] chs,int start,int end) {
		 while(start<end) {
			 swap(chs,start++,end--);
		 }
	 }
	 private void swap(char[] chs,int i,int j) {
		 char temp = chs[i];
		 chs[i] = chs[j];
		 chs[j] = temp;
	 }
	 
	 
	 
	 
	 
	 public static void main(String[] args) {
		 Code43 code = new Code43();
		String str = "abcdef";
		String res = code.LeftRotateString2(str, 7);
		System.out.println(res);
	}
}
