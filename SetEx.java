

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class SetEx {

	// SET : ���ĵ��� �ʴ´�. ����Ǵ� ��ü�� �� �ߺ��� ��ü������ ������
	// HASHSET : �����͸� �������� get() ���� ��ɾ ������ iterator()�� ���
	//           �����͸� �̾ƿö�� ArrayList�� �ٲ㼭 ���ϴ� Index�� ����������
	//                         HashMap�� ����ؼ� key������ �����ü� ����.
	
	public static void main(String[] args) {
		System.out.println("===hashSet ����ؼ� �ζ� �����===");
		
		HashSet<Integer> hs = new HashSet<Integer>();
		Random ra = new Random();
		
		// 1~45������ �ߺ����� �ʴ� 6�� ���� �����
		while(hs.size()<6) {
			hs.add(ra.nextInt(45)+1);
		}
	
		System.out.println(hs);
		
		// HashSet�� ����� �����͸� ArrayList�� ���� 
		ArrayList<Integer>list = new ArrayList<Integer>();
		
		
		Collections.sort(list);
		
		
		System.out.println("LIST : " + list);
	}

}
