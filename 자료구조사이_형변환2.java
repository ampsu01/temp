import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



public class 자료구조사이_형변환2 {

	public static void main(String[] args) {

		배열을_LIST로();
		배열을_새로운LIST로();
		LIST를_배열로();
		
		INT배열을_LIST로();
		
		배열_중복값제거();
		배열을_SET로();
	}
	
	public static void 배열을_LIST로() {
		
		String[] arr = { "A", "B", "C" };
		
		// 배열->LIST
		List<String> list = Arrays.asList(arr);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		// 배열의 같이 변경되면 List데이터도 변경됨 
		//arr[0] = "Z";
		//System.out.println(list.get(0));
		
		// 배열을 리스트로 변환 후, 리스트의 값이 변경되면 배열의 값도 변경됨 
		//list.set(0, "D");
		
		//System.out.println(Arrays.toString(arr));
		//System.out.println(list.get(0));
		//System.out.println(list.get(1));
		//System.out.println(list.get(2));
		
		// 배열을 리스트로 변환 후, 리스트에 값이 추가되면 에러발생-변환될때 크기로 고정사이즈로 생성되기 때문 
		//list.add("D");
		//System.out.println(list.get(0));
		//System.out.println(list.get(1));
		//System.out.println(list.get(2));
		//System.out.println(list.get(3));
	}
	
	public static void 배열을_새로운LIST로() {
		String[] arr = { "A", "B", "C" };
		
		// 배열->LIST
		List<String> list = new ArrayList<>(Arrays.asList(arr));
		
		arr[0] = "Z";
		list.add("D");
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
	}
	
	public static void LIST를_배열로() {
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		String[] arr = list.toArray(new String[list.size()]);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void INT배열을_LIST로() {
		
		System.out.println("------INT배열을_LIST로--------");
		int[] arr = { 1, 2, 3 };
		
		List<int[]> intList = Arrays.asList(arr); // 원하던 결과가 아님 : int[] 자체로 생성됨
		System.out.println(intList.size());       // 크기가 1이됨 
		
		List<Integer> integerList = new ArrayList<>();
		for(int num : arr)
			integerList.add(num);
		
		System.out.println(integerList.size());
		
	}

	public static void 배열_중복값제거() {
		
		System.out.println("-------배열_중복값제거-------");
		
		String[] arr = { "H", "E", "L", "L", "O" };
		
		// HashSet은 원래 배열의 순서를 보장하지 않음 
		HashSet<String> hashSet = new HashSet<>(Arrays.asList(arr));
		
		System.out.println("HashSet : " + hashSet);
		
		// HashSet->배열 
		String[] resultArr = hashSet.toArray(new String[0]);
		System.out.println(Arrays.toString(resultArr));
		
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(arr));
		System.out.println("LinkedHashSet : " + linkedHashSet);
		
		String[] resultArr2 = linkedHashSet.toArray(new String[0]);
		System.out.println(Arrays.toString(resultArr2));
	}
	
	public static void 배열을_SET로() {
		System.out.println("------(배열->SET)--------");
		Integer[] arr = { 1, 1, 2, 3, 4 };
		
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
		System.out.println(set);

		System.out.println("------(SET->배열)--------");
		Integer[] arr2 = set.toArray(new Integer[0]);
		System.out.println(Arrays.toString(arr2));
	}
}
