package 기본_API;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class 디렉토리_관리 {

	public static void main(String[] args) {

		디렉토리_생성();
		디렉토리_생성2();

	}
	
	public static void 디렉토리_생성() {
		System.out.println("-------디렉토리 생성-----------");
		
		Path dirPath = Paths.get("./WH01");
		
		try {
			Files.createDirectory(dirPath);
			System.out.println("디렉토리가 생성되었습니다.");
			
		}catch(FileAlreadyExistsException e) {
			System.out.println("디렉토리가 이미 존재합니다.");
		}catch(NoSuchFileException e) {
			System.out.println("디렉토리 경로가 존재하지 않습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void 디렉토리_생성2() {
		System.out.println("-------디렉토리 생성2-----------");
		
		Path dirPath = Paths.get("./WH02/SUB00");
		
		try {
			// 중간경로가 존재하지 않을 경우 생성해서 최종 경로를 만듬 
			Files.createDirectories(dirPath);
			System.out.println("디렉토리가 생성되었습니다.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
