package offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * @author LIN
 *
 */
public class Code23 {
	/**
	 * 思路：二叉搜索树的特点是左子树上的值都小于根节点，右子树上的值都大于根节点，根节点最后一个被遍历到
	 *     因此可以先找到数组最后一个元素，就是根节点，从头开始遍历，第一个大于根节点开始后面都是右子树，前面为左子树
	 */
	public boolean VerifySquenceOfBST(int [] sequence) {
        if(null == sequence || sequence.length<1) {
        	return false;
        }        
		return process(sequence,0,sequence.length-1);
    }
	
	//进行递归操作
	public boolean process(int[] sequence,int start,int end) {
		/*if(start>end) {
			return false;
		}*/
		//拿到根节点
		int root = sequence[end];
		//找到分界点
		int count = 0;
		for(int i=start;i<end;i++) {
			if(sequence[i]<root) {
				count++;
			}else {
				break;
			}
		}
		//从start+count开始就是右子树
		for(int i=start+count;i<end;i++) {
			if(sequence[i]<root) {
				return false;
			}
		}
		//说明当前层没有问题-=--进行子问题处理
		boolean left = true;
		if(count>0) {
			left = process(sequence, start, start+count-1);
		}
		boolean right = true;
		if(count<(end-start)) {
			right = process(sequence, start+count, end-1);
		}
		return left && right;
	}
	
	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		Code23 code = new Code23();
		boolean res = code.VerifySquenceOfBST(arr);
		System.out.println(res);
	}
	
}
