package com.zju.newcode;

/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 * @author LIN
 *
 */
public class Code28 {
	/**
	 * 	˼·������з������������֣��������ֵĴ����������������ֳ��ֵĴ����ͻ�Ҫ�ࡣ�ڱ�������ʱ��������ֵ��
	 * 	һ��������һ�����֣�һ�Ǵ�����������һ������ʱ��������֮ǰ�����������ͬ���������1�����������1��
	 *	ͬʱ����һ��boolean������ָʾ�Ƿ񻻶���������Ϊ0����Ӧ�û����󣬽����Ϊtrue.��һ��ѭ���ͻᱣ����һ�����֣�
	 *	����������Ϊ1����������������������ּ�Ϊ����Ȼ�����ж����Ƿ�����������ɡ�
	 */
	
	public int MoreThanHalfNum_Solution(int [] array) {
		if(null==array) {
			return 0;
		}
		//�Ƿ�Ӧ�ý���---����ǰ�������ų�����
		boolean change = true;
		int cur = 0;
		int times = 0;
		int res = 0;
		for(int i=0;i<array.length;i++) {
			if(change) {
				//����һ��������Ϊ��ѡ��
				change = false;
				cur = array[i];
				times++;
				res = cur;
			}else {
				if(cur==array[i]) {
					times++;
				}else {
					times--;
					//�ж��Ƿ�Ҫ������ѡ��
					if(times==0) {
						change=true;
					}
				}
			}
		}
		//�ж�һ������ѡ��������ǲ��ǹ�����
		times=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]==res) {
				times++;
			}
		}
		//���û�й���ͷ���0
		if(times>(array.length/2)) {
			return res;
		}else {
			return 0;
		}
    }
	
	public static void main(String[] args) {
		Code28 code = new Code28();
		int[] arr = {1,2,3,2,2,2,5,4,2};
		int res = code.MoreThanHalfNum_Solution(arr);
		System.out.println(res);
	}
}
