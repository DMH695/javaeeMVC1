package entity;

public class Person {
	private String pno;
	private String name;
	private String sex;
	private int age;
	private double height;
	private double weight;
	
	
	
	public Person(String pno, String name, String sex, int age, double height, double weight) {
		super();
		this.pno = pno;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Person [pno=" + pno + ", name=" + name + ", sex=" + sex + ", age=" + age + ", height=" + height
				+ ", weight=" + weight + "]";
	}
	
	
}
