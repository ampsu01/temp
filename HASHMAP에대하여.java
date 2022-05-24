import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HASHMAP�����Ͽ� {

	public static void main(String[] args) {

		HASHMAP_���();
		HASHMAP_Ư��Ű_����Ȯ��();
		HASHMAP_Ư����_����Ȯ�� ();
		HASHMAP_Value��_Keyã��();
		HASHMAP_�ִ�_�ּҰ�_ã��();
	}
	
	public static void A_ () {
		System.out.println("-------------------");
	}
	
	public static void HASHMAP_��� () {
		System.out.println("---------HASHMAP_���----------");
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		System.out.println("�⺻��� : " + map);
		
		for(Entry<Integer, String> entrySet : map.entrySet())
			System.out.println(entrySet.getKey() + ":" + entrySet.getValue());
		
		Set<Integer> keySet = map.keySet();
		for(Integer key : keySet)
			System.out.println(key + ":" + map.get(key));
		
		Collection<String> values = map.values();
		System.out.println(values);
		
		Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Integer, String> entrySet = (Entry<Integer, String>)it.next();
			System.out.println(entrySet.getKey() + ":" + entrySet.getValue());
		}
	}
	
	public static void HASHMAP_Ư��Ű_����Ȯ�� () {
		System.out.println("---------HASHMAP_Ư��Ű_����Ȯ��----------");
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		// Ư�� key�� ���翩�� üũ 
		System.out.println(map.containsKey(1));
		System.out.println(map.containsKey(5));
		System.out.println(map.containsKey(null));
	}
	
	public static void HASHMAP_Ư����_����Ȯ�� () {
		System.out.println("---------HASHMAP_Ư����_����Ȯ��----------");
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		System.out.println(map.containsValue("Banana"));
		System.out.println(map.containsValue("Grape"));
	}
	
	public static void HASHMAP_Value��_Keyã�� () {
		System.out.println("---------HASHMAP_Value��_Keyã��----------");
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		for(Entry<Integer, String> entry : entrySet) {
			if(entry.getValue().equals("Apple")) {
				System.out.println("Apple�������� Ű���� " + entry.getKey());
			}
		}
	}
	
	public static void HASHMAP_�ִ�_�ּҰ�_ã�� () {
		System.out.println("---------HASHMAP_�ִ�_�ּҰ�_ã��----------");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 5);
		map.put(2, 70);
		map.put(3, 50);
		
		Entry<Integer, Integer> maxEntry = null;
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for(Entry<Integer, Integer> entry : entrySet) {
			if(maxEntry==null || entry.getValue()>maxEntry.getValue())
				maxEntry = entry;
		}
		
		System.out.println(maxEntry.getKey() + ":" + maxEntry.getValue());
	
	}
}
