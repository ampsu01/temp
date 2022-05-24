import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LIST_심화 {

	public static void main(String[] args) {

		LIST_사용자정렬();
		
		LIST_데이터_최대_최소값();
	}

	public static void LIST_데이터_최대_최소값() {
		System.out.println("\n-------LIST_데이터_최대_최소값---------");
		
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 3, 2, 1, 5));
		System.out.println(list);
		
		// MAX
		int max = Collections.max(list);
		System.out.println("최대값 : " + max);
		
		
		
	}
	
	public static void LIST_사용자정렬() {
		System.out.println("\n-------LIST_사용자정렬---------");
		
		System.out.println("\n-------LIST_Comparable---------");
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		list.add(new Fruit("Apple", 2000));
		list.add(new Fruit("Orange", 3000));
		list.add(new Fruit("Banana", 1000));
		System.out.println("원본 : " + list);

		// price 오름차순 정렬
		Collections.sort(list);
		System.out.println("가격 오름차순 : " + list);
		
		// price 내림차순 정렬
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("가격 내림차순 : " + list);
		
		System.out.println("\n-------LIST_Compararor---------");
		ArrayList<Fruit2> list2 = new ArrayList<Fruit2>();
		list2.add(new Fruit2("Apple", 2000));
		list2.add(new Fruit2("Orange", 3000));
		list2.add(new Fruit2("Banana", 1000));
		System.out.println("원본 : " + list2);
		
		// price 오름차순 정렬
		Collections.sort(list2, new FruitPriceComparator());
		System.out.println("가격 오름차순 : " + list2);
		
		// price 내림차순 정렬
		Collections.sort(list2, new FruitPriceComparator().reversed());
		System.out.println("가격 내림차순 : " + list2);
		
		// name 오름차순 정렬
		Collections.sort(list2, new FruitNameComparator());
		System.out.println("이름 오름차순 : " + list2);
		
	}
}

class Fruit implements Comparable<Fruit> {
	private String name;
	private int price;

	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[ " + this.name + ": " + this.price + " ]";
	}

	@Override
	public int compareTo(Fruit fruit) {
		if(fruit.price < price)
			return 1;
		else if(fruit.price > price)
			return -1;
			
		return 0;
	}
}

class FruitPriceComparator implements Comparator<Fruit2>{

	@Override
	public int compare(Fruit2 o1, Fruit2 o2) {
		if(o1.price > o2.price)
			return 1;
		else if(o1.price < o2.price)
			return -1;
		
		return 0;
	}
	
}

class FruitNameComparator implements Comparator<Fruit2>{

	@Override
	public int compare(Fruit2 o1, Fruit2 o2) {
		return o1.name.compareTo(o2.name);
			
	}
	
}

class Fruit2  {
	String name;
	int price;

	public Fruit2(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "[ " + this.name + ": " + this.price + " ]";
	}
}

