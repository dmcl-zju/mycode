package offer;
/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * @author LIN
 *
 */
public class Code12 {
	/**
	 *     ˼·������Ҫ�������Ϊһ�����⣬����һ�������������ݣ����巽�� absPower�������������������ݵ�f(n)=f(n/2)*f(n/2)ż��ʱ��
    	  f(n)=f(n-1/2)*f(n-1/2)*base����ʱ��������Կ��Կ������ݣ��������Ҫ���գ��������������������ԵĿ���
	 * @param base
	 * @param exponent
	 * @return
	 */
	 public double Power(double base, int exponent) {
		 
		 //���Ƿ�ĸΪ0�����
		 if(base==0 && exponent<0) {
			 return 0.0;
		 }
		 
		 //��ָ�������ֵ
		 int absExponent = exponent;
		 if(exponent<0) {
			 absExponent = -absExponent;
		 }
		 double res = getPower(base, absExponent);
		 if(exponent<0) {
			 res = 1/res;
		 }
		return res;
	        
	 }
	 //����ָ���ݺ���
	 private double getPower(double base, int exponent) {
		 double res;
		 if(exponent==0) {
			 return 1;
		 }
		 res = getPower(base, exponent/2);
		 System.out.println(res);
		 res *= res;
		 if(exponent%2 != 0) {
			 res *= base;
		 }
		return res;
	 }
	 
	 public static void main(String[] args) {
		Code12 code = new Code12();
		System.out.println(code.getPower(2.0, 3));
	}
}
