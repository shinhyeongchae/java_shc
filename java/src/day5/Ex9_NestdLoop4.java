package day5;

import java.util.Scanner;

public class Ex9_NestdLoop4 {

	public static void main(String[] args) {
		/*구구단 7단을 출력하는 코드를 작성하세요.
		 *
		 * */
		
	Scanner scan = new Scanner(System.in);
	
	for(int i=2; i<=9; i++) {
			System.out.println(i + " 단을 출력합니다. ");
	
			for(int j = 1; j <=9; j++)
					System.out.println(i + " x " + j + " = " + i*j);
	}
		/*System.out.println();
	
	    scan.close();
	    //num단 출력하는 예제
	    int num = 7;
	    for(int i = 1;i<=9;i++) {
	    	System.out.println(num + " x " + i + " = " + num * 1);
	    }
	*/
	    
	
	}
	

}
