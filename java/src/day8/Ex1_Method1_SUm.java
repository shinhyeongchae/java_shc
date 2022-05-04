package day8;

public class Ex1_Method1_SUm {

	public static void main(String[] args) {
		/*두 정수의 합을 알려주는 메소드를 작성해보세요.*/
	int num1 = 1, num2 =2;
	int res = sum1(num1, num2);
	System.out.println(res);// 한번 적어놓고 적은거.
	System.out.println(sum1(1,2));//바로 적은거.
	sum2(1,2);
	int res1 = sum1(1,2);
	int res2 = sum1(res1, 3);
	System.out.println(res2);
	
	}
		
		/* 기능 : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
		 * 매개변수 : 두 정수 => int num1, int num2 : 각 변수앞에 타입을 따로 써줘야함.
		 * 리턴타입 : 두 정수의 합=> 정수 => int 
		 * 메소드명 : sum
		 *                               */ 
		public static int sum1(int num1, int num2) {
			int res = num1 + num2;
			return res;
			
		}
		/*기능 : 두정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드
		 * 매개변수 : 두 정수 => int num1, int num2 : 각 변수앞에 타입을 따로 써줘야함.
		 * 리턴타입 : 없음 = void
		 * 메소드명 : sum2*/
		public static void sum2(int num1, int num2) {
			int res = num1 + num2;
			System.out.println(res);
		}
		

}
