package offer;

/**
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ���������������һ���������ַ�����S��
 * �������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
 * @author lin
 *
 */
public class Code43 {
	 
	 public String LeftRotateString(String str,int n) {
		 if(null==str || str.length()==0 || n<=0) {
			 return str;
		 }
		 //��ȡ����
		 n = n%str.length();
		//��ȡ�����ַ���
		 String substr1 = str.substring(0, n);
		 String substr2 = str.substring(n);
		return substr2+substr1;
	 }
	 //�������η�ת����---��ָoffer
	 public String LeftRotateString2(String str,int n) {
		 if(null==str || str.length()==0 || n<=0) {
			 return str;
		 }
		 //��ȡ����
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
