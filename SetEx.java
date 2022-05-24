

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class SetEx {

	// SET : 정렬되지 않는다. 저장되는 객체들 간 중복을 자체적으로 관리함
	// HASHSET : 데이터를 가져오는 get() 같은 명령어가 없으며 iterator()를 사용
	//           데이터를 뽑아올라면 ArrayList로 바꿔서 원하는 Index를 가져오던지
	//                         HashMap을 사용해서 key값으로 가져올수 있음.
	
	public static void main(String[] args) {
		System.out.println("===hashSet 사용해서 로또 만들기===");
		
		HashSet<Integer> hs = new HashSet<Integer>();
		Random ra = new Random();
		
		// 1~45사이의 중복되지 않는 6개 숫자 만들기
		while(hs.size()<6) {
			hs.add(ra.nextInt(45)+1);
		}
	
		System.out.println(hs);
		
		// HashSet에 저장된 데이터를 ArrayList로 저장 
		ArrayList<Integer>list = new ArrayList<Integer>();
		
		
		Collections.sort(list);
		
		
		System.out.println("LIST : " + list);
	}

}
