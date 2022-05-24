import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;



public class �ڷᱸ������_����ȯ2 {

	public static void main(String[] args) {

		�迭��_LIST��();
		�迭��_���ο�LIST��();
		LIST��_�迭��();
		
		INT�迭��_LIST��();
		
		�迭_�ߺ�������();
		�迭��_SET��();
	}
	
	public static void �迭��_LIST��() {
		
		String[] arr = { "A", "B", "C" };
		
		// �迭->LIST
		List<String> list = Arrays.asList(arr);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		// �迭�� ���� ����Ǹ� List�����͵� ����� 
		//arr[0] = "Z";
		//System.out.println(list.get(0));
		
		// �迭�� ����Ʈ�� ��ȯ ��, ����Ʈ�� ���� ����Ǹ� �迭�� ���� ����� 
		//list.set(0, "D");
		
		//System.out.println(Arrays.toString(arr));
		//System.out.println(list.get(0));
		//System.out.println(list.get(1));
		//System.out.println(list.get(2));
		
		// �迭�� ����Ʈ�� ��ȯ ��, ����Ʈ�� ���� �߰��Ǹ� �����߻�-��ȯ�ɶ� ũ��� ����������� �����Ǳ� ���� 
		//list.add("D");
		//System.out.println(list.get(0));
		//System.out.println(list.get(1));
		//System.out.println(list.get(2));
		//System.out.println(list.get(3));
	}
	
	public static void �迭��_���ο�LIST��() {
		String[] arr = { "A", "B", "C" };
		
		// �迭->LIST
		List<String> list = new ArrayList<>(Arrays.asList(arr));
		
		arr[0] = "Z";
		list.add("D");
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
	}
	
	public static void LIST��_�迭��() {
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		String[] arr = list.toArray(new String[list.size()]);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void INT�迭��_LIST��() {
		
		System.out.println("------INT�迭��_LIST��--------");
		int[] arr = { 1, 2, 3 };
		
		List<int[]> intList = Arrays.asList(arr); // ���ϴ� ����� �ƴ� : int[] ��ü�� ������
		System.out.println(intList.size());       // ũ�Ⱑ 1�̵� 
		
		List<Integer> integerList = new ArrayList<>();
		for(int num : arr)
			integerList.add(num);
		
		System.out.println(integerList.size());
		
	}

	public static void �迭_�ߺ�������() {
		
		System.out.println("-------�迭_�ߺ�������-------");
		
		String[] arr = { "H", "E", "L", "L", "O" };
		
		// HashSet�� ���� �迭�� ������ �������� ���� 
		HashSet<String> hashSet = new HashSet<>(Arrays.asList(arr));
		
		System.out.println("HashSet : " + hashSet);
		
		// HashSet->�迭 
		String[] resultArr = hashSet.toArray(new String[0]);
		System.out.println(Arrays.toString(resultArr));
		
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList(arr));
		System.out.println("LinkedHashSet : " + linkedHashSet);
		
		String[] resultArr2 = linkedHashSet.toArray(new String[0]);
		System.out.println(Arrays.toString(resultArr2));
	}
	
	public static void �迭��_SET��() {
		System.out.println("------(�迭->SET)--------");
		Integer[] arr = { 1, 1, 2, 3, 4 };
		
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
		System.out.println(set);

		System.out.println("------(SET->�迭)--------");
		Integer[] arr2 = set.toArray(new Integer[0]);
		System.out.println(Arrays.toString(arr2));
	}
}
