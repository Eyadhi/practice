package serialize;

import java.io.Serializable;

class Student implements Serializable {
	
	private static final long serialVersionUID=1L;
	private String name;
	private int age;
	private String address;
	
	public Student(String name,int age,String address) {
		this.name=name;
		this.age=age;
		this.address=address;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return ("Student name is "+this.getName()+
				", age is "+this.getAge()+
				" and address is "+this.getAddress());
	}

}
