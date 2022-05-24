package 기본_API;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class 파일관련_기능 {

	public static void main(String[] args) throws IOException {
		파일에서_확장자_추출();
		파일_복사하기();
		파일_이름변경();
	}

	public static void 파일에서_확장자_추출() {
		System.out.println("------파일에서_확장자_추출-------");
		
		File file = new File("sample.txt");
		
		String fileName = file.getName();
		
		// 파일명에서 가장 마지막에 오는 '.'의 index 확인 
		int index = fileName.lastIndexOf(".");
		
		// 확장자 추출
		if(index>0) {
			// 파일이름에서 '.' 이후의 문자열이 확장자임 
			String extension = fileName.substring(index+1);
			System.out.println(extension);
		}
	}
	
	public static void 파일_복사하기() throws IOException {
		System.out.println("---------파일_복사하기----------");
		
		File file = new File("text_file.txt");
		File newFile = new File("new_text_file.txt");
		
		FileInputStream input = new FileInputStream(file);
		FileOutputStream output = new FileOutputStream(newFile);
		
		// 한번에 읽고/쓰기할 버퍼 크기 설정 
		byte[] buf = new byte[1024];
		
		int readData;
		while( (readData=input.read(buf))>0) {
			output.write(buf, 0, readData);
		}
		
		input.close();
		output.close();
		
		System.out.println("---------파일_복사하기(Files.copy())----------");
		File file2 = new File("new_text_file.txt");
		File newFile2 = new File("new_text_file2.txt");

		Files.copy(file2.toPath(), newFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static void 파일_이름변경() {
		System.out.println("------파일_이름변경-------");
		
		// 원본파일
		File file = new File("sample.txt");
		
		// 새로운파일
		File newFile = new File("simple.txt");
		
		boolean result = file.renameTo(newFile);
		System.out.println(result);
	}
}
