package �⺻_API;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ���丮_���� {

	public static void main(String[] args) {

		���丮_����();
		���丮_����2();

	}
	
	public static void ���丮_����() {
		System.out.println("-------���丮 ����-----------");
		
		Path dirPath = Paths.get("./WH01");
		
		try {
			Files.createDirectory(dirPath);
			System.out.println("���丮�� �����Ǿ����ϴ�.");
			
		}catch(FileAlreadyExistsException e) {
			System.out.println("���丮�� �̹� �����մϴ�.");
		}catch(NoSuchFileException e) {
			System.out.println("���丮 ��ΰ� �������� �ʽ��ϴ�.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ���丮_����2() {
		System.out.println("-------���丮 ����2-----------");
		
		Path dirPath = Paths.get("./WH02/SUB00");
		
		try {
			// �߰���ΰ� �������� ���� ��� �����ؼ� ���� ��θ� ���� 
			Files.createDirectories(dirPath);
			System.out.println("���丮�� �����Ǿ����ϴ�.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
