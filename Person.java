
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
	// ������� : '�̸�'_'����'_'��ȭ��ȣ ������ 4�ڸ�'
	public String toString() {
		return name + "_" + age + "_" + phone.split("-")[2];
	}

	@Override
	public int compareTo(Person o) {
		// ���� �������� ����
		if(this.age > o.age) return 1;
		else if(this.age == o.age) {
			// �̸� �������� ����
			if(this.name.compareTo(o.name)>0)
				return 1;
		}
		
		return -1;
	}
	
	
}
