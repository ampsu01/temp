import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IntegerListSortTest {
	public static void main(String[] args) {
		
		List<Integer> num = new LinkedList<>();
		num.add(30);
		num.add(6);
		num.add(23);
		num.add(1);
		num.add(3);
		num.add(76);
		num.add(23);
		num.add(11);
		
		printList(num);
		Collections.sort(num);
		printList(num);
		
	}
	
	public static void printList(List<Integer> p) {
		for(int v : p)
			System.out.print(v + " ");
		System.out.println();
	}
}
