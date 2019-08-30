package process_class01;

/**
 * kmp算法
 * @author lin
 *
 */
public class Code_01_MyKMP {
	public static void main(String[] args) {
		String str1 = "abcabcababaccc";
		String str2 = "ababa";
		System.out.println(getIndex(str1, str2));
	}
	
	
	private static int getIndex(String str1,String str2) {
		
		int index1 = 0;
		int index2 = 0;
		int[] arr = getNextArray(str2);
		while(index1<str1.length() && index2<str2.length()) {
			if(str1.charAt(index1)==str2.charAt(index2)) {
				index1++;
				index2++;
			}else if(arr[index2]==-1) {
				index1++;
			}else {
				index2 = arr[index2];	
			}
		}
		if(index2==str2.length()) {
			return index1-index2;
		}
		return -1;
	}
	
	private static int[] getNextArray(String str) {
		
		int[] arr = new int[str.length()];
		//前两个
		arr[0] = -1;
		arr[1] = 0;
		int index = 2;
		int pre = 0;
		
		while(index<arr.length) {
			if(str.charAt(index-1)==str.charAt(pre)) {
				arr[index++] = ++pre;
			}else if(pre>0) {
				pre = arr[pre];
			}else {
				arr[index++] = 0;
			}
		}
		return arr;
	}
	
}
