import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringListSortTest {

	public static void main(String[] args) {
		String[] sample = { "Hong 25 Seoul",
				"Lee 30 Busan",
				"Park 15 Suwon",
				"Hong 15 Seoul"
			  };

		ArrayList<String> member = new ArrayList<String>();
		for(String s : sample)
			member.add(s);
		
		System.out.println(member);
		Collections.sort(member);
		System.out.println(member);
	}
}
