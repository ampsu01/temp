package 기본_API;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class 파일_생성_텍스트_쓰기 {

	// BufferedWriter
	// PrintWriter
	// FileOutputStream
	// Files
	// DataOutputStream

	public static void main(String[] args) throws IOException {

		BufferedWriter_예제();
		PrintWriter_예제();
		FileOutputStream_예제();
		Files_예제();
		DataOutputStream_예제();
		
	}


	
	public static void BufferedWriter_예제() {
		System.out.println("---------BufferedWriter_예제----------");
		
		try {
			File file = new File("writeFile.txt");
			
			if(!file.exists())
				file.createNewFile();
			
			// Buffer를 사용해서 File에 write할 수 있는 BufferedWriter 생성
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fw);
			
			// 파일에 쓰기
			writer.write("안녕하세요\n");
			
			writer.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void PrintWriter_예제() {
		System.out.println("----------PrintWriter_예제---------");
		
		try {
			File file = new File("writeFile2.txt");
			
			if(!file.exists())
				file.createNewFile();
			
			FileWriter fw = new FileWriter(file);
			PrintWriter writer = new PrintWriter(fw);
			
			writer.write("안녕하세요\n");
			writer.println("Nice to meet you");
			writer.print("!!");
			
			writer.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void FileOutputStream_예제() {
		System.out.println("---------FileOutputStream_예제----------");
		// byte 사용가능, 문자열을 파일에 쓸때보다는 이미지나 통신에 더 적합함 
		
		try {
			File file = new File("writeFile3.txt");
			if(!file.exists())
				file.createNewFile();
			
			FileOutputStream fos = new FileOutputStream(file);
			
			fos.write("안녕하세요".getBytes());
			
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Files_예제() {
		System.out.println("---------Files_예제----------");
	}
	
	public static void DataOutputStream_예제() {
		System.out.println("---------DataOutputStream_예제----------");
		
		try {
			File file = new File("writeFile4.txt");
			if(!file.exists())
				file.createNewFile();
			
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream(bos);
			
			dos.writeUTF("안녕하세요");
			dos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
