import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HASHMAP에대하여 {

	public static void main(String[] args) {

		HASHMAP_출력();
		HASHMAP_특정키_존재확인();
		HASHMAP_특정값_존재확인 ();
		HASHMAP_Value로_Key찾기();
		HASHMAP_최대_최소값_찾기();
	}
	
	public static void A_ () {
		System.out.println("-------------------");
	}
	
	public static void HASHMAP_출력 () {
		System.out.println("---------HASHMAP_출력----------");
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		System.out.println("기본출력 : " + map);
		
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
	
	public static void HASHMAP_특정키_존재확인 () {
		System.out.println("---------HASHMAP_특정키_존재확인----------");
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		// 특정 key값 존재여부 체크 
		System.out.println(map.containsKey(1));
		System.out.println(map.containsKey(5));
		System.out.println(map.containsKey(null));
	}
	
	public static void HASHMAP_특정값_존재확인 () {
		System.out.println("---------HASHMAP_특정값_존재확인----------");
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		System.out.println(map.containsValue("Banana"));
		System.out.println(map.containsValue("Grape"));
	}
	
	public static void HASHMAP_Value로_Key찾기 () {
		System.out.println("---------HASHMAP_Value로_Key찾기----------");
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		for(Entry<Integer, String> entry : entrySet) {
			if(entry.getValue().equals("Apple")) {
				System.out.println("Apple데이터의 키값은 " + entry.getKey());
			}
		}
	}
	
	public static void HASHMAP_최대_최소값_찾기 () {
		System.out.println("---------HASHMAP_최대_최소값_찾기----------");
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
