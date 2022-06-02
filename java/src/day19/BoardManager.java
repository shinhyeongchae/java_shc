package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day14.ConsoleProgram;

public class BoardManager implements ConsoleProgram{
		private static final char[] modifyBoard = null;
		private static Scanner scan;
		private List<Board> list;
		private int exitMenu;

	public BoardManager(Scanner scan) {
		this.scan = scan;	
		String title, content, writer, type;
		list = new ArrayList<Board>();
	}
		
	//게시글 타입, 작성자는 공백이 없는 단어를 입력하고 , 제목, 내용은, 공백이 포함된 문자열을 입력한다.
	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("========메뉴==========");
		System.out.println("1.게시물 등록(1.공지2.일반게시글)");
		System.out.println("2.게시물 확인");
		System.out.println("3.게시물 수정");
		System.out.println("4.프로그램 종료");
		System.out.println("메뉴를 선택하세요 : ");
	int menu = scan.nextInt();
		System.out.println("=====================");
	return menu;
	}//selectMenu

	
	@Override
	public void excute(int menu) {
	switch(menu) {
		case 1 :
			//게시글 등록
			Board bd = inputBoard();
			insertBoard(bd);
			list.add(bd);
			break;
		case 2 :
			//메뉴를 선택 게시글 확인기능을 실행
			// 전체 게시글을 확인
			//게시글 선택
			//게시글 상세확인
			//확인기능..?

			System.out.print(list);
			break;
		case 3 ://수정

			//게시글 수정
			//전체 게시글을 출력한 후, 수정한 게시글을 선택.
			//게시글이 선택되면 제목, 내용을 수정한다.
			//modifyBoard를 입력..?
				break;
		case 4 ://종료
			System.out.println("프로그램을 종료합니다!.");
			break;
		default : 
			System.out.println("잘못된 메뉴를 선택했습니다.");
		
	}
			
 	
	
}//excute
	private void insertBoard(Board bd) {
		
		
	}
	private Board inputBoard() {
		System.out.println("게시글 정보를 입력하세요.");
		
		System.out.println("타입[일반,공지] : ");
		String type = scan.next();
		scan.nextLine();
		
		System.out.println("제목 : ");
		String title = scan.nextLine();
		
		System.out.println("내용 : ");
		String content = scan.nextLine();
		
		System.out.println("작성자 : ");
		String writer = scan.next();  
		
		list.add(new Board(type,title,content,writer));
		return null;
	}
	
	
	
	public void modifyBoard() {
		//try문을 통한 수정
		try {
			System.out.println("수정할 게시글을 선택하세요 " + list);
			int num = scan.nextInt();
			scan.nextLine();
			System.out.println("제목을 수정 :  ");
			String title = scan.next();
			System.out.println("게시물수정 : ");
			String cotent = scan.next();
			
			Board tmp = list.get(num-1);
			
			String content = null;
		
			tmp.modify(title, content);	
			}catch(Exception e) {
				System.out.println("잘못입력했습니다.");
				scan.nextLine();
				
			return;
			
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

	public int registration(Scanner scan) {
		//??....
		return 0;
	}
		
	}
	
	
	
	
	