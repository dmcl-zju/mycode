package process_class01;

public class Code_02_Manacher {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		//��ȡ������#���ַ��������ż�����ĵ�����
		char[] charArr = manacherString(str);
		
		//���İ뾶����
		int[] pArr = new int[charArr.length];
		//������ұ߽�����
		int C = -1;
		//������ұ߽�
		int R = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			//���i��R���ұߣ��Ǿ����������1����ô��֪�İ뾶�����Լ������i��R���ϻ���R���ڣ��������������ô�����ڶԳƵ�뾶�����ұ߽�ѡһ����С����Ϊ��֪�߽�
			//�������i��CΪ���ĵĶԳƵ����2*C-i
			pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
			//������������pArr[i]������һ���Ѿ����������֪�뾶�������������������ʵֻ����R�Ϻ�R�ұ��п��ܻ����ӣ����������������ʧ�ܣ�������������ͳһ�������жϡ�
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			//ÿ������һ���󶼳��Ը������ұ߽�����ĵ�
			if (i + pArr[i] > R) {
				R = i + pArr[i];
				C = i;
			}
			//����ȫ�����ֵ
			max = Math.max(max, pArr[i]);
		}
		
		//ע�⣺���ﷵ�ص��Ǽ���#���ַ����İ뾶,�����������ԭ�ַ������Ⱦ��ǰ뾶��ȥ1���������Ϊȥ�����һ��#
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		str1 = "121";
		System.out.println(maxLcpsLength(str1));
	}

}
