package offer;

/**
 * 	��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С���������磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 * 	 ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 * @author lin
 *
 */
public class Code53 {
	
	/**
	 * 	˼·�������������飬�������ַ��������⴦���ο��ش��һ����
		1��e/E��ֻ�ܳ���һ�Σ����Ҳ��������һ������
		2��+/-����һ�γ��ֱ����ڵ�һ������e���棬�ڶ��γ��ֱ�������e����
		3��С���㣺ֻ�ܳ���һ�Σ����ܳ�����e����
		
		
	 */
	
	
	public boolean isNumeric(char[] str) {
		if(null==str || str.length<1) {
			return false;
		}
		//����e��־λ
		boolean hasE = false;
		//���ַ��ϱ�־λ
		boolean sign = false;
		//����С�����־λ
		boolean hasPoint = false;
		
		for(int i=0;i<str.length;i++) {
			//�������ַ���������д���
			if(str[i]=='e' || str[i]=='E') {
				if(i==str.length-1 || hasE) {
					return false;
				}
				hasE = true;
			}else if(str[i] == '.') {
				if(hasE || hasPoint) {
					return false;
				}
				hasPoint = true;
			}else if(str[i]=='+' || str[i]=='-') {
				//����ǵ�һ�γ���
				if(!sign &&i>0 && str[i-1]!='e'&&str[i-1]!='E') {
					return false;
				}
				//������ǵ�һ�γ���
				if(sign && str[i-1]!='e' && str[i-1]!='E') {
					return false;
				}
				sign = true;
			}else if(str[i]<'0' || str[i]>'9') {
				return false;
			}
		}
		return true;
    }
	
	
	public static void main(String[] args) {
		String str = "123.45e+6";
		boolean res  = new Code53().isNumeric(str.toCharArray());
		System.out.println(res);
	}
}
