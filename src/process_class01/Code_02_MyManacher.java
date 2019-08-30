package process_class01;

/**
 * Manacher算法：解决最长回文串
 * @author lin
 *
 */
public class Code_02_MyManacher {
	public static void main(String[] args) {
		String str = "abc";
		int res = manacher(str);
		System.out.println(res);
	}
	
	//字符串中插入#
	private static char[] getString(String str) {
		char[] chs = new char[2*str.length()+1];
		for(int i=0;i<chs.length;i++) {
			if(i%2==0) {
				chs[i] = '#';
			}else {
				chs[i] = str.charAt(i/2);
			}
		}
		return chs;
	}
	
	private static int manacher(String str) {
		
		char[] chs = getString(str);
		int max = Integer.MIN_VALUE;
		
		//回文半径数组
		int[] pArr = new int[chs.length];
		//最长回文右边界
		int R = -1;
		//其中点
		int C = -1;
		
		for(int i=0;i<chs.length;i++) {
			//已知的半径大小
			pArr[i] = R>i?Math.min(pArr[2*C-i], R-i):1;
			//尝试两边扩
			while(i+pArr[i]<chs.length && i-pArr[i]>=0) {
				if(chs[i+pArr[i]]==chs[i-pArr[i]]) {
					pArr[i]++;
				}else {
					break;
				}	
			}
			
			//更新最长右边界
			if(i+pArr[i]>R) {
				R = i+pArr[i];
				C = i;
			}
			//更新全局最大
			max = Math.max(max, pArr[i]);
		}
		//System.out.println(R+"--"+C);
		return max-1;
	}
	
}
