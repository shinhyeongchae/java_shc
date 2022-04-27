package day3;

import java.util.Scanner;

public class Ex4_If1 {

	public static void main(String[] args) {
		/*두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요.
		 * op1이  + 이면 num3 + num4 를 출력하고
		 * op1이  - 이면 num3 - num4 를 출력하고
		 * op1이  * 이면 num3 * num4 를 출력하고
		 * op1이  / 이면 num3 / num4 를 출력하고
		 * op1이  % 이면 num3 % num4 를 출력하고
		 * op1이 산술연산자가 아니면 op1은 산술연산자가 아니라고 출력
		 * 두정수와 산술연산자를 입력하세요 (예 : 1+2)) : 1+2
		 * 1+2=3
		 * */
				
		Scanner scan = new Scanner(System.in);
		System.out.println("정수와 산술연산자를 입력하세요 ");
		int num3 = scan.nextInt();
		System.out.println("정수 2을 입력하세요 : ");
		int num4 = scan.nextInt();
		System.out.println("산술 연산자를 입력하세요.");
		char op = scan.next().charAt(0);
		
		
		if(op == '+') {
			System.out.println(""+num3 + op + num4 + "=" + (num3 + num4));
		}if(op == '-') {
			System.out.println(""+num3 + op + num4 + "=" + (num3 - num4));
		}if(op == '*') {
			System.out.println(""+num3 + op + num4 + "=" + (num3 * num4));
		}if(op == '/') {
			System.out.println(""+num3 + op + num4 + "=" + (num3 / num4));
		}if(op == '%') {
		System.out.println(""+num3 + op + num4 + "=" + (num3 % num4));
		
		
		}
		
	    }

	}