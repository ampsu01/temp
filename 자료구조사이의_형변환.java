
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 자료구조사이의_형변환 {
	// https://hianna.tistory.com/579
	
	public static void main(String[] args) {

		MAP을_배열로_변환();
		MAP을_LIST로_변환();
		MAP을_SET로_변환();
		
		LIST를_SET으로_변환();
		
	}
	
	public static void MAP을_배열로_변환() {
	
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		Collection<String> values = map.values();
		
		// 현재 map이 3개의 element를 가지고 있으므로 길이가 3인 배열을 인자로 주어야 하지만
		// 길이가 0인 배열을 넘기면 자동으로 변환될 배열 길이로 정해져서 0을 인자로 줌
		String[] strArr = values.toArray(new String[0]);
		
		System.out.println("MAP->ARRAY : " + Arrays.toString(strArr));
	}
	
	public static void MAP을_LIST로_변환() {
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		// MAP->LIST
		Collection<String> values = map.values();
		List<String> list = new ArrayList<String>(values);
		
		System.out.println("MAP->LIST : " + list);
		
		LIST을_MAP로_변환(list);
	}
	
	public static void MAP을_SET로_변환() {
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		// MAP->SET
		Collection<String> values = map.values();
		Set<String> set = new HashSet<>(values);
		
		System.out.println("MAP->SET :" + set);
	}
	
	public static void LIST을_MAP로_변환(List<String> list) {
		
		ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C", "A"));
		
		// LIST->MAP
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		for(int i=0; i<list.size(); i++) {
			hashMap.put(i, list.get(i));
		}
		
		System.out.println("LIST->MAP : " + hashMap);
	}
	
	public static void LIST를_SET으로_변환() {
		System.out.println("-------LIST를_SET으로_변환---------");
		
		List<String> list = Arrays.asList("L", "I", "S", "T", "S");
		Set<String> set = new HashSet<>(list);
		System.out.println(set);
		
		Set<String> set2 = new LinkedHashSet<>(list);
		System.out.println(set2);

				
	}

}
