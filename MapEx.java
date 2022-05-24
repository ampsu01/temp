

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
		map2.put("������", 95);
		map2.put("õ����", 100);
		map2.put("������", 85);
		map2.put("���ְ�", 93);
		map2.put("�����", 70);
		
		// KEY�� ���� VALUE�� �ٸ� -> KEY�ߺ� �� �������� �Է��� ���� VALUE���� ��
		map2.put("õ����", 99);
		
		// KEY�� ���������� VALUE�� ���� ��� -> VALUE�� NULL ���
		map2.put("��ȣ��", null);
		
		// KEY�� NULL ������ VALUE�� �ִ� ��� -> KEY�� NULL ���
		map2.put(null, 100);
		
		// KEY�� NULL, VALUE�� NULL �ΰ�� -> KEY/VALUE�� NULL ���
		map2.put(null, null);
		
		// KEY�� ���� VALUE�� ������
		System.out.println("HashMap : " + map2);
	}

}
