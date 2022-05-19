package day17;

public class Ex02_Math {

	public static void main(String[] args) {
		/* 주어진 정수를 입력받아 소수점 둘째자리에서 반올림하는코드를 작성하세요.*/
		double pi = 3.141592;
		 System.out.println((double)Math.round(pi*10));
		//x를 곱해서 반올림
		//반올림한 값에서 x로 나눔
		 System.out.println((double)Math.round(pi*1000)/1000);
		 
		 int num = -1;
		 double pi2 = pi * Math.pow(10, num-1);
		 double pi3 = Math.round(pi2) / Math.pow(10, num-1);
		 double pi4 = Math.round(pi * Math.pow(10, num-1))/Math.pow(10, num-1);
		 System.out.println(pi3);
		 System.out.println(pi4);
	}

}
