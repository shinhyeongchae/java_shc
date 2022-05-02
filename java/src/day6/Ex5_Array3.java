package day6;

import java.util.Scanner;

public class Ex5_Array3 {

	public static void main(String[] args) {
		/*학생 3명의 국어성적을 입력 받고 총점과 평균을 구하는 코드를 작성하세요
		 * 단 학생 3명의 성적을 총점과 평균을 출력한다음 출력하세요*/

		
		/*int []arr = new int[3];
		
		
		for(int i = 0;i< arr.length;i++) {
			System.out.println("학생" + i + "국어성적 : ");
			System.out.println("점수를입력하세요 ");
		*/
		//배열 선언 : 몇개짜리 ?
		int []score = new int[3];
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		double avg = 0;
		//반복문 : 몇번 ?
		for(int i = 0; i <score.length;i++) {
			//학생의 점수를 입력
				System.out.print(i+1+"번째 학생 성적 : ");
				score[i] = scan.nextInt();
		}
		for(int i = 0; i <score.length;i++) {
			sum += score[i];
		}
		
		avg = sum / (double)score.length;
		System.out.println("학생 3명의 총점 : " + sum + "점이고, 평균은 " + avg + "점입니다");
		
		
		//반복문을 이용하여 학생점수를 출력
		for(int i =0;i<score.length;i++) {
			System.out.println(i+1+ "번째 학생 성적 : " +score[i]);
		}
		/*
		 * int []score = new int[10];
		int sum = 0;
		double avg = 0;
		
		for(int i= 1; i<score.length;i++) {
			System.out.println("학생 수를 입력하세요.");
			
		}
			for(int i = 0;i<score.length;i++) {
				score[i] = scan.nextInt();
			}
			for(int i = 0; i <score.length;i++) {
				sum += score[i];
			}avg = sum / (double)score.length;
				System.out.println("학생 10명의 총점 : " + sum + "점이고, 평균은 " + avg + "점입니다");
		
				for(int i =0;i<score.length;i++) {
					System.out.println(i+1+ "번째 학생 성적 : " +score[i]);
				}	*/
		
		scan.close();
	}

}
