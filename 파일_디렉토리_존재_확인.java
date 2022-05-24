package 기본_API;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class 파일_디렉토리_존재_확인 {

	public static void main(String[] args) {
		File_예제();
		Files_예제();

	}

	public static void File_예제() {
		System.out.println("---------File예제-----------");
		File file = new File("sample.txt");
		
		if(file.exists()) {
			if(file.isDirectory())
				System.out.println("디렉토리가 존재합니다.");
			else if(file.isFile()) {
				System.out.println("파일이 존재합니다.");
				
			
			}
		}
		else
			System.out.println("파일/디렉토리가 존재하지 않습니다.");
	}
	
	public static void Files_예제() {
		System.out.println("---------Files예제-----------");
		Path path = Paths.get("sample.txt");
		
		if(Files.exists(path)) {
			if(Files.isDirectory(path)) 
				System.out.println("디렉토리가 존재합니다.");
			else if(Files.isRegularFile(path)) {
				System.out.println("파일이 존재합니다.");
				
				try {
					Files.delete(path);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else
			System.out.println("파일/디렉토리가 존재하지 않습니다.");
		
		
	}
}
