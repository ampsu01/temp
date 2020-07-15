
public class Person implements Comparable<Person> {
	String name;
	String phone;
	int age;
	
	public Person(String name, String phone, int age) {
		super();
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	@Override
	// 출력형태 : '이름'_'나이'_'전화번호 마지막 4자리'
	public String toString() {
		return name + "_" + age + "_" + phone.split("-")[2];
	}

	@Override
	public int compareTo(Person o) {
		// 나이 오름차순 정렬
		if(this.age > o.age) return 1;
		else if(this.age == o.age) {
			// 이름 오름차순 정렬
			if(this.name.compareTo(o.name)>0)
				return 1;
		}
		
		return -1;
	}
	
	
}
