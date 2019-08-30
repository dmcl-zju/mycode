package class08;

//��ŵ������
public class MyHanoi {
	
	public static void hanoi(int N) {
		if(N<1) {
			return;
		}
		//���еݹ�
		System.out.println("����һ��");
		process1(N,"left","right","mid");
		
		System.out.println("��������");
		process2(N,N,"left","right","mid");

	}
	
	//˼·1������������ֽ�ΪN���������N-1���̵��ƶ�---�൱�������̵�˼·������N-1���̵��ƶ�����--���ںС�
	public static void process1(int N,String from,String to,String help) {
		if(N==1) {
			//ֻʣ��һ����ʱ��ֱ���ƶ���Ŀ�ĵ�
			System.out.println("move "+N+" from "+from+" to "+to);
			return;
		}
		//���������
		//�Ȱ�ѹ���Լ������N-1����from�ƶ���help,����to---�ݹ����
		process1(N-1,from,help,to);
		//���Լ���from�ƶ���to---һ������
		//process1(1,from,to,help);
		System.out.println("move "+N+" from "+from+" to "+to);
		//����n-1����help�ƶ���to������from----�ݹ����
		process1(N-1,help,to,from);
	}
	
	//˼·2�������̹淶
	public static void process2(int N,int down,String from,String to,String help) {
		if(N==1) {
			//ֻʣ��һ����ʱ��ֱ���ƶ���Ŀ�ĵ�
			System.out.println("move "+down+" from "+from+" to "+to);
			return;
		}
		//���������
		//�Ȱ�ѹ���Լ������N-1����from�ƶ���help,����to---�ݹ����
		process2(N-1,down-1,from,help,to);
		//���Լ���from�ƶ���to---һ������
		process2(1,down,from,to,help);
		//����n-1����help�ƶ���to������from----�ݹ����
		process2(N-1,down-1,help,to,from);
	}
	
	
	
	
	public static void main(String[] args) {
		hanoi(3);
	}
}
