package offer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * @author lin
 *
 */

public class Code02 {
	 public String replaceSpace(StringBuffer str) {
		 if(null==str ||str.length()==0) {
			 return null;
		 }
		 StringBuilder sb = new StringBuilder();
		 for(int i=0;i<str.length();i++) {
			 if(str.charAt(i)==' ') {
				 sb.append("%20");
			 }else {
				 sb.append(str.charAt(i));
			 }
		 }
		return sb.toString();
	 }
	 
	 public static void main(String[] args) {
		 Code02 code = new Code02();
		 StringBuffer sb = new StringBuffer("We Are Happy");
		 System.out.println(code.replaceSpace(sb));
	}
}
