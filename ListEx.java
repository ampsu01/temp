

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class A {
	// Object의 toString 재정의
	public String toString() {
		// 클래스 명 반환시킴
		return "A";
	}
}

class B {
	
}

public class ListEx {

	public static void main(String[] args) {

		System.out.println("===ArrayList:인덱스탐색,정렬===");
		System.out.println("-----문자열 정렬------");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("d");
		list.add("b");
		
		System.out.println(list.toString());
		
		// 인덱스 탐색 
		int inx1 = list.indexOf("b");
		int inx2 = list.lastIndexOf("b");
		//System.out.println(inx1 + " || " + inx2);
		
		// 정열(사전순)
		Collections.sort(list);
		System.out.println(list);
		
		// 정열(역순)
		Collections.reverse(list);
		System.out.println(list);
		
		
		System.out.println("-----숫자 정렬------");
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(100);
		list2.add(15);
		list2.add(2);
		list2.add(40);
		
		System.out.println(list2);
		Collections.sort(list2);
		System.out.println(list2);
		Collections.reverse(list2);
		System.out.println(list2);
		
		
		System.out.println("===콜렉션:list===");
		
		ArrayList al = new ArrayList();
		
		//객체 저장(ArrayList는 주소만 저장, 실제데이터는 객체(heap영역)에 저장)
		al.add(new A());
		al.add(new B());
		al.add("김연아");
		al.add(20);
		al.add(new Integer(20));
		
		System.out.println(al);
		
		al.clear();
		al.add("강호동");
		al.add("유재석");
		al.add("김병만");
		al.add("박명수");
		
		for(int i=0; i<al.size(); i++) {
			System.out.print((String)al.get(i) + " ");
		}
		System.out.println();
		
		al.remove(3);
		for(int i=0; i<al.size(); i++) {
			System.out.print((String)al.get(i) + " ");
		}
		System.out.println();
		
		al.remove("김병만");
		for(int i=0; i<al.size(); i++) {
			System.out.print((String)al.get(i) + " ");
		}
		System.out.println();
		
		for (Object o : al) {
			System.out.println((String)o);
		}
		
		System.out.println("--------Integer------------");
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(1);
		al2.add(5);
		al2.add(7);
		
		for(Integer i : al2)
			System.out.print(i + " ");
		
		LIST에_특정값_포함_확인();
		LIST_NULL_제거();
		LIST_합치기();
		LIST_중복제거_합치기();
		LIST_맨앞에_값추가하기();
		LIST_중간에_값추가하기();
		
		LIST에_중복_제거();
	}
	
	public static void LIST에_중복_제거() {
		System.out.println("\n-------LIST에_특정값_포함_확인---------");
		
		List<String> list = Arrays.asList("A", "B", "C", "A");
		
		// LIST -> Set 변경
		Set<String> set = new HashSet<>(list);
		
		// Set -> List 변경
		List<String> list2 = new ArrayList<>(set);
		
		System.out.println(list2);
	}
	
	public static void LIST에_특정값_포함_확인() {
		System.out.println("\n-------LIST에_특정값_포함_확인---------");
		
		List<String> list = new ArrayList<>(Arrays.asList("Hello", "Hi"));
		
		// 포함여부 체크 
		System.out.println("Hello 포함 여부 : " + list.contains("Hello"));
		System.out.println("hello 포함 여부 : " + list.contains("hello"));

	}
	
	public static void LIST_NULL_제거() {
		System.out.println("\n-------LIST_NULL_제거---------");
		
		List<String> list = new ArrayList<String>(Arrays.asList("Hi", null, "Hello", null));
		System.out.println("LIST(처음) : " + list);
		
		for(int i=0; i<list.size(); i++) {
			list.remove(null);
		}
		System.out.println("LIST(for()) : " + list);
		
		List<String> list2 = new ArrayList<String>(Arrays.asList("Hi", null, "Hello", null));
		while(list2.remove(null)) {
			
		}
		System.out.println("LIST2(while()) : " + list2);
		
		List<String> list3 = new ArrayList<String>(Arrays.asList("Hi", null, "Hello", null));
		list3.removeAll(Collections.singletonList(null));
		System.out.println("LIST3(removeAll()) : " + list3);
		
		List<String> list4 = new ArrayList<String>(Arrays.asList("Hi", null, "Hello", null));
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			if(it.next()==null) {
				it.remove();
			}
		}
		System.out.println("LIST4(Iterator()) : " + list3);
	}
	
	public static void LIST_합치기() {
		System.out.println("\n-------LIST_합치기---------");
		
		List<String>list1 = new ArrayList<>(Arrays.asList("A", "B"));
		List<String>list2 = new ArrayList<>(Arrays.asList("C", "D"));
		
		// 첫번째 방법
		list1.addAll(list2);
		
		// 두번째 방법
		Collections.addAll(list2, list1.toArray(new String[0]));
		Collections.sort(list2);
		
		System.out.println(list1);
		System.out.println(list2);
		
	}
	
	public static void LIST_중복제거_합치기() {
		System.out.println("\n-------LIST_중복제거_합치기---------");
		
		// 1. LinkedHashSet 이용  : 중복허용하지 않으면서 데이터 입력 순서대로 저장 
		List<String>list1 = new ArrayList<>(Arrays.asList("B", "A"));
		List<String>list2 = new ArrayList<>(Arrays.asList("C", "B"));	
		
		Set<String> set = new LinkedHashSet<>(list1);
		set.addAll(list2);
		
		List<String> mergedList = new ArrayList<>(set);
		System.out.println(mergedList);
		
		// 2. List.removeAll() 이용 
		List<String>list3 = new ArrayList<>(Arrays.asList("B", "A"));
		List<String>list4 = new ArrayList<>(Arrays.asList("C", "B"));
		
		list3.removeAll(list4);
		list3.addAll(list4);
		System.out.println(list3);
	}
	
	public static void LIST_맨앞에_값추가하기() {
		System.out.println("\n-------LIST_맨앞에_값추가하기---------");
		
		List<String> list = new ArrayList<>(Arrays.asList("B", "C"));
		List<String> list2 = new ArrayList<>(Arrays.asList("B", "C"));
		List<String> list3 = new ArrayList<>(Arrays.asList("A", "B"));

		// 0번째 index에 "A"추가 
		list.add(0, "A");
		System.out.println(list);
		
		// 0번재 index에 list3 추가 
		list2.addAll(0, list3);
		System.out.println(list2);
		
		System.out.println("\n-------LIST_에서_특정값_갯수세기---------");
		int count = Collections.frequency(list2, "B");
		System.out.println(list2 + "에 B는 " + count +"개 존재합니다");
	}
	
	public static void LIST_중간에_값추가하기() {
		System.out.println("\n-------LIST_중간에_값추가하기---------");
		
		List<String> list = new ArrayList<>(Arrays.asList("A", "B", "E", "F"));

		// 2번째 index에 "C"추가 
		list.add(2, "C");
		
		// 3번재 index에 "D" 추가 
		list.add(3, "D");
		System.out.println(list);
		
		System.out.println("\n-------LIST_중간에_LIST추가하기---------");
		List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "E", "F"));
		List<String> list3 = new ArrayList<>(Arrays.asList("C", "D"));
		list2.addAll(2, list3);
		System.out.println(list2);
	}

}
