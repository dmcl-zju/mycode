package offer;

/**
 * 	��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� 
 * 	�ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 * @author lin
 *
 */
public class Code52 {
	/**
	 * 	˼·�����ӣ�https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
		��Դ��ţ����
		    ���ȣ��������������
		         1>�����ַ�����Ϊ�գ�����true
		         2>����һ���ַ������գ����ڶ����ַ������ˣ�����false����Ϊ���������޷�
		            ƥ��ɹ���,�������һ���ַ������ˣ��ڶ����ַ����ǿգ����ǿ���ƥ���
		            ���ģ�����ڶ����ַ����ǡ�a*a*a*a*��,���ڡ�*��֮ǰ��Ԫ�ؿ��Գ���0�Σ�
		            �����п���ƥ��ɹ���
		    ֮��Ϳ�ʼƥ���һ���ַ������������ֿ��ܣ�ƥ��ɹ���ƥ��ʧ�ܡ������ǵ�pattern
		    ��һ���ַ������ǡ�*���� �������Ƿ�����������ۣ�pattern��һ���ַ�Ϊ��*����
		    ��Ϊ��*����
		          1>pattern��һ���ַ���Ϊ��*������������Ƚϼ򵥣�ֱ��ƥ�䵱ǰ�ַ������
		            ƥ��ɹ�������ƥ����һ�������ƥ��ʧ�ܣ�ֱ�ӷ���false��ע�������
		            ��ƥ��ɹ��������������ַ���ͬ������⣬����һ�����������pattern��
		            ��ǰ�ַ�Ϊ��.��,ͬʱstr�ĵ�ǰ�ַ���Ϊ��\0����
		          2>pattern��һ���ַ�Ϊ��*��ʱ����΢����һЩ����Ϊ��*�����Դ���0��������
		            �������Щ��������ǵ���
		             a>����*��ƥ��0���ַ�ʱ��str��ǰ�ַ����䣬pattern��ǰ�ַ�������λ��
		                ���������*�����ţ�����Ϊ*ǰ����ַ����ַ������ַ���һ�����ֻ��ѡ�����0�Σ�
		             b>����*��ƥ��1������ʱ�����ʱ�������ֿ��ܵ������
		             	1��ģʽ����2�ַ����൱��x*�����ԡ���Ϊ��ʹ����ַ�ƥ�����ˣ�������Ȼ����ѡ�����0�ε����������ƥ��0����ֻ��ѡ�����0�Σ���
		             	      �磺a �� a*a����ʹ��һ��ƥ�䵽�ˣ�����Ҫѡ��0�ε����������ƥ��ɹ���
		             	2���ַ�������1�ַ���ģʽ����2�ַ����൱�ڳ���һ�ε����
		             	3���ַ�������1�ַ���ģʽ���䡣�൱��׼��ƥ���Ρ�

		
		    ֮����д����ͺܼ��ˡ�
	 * @param str
	 * @param pattern
	 * @return
	 */
	
	public boolean match(char[] str, char[] pattern)
    {
		if(null==str || null==pattern) {
			return false;
		}
		return process(str,0,pattern,0);
    }
	
	//���еݹ鴦��
	private boolean process(char[] str,int i,char[] pattern,int j) {
		//��ֹ����
		//1����������ַ�����ƥ������˾ͷ�����
		if(i>=str.length && j>=pattern.length) {
			return true;
		}
		//���pattern���ˣ�str��û���Ϊ��
		if(i<str.length && j>=pattern.length) {
			return false;
		}
		//���������
		if((j+1)<pattern.length && pattern[j+1]=='*') {
			System.out.println(i+"===="+j+"==="+pattern[j]);
			//��ʱ�����str�Ѿ��������˾�ֱ�ӷ���true
			if((i!=str.length)&&((str[i]==pattern[j]) || pattern[j]=='.')) {
						//ѡ������
				return process(str,i,pattern,j+2)
						//ѡ��ƥ��һ��
						|| process(str,i+1,pattern,j+2)
					    // ѡ����ƥ��
						|| process(str,i+1,pattern,j);
			}else {
				//ֻ�ܵ��ɳ���0�δ���
				return process(str,i,pattern,j+2);
			}	
		}else {
			//��û��*��ʱ��Ƚϼ�
			if((i!=str.length)&&((str[i]==pattern[j]) || pattern[j]=='.')) {
				return process(str,i+1,pattern,j+1);
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "";
		String pattern = ".";
		boolean res = new Code52().match( str.toCharArray(), pattern.toCharArray());
		System.out.println(res);
	}
	
}
