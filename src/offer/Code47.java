package offer;

/**
 * 	��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 * @author lin
 *
 */
public class Code47 {
	
	//����1�����쳣����if�ж�
	public int Sum_Solution(int n) {
		//���ڲ���ʹ��if,����ϵͳ��һ���쳣���ж�n�ǲ���0
		try {
			int i = 3/n;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return n+Sum_Solution(n-1);
    }
	
	//���ö�·�룬���n==0�Ļ�����Ͳ�ִ����ֱ�ӷ���
	public int Sum_Solution2(int n) {
		int sum = n;
		boolean flag = (n>0)&&((sum=sum+Sum_Solution2(n-1))>0);
		return sum;
    }
	
	public static void main(String[] args) {
		Code47 code = new Code47();
		int res = code.Sum_Solution2(3);
		System.out.println(res);
	}
}
