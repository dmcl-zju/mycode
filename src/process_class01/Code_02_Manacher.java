package process_class01;

public class Code_02_Manacher {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		//获取插入了#的字符串，解决偶数回文的问题
		char[] charArr = manacherString(str);
		
		//回文半径数组
		int[] pArr = new int[charArr.length];
		//最长回文右边界中心
		int C = -1;
		//最长回文右边界
		int R = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			//如果i在R的右边，那就是属于情况1，那么已知的半径就是自己，如果i在R边上或者R以内，就是情况二，那么就是在对称点半径和最右边界选一个最小的作为已知边界
			//如果这里i以C为中心的对称点就是2*C-i
			pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
			//尝试往外扩，pArr[i]就是上一步已经求出来的已知半径，在这个基础上扩，其实只有在R上和R右边有可能会增加，其他情况都会立即失败，但是这样可以统一，不用判断。
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			//每次求完一个后都尝试更新最右边界和中心点
			if (i + pArr[i] > R) {
				R = i + pArr[i];
				C = i;
			}
			//更新全局最大值
			max = Math.max(max, pArr[i]);
		}
		
		//注意：这里返回的是加了#的字符串的半径,因此整个回文原字符串长度就是半径减去1，可以理解为去掉最后一个#
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		str1 = "121";
		System.out.println(maxLcpsLength(str1));
	}

}
