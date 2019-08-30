package offer;


/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
 * 个整数，判断数组中是否含有该整数。
 * @author lin
 *
 */
public class Code01 {
	
	public boolean Find(int target, int [][] array) {
		if(null==array || array.length==0 ||array[0]==null ||array[0].length==0) {
			return false;
		}
		//从右下角开始
		int row = array.length-1;
		int col = 0;
		//在数组范围内循环
		while(row>=0 && col<array[0].length) {
			if(target==array[row][col]) {
				return true;
			}else if(target>array[row][col]) {
				//如果大了向右移动
				col++;
			}else {
				//如果小了，向上移动
				row--;
			}
		}
		//如果执行完了都没有，就返回false
		return false;
    }
	
	
}
