package class08;

public class MyPrintSubStr {
	
	public static void printSubStr(String str) {
		if(str==null) {
			return;
		}
		//���д�ӡ
		char[] chs = str.toCharArray();
		System.out.println("����һ��");
		process1(chs,0);
		System.out.println("��������");
		process2(chs,0,"");
	}
	//���еݹ����
	//˼·1�����ڲ���i��ʾ��������ĵڼ��������������Ϊ�㡣
	//����ÿһ��ֻ��Ҫ�����Լ��費��Ҫ��ӡ����Ϊ����û�����������ڴ�ֱchs�ϴ�����˼ǵô���������ָ�ԭ��
	public static void process1(char[] chs,int i) {
		//��ֹ����--��chs�ϵ�Ԫ�ض��������ˣ���ִ�д�ӡ����
		if(i==chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		//��ǰԪ��Ҫ��ӡ--�Ͳ����κδ���ֱ�ӽ�����һ��
		process1(chs,i+1);
		//��ǰԪ�ز���ӡ,���������л���0�����ȼǵ��Ȱ�ԭʼ���ݱ����������ں�������ǰ�ظ�chs
		char temp = chs[i];
		chs[i] = 0;
		process1(chs,i+1);
		//�ú���û�з���ֵ��������ǳ��ڣ��ظ�chs
		chs[i] = temp;
	}
	//˼·2�����Դ����chs��������κθı䣬ֱ�Ӽ���һ�������ռ����
	//����ע�� String�ǲ��ɱ䳤���ַ��������ÿ�μ����ַ������Զ������µ��ַ�������˲��������������ظ�res,
	//��Ϊ�ݹ���ÿ�����̵õ��Ķ��ǲ�һ����ַ��res
	public static void process2(char[] chs,int i,String res) {
		if(i==chs.length) {
			System.out.println(res);
			return;
		}
		//Ҫ��ӡ����
		process2(chs,i+1,res+chs[i]);
		//����ӡ����
		process2(chs,i+1,res);
	}
	public static void main(String[] args) {
		printSubStr("abc");
	}
}
