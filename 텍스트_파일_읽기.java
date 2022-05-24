package �⺻_API;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class �ؽ�Ʈ_����_�б� {
	// FileReader, BufferedReader, Scanner, Files

	public static void main(String[] args) throws IOException {

		File_������_���ϱ�();
		File_���μ�_���ϱ�();
		�ؽ�Ʈ_File_������_���κ���_�б�();
		
		
		FileReader_����();
		BufferedReader_����();
		Scanner_����();
		Files_����();
	}
	
	public static void File_������_���ϱ�() {
		System.out.println("---------File������ ���ϱ�----------");
		
		File file = new File("sample.txt");
		 long bytes = file.length();
		 long kilobyte = bytes/1024;
		 long megabyte = kilobyte/1024;
		 
		 System.out.println(bytes + "Byte");
		 System.out.println(kilobyte + "KByte");
		 System.out.println(megabyte + "MByte");
	}
	
	public static void �ؽ�Ʈ_File_������_���κ���_�б�() {
		System.out.println("---------�ؽ�Ʈ_File_������_���κ���_�б�----------");
		
		try{
			// RandomAccessFile, ������ ������ ���� String 
			RandomAccessFile randomAccessFile = new RandomAccessFile("text_file.txt", "r");
			StringBuilder lastLine = new StringBuilder();
			int lineCount = 3;
			
			long fileLength = randomAccessFile.length();
			
			// �����͸� �̿��Ͽ� �ڿ������� ������ �����͸� �д´� 
			for(long pointer = fileLength-1; pointer>=0; pointer--) {
				// 1.�����͸� ���� ���� ������ �ű��
				randomAccessFile.seek(pointer);
				
				// 2.������ ��ġ�� ���ڸ� �д´�
				char c = (char)randomAccessFile.read();
				
				// 3.�ٹٲ��� ��Ÿ���� �� �̻� ���ڸ� ���� �ʴ´�
				if(c=='\n') {
					lineCount--;
					
					if(lineCount==0)
						break;
				}
				
				// 4.���  ���ڿ��� �տ� �о�� ���ڸ� �ٿ��ش�
				lastLine.insert(0, c);
			}
			
			System.out.println(lastLine);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void File_���μ�_���ϱ�() {
		System.out.println("---------File ���μ� ���ϱ�----------");
		
		try {
			Scanner scanner = new Scanner(new FileReader("sample.txt"));
	
			int lineCount = 0;
			while (scanner.hasNextLine()) {
				scanner.nextLine();
				lineCount++;
			}
	
			scanner.close();
	
			System.out.println("������ ���μ��� : " + lineCount);
		}catch(IOException e) {
			e.printStackTrace();
		}

		
	}
	
	public static void FileReader_����() throws IOException {
		System.out.println("---------FileReader_����----------");
		
		FileReader reader = new FileReader("sample.txt");
		
		int ch;
		while( (ch=reader.read())!=-1 ) { // �ѱ��ھ� �б� 
			System.out.print((char)ch);
		}
		
		reader.close();
	}
	
	public static void BufferedReader_����() throws IOException {
		System.out.println("---------BufferedReader_����----------");
			
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
	
	public static void Scanner_����() throws IOException {
		System.out.println("--------Scanner_����-----------");
		
		Scanner scanner = new Scanner(new File("sample.txt"));
		
		while(scanner.hasNextLine()) {
			String str = scanner.nextLine();
			System.out.println(str);
		}
	}
	
	public static void Files_����() {
		System.out.println("----------Files_����---------");
	}

}
