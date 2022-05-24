

import java.util.HashMap;
import java.util.Iterator;

public class MapEx {

	public static void main(String[] args) {
		
		System.out.println("===Map:HashMap===");
		String[] msg = {"Berlin", "Paris", "Seoul", "New York", "London"};
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i=0; i<msg.length; i++)
			map.put(i, msg[i]);
		
		System.out.println(map);
		System.out.println("------------------------------------------------------");
		
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(key + ":" + map.get(key));
		}
		
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("도민준", 95);
		map2.put("천송이", 100);
		map2.put("유세미", 85);
		map2.put("이휘경", 93);
		map2.put("이재경", 70);
		
		// KEY는 같고 VALUE는 다름 -> KEY중복 시 마지막에 입력한 값이 VALUE값이 됨
		map2.put("천송이", 99);
		
		// KEY는 존재하지만 VALUE가 없는 경우 -> VALUE값 NULL 허용
		map2.put("강호동", null);
		
		// KEY는 NULL 이지만 VALUE가 있는 경우 -> KEY값 NULL 허용
		map2.put(null, 100);
		
		// KEY는 NULL, VALUE가 NULL 인경우 -> KEY/VALUE값 NULL 허용
		map2.put(null, null);
		
		// KEY를 통해 VALUE를 가져옴
		System.out.println("HashMap : " + map2);
	}

}
