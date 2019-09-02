package mypractice;

public class PrintStrTest {
	
	public static void main(String[] args) {
		String str = "abc";
		printStrAll(str);
	}
	
	private static void printStrAll(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
		
	}
	
	private static void process(char[] chs,int index) {
		if(index==chs.length) {
			//²Ù×÷
			System.out.println(String.valueOf(chs));
		}
		
		for(int i=index;i<chs.length;i++) {
			swap(chs, index, i);
			process(chs, index+1);
			swap(chs, index, i);
		}
	}
	
	private static void swap(char[] arr,int i,int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
