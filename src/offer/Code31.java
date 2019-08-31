package offer;

/*
 * 	���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����Ϊ�����ر�����һ��1~13�а���1������
 * 	��1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�ACMerϣ�����ǰ����,������������ձ黯,
 * 	���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
 */
public class Code31 {
	/**
	 * https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
	 * �������ش���ݸ�λʮλ��λ����1�Ĺ�������
	 */
	public int NumberOf1Between1AndN_Solution(int n) {
		if(n<=0) {
			return 0 ;
		}
		int count=0;
		int k=0;
		int pre=0;
		int cur=0;
		//i=1(��λ��i=10(ʮλ) i=100(��λ������������
		for(int i=1;i<=n;i*=10) {
			pre=n/(i*10)*i;
			k = n%(i*10);
			if(k>(i*2-1)) {
				cur=i;
			}else if(k<i) {
				cur=0;
			}else {
				cur=k-i+1;
			}
			count = count+pre+cur;
		}
		return count;
    }
	
	public static void main(String[] args) {
		Code31 code = new Code31();
		int res = code.NumberOf1Between1AndN_Solution(13);
		System.out.println(res);
	}
}
