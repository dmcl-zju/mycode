package class05;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;




//hashMapһЩ�����÷�ʹ�ò���
public class MyHashMap {
	
	//�Զ���Ƚ�������
	public static class compareAsc implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}

	}
	
	//�Զ���Ƚ�������
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
		System.out.println("�Ƿ����a��"+map.containsKey("a"));
		System.out.println("foreach��������1��");
		for(String key:map.keySet()) {
			System.out.print(key+"-->"+map.get(key)+" ");
		}
		System.out.println();
		
		System.out.println("foreach��������2��");
	
		Set<Entry<String,String>> entrySet = map.entrySet();
		for(Entry<String,String> entry:entrySet) {
			System.out.print(entry.getKey()+"-->"+entry.getValue()+" ");
		}
		System.out.println();
		System.out.println("������������");
		//��ת��Ϊ������
		Set<Entry<String,String>> entrys = map.entrySet();
		Iterator<Entry<String,String>> iterator = entrys.iterator();
		while(iterator.hasNext()) {
			Entry<String,String> entry = iterator.next();
			System.out.print(entry.getKey()+"-->"+entry.getValue()+" ");
		}
		System.out.println();
				
		System.out.println("value���ϣ�");
		for(String value:map.values()) {
			System.out.print(value+" ");
		}
		System.out.println();
		System.out.println("key���ϣ�");
		Set<String> keys = map.keySet();
		Iterator<String> its = keys.iterator();
		while(its.hasNext()) {
			String it = its.next();
			System.out.print(it+" ");
		}
		System.out.println();
		
		System.out.println("����������ɾ����");
		//��ת��Ϊ������
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
		
		System.out.println("foreach��������3��");
		for(String key:map.keySet()) {
			System.out.print(key+"-->"+map.get(key)+" ");
		}
		System.out.println();
		System.out.println("Ԫ�ظ�����"+map.size()+"�Ƿ�Ϊ�գ�"+map.isEmpty());
		map.clear();
		System.out.println("Ԫ�ظ�����"+map.size()+"�Ƿ�Ϊ�գ�"+map.isEmpty());
	} 
}
