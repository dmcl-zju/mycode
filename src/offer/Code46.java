package offer;

import java.util.LinkedList;

/**
 * 	ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ������,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��
 *	 Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ
 * ,����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,�����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 * @author lin
 *
 */
public class Code46 {
	//����һ��ģ��Լɪ��
	public int LastRemaining_Solution(int n, int m) {
		if(n<1 || m<1 ) {
			return -1;
		}
		//������ģ�⣬ͨ��ȡ������γɻ�״
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<n;i++) {
			list.add(i);
		}
		int index = 0;
		while(list.size()>1) {
			//���ҿ�ʼ�������ٱ�m-1��ͬѧ����Ҫ��ȥ��ͬѧ
			index = (index+m-1)%list.size();
			list.remove(index);
		}
		return list.get(0);   
    }
	
	
	//���������ù�ʽ���Ƶ���������ʽ
	//---------------f(n,m)=(f(n-1,m)+m)%n   n>1;
	//---------------f(n,m)= 0; n=1;
	public int LastRemaining_Solution2(int n, int m) {
		if(n<1 || m<1 ) {
			return -1;
		}
		if(n==1) {
			return 0;
		}
		return (LastRemaining_Solution2(n-1, m)+m)%n;
    }
	
	
	
	public static void main(String[] args) {
		Code46 code = new Code46();
		int res = code.LastRemaining_Solution(5, 3);
		int res2 = code.LastRemaining_Solution2(5, 3);
		System.out.println(res+"----"+res2);
	}
}
