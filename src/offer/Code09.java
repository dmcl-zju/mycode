package com.zju.newcode;
/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * @author LIN
 *
 */
public class Code09 {
	//�ݹ�
	public int JumpFloorII(int target) {
		if(target<=0) {
			return 0;
		}
		if(target==1) {
			return 1;
		}
		return 2*JumpFloorII(target-1);
    }
}
