package process_class01;

/**
 * KMP�㷨����ַ��ַ���ƥ�����⣬�����ַ�������ǰ׺�ͺ�׺����������������ƥ�����
 * @author lin
 *
 */
public class Code_01_KMP {

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		//��ȡҪƥ����ַ������ǰ׺����
		int[] next = getNextArray(ms);
		//����ƥ��
		while (si < ss.length && mi < ms.length) {
			
			if (ss[si] == ms[mi]) {
				//���ƥ�䵽��ȫ��ǰ��
				si++;
				mi++;
			} else if (next[mi] == -1) {
				//���Ŀ���ַ����ĵ�һ���ַ���ûƥ���ϣ��������
				si++;
			} else {
				//��mi���ָ����ǰ׺֮��ʼƥ�䣬������Ϊ�ǰ׺֮ǰ�Ķ����óɹ���
				mi = next[mi];
			}
		}
		//�ж�Ŀ���ַ����ǲ����Ѿ�������
		return mi == ms.length ? si - mi : -1;
	}

	//��ȡ�ַ�����ÿ���ַ�������ǰ׺����
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		//�������ǹ̶���
		next[0] = -1;
		next[1] = 0;
		//��2��ʼ��
		int pos = 2;
		//������Ϊͣ��ǰһ���ַ����ǰ׺����һ��λ�ã�һ��ʼΪ0
		int cn = 0;
		
		while (pos < next.length) {
			//pos��ǰһ�������Ǻ�׺�����һ�����������ǰ׺֮����Ǹ�����ȣ�˵����ȵ�ǰ��׺��һ�ˣ���˼����ǰ��Ļ����Ͽ��Կ����жϣ�
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				//��������Ǹ���ƥ�����Сǰ׺��ǰ׺Ҫ����0������С������С��������Ŀǰcn������������ǰ׺�Ƕ��١�
				cn = next[cn];
			} else {
				//������˵��cn�Ѿ�������С��ûƥ���ϣ���˸�λ������ǰ׺Ϊ0.
				next[pos++] = 0;
			}
		}
		return next;
	}
	
	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));

	}

}
