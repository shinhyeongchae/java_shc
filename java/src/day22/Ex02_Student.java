package day22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex02_Student {

	public static void main(String[] args) {
		/*학생 1명의 성적을 관리하는 프로그램을 작성하세요
		 * 1.성적 추가
		 * 2.성적 확인
		 * 3.성적 수정
		 * 4.프로그램 종료*/
		/*성적을 추가할려면 어떠한 기능을 구현할건지 ?
		 * 처음엔 do - while문 안에 switch문을 이용하는게 깔끔할거같다.
		 * 1.성적추가 : 성적을 추가하여 저장하는 기능은 list를 이용
		 *  => 성적추가시 과목명, 중간성적, 기말성적, 수행평가 성적을 입력한다.
		 *  과목명은 국어와 같은 문자열이다
		 *  기말, 중간, 수행평가는 0~100사이의 정수이다
		 *  입력된 성적 정보를 추가한다
		 * 2.성적확인 : list와 tmp를 이용하여 성적을 확인
		 * 3.성적수정 : try catch를 이용하여 잘못된 부분을 지적하고 try문 안에 반복문을 이용하여 학생의 성적을 수정한다*/
		//List<Ex02_Student>list = new ArrayList<Ex02_Student>(); list 를 이요하려고 했는데 생각해보니
			//배열을 이용하는것이 더 좋을거같다.
		Scanner scan = new Scanner(System.in);
		
		int exitMenu = 4;
		int menu;
		
		do {
			System.out.println("메뉴");
			System.out.println("1.성적추가");
			System.out.println("2.성적확인");
			System.out.println("3.성적수정");
			System.out.println("4.프로그램 종료");
			
			menu = scan.nextInt();
			switch(menu) {
			case 1: /**/
				
				break;
			case 2:
				break;
			case 3:
				break;
			case 4 :
				System.out.println("프로그램이 종료;");
				 break;
			 default :
			    System.out.println("잘못된 메뉴");
			}
			
		}while(menu != exitMenu);
		
		
		
		
		
		scan.close();
	}
	

}
