package day8;

public class Ex7_Methood5_Overloading {

	public static void main(String[] args) {
		System.out.println(sum(1,2));
		System.out.println(sum(1.2,1.3));
		System.out.println(sum(1.2f,2.3));
		System.out.println(sum(1.2,3));
		/*System.out.println(1);
		System.out.println('1'); // 3개다 각각 다른 메소드
		System.out.println("1");*/
		//메소드 오버로딩!
	}
	public static int sum(int num1, int num2) {
		return num1 + num2;
		
				
	}
	public static double  sum(double num1,double num2) {
		return num1 + num2;
	}
}
