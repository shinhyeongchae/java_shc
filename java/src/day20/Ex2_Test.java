package day20;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Ex2_Test {

	public static void main(String[] args) {
		//파일 선언및 저장
		List<String>list = new ArrayList<String>();
		
		list.add("text.text");
		list.add("text.jpg");
		Scanner scan = new Scanner(System.in);
		//파일 리스트 선언및 저장
	
		int exitMenu = 4;
		int menu;
		int num;
		String file;
	
		do {
			System.out.println("메뉴");
			System.out.println("1.파일저장");
			System.out.println("2.파일확인");
			System.out.println("3.파일검색");
			System.out.println("4.프로그램종료");
			System.out.println("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
	
			switch(menu) {
			case 1: //파일 저장
				System.out.println("저장할 파일을 입력하세요 : ");
				list.add(new String(scan.next()));
				System.out.println("파일저장이 됬습니다.");
				break;
				
			case 2://파일확인
				for(String tmp : list) {
					System.out.println(tmp);
				}
				break;
			case 3 : //파일검색
				System.out.println("검색어 : ");
				String search = scan.next();
			
				for(String tmp : list) {
					int index = tmp.indexOf(search);
					if(index >=0 ) {
					System.out.println(tmp);
				
					Iterator<String> it = list.iterator();
				while(it.hasNext()) {
					String str = it.next();
					System.out.println(str);
				}
		}
				
				
			
				break;
				}
				
			case 4 : 
					System.out.println("프로그램이 종료됩니다.");
				break;
			case 5 :
				System.out.println("메뉴를 선택하세요 : ");
				break;
			default :
				System.out.println("잘못된 메뉴입니다");
					
			}
		}while(menu != exitMenu);
		


		scan.close();
	}
}

