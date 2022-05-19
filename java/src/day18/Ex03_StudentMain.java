package day18;

import java.util.Scanner;

public class Ex03_StudentMain {

	public static void main(String[] args) {
	/*	Student std1 = new Student(1,1,1, "홍길동" , 0,0,0);
		Student std2 = std1.clone(); // Student std2 = std1; =>은 공유하기 때문에 이와같이 콘솔창에 출력하면 같다라고 표현함.
		std1.modify("임꺽정 ", 0, 0, 0);
		System.out.println(std1);
		System.out.println(std2);
		if(std1 == std2) {
			System.out.println("같다");
			
		}else {
			System.out.println("다르다");*/
		Scanner scan = new Scanner(System.in);
		StudentManager sm = new StudentManager(scan);
		sm.run();//콘솔창에 실행하는 부분
	}
}


