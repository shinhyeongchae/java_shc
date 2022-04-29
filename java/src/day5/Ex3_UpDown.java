package day5;

import java.util.Scanner;

public class Ex3_UpDown {

	public static void main(String[] args) {
		/*
		 * (1~100)랜덤으로 생성한 수를 맞추는 게임을 작성하세요.
		 * 정수를 입력했을 때 입력한 정수보다 랜덤으로 생성된 수가 크면, up 작 으면 down을 표시
		 * 맞으면 맞췄습니다라고 표시
		 * 랜덤으로 생성한수 : 40
		 * down
		 * 입력 :100
		 * Down
		 * 입력 : 50
		 * down
		 * 입력 :  25
		 *  up
		 *  입력 : 40
		 *  정답입니다.
		 *  
		 *  반복횟수 : 무한대 
		 * 	규칙성 : 정수를 입력받고, 
		 * 입력받은 정수 num가 랜덤한수  r과 같으면 정답입니다. 라고 출력한 후 반복문을 빠져나가고, 
		 * 입력받은 정수 num가 랜덤한수  r과 같지 않고 r보다 크면 down이라고 출력하고, 
		 * 입력받은 정수 num가 랜덤한수  r과 같거나 크지 않으면 up이라고 출력   
		 * */

		int  min = 1, max = 100;
		int r = (int)(Math.random() * (max-min+1)+ min);
		Scanner scan = new Scanner(System.in);
		for(int i = 1; i<= 10; i++) {
			System.out.println("랜덤으로 생성한수(1~100) : " + r);
			
		while(true) {
			//정수를 입력받고, 
			System.out.println("1~100사이의 정수를 입력하세요 : "); 
			int num = scan.nextInt();
			//1미만 100초과 경우 스킵
			if(num < 1 || num > 100);
			
			// 입력받은 정수 num가 랜덤한수  r과 같으면 정답입니다. 라고 출력한 후 반복문을 빠져나가고, 
			if(num == r){
				System.out.println("정답입니다.");
				break;
				//정답입니다.라고 출력
				//반복문을 빠져나가고	
			}
			else if(num > r) {
				  System.out.println("Down");
			}
			// 입력받은 정수 num가 랜덤한수  r과 같지 않고 r보다 크면 down이라고 출력하고, 
			else {
				System.out.println("up");
			}
			// 입력받은 정수 num가 랜덤한수  r과 같거나 크지 않으면 up이라고 출력   
		}
			scan.close();
			
			
			
			
		}
		
		
		
	}

}
