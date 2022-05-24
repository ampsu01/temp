package �⺻_API;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ����_���丮_����_Ȯ�� {

	public static void main(String[] args) {
		File_����();
		Files_����();

	}

	public static void File_����() {
		System.out.println("---------File����-----------");
		File file = new File("sample.txt");
		
		if(file.exists()) {
			if(file.isDirectory())
				System.out.println("���丮�� �����մϴ�.");
			else if(file.isFile()) {
				System.out.println("������ �����մϴ�.");
				
			
			}
		}
		else
			System.out.println("����/���丮�� �������� �ʽ��ϴ�.");
	}
	
	public static void Files_����() {
		System.out.println("---------Files����-----------");
		Path path = Paths.get("sample.txt");
		
		if(Files.exists(path)) {
			if(Files.isDirectory(path)) 
				System.out.println("���丮�� �����մϴ�.");
			else if(Files.isRegularFile(path)) {
				System.out.println("������ �����մϴ�.");
				
				try {
					Files.delete(path);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
			System.out.println("����/���丮�� �������� �ʽ��ϴ�.");
		
		
	}
}
