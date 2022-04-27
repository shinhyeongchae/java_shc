package day3;

import java.util.Scanner;

public class Ex3_Scanner3 {

	public static void main(String[] args) {
		/*두 정수와 산술 연산자를 입력받아 출력하는 코드를 작성하세요.
		 *
		 
		 * */
		
		/*Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num1 = scan.nextint();
		int num2 = scan.nextint();
		
			
		System.out.print("문자를 입력하세요 : ");
		String str = scan.next();
		*/
		/*
		 *방법1
		 *정수1을을 입력하세요 : 1
		 * 정수2를 입력하셍요 : 2
		 * 산술 연산자를 입력하세요 : +
		 * 1+2
		 * 
		 * 방법2
		 * 두정수와 산술연산자를 입력하세요(예 : 1+2) : 1+2
		 * 1+2
		
		*/
			Scanner scan = new Scanner(System.in);
			System.out.println("정수 1을 입력하세요 : ");
			int num1 = scan.nextInt();
			System.out.println("정수 2을 입력하세요 : ");
			int num2 = scan.nextInt();
			System.out.println("산술 연산자를 입력하세요.");
			char op = scan.next().charAt(0);
			//정수 + 정수 =>정수
			//+는 유니코드표에서 십진수 43에 해당
			//문자열 + 정수 => 문자열
			System.out.println(""+num1 + op + num2);
			scan.close();
			
			
			//방법2
			System.out.println("정수와 산술연산자를 입력하세요);
			int num3 = scan.nextInt();
			System.out.println("정수 2을 입력하세요 : ");
			int num4 = scan.nextInt();
			System.out.println("산술 연산자를 입력하세요.");
			char op1 = scan.next().charAt(0);
		
	
	
	
	}
				
		
		

	}


