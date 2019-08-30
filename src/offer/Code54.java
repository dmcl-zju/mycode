package offer;

import java.util.LinkedHashMap;

/**
 * 	请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 	当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @author lin
 *
 */
public class Code54 {
	//用来记录顺序
	private LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
	//用来记录字符串
	StringBuilder sb = new StringBuilder();
	
	//Insert one char from stringstream
    public void Insert(char ch)
    {
    	sb.append(ch);
    	if(map.containsKey(ch)) {
    		int count = map.get(ch);
    		count++;
    		map.put(ch, count);
    	}else {
    		map.put(ch, 1);
    	}
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	for(char c:sb.toString().toCharArray()) {
    		if(map.get(c)==1) {
    			return c;
    		}
    	}
		return '#';
    }
    
    public static void main(String[] args) {
		Code54 code = new Code54();
		code.Insert('g');
		System.out.println(code.FirstAppearingOnce());
		code.Insert('o');
		System.out.println(code.FirstAppearingOnce());
		code.Insert('o');
		System.out.println(code.FirstAppearingOnce());
		code.Insert('g');
		System.out.println(code.FirstAppearingOnce());
		code.Insert('l');
		System.out.println(code.FirstAppearingOnce());
		code.Insert('e');
		System.out.println(code.FirstAppearingOnce());
	}
	
}
