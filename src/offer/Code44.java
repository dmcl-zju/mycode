package offer;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
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
