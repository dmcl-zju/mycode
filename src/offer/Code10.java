package offer;

public class Code10 {
	//最优版本---其他版本和code07一样
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
