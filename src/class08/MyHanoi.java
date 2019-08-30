package class08;

//汉诺塔问题
public class MyHanoi {
	
	public static void hanoi(int N) {
		if(N<1) {
			return;
		}
		//进行递归
		System.out.println("方法一：");
		process1(N,"left","right","mid");
		
		System.out.println("方法二：");
		process2(N,N,"left","right","mid");

	}
	
	//思路1：将整个问题分解为N和其上面的N-1个盘的移动---相当于两个盘的思路，至于N-1个盘的移动看做--“黑盒”
	public static void process1(int N,String from,String to,String help) {
		if(N==1) {
			//只剩下一个的时候直接移动到目的地
			System.out.println("move "+N+" from "+from+" to "+to);
			return;
		}
		//正常情况：
		//先把压在自己上面的N-1个从from移动到help,借助to---递归进行
		process1(N-1,from,help,to);
		//把自己从from移动到to---一步就行
		//process1(1,from,to,help);
		System.out.println("move "+N+" from "+from+" to "+to);
		//把那n-1个从help移动到to，借助from----递归进行
		process1(N-1,help,to,from);
	}
	
	//思路2：将过程规范
	public static void process2(int N,int down,String from,String to,String help) {
		if(N==1) {
			//只剩下一个的时候直接移动到目的地
			System.out.println("move "+down+" from "+from+" to "+to);
			return;
		}
		//正常情况：
		//先把压在自己上面的N-1个从from移动到help,借助to---递归进行
		process2(N-1,down-1,from,help,to);
		//把自己从from移动到to---一步就行
		process2(1,down,from,to,help);
		//把那n-1个从help移动到to，借助from----递归进行
		process2(N-1,down-1,help,to,from);
	}
	
	
	
	
	public static void main(String[] args) {
		hanoi(3);
	}
}
