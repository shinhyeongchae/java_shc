package day2;

public class Ex2_Arithmetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			/* 산술 연산자 주의 사항 : 나누기 할때 소수점 사라지는 현상 조심
			 *	
			 * 정수 연산자 정수 => 정수
			 * 5 + 2 = 7
			 * 5 - 2 = 3
			 * 5 * 2 = 10
			 * 5 % 2 = 1
			 * 5 / 2 = 2
			 * 정수 연산자 실수 => 실수
			 * 실수 연산자 실수 => 실수
			 * 실수 연산자 실수 => 실수
			 *  */
			 
		System.out.println(5 + 2);
		System.out.println(5 - 2);
		System.out.println(5 * 2);
		System.out.println(5 % 2);
		System.out.println(5 / 2);
		System.out.println(5 / 2.0);
		System.out.println(5 / (double)2);
		// 산술 연산자 주의 사항2 :0으로 나눈 경우가 예외가 발생 할 수있다.(정수 / 0인경우, 정수 % 0인경우)
		System.out.println(5 / 0.0);
		System.out.println(5 % 0);
		System.out.println(5 / 0);
		System.out.println("프로그램 종료");
	}

}
