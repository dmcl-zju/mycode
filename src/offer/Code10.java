package offer;

public class Code10 {
	//���Ű汾---�����汾��code07һ��
	public int RectCover(int target) {
        if(target>=0 && target<=2){
            return target;
        }
        int t1=1;
        int t2=2;
        int t = t1+t2;
        for(int i=3; i<=target; i++){
            t = t1+t2;
            t1 = t2;
            t2 = t;
        }
        return t;
    }
}
