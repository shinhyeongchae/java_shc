package day4;

import java.util.Scanner;

public class Ex2_For2_Score {

	public static void main(String[] args) {
		/*
		 * 세명의 국어 점수를 입력받아 총점과 평균을 구하는 코드를 작성하세요. 반복문을 이용
		 * 
		 * 반복횟수 : 3번 i 는 1부터 3까지 1씩 증가
		 * 규칙성 : 성적을 입력받고 총점에 누적
		 *  Scanner를 이용하여 정수를 입력받아 num에 저장한 후
		 *  sum 에 num를 더해서 sum에 저장
		 *  
		 * 반복	문 종료 후 : 	총점을 출력하고, 총점을 이용하여 평균을 계싼하고 , 총점을 출력
		 * 					sum을 출력하고, sum을 3으로 나누어서 avg에 저장한후, avg을 출력
		 * 
		 * */
	
	/*	Scanner scan = new Scanner(System.in);
		
		int num = 1, i;
		for(i = 1; i<=3; i++ ) {
				//성적을 입력받고 총점에 누적
		}
		
		System.out.print((""));
		int num = scan.nextInt();
		System.out.print((""));
		
		int i = scan.nextInt();
		int sum = num + num + num;
		System.out.println("세 명의 총점은" + sum + "점입니다");
		
		float avg = sum / 3.0f;
		System.out.println("세 명의 평균은" + avg + "점입니다");			
		scan.close();내가 한것
*/
		
	/*		//i 는 1부터 3까지 1씩 증가
		for(; ;) {
			//Scanner를 이용하여 정수를 입력받아 num에 저장한 후
		}
	
	//총점을 출력하고, 총점을 이용하여 평균을 계싼하고 , 총점을 출력
		  		//sum을 출력하고, sum을 3으로 나누어서 avg에 저장한후, avg을 출력
	
	*/
		
		
		int i ,num, sum=0;
		double avg;
		Scanner scan = new Scanner(System.in);
		
		//i는 1부터 3까지 1씩 증가1
		for(i=1;i<=3;i++ ) {
			System.out.println("학생" + i+ "국어 성적 : ");
			//Scaneer를 이용하여 정수를 입력받아  num에 저장한 후,
			num = scan.nextInt();
			//sum에 num를 더해서 sum에 저장
			sum = sum + num; // sum+= num;
		}
		//sum을 출력하고,  sum을 3으로 나누어서 avg에 저장한후, avg을 출력
		System.out.println("3명 학생의 국어 총점 :" +sum);
			avg = sum / (double)3;
			System.out.println( "3명 학생의 국어 평균 : " +avg);
				scan.close();
				
		
		
		
		}
		
		
		
		
			
		
		
	}
		


