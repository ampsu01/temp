package 기본_API;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 문자열_API {

	public static void main(String[] args) {

		String s1 = new String();
		System.out.println(s1);
		
		byte[] b2 = {104, 101, 108, 108, 111};
		String s2 = new String(b2);
		System.out.println(s2);
		
		char[] c8 = {'h', 'e', 'l', 'l', 'o'};
		String s3 = new String(c8);
		System.out.println(s3);
		
		System.out.println("\n-----2차원배열 출력-------");
		int[] arr = {1, 2, 3, 4 ,5};
		int[][] arrInt = {{1, 2}, {3, 4}, {5, 6, 7}};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arrInt));
		
		// 반복문 이용
		for(int i=0; i<arrInt.length; i++) {
			for(int j=0; j<arrInt[i].length; j++) {
				System.out.print(arrInt[i][j] + "  ");
			}
			System.out.println();
		}
		
		배열원소의_합_평균_구하기();
		배열원소의_최대_최소_구하기();
		배열_거꾸로_변환();
		가변길이배열_();
	}
	
	public static void 배열원소의_합_평균_구하기() {
		
		System.out.println("\n-----배열원소의_합_평균_구하기()-------");
		double[] arr = {90.6, 80.2, 70.7};
		double sum = 0.0;
		
		for(double num : arr)
			sum+=num;
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum/arr.length);
	}
	
	public static void 배열원소의_최대_최소_구하기() {
		System.out.println("\n-----배열원소의_최대_최소_구하기()-------");
		int[] arr = {3, 2, 1, 5, 1};
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			max = max>arr[i] ? max : arr[i];
			min = min<arr[i] ? min : arr[i];
		}
		
		System.out.printf("MAX : %d, MIN : %d\n", max, min);
	}
	
	public static void 배열_거꾸로_변환() {
		System.out.println("\n-----배열 거꾸로 변환 -------");
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] reverseArr = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			reverseArr[arr.length-i-1] = arr[i];
		}
		
		System.out.println("원본 : " + Arrays.toString(arr));
		System.out.println("역순 : " + Arrays.toString(reverseArr));
		
		Integer[] arr2 = new Integer[arr.length];
		for(int i=0; i<arr.length; i++) {
			arr2[i] = Integer.valueOf(arr[i]);
		}
		
		List<Integer> list = Arrays.asList(arr2);
		Collections.reverse(list);
		Integer[] reverseInteger = list.toArray(arr2);
		System.out.println(Arrays.deepToString(reverseInteger));
		
		
		
		System.out.println("역순(리스트) : " + list);
		Collections.reverse(list);
		System.out.println("역순(리스트) : " + list);
	}
	
	public static void 가변길이배열_() {
		System.out.println("\n-----가변길이배열 -------");
		String[][] arr = new String[3][];
		arr[0] = new String[3];
		arr[1] = new String[2];
		arr[2] = new String[4];
		

		// arr길이
		System.out.println("arr길이 : " + arr.length);
		
		
		// 각 arr[i]길이 
		System.out.println("arr[0]길이 : " + arr[0].length);
		System.out.println("arr[1]길이 : " + arr[1].length);
		System.out.println("arr[2]길이 : " + arr[2].length);
		
	}

}
