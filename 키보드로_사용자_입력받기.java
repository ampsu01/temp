package �⺻_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ű�����_�����_�Է¹ޱ� {

	public static void main(String[] args) throws IOException {
		//BufferedReader_����();
		Scanner_����();
		
	}

	public static void BufferedReader_����() throws IOException {
		System.out.println("---------BufferedReader_����-----------");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// �ݺ��ؼ� �Է� ������ �б�
		String str = "";
		
		while( (str=reader.readLine())!=null ) {
			// �Է� ������ ���
			System.out.println(str);	
		}
		
		
	}
	
	public static void Scanner_����() {
		System.out.println("---------Scanner_����-----------");
		
		Scanner scanner= new Scanner(System.in);
		
		while(scanner.hasNextLine()) {
			String input = scanner.nextLine();
			System.out.println(input);
		}
		
		System.out.println("���ڿ��� �Է��ϼ��� : ");
		String str = scanner.nextLine();
		
		System.out.println("������ �Է��ϼ��� : ");
		int num = scanner.nextInt();
		
		System.out.println("�Ǽ��� �Է��ϼ��� : ");
		float fNum = scanner.nextFloat();
		
		System.out.println("true/false�� �Է��ϼ��� : ");
		boolean flag = scanner.nextBoolean();
		
		// ��� ���
		System.out.println(str);
		System.out.println(num);
		System.out.println(fNum);
		System.out.println(flag);
		
		// close scanner
		scanner.close();
	}
}
