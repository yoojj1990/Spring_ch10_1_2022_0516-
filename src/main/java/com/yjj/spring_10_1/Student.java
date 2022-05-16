package com.yjj.spring_10_1;

public class Student {

	private String name;
	private String age;
	private String gradNum; // 학년
	private String classNum; // 반
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGradNum() {
		return gradNum;
	}
	public void setGradNum(String gradNum) {
		this.gradNum = gradNum;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
	
	//핵심기능
	
	public void printStudentInfo() {
		
		
		System.out.println("이름 : " + getName());
		System.out.println("나이 : " + getAge());
		System.out.println("학년 : " + getGradNum());
		System.out.println("반 : " + getClassNum());
		
//		System.out.println(10/0); // 강제에러 발생(by zero에러) -> afterThrowong advice 발생
		
	}
	
	
	
	
	
	
	
}
