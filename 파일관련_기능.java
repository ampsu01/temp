package �⺻_API;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ���ϰ���_��� {

	public static void main(String[] args) throws IOException {
		���Ͽ���_Ȯ����_����();
		����_�����ϱ�();
		����_�̸�����();
	}

	public static void ���Ͽ���_Ȯ����_����() {
		System.out.println("------���Ͽ���_Ȯ����_����-------");
		
		File file = new File("sample.txt");
		
		String fileName = file.getName();
		
		// ���ϸ��� ���� �������� ���� '.'�� index Ȯ�� 
		int index = fileName.lastIndexOf(".");
		
		// Ȯ���� ����
		if(index>0) {
			// �����̸����� '.' ������ ���ڿ��� Ȯ������ 
			String extension = fileName.substring(index+1);
			System.out.println(extension);
		}
	}
	
	public static void ����_�����ϱ�() throws IOException {
		System.out.println("---------����_�����ϱ�----------");
		
		File file = new File("text_file.txt");
		File newFile = new File("new_text_file.txt");
		
		FileInputStream input = new FileInputStream(file);
		FileOutputStream output = new FileOutputStream(newFile);
		
		// �ѹ��� �а�/������ ���� ũ�� ���� 
		byte[] buf = new byte[1024];
		
		int readData;
		while( (readData=input.read(buf))>0) {
			output.write(buf, 0, readData);
		}
		
		input.close();
		output.close();
		
		System.out.println("---------����_�����ϱ�(Files.copy())----------");
		File file2 = new File("new_text_file.txt");
		File newFile2 = new File("new_text_file2.txt");

		Files.copy(file2.toPath(), newFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static void ����_�̸�����() {
		System.out.println("------����_�̸�����-------");
		
		// ��������
		File file = new File("sample.txt");
		
		// ���ο�����
		File newFile = new File("simple.txt");
		
		boolean result = file.renameTo(newFile);
		System.out.println(result);
	}
}
