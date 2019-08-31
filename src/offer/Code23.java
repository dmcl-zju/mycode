package offer;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No��
 * �������������������������ֶ�������ͬ��
 * @author LIN
 *
 */
public class Code23 {
	/**
	 * ˼·���������������ص����������ϵ�ֵ��С�ڸ��ڵ㣬�������ϵ�ֵ�����ڸ��ڵ㣬���ڵ����һ����������
	 *     ��˿������ҵ��������һ��Ԫ�أ����Ǹ��ڵ㣬��ͷ��ʼ��������һ�����ڸ��ڵ㿪ʼ���涼����������ǰ��Ϊ������
	 */
	public boolean VerifySquenceOfBST(int [] sequence) {
        if(null == sequence || sequence.length<1) {
        	return false;
        }        
		return process(sequence,0,sequence.length-1);
    }
	
	//���еݹ����
	public boolean process(int[] sequence,int start,int end) {
		/*if(start>end) {
			return false;
		}*/
		//�õ����ڵ�
		int root = sequence[end];
		//�ҵ��ֽ��
		int count = 0;
		for(int i=start;i<end;i++) {
			if(sequence[i]<root) {
				count++;
			}else {
				break;
			}
		}
		//��start+count��ʼ����������
		for(int i=start+count;i<end;i++) {
			if(sequence[i]<root) {
				return false;
			}
		}
		//˵����ǰ��û������-=--���������⴦��
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
