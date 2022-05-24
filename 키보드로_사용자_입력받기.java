package 기본_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 키보드로_사용자_입력받기 {

	public static void main(String[] args) throws IOException {
		//BufferedReader_예제();
		Scanner_예제();
		
	}

	public static void BufferedReader_예제() throws IOException {
		System.out.println("---------BufferedReader_예제-----------");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// 반복해서 입력 데이터 읽기
		String str = "";
		
		while( (str=reader.readLine())!=null ) {
			// 입력 데이터 출력
			System.out.println(str);	
		}
		
		
	}
	
	public static void Scanner_예제() {
		System.out.println("---------Scanner_예제-----------");
		
		Scanner scanner= new Scanner(System.in);
		
		while(scanner.hasNextLine()) {
			String input = scanner.nextLine();
			System.out.println(input);
		}
		
		System.out.println("문자열을 입력하세요 : ");
		String str = scanner.nextLine();
		
		System.out.println("정수를 입력하세요 : ");
		int num = scanner.nextInt();
		
		System.out.println("실수를 입력하세요 : ");
		float fNum = scanner.nextFloat();
		
		System.out.println("true/false를 입력하세요 : ");
		boolean flag = scanner.nextBoolean();
		
		// 결과 출력
		System.out.println(str);
		System.out.println(num);
		System.out.println(fNum);
		System.out.println(flag);
		
		// close scanner
		scanner.close();
	}
}
