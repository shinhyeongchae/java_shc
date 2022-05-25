package day22;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import day14.ConsoleProgram;

public class ScoreManager implements ConsoleProgram{

	private Scanner scan;
	private int exitMenu = 4;
	private List<Score> list = new ArrayList<Score>();
	
	public ScoreManager(Scanner scan) {
		if(scan == null)
			scan = new Scanner(System.in);
		this.scan = scan;
	}
	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("=====메뉴=====");
		System.out.println("1.성적추가");
		System.out.println("2.성적확인");
		System.out.println("3.성적수정");
		System.out.println("4.프로그램종료");
		System.out.println("=============");
		int menu = scan.nextInt();
		return menu;
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1 :/*1.성적추가
		 	* - 성적 추가시, 과목명, 중간성적, 기말성적, 수행평가 성적, 학년, 학기를 입력한다.
		 	* - 과목명은 국어와 같은 문자열이다.
		 	* - 기말, 중간, 수행평가는 0~100사이의 정수이다.
		 	* - 학년은 1~3사이의 정수, 학기는 1~2사이의 정수
		 	* - 입력된 성적 정보가 이미 있으면 ㅁ추가하지 않고 없으면 입력된 성적 정보를 성적리스트에 추가한다.
		 	* - 입력된 성적정보가 있는지 여부는 학년, 학기 , 과목이 같으면 있다고 판별한다.*/
			if(addScore())
				printMessage("성적을 추가했습니다.");
			else
				printMessage("이미 등록된 과목 성적입니다.");
			break;
		case 2 :/*2.성적확인
		 	* - 서브 메뉴를 이용하여 다양한 방식으로 성적을 확인
		 	* - 서브 메뉴는 1. 모든성적 2. 학기 성적. 3. 과목성적이 있다
		 	* - 모든 성적은 저장된 모든 성적을 출력
		 	* - 학기 성적은 학년과 학기를 입력받아 해당 학년학기에 맞는 모든 과목 성적을 출력
		 	* - 과목 성적은 과목을 입력받으면 해당 과목의 모든 학기 성적을 출력
		 	* - 각 성적은 학년, 학기, 과목, 중간, 기말, 수행평가, 총점으로 출력
		 	* - 총점은 중간 40%, 기말 50%, 수행평가 10%가 반영된 점수로 100점 만점이다*/
			printScore();
			break;
		case 3 :/*3.성적 수정
		 	* - 학년, 학기, 과목명을 입력받는다
		 	* - 입력받은 정보와 일치하는 성적이 있으면 성적을 입력받아 수정한다.*/
			break;
		case 4 : 
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("잘못된 메뉴를 선택했습니다.");
			
		}
				
	}

	private void printScore() {
		System.out.println("--------------------");
		System.out.println("성적 확인 메뉴");
		System.out.println("1.모든 성적 확인");
		System.out.println("2.학기 성적 확인");
		System.out.println("3.과목 성적 확인");
		System.out.println("--------------------");
		System.out.println("메뉴 선택 : ");
		int menu = scan.nextInt();
		switch(menu) {
		case 1:
			printScoreList(s->true); //람다식을통해서 익명객체로 만든것 
		/*	printScoreList(s->{
				return true;        == 와 같은 방법을 풀어서 쓴것.
			});*/
			break;
		case 2:
			System.out.println("학년 : ");
			int grade = scan.nextInt();
			System.out.println("학기 : ");
			int term = scan.nextInt();
			printScoreList(s->s.getGrade() == grade && s.getTerm() == term);
			break;
		case 3:
			System.out.println("과목 : ");
			String name = scan.next();
			printScoreList(s->s.getName().equals(name));
			break;
		default:
			printMessage("잘못된 메뉴를 선택했습니다.");
		}

	}
	private void printScoreList(Predicate<Score> p) {
		List<Score> tmpList = new ArrayList<Score>();
		
		for(Score tmp : list) {
			if(p.test(tmp)) {
				tmpList.add(tmp);
			}
		}
		if(tmpList.size() == 0) {
			printMessage("출력할 성적이 없습니다.");
		}else {
			System.out.println("--------------------");
			for(Score tmp : tmpList) {
				System.out.println(tmp);
			}
			System.out.println("--------------------");				
		}
	}
				
	
	
	private boolean addScore() {
		System.out.println("--------------------");
		System.out.println("추가할 학생 정보를 입력하세요.");
		
		//학년, 학기, 과목을 입력
		System.out.println("학년 : ");
		int grade = scan.nextInt();
		System.out.println("학기 : ");
		int term = scan.nextInt();
		System.out.println("과목 : ");
		String name = scan.next();
		
		//학년, 학기, 과목이 같은 성적이 성적 리스트에 있으면 있다고 알림
		Score tmp = new Score(grade, term, name);
		if(list.contains(tmp)) {
			System.out.println("--------------------");
			return false;
			
		}
		//중간, 기말, 수행평가을 입력
		System.out.println("중간 : ");
		int midterm = scan.nextInt();
		System.out.println("기말 : ");
		int finals = scan.nextInt();
		System.out.println("수행 : ");
		int pa = scan.nextInt();
		
		//성적 정보를 성적 리스트에 추가
		tmp = new Score(name, grade, term, midterm, finals, pa);
		list.add(tmp);
		return true;
		
	}
	@Override
	public void run() {
		//샘플 데이터를 추가
		list.add(new Score("국어", 1, 1, 100, 100, 90));
		list.add(new Score("국어", 2, 1, 100, 100, 90));
		list.add(new Score("영어", 1, 1, 100, 100, 90));
		list.add(new Score("수학", 1, 1, 100, 100, 90));
		int menu = -1;
		do {
			try {
				menu = selectMenu(scan);
				excute(menu);
			}catch(InputMismatchException e) {
				printMessage("올바른 값을 입력하세요.");
				scan.nextLine();
			}catch(RuntimeException e) {
				printMessage(e.getMessage());
			}catch(Exception e) {
				printMessage("예외 발생"+ e.getMessage());
			}
	
		}while(menu != exitMenu);
		
	}
	private void printMessage(String str) {
		System.out.println("--------------------");
		System.out.println(str);
		System.out.println("--------------------");
	}
	
}
		
