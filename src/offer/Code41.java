package offer;

import java.util.ArrayList;

/**
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100�����������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 * @author lin
 *
 */
public class Code41 {
	
	 public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		 ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
		 if(sum<0) {
			 return listAll;
		 }
		 int left = 1;
		 int right = 2;
		 int temp = 0;
		 while(left<right) {
			 //���ݹ�ʽ���
			 temp = (left+right)*(right-left+1)/2;
			 if(temp==sum) {
				 ArrayList<Integer> list = new ArrayList<>();
				 for(int i=left;i<=right;i++) {
					 list.add(i);
				 }
				 listAll.add(list);
				 left++;
			 }else if(temp>sum) {
				 //��С��Χ����С�ۼ�
				 left++;
			 }else {
				 //�����ۼ�
				 right++;
			 }
		 }
		return listAll;
	 }
	 
	 public static void main(String[] args) {
		Code41 code = new Code41();
		 ArrayList<ArrayList<Integer>> listAll = code.FindContinuousSequence(15);
		 for(ArrayList<Integer> list:listAll) {
			 for(int i:list) {
				 System.out.print(i+" ");
			 }
			 System.out.println("");
		 }
		 
	}
	 
}
