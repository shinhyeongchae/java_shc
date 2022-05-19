package day16;

import java.util.Scanner;

public class Ex3_Class_ForName {

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("java.utill.Scanner1");
			System.out.println(c);
			c = Class.forName("day12.Car");
			System.out.println(c);
			//자바 9버전 이후에 없어짐
			Scanner scan = (Scanner)c.newInstance();
			c = Class.forName("java.utill.Scanner1");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace(); 
		}

	}

}
