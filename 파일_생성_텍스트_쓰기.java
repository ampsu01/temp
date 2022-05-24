package �⺻_API;

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

public class ����_����_�ؽ�Ʈ_���� {

	// BufferedWriter
	// PrintWriter
	// FileOutputStream
	// Files
	// DataOutputStream

	public static void main(String[] args) throws IOException {

		BufferedWriter_����();
		PrintWriter_����();
		FileOutputStream_����();
		Files_����();
		DataOutputStream_����();
		
	}


	
	public static void BufferedWriter_����() {
		System.out.println("---------BufferedWriter_����----------");
		
		try {
			File file = new File("writeFile.txt");
			
			if(!file.exists())
				file.createNewFile();
			
			// Buffer�� ����ؼ� File�� write�� �� �ִ� BufferedWriter ����
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fw);
			
			// ���Ͽ� ����
			writer.write("�ȳ��ϼ���\n");
			
			writer.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void PrintWriter_����() {
		System.out.println("----------PrintWriter_����---------");
		
		try {
			File file = new File("writeFile2.txt");
			
			if(!file.exists())
				file.createNewFile();
			
			FileWriter fw = new FileWriter(file);
			PrintWriter writer = new PrintWriter(fw);
			
			writer.write("�ȳ��ϼ���\n");
			writer.println("Nice to meet you");
			writer.print("!!");
			
			writer.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void FileOutputStream_����() {
		System.out.println("---------FileOutputStream_����----------");
		// byte ��밡��, ���ڿ��� ���Ͽ� �������ٴ� �̹����� ��ſ� �� ������ 
		
		try {
			File file = new File("writeFile3.txt");
			if(!file.exists())
				file.createNewFile();
			
			FileOutputStream fos = new FileOutputStream(file);
			
			fos.write("�ȳ��ϼ���".getBytes());
			
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Files_����() {
		System.out.println("---------Files_����----------");
	}
	
	public static void DataOutputStream_����() {
		System.out.println("---------DataOutputStream_����----------");
		
		try {
			File file = new File("writeFile4.txt");
			if(!file.exists())
				file.createNewFile();
			
			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream(bos);
			
			dos.writeUTF("�ȳ��ϼ���");
			dos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
