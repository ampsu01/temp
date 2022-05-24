

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class A {
	// Object�� toString ������
	public String toString() {
		// Ŭ���� �� ��ȯ��Ŵ
		return "A";
	}
}

class B {
	
}

public class ListEx {

	public static void main(String[] args) {

		System.out.println("===ArrayList:�ε���Ž��,����===");
		System.out.println("-----���ڿ� ����------");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("d");
		list.add("b");
		
		System.out.println(list.toString());
		
		// �ε��� Ž�� 
		int inx1 = list.indexOf("b");
		int inx2 = list.lastIndexOf("b");
		//System.out.println(inx1 + " || " + inx2);
		
		// ����(������)
		Collections.sort(list);
		System.out.println(list);
		
		// ����(����)
		Collections.reverse(list);
		System.out.println(list);
		
		
		System.out.println("-----���� ����------");
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
		
		
		System.out.println("===�ݷ���:list===");
		
		ArrayList al = new ArrayList();
		
		//��ü ����(ArrayList�� �ּҸ� ����, ���������ʹ� ��ü(heap����)�� ����)
		al.add(new A());
		al.add(new B());
		al.add("�迬��");
		al.add(20);
		al.add(new Integer(20));
		
		System.out.println(al);
		
		al.clear();
		al.add("��ȣ��");
		al.add("���缮");
		al.add("�躴��");
		al.add("�ڸ��");
		
		for(int i=0; i<al.size(); i++) {
			System.out.print((String)al.get(i) + " ");
		}
		System.out.println();
		
		al.remove(3);
		for(int i=0; i<al.size(); i++) {
			System.out.print((String)al.get(i) + " ");
		}
		System.out.println();
		
		al.remove("�躴��");
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
		
		LIST��_Ư����_����_Ȯ��();
		LIST_NULL_����();
		LIST_��ġ��();
		LIST_�ߺ�����_��ġ��();
		LIST_�Ǿտ�_���߰��ϱ�();
		LIST_�߰���_���߰��ϱ�();
		
		LIST��_�ߺ�_����();
	}
	
	public static void LIST��_�ߺ�_����() {
		System.out.println("\n-------LIST��_Ư����_����_Ȯ��---------");
		
		List<String> list = Arrays.asList("A", "B", "C", "A");
		
		// LIST -> Set ����
		Set<String> set = new HashSet<>(list);
		
		// Set -> List ����
		List<String> list2 = new ArrayList<>(set);
		
		System.out.println(list2);
	}
	
	public static void LIST��_Ư����_����_Ȯ��() {
		System.out.println("\n-------LIST��_Ư����_����_Ȯ��---------");
		
		List<String> list = new ArrayList<>(Arrays.asList("Hello", "Hi"));
		
		// ���Կ��� üũ 
		System.out.println("Hello ���� ���� : " + list.contains("Hello"));
		System.out.println("hello ���� ���� : " + list.contains("hello"));

	}
	
	public static void LIST_NULL_����() {
		System.out.println("\n-------LIST_NULL_����---------");
		
		List<String> list = new ArrayList<String>(Arrays.asList("Hi", null, "Hello", null));
		System.out.println("LIST(ó��) : " + list);
		
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
	
	public static void LIST_��ġ��() {
		System.out.println("\n-------LIST_��ġ��---------");
		
		List<String>list1 = new ArrayList<>(Arrays.asList("A", "B"));
		List<String>list2 = new ArrayList<>(Arrays.asList("C", "D"));
		
		// ù��° ���
		list1.addAll(list2);
		
		// �ι�° ���
		Collections.addAll(list2, list1.toArray(new String[0]));
		Collections.sort(list2);
		
		System.out.println(list1);
		System.out.println(list2);
		
	}
	
	public static void LIST_�ߺ�����_��ġ��() {
		System.out.println("\n-------LIST_�ߺ�����_��ġ��---------");
		
		// 1. LinkedHashSet �̿�  : �ߺ�������� �����鼭 ������ �Է� ������� ���� 
		List<String>list1 = new ArrayList<>(Arrays.asList("B", "A"));
		List<String>list2 = new ArrayList<>(Arrays.asList("C", "B"));	
		
		Set<String> set = new LinkedHashSet<>(list1);
		set.addAll(list2);
		
		List<String> mergedList = new ArrayList<>(set);
		System.out.println(mergedList);
		
		// 2. List.removeAll() �̿� 
		List<String>list3 = new ArrayList<>(Arrays.asList("B", "A"));
		List<String>list4 = new ArrayList<>(Arrays.asList("C", "B"));
		
		list3.removeAll(list4);
		list3.addAll(list4);
		System.out.println(list3);
	}
	
	public static void LIST_�Ǿտ�_���߰��ϱ�() {
		System.out.println("\n-------LIST_�Ǿտ�_���߰��ϱ�---------");
		
		List<String> list = new ArrayList<>(Arrays.asList("B", "C"));
		List<String> list2 = new ArrayList<>(Arrays.asList("B", "C"));
		List<String> list3 = new ArrayList<>(Arrays.asList("A", "B"));

		// 0��° index�� "A"�߰� 
		list.add(0, "A");
		System.out.println(list);
		
		// 0���� index�� list3 �߰� 
		list2.addAll(0, list3);
		System.out.println(list2);
		
		System.out.println("\n-------LIST_����_Ư����_��������---------");
		int count = Collections.frequency(list2, "B");
		System.out.println(list2 + "�� B�� " + count +"�� �����մϴ�");
	}
	
	public static void LIST_�߰���_���߰��ϱ�() {
		System.out.println("\n-------LIST_�߰���_���߰��ϱ�---------");
		
		List<String> list = new ArrayList<>(Arrays.asList("A", "B", "E", "F"));

		// 2��° index�� "C"�߰� 
		list.add(2, "C");
		
		// 3���� index�� "D" �߰� 
		list.add(3, "D");
		System.out.println(list);
		
		System.out.println("\n-------LIST_�߰���_LIST�߰��ϱ�---------");
		List<String> list2 = new ArrayList<>(Arrays.asList("A", "B", "E", "F"));
		List<String> list3 = new ArrayList<>(Arrays.asList("C", "D"));
		list2.addAll(2, list3);
		System.out.println(list2);
	}

}
