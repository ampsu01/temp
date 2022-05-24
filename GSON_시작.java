package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GSON_시작 {

	// https://hianna.tistory.com/629?category=650599
	
	public static void main(String[] args) throws IOException {
		
		GSON_객체생성();
		JSON_생성();
		JSON_데이터변환();
		
		JSON_MAP변환();
		JSON_예쁘게출력();
		값이_NULL인_field의_JSON_생성();
		
		JSON_문자열_파싱();
		JSON_파일_읽기();
		JSON_파일_쓰기();
		
		JSON_파일_읽기2();
		JSON_파일_쓰기2();
	}
	
	public static void GSON_객체생성() {
		System.out.println("------GSON_객체생성-----");
		
		// new
		Gson gson1 = new Gson();
		
		// GsonBuilder
		Gson gson2 = new GsonBuilder().create();
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
		Gson gson4 = new GsonBuilder().serializeNulls().create();

	}
	
	public static void JSON_생성() {
		System.out.println("------JSON_생성-----");
		
		Gson gson = new Gson();
		
		// Json key, value 추가
		JsonObject jObj = new JsonObject();
		jObj.addProperty("name", "anna");
		jObj.addProperty("age", 1);
		
		// JsonObject를 Json 문자열로 변환
		String jsonStr = gson.toJson(jObj);
		
		// 생성된 Json 문자열 출력 
		System.out.println(jsonStr);
		
	}

	public static void JSON_데이터변환() {
		System.out.println("------JSON_데이터변환(Student클래스->Json문자열)-----");
		
		Student student = new Student(1, "Anna");
		Gson gson = new Gson();
		
		// Student객체->Json문자열
		String studentJson = gson.toJson(student, Student.class);
		
		System.out.println(studentJson);
		
		System.out.println("------JSON_데이터변환(Json문자열->Student클래스)-----");
		String jsonStr = "{\"id\":1,\"name\":\"Anna\"}";
		Gson gson2 = new Gson();

		// Json문자열->Student객체
		Student student2 = gson.fromJson(jsonStr, Student.class);
		
		System.out.println(student2);
	}
	
	public static void JSON_MAP변환() {
		System.out.println("------JSON_MAP변환-----");
		
		Map<String, String> map = new HashMap<>();
		map.put("id", "1");
		map.put("name", "Anna");
		
		// Map->Json
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		
		System.out.println(jsonStr);
		
		//---------------------------------------------
		
		String jsonStr2 = "{\"id\":\"1\",\"name\":\"Anna\"}";
		Gson gson2 = new Gson();
		
		Map<String, Object> map2 = gson.fromJson(jsonStr2, Map.class);
		
		for(Map.Entry<String, Object>entry : map2.entrySet())
			System.out.println(entry.getKey() + ":" + entry.getValue());
	}
	
	public static void JSON_예쁘게출력() {
		System.out.println("------JSON_예쁘게출력-----");
		
		Student student = new Student(1, "Anna");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String studentStr = gson.toJson(student);
		System.out.println(studentStr);
		
	}
	
	public static void 값이_NULL인_field의_JSON_생성() {
		System.out.println("------값이_NULL인_field의_JSON_생성-----");
		
		// 이름이 null인 Student 객체 
		Student student = new Student(1, null);
		
		// 1. default : 값이 null인 field는 json에 포함되지 않음 
		Gson gsonWithoutNull = new Gson();
		String studentJson = gsonWithoutNull.toJson(student);
		System.out.println(studentJson); // {"id":1}

		// 2. serializeNulls 옵션사용 시, 값이 null인 field도 json에 포함됨  
		Gson gsonWithNull = new GsonBuilder().serializeNulls().create();
		String studentJsonWithNull = gsonWithNull.toJson(student);
		System.out.println(studentJsonWithNull); // {"id":1,"name":null}

	}
	
	public static void JSON_문자열_파싱() {
		System.out.println("------JSON_문자열_파싱-----");
		
		String json = "{\"id\":1,\"students\": [\"Anna\", \"Jerry\"],\"subject\":{\"name\":\"Java\",\"professor\":\"Tony\"}}";
		
		// 문자열 parsing
		JsonElement element = JsonParser.parseString(json);
		
		// element가 Object 타입인 경우 JsonObject 타입으로 변환 
		JsonObject object = element.getAsJsonObject();
		
		// id 값 확인 (primitive type)
		long id = object.get("id").getAsLong();
		System.out.println("id : " + id);
		
		// student 값 확인 (배열)
		JsonArray studentJsonArray = object.get("students").getAsJsonArray();
		for(int i=0; i<studentJsonArray.size(); i++) {
			String student = studentJsonArray.get(i).getAsString();
			System.out.println("student["+i+"] : " + student);
		}
		
		// subject 값 확인 (Object)
		JsonObject subjectJsonObject = object.get("subject").getAsJsonObject();
		String name = subjectJsonObject.get("name").getAsString();
		String professor = subjectJsonObject.get("professor").getAsString();
		
		System.out.println(name + ":" + professor);
		
	}
	
	public static void JSON_파일_읽기() throws IOException {
		System.out.println("------JSON_파일_읽기(객체)-----");
		
		Reader reader = new FileReader("lecture.json");
		
		// Json 파일 읽어서, Lecture 객체로 변환 
		Gson gson = new Gson();
		Lecture lecture = gson.fromJson(reader, Lecture.class);
		
		System.out.println(lecture);
		
	}
	
	public static void JSON_파일_쓰기() throws IOException {
		System.out.println("------JSON_파일_쓰기(객체)-----");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// Lecture Object 생성 
		Lecture lecture = new Lecture();
		
		lecture.setId(1);
		
		List<Map<String, Object>> students = new ArrayList<>();
		students.add(getStudentMap(123, "Tom"));
		students.add(getStudentMap(124, "Jerry"));
		lecture.setStudents(students);
		
		// setSubject
		Map<String, Object> subject = getSubjectMap("Java", "Anna");
		lecture.setSubject(subject);
		
		// lecture 객체를 파일에 쓰기 
		FileWriter fw = new FileWriter("lecture.json");
		gson.toJson(lecture, fw);
		fw.flush();
		fw.close();
	}
	
	public static Map<String, Object> getStudentMap(long id, String name) {
		Map<String, Object> student = new HashMap<>();
		student.put("id", id);
		student.put("name", name);
		return student;
	}

	public static Map<String, Object> getSubjectMap(String name, String professor) {
		Map<String, Object> subject = new HashMap<>();
		subject.put("name", name);
		subject.put("professor", professor);
		return subject;
	}

	public static void JSON_파일_읽기2() throws IOException {
		System.out.println("------JSON_파일_읽기(JsonObject)-----");
		
		Reader reader = new FileReader("lecture2.json");
		
		// Json 파일 읽어서, Lecture 객체로 변환 
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		
		System.out.println(obj);
		
	}
	
	public static void JSON_파일_쓰기2() throws IOException {
		System.out.println("------JSON_파일_쓰기(JsonObject)-----");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// Json key/value 추가 
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", 1);
		
		// students
		JsonObject stdu1 = getStudentJsonObject(123, "Tom");
		JsonObject stdu2 = getStudentJsonObject(124, "Jerry");
		JsonArray students = new JsonArray();
		students.add(stdu1);
		students.add(stdu2);
		jsonObject.add("students", students);
		
		// subject
		JsonObject subject = getSubjectJsonObject("Java", "Anna");
		jsonObject.add("subject", subject);

		FileWriter fw = new FileWriter("lecture2.json");
		gson.toJson(jsonObject, fw);
		fw.flush();
		fw.close();
		
	}
	
	public static JsonObject getStudentJsonObject(long id, String name) {
		JsonObject studentJsonObject = new JsonObject();
		studentJsonObject.addProperty("id", id);
		studentJsonObject.addProperty("name", name);
		return studentJsonObject;
	}

	public static JsonObject getSubjectJsonObject(String name, String professor) {
		JsonObject subjectJsonObject = new JsonObject();
		subjectJsonObject.addProperty("name", name);
		subjectJsonObject.addProperty("professor", professor);
		return subjectJsonObject;
	}
}

class Lecture {
	private int id;
	private List<Map<String, Object>> students;
	private Map<String, Object> subject;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Map<String, Object>> getStudents() {
		return students;
	}

	public void setStudents(List<Map<String, Object>> students) {
		this.students = students;
	}

	public Map<String, Object> getSubject() {
		return subject;
	}

	public void setSubject(Map<String, Object> subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Lecture [id=" + id + ", students=" + students + ", subject=" + subject + "]";
	}
}

class Student {
	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
