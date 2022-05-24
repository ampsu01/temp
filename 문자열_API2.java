package 기본_API;

import java.util.Arrays;

public class 문자열_API2 {

	public static void main(String[] args) {

		각_단어_첫번째문자_대문자로_변경();
		SPLIT_사용();
		SPLIT_구분자_여러개_사용();
		
		문자열_뒤집기();
		문자열_마지막_콤마_제거();
		스트링_앞에_문자열_붙이기();
	}

	public static void 스트링_앞에_문자열_붙이기() {
		System.out.println("-----String앞에 문자열 붙이기--------");
		
		// String
		String str = "Anna";
		String prefix = "Hi! ";
		
		str = prefix + str;
		System.out.println("문자열붙이기(String) : " + str);
		
		// StringBuffer
		StringBuffer strBuff = new StringBuffer("Anna");
		strBuff.insert(0, "Hi! ");
		System.out.println("문자열붙이기(StringBuffer) : " + strBuff);
		
		// StringBuilder
		StringBuilder strBuilder = new StringBuilder("Anna");
		strBuilder.insert(0, "Hi! ");
		System.out.println("문자열붙이기(StringBuilder) : " + strBuilder);
	}
	
	public static void 각_단어_첫번째문자_대문자로_변경() {
		
		String str = "nice to mEET you";
		
		String result = "";
		String[] words = str.split(" ");
		
		for(String word : words) {
			String data = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
			result += data;
		}
		
		System.out.println(result);
	}
	
	public static void SPLIT_사용() {
		
		String str = "apple,banana,,orange,grape,,";
		
		String[] words = str.split(",", 4);
		//String[] words = str.split(",", 0);  // 0   : 끝까지 수행하고 빈문자열은 포함안시킴
		//String[] words = str.split(",", -1); // 음수 : 끝까지 수행하고 빈문자열이라도 포함시킴
		for(String word : words)
			System.out.println("\"" + word + "\"");

	}
	
	public static void SPLIT_구분자_여러개_사용() {
		String str = "a@b#c%d";
		String[] strArr = str.split("@|#|%");
		System.out.println(Arrays.toString(strArr));
	}
	
	public static void 문자열_뒤집기() {
		
		String str = "ABCDE";
		String reverse = "";
		
		StringBuffer sb = new StringBuffer(str);
		reverse = sb.reverse().toString();
		
		System.out.println(sb);
		System.out.println(reverse);
	}
	
	public static void 문자열_마지막_콤마_제거() {
		System.out.println("-----------문자열_마지막_콤마_제거-------------");
		
		String str1 = "Apple, Banana,";
		String str2 = "Apple, Banana";
		
		// 정규식 이용 
		str1 = str1.replaceAll(",$", "");
		str2 = str2.replaceAll(",$", "");
		
		System.out.println(str1);
		System.out.println(str2);
		
		String str3 = "Apple, Banana,";
		if(str3.endsWith(","))
			str3 = str3.substring(0, str3.length()-1);
		
		System.out.println(str3);
		
	}
}
