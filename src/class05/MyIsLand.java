package class05;

public class MyIsLand {
	
	public static int countLands(int[][] m){
		if(m==null || m[0]==null) {
			return 0;
		}
		int M = m.length;
		int N = m[0].length;
		int count=0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N; j++) {
				if(m[i][j] == 1) {
					count++;
					//½øÐÐ¸ÐÈ¾
					infect(m,i,j,M,N);
				}
			}
		}
		return count;
	}
	
	public static void infect(int[][] m,int i,int j,int M,int N) {
		if(i<0 || i>=M || j<0 ||j>=N || m[i][j]!=1) {
			return;
		}
		m[i][j] = 2;
		infect(m,i+1,j,M,N);
		infect(m,i-1,j,M,N);
		infect(m,i,j+1,M,N);
		infect(m,i,j-1,M,N);
	}
	
	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
				        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				        { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countLands(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
						{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
						{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, 
						{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
						{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countLands(m2));
	}

}
