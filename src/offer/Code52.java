package offer;

/**
 * 	请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
 * 	在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author lin
 *
 */
public class Code52 {
	/**
	 * 	思路：链接：https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
		来源：牛客网
		    首先，考虑特殊情况：
		         1>两个字符串都为空，返回true
		         2>当第一个字符串不空，而第二个字符串空了，返回false（因为这样，就无法
		            匹配成功了,而如果第一个字符串空了，第二个字符串非空，还是可能匹配成
		            功的，比如第二个字符串是“a*a*a*a*”,由于‘*’之前的元素可以出现0次，
		            所以有可能匹配成功）
		    之后就开始匹配第一个字符，这里有两种可能：匹配成功或匹配失败。但考虑到pattern
		    下一个字符可能是‘*’， 这里我们分两种情况讨论：pattern下一个字符为‘*’或
		    不为‘*’：
		          1>pattern下一个字符不为‘*’：这种情况比较简单，直接匹配当前字符。如果
		            匹配成功，继续匹配下一个；如果匹配失败，直接返回false。注意这里的
		            “匹配成功”，除了两个字符相同的情况外，还有一种情况，就是pattern的
		            当前字符为‘.’,同时str的当前字符不为‘\0’。
		          2>pattern下一个字符为‘*’时，稍微复杂一些，因为‘*’可以代表0个或多个。
		            这里把这些情况都考虑到：
		             a>当‘*’匹配0个字符时，str当前字符不变，pattern当前字符后移两位，
		                跳过这个‘*’符号；（因为*前面的字符和字符串的字符不一致因此只能选择出现0次）
		             b>当‘*’匹配1个或多个时，这个时候有三种可能的情况：
		             	1、模式后移2字符，相当于x*被忽略。因为即使这个字符匹配上了，但是任然可以选择出现0次的情况（上面匹配0个是只能选择出现0次），
		             	      如：a 和 a*a，即使第一个匹配到了，但是要选择0次的情况最后才能匹配成功。
		             	2、字符串后移1字符，模式后移2字符。相当于出现一次的情况
		             	3、字符串后移1字符，模式不变。相当于准备匹配多次。

		
		    之后再写代码就很简单了。
	 * @param str
	 * @param pattern
	 * @return
	 */
	
	public boolean match(char[] str, char[] pattern)
    {
		if(null==str || null==pattern) {
			return false;
		}
		return process(str,0,pattern,0);
    }
	
	//进行递归处理
	private boolean process(char[] str,int i,char[] pattern,int j) {
		//终止条件
		//1、如果两个字符串都匹配完成了就返回真
		if(i>=str.length && j>=pattern.length) {
			return true;
		}
		//如果pattern完了，str还没完就为假
		if(i<str.length && j>=pattern.length) {
			return false;
		}
		//分两种情况
		if((j+1)<pattern.length && pattern[j+1]=='*') {
			System.out.println(i+"===="+j+"==="+pattern[j]);
			//这时候如果str已经配置完了就直接返回true
			if((i!=str.length)&&((str[i]==pattern[j]) || pattern[j]=='.')) {
						//选择跳过
				return process(str,i,pattern,j+2)
						//选择匹配一次
						|| process(str,i+1,pattern,j+2)
					    // 选择多次匹配
						|| process(str,i+1,pattern,j);
			}else {
				//只能当成出现0次处理
				return process(str,i,pattern,j+2);
			}	
		}else {
			//当没有*的时候比较简单
			if((i!=str.length)&&((str[i]==pattern[j]) || pattern[j]=='.')) {
				return process(str,i+1,pattern,j+1);
			}else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "";
		String pattern = ".";
		boolean res = new Code52().match( str.toCharArray(), pattern.toCharArray());
		System.out.println(res);
	}
	
}
