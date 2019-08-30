package process_class01;

/**
 * KMP算法解决字符字符串匹配问题，引入字符串最长相等前缀和后缀概念，利用这个来加速匹配过程
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
		//获取要匹配的字符串的最长前缀数组
		int[] next = getNextArray(ms);
		//进行匹配
		while (si < ss.length && mi < ms.length) {
			
			if (ss[si] == ms[mi]) {
				//如果匹配到，全向前走
				si++;
				mi++;
			} else if (next[mi] == -1) {
				//如果目标字符串的第一个字符都没匹配上，就向后找
				si++;
			} else {
				//从mi这个指针的最长前缀之后开始匹配，可以认为最长前缀之前的都配置成功了
				mi = next[mi];
			}
		}
		//判断目标字符串是不是已经走完了
		return mi == ms.length ? si - mi : -1;
	}

	//获取字符串中每个字符的最长相等前缀数组
	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		//这两个是固定的
		next[0] = -1;
		next[1] = 0;
		//从2开始求
		int pos = 2;
		//可以认为停在前一个字符的最长前缀的下一个位置，一开始为0
		int cn = 0;
		
		while (pos < next.length) {
			//pos的前一个数就是后缀的最后一个数，如果和前缀之后的那个数相等，说明相等的前后缀加一了（意思是在前面的基础上可以快速判断）
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				//如果上面那个不匹配就缩小前缀，前缀要大于0才能缩小。而缩小到的是以目前cn这个点来看的最长前缀是多少。
				cn = next[cn];
			} else {
				//到这里说明cn已经不能缩小还没匹配上，因此该位置最长相等前缀为0.
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
