package class05;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;




//hashMap一些基本用法使用测试
public class MyHashMap {
	
	//自定义比较器升序
	public static class compareAsc implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}

	}
	
	//自定义比较器降序
	public static class compareDsc implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}

	}
	
	public static void main(String arg[]) {
		Map<String,String> map = new TreeMap<>(new compareDsc());
		map.put("z","1");
		map.put("zb","2");
		map.put("c","3");
		map.put("d","4");
		System.out.println("是否包含a："+map.containsKey("a"));
		System.out.println("foreach遍历集合1：");
		for(String key:map.keySet()) {
			System.out.print(key+"-->"+map.get(key)+" ");
		}
		System.out.println();
		
		System.out.println("foreach遍历集合2：");
	
		Set<Entry<String,String>> entrySet = map.entrySet();
		for(Entry<String,String> entry:entrySet) {
			System.out.print(entry.getKey()+"-->"+entry.getValue()+" ");
		}
		System.out.println();
		System.out.println("迭代器遍历：");
		//先转化为单集合
		Set<Entry<String,String>> entrys = map.entrySet();
		Iterator<Entry<String,String>> iterator = entrys.iterator();
		while(iterator.hasNext()) {
			Entry<String,String> entry = iterator.next();
			System.out.print(entry.getKey()+"-->"+entry.getValue()+" ");
		}
		System.out.println();
				
		System.out.println("value集合：");
		for(String value:map.values()) {
			System.out.print(value+" ");
		}
		System.out.println();
		System.out.println("key集合：");
		Set<String> keys = map.keySet();
		Iterator<String> its = keys.iterator();
		while(its.hasNext()) {
			String it = its.next();
			System.out.print(it+" ");
		}
		System.out.println();
		
		System.out.println("迭代器遍历删除：");
		//先转化为单集合
		Set<Entry<String,String>> entrys2 = map.entrySet();
		Iterator<Entry<String,String>> iterator2 = entrys2.iterator();
		while(iterator2.hasNext()) {
			Entry<String,String> entry = iterator2.next();
			if(entry.getKey().equals("b")) {
				//map.remove(entry.getKey());
				iterator2.remove();
			}
		}
		System.out.println();
		
		System.out.println("foreach遍历集合3：");
		for(String key:map.keySet()) {
			System.out.print(key+"-->"+map.get(key)+" ");
		}
		System.out.println();
		System.out.println("元素个数："+map.size()+"是否为空："+map.isEmpty());
		map.clear();
		System.out.println("元素个数："+map.size()+"是否为空："+map.isEmpty());
	} 
}
