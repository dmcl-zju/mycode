package class08;

public class MyFactorial {
	
	public static long factorial(int n) {
		if(n<1) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	public static long factorial2(int n) {
		if(n<1) {
			return 0;
		}
		long res=1;
		for(int i=1;i<=n;i++) {
			res = res*i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(8));
		System.out.println(factorial2(8));
	}
}
