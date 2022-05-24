package 기본_API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class 날짜_시간 {

	// https://hianna.tistory.com/607?category=650599
	public static void main(String[] args) throws ParseException {
		
		현재날짜_구하기();
		현재시간_구하기();
		
		문자열을_날짜로_변환하기();

	}

	public static void 문자열을_날짜로_변환하기() throws ParseException {
		System.out.println("------문자열을_날짜로_변환하기(String->Date)--------");
		
		//  문자열
		String dateStr = "2022년 05월 23일 22시 29분 07초";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		// 문자열 -> Date
		Date date = formatter.parse(dateStr);
		System.out.println(date); // Mon May 23 22:29:07 KST 2022
		
		
		System.out.println("------문자열을_날짜로_변환하기(String->LocalDateTime)--------");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		// 문자열 -> Date
		LocalDateTime date2 = LocalDateTime.parse(dateStr, formatter2);
		System.out.println(date2); // 2021-06-19T21:05:07

	}
	
	public static void 현재날짜_구하기() {
		System.out.println("------현재날짜_구하기--------");
		
		LocalDate now = LocalDate.now();
		System.out.println(now); // 2022-05-23
		
		System.out.println("------현재날짜_구하기(포맷 적용)--------");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = now.format(formatter);
		System.out.println(formatedNow);
		
		System.out.println("------현재날짜_구하기(년,월,일,요일)--------");
		int year = now.getYear();
		String month = now.getMonth().toString();
		int monthValue = now.getMonthValue();
		int dayOfMonth = now.getDayOfMonth();
		int dayOfYear = now.getDayOfYear();
		String dayOfWeek = now.getDayOfWeek().toString();
		int dayOfWeekValue = now.getDayOfWeek().getValue();
		
		// 결과 출력
		System.out.println(now); // 2021-06-17
		System.out.println(year); // 2021
		System.out.println(month + "(" + monthValue + ")"); // JUNE(6)
		System.out.println(dayOfMonth); // 17
		System.out.println(dayOfYear); // 168
		System.out.println(dayOfWeek + "(" + dayOfWeekValue + ")"); // THURSDAY(4)
	}
	
	public static void 현재시간_구하기() {
		System.out.println("------현재시간_구하기--------");
		
		LocalTime now = LocalTime.now();
		System.out.println(now); // 22:20:49.890718500
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		String formatedNow = now.format(formatter);
		System.out.println("FormatedNow : " + formatedNow); // 22시 23분 22초
		
		System.out.println("------현재시간_구하기(시,분,초)--------");
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		System.out.printf("시간 : %d   분 : %d   초 : %d \n", hour, minute, second);
	}
}
