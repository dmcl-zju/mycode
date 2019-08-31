package offer;

import java.util.LinkedHashMap;

/**
 * 	��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1
 * 	����Ҫ���ִ�Сд��.
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
