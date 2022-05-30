package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day14.ConsoleProgram;

public class PhoneBookManager implements ConsoleProgram{
	/*PhoneBookMain -> PhoneBookManager -> PhoneBook순으로 만듦*/
	private Scanner scan;
	private int exitMenu = 4;
	private List<PhoneBook> list = new ArrayList<PhoneBook>();
	
	public PhoneBookManager(Scanner scan) {
		this.scan = scan != null? scan : new Scanner(System.in);
		if(scan != null)	
			this.scan = scan;
		else
			this.scan = new Scanner(System.in);
		list = new ArrayList<PhoneBook>();
	}
	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("1.전화번호 추가");
		System.out.println("2.전화번호 입력");
		System.out.println("3.전화번호 검색");
		System.out.println("4.프로그램 종료");
		System.out.println("메뉴 선택 : ");
		return scan.nextInt();
	}
	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1 :
			insertPhoneBook();
			break;
		case 2 :
			printPhoneBook();
			break;
		case 3 :
			searchPhoneBook();
			break;
		case 4 :
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 메뉴입니다");
		}
	}
	@Override
	public void run() {
		int menu;
		do {
			menu = selectMenu(scan);
				excute(menu);
		}while(menu != exitMenu);
	}
	private void insertPhoneBook() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("번호 : ");
		String number = scan.next();
		list.add(new PhoneBook(name,number));
		
	}
	private void printPhoneBook() {
		for(PhoneBook tmp : list) {
			System.out.println(tmp);//여기까지가 2번메뉴
		}
	}
	private void searchPhoneBook() { //3번메뉴
		System.out.println();
		String name = scan.next();
		for(PhoneBook tmp : list) {
			if(tmp.getName().contains(name)) {
				System.out.println(tmp);
			}
		}
	}
}
	
	
