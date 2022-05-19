package day15;

import java.util.Scanner;

public class Ex13_Exception_Test1 {

	public static void main(String[] args) {
		/*매우 중요한 예제*/
		/* 5개 짜리 정수배열을 선언 한후 ,
		 * 정수를 입력받아 입력받은 정수를 출력하는 코드를 작성하세요.*/
		Scanner scan = new Scanner(System.in);
		
		int max = 5;
		int arr[] = new int[max];
		
		int count = 0;
		while(count < 5) {
			try {
				
				System.out.println(count+1 + "번째 정수 입력 : ");
				arr[count] = scan.nextInt();
				count++;
			}catch(Exception e) {
				System.out.println("입력한 값이 정수가 아입니다");
				/* -문자 또는 문자열을 입력하고 엔터를 친경우
				 * 	입력버퍼에 해당 값들이 여전히 남아있어서 scan.next()로 처리를 하지 않으면 무한루프에 빠짐
				 * 	남아있는 값들을 제거해서 무한루프에 빠지지 않게 하기 위해 scan.next()로 제거*/
				scan.next(); //이친구때문에 무한루프에 빠지지않음
		}
				for(int tmp : arr) {
					System.out.println(tmp + "");
				}
		
		}
		System.out.println();
		System.out.println("프로그램 종료");
		scan.close();
		}
	}
	
