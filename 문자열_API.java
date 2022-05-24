package �⺻_API;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ���ڿ�_API {

	public static void main(String[] args) {

		String s1 = new String();
		System.out.println(s1);
		
		byte[] b2 = {104, 101, 108, 108, 111};
		String s2 = new String(b2);
		System.out.println(s2);
		
		char[] c8 = {'h', 'e', 'l', 'l', 'o'};
		String s3 = new String(c8);
		System.out.println(s3);
		
		System.out.println("\n-----2�����迭 ���-------");
		int[] arr = {1, 2, 3, 4 ,5};
		int[][] arrInt = {{1, 2}, {3, 4}, {5, 6, 7}};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arrInt));
		
		// �ݺ��� �̿�
		for(int i=0; i<arrInt.length; i++) {
			for(int j=0; j<arrInt[i].length; j++) {
				System.out.print(arrInt[i][j] + "  ");
			}
			System.out.println();
		}
		
		�迭������_��_���_���ϱ�();
		�迭������_�ִ�_�ּ�_���ϱ�();
		�迭_�Ųٷ�_��ȯ();
		�������̹迭_();
	}
	
	public static void �迭������_��_���_���ϱ�() {
		
		System.out.println("\n-----�迭������_��_���_���ϱ�()-------");
		double[] arr = {90.6, 80.2, 70.7};
		double sum = 0.0;
		
		for(double num : arr)
			sum+=num;
		
		System.out.println("�հ� : " + sum);
		System.out.println("��� : " + sum/arr.length);
	}
	
	public static void �迭������_�ִ�_�ּ�_���ϱ�() {
		System.out.println("\n-----�迭������_�ִ�_�ּ�_���ϱ�()-------");
		int[] arr = {3, 2, 1, 5, 1};
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			max = max>arr[i] ? max : arr[i];
			min = min<arr[i] ? min : arr[i];
		}
		
		System.out.printf("MAX : %d, MIN : %d\n", max, min);
	}
	
	public static void �迭_�Ųٷ�_��ȯ() {
		System.out.println("\n-----�迭 �Ųٷ� ��ȯ -------");
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] reverseArr = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			reverseArr[arr.length-i-1] = arr[i];
		}
		
		System.out.println("���� : " + Arrays.toString(arr));
		System.out.println("���� : " + Arrays.toString(reverseArr));
		
		Integer[] arr2 = new Integer[arr.length];
		for(int i=0; i<arr.length; i++) {
			arr2[i] = Integer.valueOf(arr[i]);
		}
		
		List<Integer> list = Arrays.asList(arr2);
		Collections.reverse(list);
		Integer[] reverseInteger = list.toArray(arr2);
		System.out.println(Arrays.deepToString(reverseInteger));
		
		
		
		System.out.println("����(����Ʈ) : " + list);
		Collections.reverse(list);
		System.out.println("����(����Ʈ) : " + list);
	}
	
	public static void �������̹迭_() {
		System.out.println("\n-----�������̹迭 -------");
		String[][] arr = new String[3][];
		arr[0] = new String[3];
		arr[1] = new String[2];
		arr[2] = new String[4];
		

		// arr����
		System.out.println("arr���� : " + arr.length);
		
		
		// �� arr[i]���� 
		System.out.println("arr[0]���� : " + arr[0].length);
		System.out.println("arr[1]���� : " + arr[1].length);
		System.out.println("arr[2]���� : " + arr[2].length);
		
	}

}
