import java.util.Arrays;
import java.util.Comparator;

public class StringArraySortTest {

	public static void main(String[] args) {
		String[] sample = { "Hong 25 Seoul",
							"Lee 30 Busan",
							"Park 15 Suwon",
							"Hong 15 Seoul"
						  };
		
		printArray(sample);
		Arrays.sort(sample, new Comparator<String>() {

			@Override
			// 나이 오름 순차 정렬, 이름 오름차순 정렬  
			public int compare(String str1, String str2) {
				int a = Integer.parseInt(str1.split(" ")[1]);
				int b = Integer.parseInt(str2.split(" ")[1]);
				
				if(a>b) return 1;
				if(a==b)
					str1.compareTo(str2);
				
				return -1;
			}
		});
		
		printArray(sample);

	}

	public static void printArray(String[] p) {
		System.out.println(Arrays.toString(p));
	}
		

}
