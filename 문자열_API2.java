package �⺻_API;

import java.util.Arrays;

public class ���ڿ�_API2 {

	public static void main(String[] args) {

		��_�ܾ�_ù��°����_�빮�ڷ�_����();
		SPLIT_���();
		SPLIT_������_������_���();
		
		���ڿ�_������();
		���ڿ�_������_�޸�_����();
		��Ʈ��_�տ�_���ڿ�_���̱�();
	}

	public static void ��Ʈ��_�տ�_���ڿ�_���̱�() {
		System.out.println("-----String�տ� ���ڿ� ���̱�--------");
		
		// String
		String str = "Anna";
		String prefix = "Hi! ";
		
		str = prefix + str;
		System.out.println("���ڿ����̱�(String) : " + str);
		
		// StringBuffer
		StringBuffer strBuff = new StringBuffer("Anna");
		strBuff.insert(0, "Hi! ");
		System.out.println("���ڿ����̱�(StringBuffer) : " + strBuff);
		
		// StringBuilder
		StringBuilder strBuilder = new StringBuilder("Anna");
		strBuilder.insert(0, "Hi! ");
		System.out.println("���ڿ����̱�(StringBuilder) : " + strBuilder);
	}
	
	public static void ��_�ܾ�_ù��°����_�빮�ڷ�_����() {
		
		String str = "nice to mEET you";
		
		String result = "";
		String[] words = str.split(" ");
		
		for(String word : words) {
			String data = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ";
			result += data;
		}
		
		System.out.println(result);
	}
	
	public static void SPLIT_���() {
		
		String str = "apple,banana,,orange,grape,,";
		
		String[] words = str.split(",", 4);
		//String[] words = str.split(",", 0);  // 0   : ������ �����ϰ� ���ڿ��� ���ԾȽ�Ŵ
		//String[] words = str.split(",", -1); // ���� : ������ �����ϰ� ���ڿ��̶� ���Խ�Ŵ
		for(String word : words)
			System.out.println("\"" + word + "\"");

	}
	
	public static void SPLIT_������_������_���() {
		String str = "a@b#c%d";
		String[] strArr = str.split("@|#|%");
		System.out.println(Arrays.toString(strArr));
	}
	
	public static void ���ڿ�_������() {
		
		String str = "ABCDE";
		String reverse = "";
		
		StringBuffer sb = new StringBuffer(str);
		reverse = sb.reverse().toString();
		
		System.out.println(sb);
		System.out.println(reverse);
	}
	
	public static void ���ڿ�_������_�޸�_����() {
		System.out.println("-----------���ڿ�_������_�޸�_����-------------");
		
		String str1 = "Apple, Banana,";
		String str2 = "Apple, Banana";
		
		// ���Խ� �̿� 
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
