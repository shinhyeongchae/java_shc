package day21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Ex07_Function {

	public static void main(String[] args) {
		List<Student> list  = new ArrayList<Student>();
		list.add(new Student(1,1,1,100,90,80,"홍길동"));
		list.add(new Student(1,1,1,20,50,40,"임꺽정"));
		list.add(new Student(1,1,1,90,80,70,"제임스"));
		list.add(new Student(1,1,1,20,50,40,"파티"));
		
		BiFunction<Student, String, Integer> f = (Student std, String subject)->{
			if(subject.equals("국어")) return std.getKor();
			if(subject.equals("영어")) return std.getEng();
			if(subject.equals("수학")) return std.getMath();	
				
			return 0;
			
		};
			System.out.println("학생들의 국어 총점 : " + sum(list, "국어", f));//230
			System.out.println("학생들의 영어 총점 : " + sum(list, "영어", f));//270
			System.out.println("학생들의 수학 총점 : " + sum(list, "수학", f));//230
	}
	public static int sum(List<Student>list, String subject ,BiFunction<Student,String ,
			Integer> function) {
		int sum = 0;
		for(int i = 0 ; i<list.size();i++) {
			sum += function.apply(list.get(i),subject);
			
		}
		return sum;
	}

}
class Student{
	private int grade, classNum,num,kor,eng,math;
	private String name;
	
	
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", kor=" + kor + ", eng=" + eng
				+ ", math=" + math + ", name=" + name + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (eng != other.eng)
			return false;
		if (grade != other.grade)
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	public Student(int grade, int classNum, int num, int kor, int eng, int math, String name) {
		super();
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public int getNum() {
		return num;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public String getName() {
		return name;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
