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

public class GSON_���� {

	// https://hianna.tistory.com/629?category=650599
	
	public static void main(String[] args) throws IOException {
		
		GSON_��ü����();
		JSON_����();
		JSON_�����ͺ�ȯ();
		
		JSON_MAP��ȯ();
		JSON_���ڰ����();
		����_NULL��_field��_JSON_����();
		
		JSON_���ڿ�_�Ľ�();
		JSON_����_�б�();
		JSON_����_����();
		
		JSON_����_�б�2();
		JSON_����_����2();
	}
	
	public static void GSON_��ü����() {
		System.out.println("------GSON_��ü����-----");
		
		// new
		Gson gson1 = new Gson();
		
		// GsonBuilder
		Gson gson2 = new GsonBuilder().create();
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
		Gson gson4 = new GsonBuilder().serializeNulls().create();

	}
	
	public static void JSON_����() {
		System.out.println("------JSON_����-----");
		
		Gson gson = new Gson();
		
		// Json key, value �߰�
		JsonObject jObj = new JsonObject();
		jObj.addProperty("name", "anna");
		jObj.addProperty("age", 1);
		
		// JsonObject�� Json ���ڿ��� ��ȯ
		String jsonStr = gson.toJson(jObj);
		
		// ������ Json ���ڿ� ��� 
		System.out.println(jsonStr);
		
	}

	public static void JSON_�����ͺ�ȯ() {
		System.out.println("------JSON_�����ͺ�ȯ(StudentŬ����->Json���ڿ�)-----");
		
		Student student = new Student(1, "Anna");
		Gson gson = new Gson();
		
		// Student��ü->Json���ڿ�
		String studentJson = gson.toJson(student, Student.class);
		
		System.out.println(studentJson);
		
		System.out.println("------JSON_�����ͺ�ȯ(Json���ڿ�->StudentŬ����)-----");
		String jsonStr = "{\"id\":1,\"name\":\"Anna\"}";
		Gson gson2 = new Gson();

		// Json���ڿ�->Student��ü
		Student student2 = gson.fromJson(jsonStr, Student.class);
		
		System.out.println(student2);
	}
	
	public static void JSON_MAP��ȯ() {
		System.out.println("------JSON_MAP��ȯ-----");
		
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
	
	public static void JSON_���ڰ����() {
		System.out.println("------JSON_���ڰ����-----");
		
		Student student = new Student(1, "Anna");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String studentStr = gson.toJson(student);
		System.out.println(studentStr);
		
	}
	
	public static void ����_NULL��_field��_JSON_����() {
		System.out.println("------����_NULL��_field��_JSON_����-----");
		
		// �̸��� null�� Student ��ü 
		Student student = new Student(1, null);
		
		// 1. default : ���� null�� field�� json�� ���Ե��� ���� 
		Gson gsonWithoutNull = new Gson();
		String studentJson = gsonWithoutNull.toJson(student);
		System.out.println(studentJson); // {"id":1}

		// 2. serializeNulls �ɼǻ�� ��, ���� null�� field�� json�� ���Ե�  
		Gson gsonWithNull = new GsonBuilder().serializeNulls().create();
		String studentJsonWithNull = gsonWithNull.toJson(student);
		System.out.println(studentJsonWithNull); // {"id":1,"name":null}

	}
	
	public static void JSON_���ڿ�_�Ľ�() {
		System.out.println("------JSON_���ڿ�_�Ľ�-----");
		
		String json = "{\"id\":1,\"students\": [\"Anna\", \"Jerry\"],\"subject\":{\"name\":\"Java\",\"professor\":\"Tony\"}}";
		
		// ���ڿ� parsing
		JsonElement element = JsonParser.parseString(json);
		
		// element�� Object Ÿ���� ��� JsonObject Ÿ������ ��ȯ 
		JsonObject object = element.getAsJsonObject();
		
		// id �� Ȯ�� (primitive type)
		long id = object.get("id").getAsLong();
		System.out.println("id : " + id);
		
		// student �� Ȯ�� (�迭)
		JsonArray studentJsonArray = object.get("students").getAsJsonArray();
		for(int i=0; i<studentJsonArray.size(); i++) {
			String student = studentJsonArray.get(i).getAsString();
			System.out.println("student["+i+"] : " + student);
		}
		
		// subject �� Ȯ�� (Object)
		JsonObject subjectJsonObject = object.get("subject").getAsJsonObject();
		String name = subjectJsonObject.get("name").getAsString();
		String professor = subjectJsonObject.get("professor").getAsString();
		
		System.out.println(name + ":" + professor);
		
	}
	
	public static void JSON_����_�б�() throws IOException {
		System.out.println("------JSON_����_�б�(��ü)-----");
		
		Reader reader = new FileReader("lecture.json");
		
		// Json ���� �о, Lecture ��ü�� ��ȯ 
		Gson gson = new Gson();
		Lecture lecture = gson.fromJson(reader, Lecture.class);
		
		System.out.println(lecture);
		
	}
	
	public static void JSON_����_����() throws IOException {
		System.out.println("------JSON_����_����(��ü)-----");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// Lecture Object ���� 
		Lecture lecture = new Lecture();
		
		lecture.setId(1);
		
		List<Map<String, Object>> students = new ArrayList<>();
		students.add(getStudentMap(123, "Tom"));
		students.add(getStudentMap(124, "Jerry"));
		lecture.setStudents(students);
		
		// setSubject
		Map<String, Object> subject = getSubjectMap("Java", "Anna");
		lecture.setSubject(subject);
		
		// lecture ��ü�� ���Ͽ� ���� 
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

	public static void JSON_����_�б�2() throws IOException {
		System.out.println("------JSON_����_�б�(JsonObject)-----");
		
		Reader reader = new FileReader("lecture2.json");
		
		// Json ���� �о, Lecture ��ü�� ��ȯ 
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(reader, JsonObject.class);
		
		System.out.println(obj);
		
	}
	
	public static void JSON_����_����2() throws IOException {
		System.out.println("------JSON_����_����(JsonObject)-----");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// Json key/value �߰� 
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
