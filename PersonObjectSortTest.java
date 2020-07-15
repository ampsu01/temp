import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonObjectSortTest {

	public static String[] solution(String[] name, String[] phone, int[] age) {
		String[] result = new String[name.length];
		List<Person> p = new ArrayList<Person>();
		for(int i=0; i<name.length; i++) {
			p.add(new Person(name[i], phone[i], age[i]));
		}
		
		System.out.println(p);
		Collections.sort(p);
		
		System.out.println(p);
		Collections.sort(p, new CompPerson());
		System.out.println(p);
		
		
		return result;
		
	}
	public static void main(String[] args) {
		String[] name = {"park", "ahn", "kim", "hong", "choi"};
		String[] phone = {"0-0-1234", "0-0-1134", "0-0-1214", "0-0-1231", "0-0-1111"};
		int[] age = {40, 39, 23, 39, 32};
		
		String[] res = solution(name, phone, age);
		System.out.println(Arrays.toString(res));
	}
	
//	[park_40_1234, ahn_39_1134, kim_23_1214, hong_39_1231, choi_32_1111]
//	[kim_23_1214, choi_32_1111, hong_39_1231, ahn_39_1134, park_40_1234]
//  [kim_23_1214, choi_32_1111, ahn_39_1134, hong_39_1231, park_40_1234]

// [park_40_1234, ahn_39_1134, hong_39_1231, choi_32_1111, kim_23_1214]
// [park_40_1234, hong_39_1231, ahn_39_1134, choi_32_1111, kim_23_1214]

}

class CompPerson implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		if(o2.age > o1.age) return 1;
		else if(o2.age == o1.age) {
			if(o2.phone.compareTo(o1.phone)>0)
				return 1;
		}
		
		return -1;
	}
	
	
}
