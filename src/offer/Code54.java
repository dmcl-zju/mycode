package offer;

import java.util.LinkedHashMap;

/**
 * 	��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * 	���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 * @author lin
 *
 */
public class Code54 {
	//������¼˳��
	private LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
	//������¼�ַ���
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
