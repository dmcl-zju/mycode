package offer;

import java.util.LinkedHashMap;

/**
 * 	在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1
 * 	（需要区分大小写）.
 * @author LIN
 *
 */
public class Code34 {
	
	public int FirstNotRepeatingChar(String str) {
		if(null==str || str.length()==0) {
			return 0;
		}
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				int count = map.get(str.charAt(i));
				map.put(str.charAt(i), ++count);
			}else {
				map.put(str.charAt(i), 1);
			}
		}
		
		for(int i=0;i<str.length();i++) {
			if(map.get(str.charAt(i))==1) {
				return i;
			}
		}
        return -1;
    }
	
	public static void main(String[] args) {
		Code34 code = new Code34();
		int res = code.FirstNotRepeatingChar("aaacbb");
		System.out.println(res);
	}
}
