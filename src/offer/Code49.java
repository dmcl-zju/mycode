package offer;

/**
 * 	��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
 * 	Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
 * @author lin
 *
 */
public class Code49 {
	
	 public int StrToInt(String str) {
        if(null==str || str.trim().isEmpty() ){
            return 0;
        }
        char[] chs = str.toCharArray();
        //�ж��ǲ��Ǹ���
        boolean flag = false;
        int temp = 0;
        int sum = 0;
        int start = 0;
        if(chs[0] == '-') {
        	flag = true;
        	start = 1;
        }else if(chs[0] == '+') {
        	start = 1;
        }
        for(int i=start;i<chs.length;i++) {
        	//�ж��ǲ��ǺϷ�����
        	if(chs[i]<'0' || chs[i]>'9') {
        		System.out.println("���벻�Ϸ�");
        		return 0;
        	}
        	
        	sum = sum*10+(chs[i]-'0');
        	//����������
        	if((sum-(chs[i]-'0'))/10!=temp) {
        		System.out.println("�������");
        		return 0;
        	}
        	//������һ�ε�sumֵ
        	temp = sum;
        }
		return flag?(sum*(-1)):sum;
	  }
	 
	 
	 public static void main(String[] args) {
		
		System.out.println(new Code49().StrToInt("0")); 
	}
}
