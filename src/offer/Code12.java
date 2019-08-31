package offer;
/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author LIN
 *
 */
public class Code12 {
	/**
	 *     思路：首先要将问题简化为一般问题，即求一个数的正整数幂，定义方法 absPower来做，这里利用整数幂的f(n)=f(n/2)*f(n/2)偶数时，
    	  f(n)=f(n-1/2)*f(n-1/2)*base奇数时，这个特性可以快速求幂，这个方法要掌握，接下来就是问题完整性的考虑
	 * @param base
	 * @param exponent
	 * @return
	 */
	 public double Power(double base, int exponent) {
		 
		 //考虑分母为0的情况
		 if(base==0 && exponent<0) {
			 return 0.0;
		 }
		 
		 //对指数求绝对值
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
	 //求正指数幂函数
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
