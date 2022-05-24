
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class �ڷᱸ��������_����ȯ {
	// https://hianna.tistory.com/579
	
	public static void main(String[] args) {

		MAP��_�迭��_��ȯ();
		MAP��_LIST��_��ȯ();
		MAP��_SET��_��ȯ();
		
		LIST��_SET����_��ȯ();
		
	}
	
	public static void MAP��_�迭��_��ȯ() {
	
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		Collection<String> values = map.values();
		
		// ���� map�� 3���� element�� ������ �����Ƿ� ���̰� 3�� �迭�� ���ڷ� �־�� ������
		// ���̰� 0�� �迭�� �ѱ�� �ڵ����� ��ȯ�� �迭 ���̷� �������� 0�� ���ڷ� ��
		String[] strArr = values.toArray(new String[0]);
		
		System.out.println("MAP->ARRAY : " + Arrays.toString(strArr));
	}
	
	public static void MAP��_LIST��_��ȯ() {
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		// MAP->LIST
		Collection<String> values = map.values();
		List<String> list = new ArrayList<String>(values);
		
		System.out.println("MAP->LIST : " + list);
		
		LIST��_MAP��_��ȯ(list);
	}
	
	public static void MAP��_SET��_��ȯ() {
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Apple");
		map.put(2, "Banana");
		map.put(3, "Orange");
		
		// MAP->SET
		Collection<String> values = map.values();
		Set<String> set = new HashSet<>(values);
		
		System.out.println("MAP->SET :" + set);
	}
	
	public static void LIST��_MAP��_��ȯ(List<String> list) {
		
		ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "C", "A"));
		
		// LIST->MAP
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		for(int i=0; i<list.size(); i++) {
			hashMap.put(i, list.get(i));
		}
		
		System.out.println("LIST->MAP : " + hashMap);
	}
	
	public static void LIST��_SET����_��ȯ() {
		System.out.println("-------LIST��_SET����_��ȯ---------");
		
		List<String> list = Arrays.asList("L", "I", "S", "T", "S");
		Set<String> set = new HashSet<>(list);
		System.out.println(set);
		
		Set<String> set2 = new LinkedHashSet<>(list);
		System.out.println(set2);

				
	}

}
