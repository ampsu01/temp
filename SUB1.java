package BIS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 =>
=>Ping google.com [172.217.24.206] 32바이트 데이터 사용:
=>172.217.24.206의 응답: 바이트=32 시간=60ms TTL=106
=>172.217.24.206의 응답: 바이트=32 시간=59ms TTL=106
=>172.217.24.206의 응답: 바이트=32 시간=60ms TTL=106
=>
=>172.217.24.206에 대한 Ping 통계:
=>    패킷: 보냄 = 3, 받음 = 3, 손실 = 0 (0% 손실),
=>왕복 시간(밀리초):
=>    최소 = 59ms, 최대 = 60ms, 평균 = 59ms

Exited with error code : 0 
 */

class Msg{
	String type;
	int cnt;
	
	public Msg() {
		type = "";
		cnt = 0;
	}
}

public class SUB1 extends Thread {
	static int g_Total_MsgCnt = 0;
	static int g_Num_Type = 0;
	static Msg[] gMsg = new Msg[100];

	static int index = 0; // 쓰레드 수
	static int id = -1;
	static String inputLine = "";
	static String inputType = "";
	static String inputMsg = "";
	
	public SUB1(int id, String line, String type, String msg) {
		this.inputLine = line;
		this.inputType = type;
		this.inputMsg = msg;
	}
	
	public void run(){
		convertM(inputLine, inputToken, inputMsg);
		
		/*
		Random r = new Random(System.currentTimeMillis();
		try{
			long s = r.nextInt(1000);
			Thread.sleep(s);
			setIndex();
		}catch(InterruptedException e){}
		*/
	}

	public synchronized static void setIndex(){
		index++;
	}

	public static void main(String[] args) {
		
		for(int i=0; i<100; i++)
			gMsg[i] = new Msg();
		
		textFileOpen("L_B.TXT", "R_4.TXT");		

	}
	
	public static void textFileOpen(String readFile, String writeFile) {
		String line = "";
		String writeBuff = "";
		
		try {
			FileReader fr = new FileReader(readFile);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile, false));
			
			while( (line=br.readLine())!=null ) {
				
				// LOGIC 반영
				// 2020-07-15T23:20:00#GW#MESSAGE54
				String[] token = line.split("#");
				String type = token[1];
				String msg = token[2];
				
				checkType(type);
				
				List<Thread> threadList = new ArrayList<Thread>();
				SUB1 sub = new SUB1(++g_Total_MsgCnt, line, type, msg);
				sub.start();
				threadList.add(sub);
				
				for(int i=0; i<threadList.size(); i++) {
					try {
						threadList.get(i).join();	
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			// File 쓰기 
			for(int i=0; i<g_Total_MsgCnt-1; i++) {
				writeBuff = "";
				writeBuff = gMsg[i].type + "#" + gMsg[i].cnt + "\n";
				
				bw.write(writeBuff);
				bw.flush();
			}
			
			br.close();
			bw.close();
			
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void convertM(String str, String type, String msg ) {
		String writeFile = "TLOG_4_" + type + ".TXT";
		String cmd = "./CODE " + msg;
		String writeBuff = str.substring(0, 23);
		
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile, true)); // append 모드
			
			Scanner scanner = new Scanner(br);
			scanner.useDelimiter(System.getProperty("line.separator"));
			
			while(scanner.hasNext()) {
				writeBuff += scanner.next() + "\n";
			}
			
			scanner.close();
			br.close();
			
			bw.write(writeBuff);
			bw.flush();
			bw.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void checkType(String type) {
		//g_Total_MsgCnt++;
		
		for(int i=0; i<g_Num_Type; i++) {
			if(gMsg[i].type.equals(type)) {
				gMsg[i].cnt++;
				return;
			}
		}
			
		// 첫등장한 type 인 경우 
		gMsg[g_Num_Type].type = type;
		gMsg[g_Num_Type].cnt = 1;
		g_Num_Type++;
	}
	
	public static void executeCmd() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("cmd.exe", "/c", "ping -n 3 google.com");
		
		try {
			Process process = processBuilder.start();
			
			// Blocked
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line ="";
			
			while((line=reader.readLine())!=null) {
				System.out.println("=>" + line);
			}
			
			int exitCode = process.waitFor();
			System.out.println("\nExited with error code : " + exitCode);
			
	
		} catch(InterruptedException e){
			e.printStackTrace();
		}  catch(Exception e) {
			e.printStackTrace();
		}
	}
}
