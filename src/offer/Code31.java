package offer;

/*
 * 	求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字
 * 	有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 	可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Code31 {
	/**
	 * https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
	 * 第三个回答根据个位十位百位出现1的规律来做
	 */
	public int NumberOf1Between1AndN_Solution(int n) {
		if(n<=0) {
			return 0 ;
		}
		int count=0;
		int k=0;
		int pre=0;
		int cur=0;
		//i=1(个位）i=10(十位) i=100(百位）。。。。。
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
