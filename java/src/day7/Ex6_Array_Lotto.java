package day7;

import java.util.Scanner;

public class Ex6_Array_Lotto {

	public static void main(String[] args) {
		
		/*1~45사이의 중복되지 않은 수 7개를 배열에 저장하는 코드를 작성하세요.*/
		
		/*
		 * */
		int lotto[] = new int[7]; //6번지가 보너스 번호
		
		for(int i = 0;i<7;i++) {
			lotto[i] = (int)(Math.random()*45)+1;
			
			//중복수가 없을려면
			for(int j = 0; j<i;j++) {
				if(lotto[i] == lotto[j]) {
					i++;
					break;
				}
			}
		}
		//로또 입력
		System.out.print("Lotto number : ");
		//로또 생성 개수 반복문
		for(int i =0; i<7;i ++) {
			System.out.print(lotto[i] + " ");
			
		}
	
		
		
		//사용자 번호 : 1~45사이의 정수 6개를 입력받아 user배열에 저장하는 코드를 작성하세요
		int user[] = new int[6];
		Scanner scan = new Scanner(System.in);
		System.out.println("로또 번호 입력 : ");
		for(int i = 0; i<user.length; i++) {
			user[i] = scan.nextInt();
		}
		
		/*로또 번호와 사용자 번호를 이용하여 등수를 출력하는 코드를 작성하세요.
		* 1등은 6개일치 ; 2등은 5개  보너스번호 일치;  3등은 5개일치 4등은 4개일치 5등은 3개일치 꽝은 그외;*/
		int count2 = 0;
		for(int i= 0; i<user.length; i++) {
			for(int j = 0; j<user.length; j++) {
				if(lotto[i]==user[j]) {
					count2++;
				}
			}
		}
		switch(count2) {
		case 6 :
				System.out.println("4등");
				break;
		case 5 :
			break;
		case 4 :
			break;
		case 3 :
			break;
		case 2 :
			break;
		case 1 :
			break;
	
		}
		
		
		
		
		scan.close();
	
	}

			





}