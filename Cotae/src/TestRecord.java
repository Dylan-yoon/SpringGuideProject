
//public class TestRecord {
//	
//}

import java.util.Objects;

public record TestRecord(long id, String content) {
	
	public static void main(String[] args) {
		
	}
	
}

record recordTypePerson(String name, int age) {
	
}

class classTypeName {
	String name;
	int age;
	
	public classTypeName(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "classTypeName [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		classTypeName other = (classTypeName) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
}