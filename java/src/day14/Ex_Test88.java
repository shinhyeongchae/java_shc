package day14;

import java.util.Scanner;


import day11.Ex6_Student;
public class Ex_Test88 {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int menu = -1;
		final int max = 30;
		Ex6_Student std[] = new Ex6_Student[max];
		int index = 0;	
		for(;menu !=8;) {
	
			menu = selectMenu(scan);
			int grade, classNum,num;
			double kor,eng, math; //자유롭게 다른과목도 추가 
			/*고등학교라고 가정했을때 한 학년의 반이 7개씩있고 각반당 수용가능한 인원은 25명일때
			각반당 저장할수있는 학생의 배열을 저장하고 전체학생의 배열을 저장한후 원하는 학생을 찾을수 있도록 해야함*/
			String name;
			switch(menu) {
				case 1 : 
				System.out.println("학생정보를 등록하세요(학년, 반, 번호, 이름순) : )");
					grade = scan.nextInt();
					classNum = scan.nextInt();
					num = scan.nextInt();
					name = scan.next();
					System.out.println("학생 성적을 입력하세요(국어, 영어, 수학순): ");
					kor = scan.nextDouble();
					eng = scan.nextDouble();
					math = scan.nextDouble();
				
					std[index] = new Ex6_Student(name,grade,classNum,num,kor,eng,math);
					index++;
						break;
				case 2 : // 학생 정보 수정
					System.out.println("수정하고싶은 학생의 정보를 입력하세요(학년, 반 , 번호, 이름순) : ");
					grade = scan.nextInt();
					classNum = scan.nextInt();
					num = scan.nextInt();
					name = scan.next();
					for(int i =0 ;i<index;i++) {
						name = scan.next();
						
					}
				
					break;
				case 3 : // 학생 정보 삭제
					
					
				
					
				case 4 : //학생성적추가
					
				
					break;
				case 5 : 
					System.out.println("수정하고 싶은 학생의, 학년, 반 , 번호를 입력하세요 : ");
					grade = scan.nextInt();
					classNum = scan.nextInt();
					num = scan.nextInt();
					name = scan.next();
					for(int i =0 ;i<index;i++) {
						if(std[i].equal(grade, classNum, num)) {
							System.out.println("수정할 학생의 성적을 입력하세요(이름,국어,영어,수학순또는 새로운 과목도 상관없음.): ");
							
							kor = scan.nextDouble();
							eng = scan.nextDouble();
							math = scan.nextDouble();
							//새로운 과목을 자유롭게 입력할려면? 위에는 정해진 과목이지만 자유롭게 입력할려면 어떻게 해야하나
							std[i].modify(name,kor, eng, math);
							break;
							
						}
						if(i+1 == index) {
							System.out.println("등록된 학생이 아닙니다.");
						}
					}
					
					break;
				case 6 :
					System.out.println("삭제할 학생정보를 입력하세요(학년, 반, 번호, 이름순) : )");
					grade = scan.nextInt();
					classNum = scan.nextInt();
					num = scan.nextInt();
					int delIndex = -1;
					for(int i = 0;i<index;i++) {
						if(std[i].equal(grade, classNum, num)) {
						delIndex = i;
							break;
						}
							
					}
					
					if(delIndex >=0) {
						for(int i = delIndex; i < index-1;i++) {
							std[i] = std[i+1];
						}
						index--;
					}
					else {
						System.out.println("등록된 학생이 아닙니다.");
					}
				
					break;
				case 7 :
					for(int i = 0; i< index;i++) {
						std[i].print();
					}
					break;
				case 8 :
					System.out.println("프로그램을 종료합니다............");		
					break;
				default : 
					System.out.println("메뉴를 잘못 선택했습니다.!!!!!!!!!!!!!!!!!!!!");
					break;
			}
		}
		
	}

		public static int selectMenu(Scanner scan) {
			System.out.println("--------메뉴---------");
			System.out.println("1.학생정보등록");
			System.out.println("2.학생정보수정");
			System.out.println("3.학생정보삭제");
			System.out.println("4.학생성적추가");
			System.out.println("5.학생성적수정");
			System.out.println("6.학생성적삭제");
			System.out.println("7.학생정보출력");
			System.out.println("8.프로그램 종료");
			System.out.println("메뉴를 선택 하세요 : ");
			int menu = scan.nextInt();
			System.out.println("------------------------");
			return menu;
		}
		
	}
		 