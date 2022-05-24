package 기본_API;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class 텍스트_파일_읽기 {
	// FileReader, BufferedReader, Scanner, Files

	public static void main(String[] args) throws IOException {

		File_사이즈_구하기();
		File_라인수_구하기();
		텍스트_File_마지막_라인부터_읽기();
		
		
		FileReader_예제();
		BufferedReader_예제();
		Scanner_예제();
		Files_예제();
	}
	
	public static void File_사이즈_구하기() {
		System.out.println("---------File사이즈 구하기----------");
		
		File file = new File("sample.txt");
		 long bytes = file.length();
		 long kilobyte = bytes/1024;
		 long megabyte = kilobyte/1024;
		 
		 System.out.println(bytes + "Byte");
		 System.out.println(kilobyte + "KByte");
		 System.out.println(megabyte + "MByte");
	}
	
	public static void 텍스트_File_마지막_라인부터_읽기() {
		System.out.println("---------텍스트_File_마지막_라인부터_읽기----------");
		
		try{
			// RandomAccessFile, 마지막 라인을 담을 String 
			RandomAccessFile randomAccessFile = new RandomAccessFile("text_file.txt", "r");
			StringBuilder lastLine = new StringBuilder();
			int lineCount = 3;
			
			long fileLength = randomAccessFile.length();
			
			// 포인터를 이용하여 뒤에서부터 앞으로 데이터를 읽는다 
			for(long pointer = fileLength-1; pointer>=0; pointer--) {
				// 1.포인터를 읽을 글자 앞으로 옮긴다
				randomAccessFile.seek(pointer);
				
				// 2.포인터 위치의 글자를 읽는다
				char c = (char)randomAccessFile.read();
				
				// 3.줄바꿈이 나타나면 더 이상 글자를 읽지 않는다
				if(c=='\n') {
					lineCount--;
					
					if(lineCount==0)
						break;
				}
				
				// 4.결과  문자열의 앞에 읽어온 글자를 붙여준다
				lastLine.insert(0, c);
			}
			
			System.out.println(lastLine);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void File_라인수_구하기() {
		System.out.println("---------File 라인수 구하기----------");
		
		try {
			Scanner scanner = new Scanner(new FileReader("sample.txt"));
	
			int lineCount = 0;
			while (scanner.hasNextLine()) {
				scanner.nextLine();
				lineCount++;
			}
	
			scanner.close();
	
			System.out.println("파일의 라인수는 : " + lineCount);
		}catch(IOException e) {
			e.printStackTrace();
		}

		
	}
	
	public static void FileReader_예제() throws IOException {
		System.out.println("---------FileReader_예제----------");
		
		FileReader reader = new FileReader("sample.txt");
		
		int ch;
		while( (ch=reader.read())!=-1 ) { // 한글자씩 읽기 
			System.out.print((char)ch);
		}
		
		reader.close();
	}
	
	public static void BufferedReader_예제() throws IOException {
		System.out.println("---------BufferedReader_예제----------");
			
		BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("sample.txt"), "UTF-8"));
		
		String str;
		while( (str=reader.readLine())!=null ) {
			System.out.println(str);			
		}
		reader.close();
		
		str = "";
		while( (str=reader2.readLine())!=null ) {
			System.out.println(str);			
		}
		reader2.close();
	}
	
	public static void Scanner_예제() throws IOException {
		System.out.println("--------Scanner_예제-----------");
		
		Scanner scanner = new Scanner(new File("sample.txt"));
		
		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
			System.out.println(str);
		}
	}
	
	public static void Files_예제() {
		System.out.println("----------Files_예제---------");
	}

}
