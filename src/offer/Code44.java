package offer;

/**
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 * ���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 * @author lin
 *
 */
public class Code44 {
	
	 public String ReverseSentence(String str) {
		 if(null==str || str.length()==0) {
			 return str;
		 }
		 String[] subs = str.split(" ");
		 if(subs.length==0) {
			 return str;
		 }
		 int left = 0;
		 int right = subs.length-1;
		 while(left<right) {
			 swap(subs,left++,right--);
		 }
		 StringBuilder sb = new StringBuilder();
		 for(int i=0;i<subs.length-1;i++) {
			 sb.append(subs[i]);
			 sb.append(" ");
		 }
		 sb.append(subs[subs.length-1]);
		return sb.toString();      
	 }
	 
	 private void swap(String[] str,int i,int j) {
		 String temp = str[i];
		 str[i] = str[j];
		 str[j] = temp;
	 }
	 
	 
	 public String ReverseSentence2(String str) {
		 if(null==str || str.length()==0) {
			 return str;
		 }
		 String[] subs = str.split(" ");
		 if(subs.length==0) {
			 return str;
		 }
		 StringBuilder sb = new StringBuilder();
		 for(int i=subs.length-1;i>=0;i--) {
			 sb.append(subs[i]);
			 if(i>0) {
				 sb.append(" ");
			 }
		 }
		return sb.toString();      
	 }
	 
	 
	 
	 public static void main(String[] args) {
		Code44 code = new Code44();
		String res = code.ReverseSentence2("I am a student.");
		System.out.println(res);
	}
}
