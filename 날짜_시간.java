package �⺻_API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ��¥_�ð� {

	// https://hianna.tistory.com/607?category=650599
	public static void main(String[] args) throws ParseException {
		
		���糯¥_���ϱ�();
		����ð�_���ϱ�();
		
		���ڿ���_��¥��_��ȯ�ϱ�();

	}

	public static void ���ڿ���_��¥��_��ȯ�ϱ�() throws ParseException {
		System.out.println("------���ڿ���_��¥��_��ȯ�ϱ�(String->Date)--------");
		
		//  ���ڿ�
		String dateStr = "2022�� 05�� 23�� 22�� 29�� 07��";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
		
		// ���ڿ� -> Date
		Date date = formatter.parse(dateStr);
		System.out.println(date); // Mon May 23 22:29:07 KST 2022
		
		
		System.out.println("------���ڿ���_��¥��_��ȯ�ϱ�(String->LocalDateTime)--------");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy�� MM�� dd�� HH�� mm�� ss��");
		// ���ڿ� -> Date
		LocalDateTime date2 = LocalDateTime.parse(dateStr, formatter2);
		System.out.println(date2); // 2021-06-19T21:05:07

	}
	
	public static void ���糯¥_���ϱ�() {
		System.out.println("------���糯¥_���ϱ�--------");
		
		LocalDate now = LocalDate.now();
		System.out.println(now); // 2022-05-23
		
		System.out.println("------���糯¥_���ϱ�(���� ����)--------");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = now.format(formatter);
		System.out.println(formatedNow);
		
		System.out.println("------���糯¥_���ϱ�(��,��,��,����)--------");
		int year = now.getYear();
		String month = now.getMonth().toString();
		int monthValue = now.getMonthValue();
		int dayOfMonth = now.getDayOfMonth();
		int dayOfYear = now.getDayOfYear();
		String dayOfWeek = now.getDayOfWeek().toString();
		int dayOfWeekValue = now.getDayOfWeek().getValue();
		
		// ��� ���
		System.out.println(now); // 2021-06-17
		System.out.println(year); // 2021
		System.out.println(month + "(" + monthValue + ")"); // JUNE(6)
		System.out.println(dayOfMonth); // 17
		System.out.println(dayOfYear); // 168
		System.out.println(dayOfWeek + "(" + dayOfWeekValue + ")"); // THURSDAY(4)
	}
	
	public static void ����ð�_���ϱ�() {
		System.out.println("------����ð�_���ϱ�--------");
		
		LocalTime now = LocalTime.now();
		System.out.println(now); // 22:20:49.890718500
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH�� mm�� ss��");
		String formatedNow = now.format(formatter);
		System.out.println("FormatedNow : " + formatedNow); // 22�� 23�� 22��
		
		System.out.println("------����ð�_���ϱ�(��,��,��)--------");
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		System.out.printf("�ð� : %d   �� : %d   �� : %d \n", hour, minute, second);
	}
}
