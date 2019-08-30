package offer;

import java.util.Arrays;

/**
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,
 * ����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,
 * ����A����1,JΪ11,QΪ12,KΪ13�������5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ��
 * ����Ĺ���,Ȼ���������LL��������Σ� ����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0��
 * @author lin
 *
 */
public class Code45 {
	
	public boolean isContinuous(int [] numbers) {
		if(null==numbers || numbers.length<1) {
			return false;
		}
		int numsOfzero = 0;
		int numsOfIntevel = 0;
		//�������������
		Arrays.sort(numbers);
		for(int i=0;i<numbers.length;i++) {
			
			if(numbers[i]==0) {
				numsOfzero++;
				continue;
			}
			//���һ����֮ǰ�����������--���ڼ��0�ĺ���
			if((i<numbers.length-1)&&(numbers[i]==numbers[i+1])) {
				return false;
			}
			//���������
			if((i<numbers.length-1)&&(numbers[i]+1!=numbers[i+1])) {
				numsOfIntevel += (numbers[i+1]-numbers[i]-1);
			}
		}
		//System.out.println(numsOfIntevel+"-----"+numsOfzero);
		if(numsOfIntevel>numsOfzero) {
			return false;
		}
		return true;
    }
	
	public static void main(String[] args) {
		Code45 code = new Code45();
		int[] arr = {1,3,0,5,0};
		System.out.println(code.isContinuous(arr));
	}
}
