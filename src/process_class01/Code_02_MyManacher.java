package process_class01;

/**
 * Manacher�㷨���������Ĵ�
 * @author lin
 *
 */
public class Code_02_MyManacher {
	public static void main(String[] args) {
		String str = "abc";
		int res = manacher(str);
		System.out.println(res);
	}
	
	//�ַ����в���#
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
		
		//���İ뾶����
		int[] pArr = new int[chs.length];
		//������ұ߽�
		int R = -1;
		//���е�
		int C = -1;
		
		for(int i=0;i<chs.length;i++) {
			//��֪�İ뾶��С
			pArr[i] = R>i?Math.min(pArr[2*C-i], R-i):1;
			//����������
			while(i+pArr[i]<chs.length && i-pArr[i]>=0) {
				if(chs[i+pArr[i]]==chs[i-pArr[i]]) {
					pArr[i]++;
				}else {
					break;
				}	
			}
			
			//������ұ߽�
			if(i+pArr[i]>R) {
				R = i+pArr[i];
				C = i;
			}
			//����ȫ�����
			max = Math.max(max, pArr[i]);
		}
		//System.out.println(R+"--"+C);
		return max-1;
	}
	
}
