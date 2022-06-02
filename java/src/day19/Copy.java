package day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Copy {

	public static void main(String[] args) {
		//게시글 리스트 : 게시글들을 담을 공간
		List<Board>list = new ArrayList<Board>();//1
		//콘솔에서 입력받기 위한 스캐너
		Scanner scan = new Scanner(System.in);//2
		//프로그램 종료 번호
		int exitMenu = 4;//3
		//종료 메뉴를 선택할때까지  do - while문을 통해서 반복.
		//1(int menu를 설정해줘야함
		int menu;//5
		//테스트 데이터
		list.add(new Board("일반", "일반제목","내용1","홍길동"));
		list.add(new Board("일반", "제목2", "내용2", "홍길동"));
		list.add(new Board("일반", "공지 제목3", "내용3", "홍길동"));
		//게시글 등록이나 확인 수정시에 임시로 사용할 변수 또는 참조변수 
		String title, content, writer, type;
		int num, view;                       //필요한 변수들을 미리 do문 위에다가 중복되지않게 선언.
		do { //4
			//콘솔창에 메뉴 출력
			System.out.println("메뉴");
			System.out.println("1.게시글 등록");
			System.out.println("2.게시글 확인");
			System.out.println("3.게시글 수정");
			System.out.println("4.프로그램 종료");
			System.out.println("메뉴 선택 : ");                     //excute 부분
			
			//실행할 메뉴를 콘솔에서 입력 받음
			menu = scan.nextInt();//6
		//입력받은 메뉴에 맞는 기능을 실행
			switch(menu) {//7
			case 1:
				/*타입 입력
				 * 제목 입력
				 * 내용 입력
				 * 작성자 입력
				 * 게시글 생성 후 저장(리스트에 생성한 게시글을 추가*/
	
				System.out.println("게시글 정보를 입력하세요.");
				//타입 입력
				System.out.println("타입[일반,공지] : ");
				type = scan.next();
				scan.nextLine();
				
				//제목입력
				System.out.println("제목 : ");
				title = scan.nextLine();
				
				//내용입력
				System.out.println("내용 : ");
				content = scan.nextLine();
				
				//작성자 입력
				System.out.println("작성자 : ");
				writer = scan.next();   //공백없이 하기위해서 넥스트 라인대신 넥스트만!.
				
				//게시글 생성 후 저장 - 리스트에 생성상 게시글을 추가
				list.add(new Board(type,title,content,writer));
				
				break;
				//2번 메뉴를 선택 : 게시글 확인 기능을 실행
			case 2:
				//System.out.println(list);
				//전체게시글확인
				//향상된 for문
				System.out.println("번호\t타입 제목 \t 작성자 \t 작성일 \t\t 조회수");
				for(Board tmp : list) {
					System.out.println(tmp); //게시글 확인
					
				}
				//게시글 선택
				System.out.println("게시글 선택[나가기 : -1] : ");
				num = scan.nextInt();
				//게시글 상세 확인 - 게시글을 상세적으로 확인할때 ? 조회수가 증가!
				if(num >= 0 ) {
					//list에서 게시글을 가져옴(num-1번지에서) 
					Board tmp = list.get(num-1);
					//가져온 게시글의 상세 내용을 확인 : detailPrint()를 호출
					tmp.detailPrint();
					//조회수 증가
					tmp.updateView();
				/*	view = tmp.getView();
					tmp.setView(View +1);**/
				}
				break;
				//3번 메뉴를 선택 : 게시글 수정 기능을 실행
			case 3:
				//전체 게시글 확인
				System.out.println("번호\t타입 제목 \t 작성자 \t 작성일 \t\t 조회수");
				for(Board tmp : list) {
					System.out.println(tmp); //게시글 확인
				}
				//게시글 선택
				System.out.println("게시글 선택 : ");
				num = scan.nextInt();
				scan.nextLine();
				//게시글 제목 입력
				System.out.println("제목 : ");
				title = scan.nextLine();
				//게시글 내용 입력
				System.out.println("내용 : ");
				content = scan.nextLine();
				//게시글 수정
				//선택한 게시글을 가져옴 
				Board tmp = new Board();
				tmp.setNum(num);
				int index = list.indexOf(tmp);
				
				Board tmp2 = list.get(num-1);
				//가져온 게시글을 수정 : : modify를 호출
				tmp2.modify(title, content);
				//list.set(num-1,tmp); == 이렇게 해도 상관없지만 의미가 없는 코드
				//List의 set을 이용 안한 이유 : 안해도 가능하기 때문에
				//List의 get을 이용하여 객체를 가져왔을 때, 가져온 객체는 원본의 주소
				break;
			case 4:
				break;
			default : 
				
			}
		
		}while(menu != exitMenu);  //메니저에서 run부분 //5
		
		

		
		
		
		scan.close();
	}

}
