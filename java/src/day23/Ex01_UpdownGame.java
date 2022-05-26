package day23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_UpdownGame {

	public static void main(String[] args) {
		/* - 1~100사이의 랜덤한 수를 맞추는 Up Down 게임 프로그램을 작성하세요.
		 * - 기록을 저장하는 기능을 추가
		 * - 기록은 최대 5등까지
		 * - 5등이내의 기록은 이름을 기록하여 저장
		 * 	1.플레이
		 * 	2.기록확인
		 * 	3.종료*/
		Scanner sc = new Scanner(System.in);
		int menu;
		int min=1, max=100;
		List<Record>list = new ArrayList<Record>(); //기록을 담을 리스트를 만듬
		list.add(new Record(1, "일길동"));
		list.add(new Record(7, "이길동"));
		list.add(new Record(8, "삼길동")); //샘플
		list.add(new Record(9, "사길동"));
			do {
			System.out.println("메뉴");
			System.out.println("1.플레이");
			System.out.println("2.기록확인");
			System.out.println("3.종료");
			System.out.print("4.메뉴 선택 : ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1://플레이
				//랜덤한수 생성
				int r = (int)(Math.random()*(max-min+1)+min);
				int count = 0;
					System.out.println("1~100사이의 랜덤한수 : "+r);
					//맞출때까지 반복문을 통해 반복
				while(true) {
					System.out.print("1~100사이의 수를 입력하세요 : ");
					int num = sc.nextInt();
					count++;   //여기에 count++; 하는 이유는 console창에 결과가 출력될때 몇번만에 정답을 맞췄는지 카운트를 증가시켜줌
					//1미만 100초과인경우 
					if(num < 1 || num > 100) {
						System.out.println("범위가 아닙니다");
					}
					//입력받은 num가 랜덤한수 r과 같으면 정답
					if(num==r) {
						System.out.println("정답");
						break;
					}else if(num>r) {
						System.out.println("down");
					}else {
						System.out.println("up");
					} 
				}//기록을 어떻게 관리하는지 !?
				int i;
				for(i = 1; i<list.size();i++) {
					if(list.get(i).getCount() > count) {
						break;
					}
				}
				//list.size() < 5 : 저장된 기록이 5개 미만
				//i < list.size() : 저장된 기록이 5개 이상 중에 지금 플레이한 횟수가 등수에 포함될 때
				//위에서 break가 동작하면 i는 list.size()보다 작고 
				//break가 동작 하지않으면 i는 list.size()가 된다
				if(list.size() < 5 || i < list.size()) {
					System.out.println("새로운 기록이 달성됐습니다. 기록을 저장하세요.");
					System.out.println("이름 : ");
					
					list.add(i, new Record(count, sc.next()));
					list = list.subList(0, list.size() > 5 ? 5: list.size());
					//list.remove(5); //마지막 번짓수를 지우는역할
				}
				break;
			case 2://기록확인
				for(int j = 0; j<list.size(); j ++) {
					System.out.println(j+1+"."+list.get(j));
				}
				break;
			case 3://종료
				System.out.println("프로그램이 종료됩니다.");
				break;
			default :		
			}
		}while(menu != 3);
		sc.close();
	}
}
class Record{
	private int count;
	String name;
	
	public Record(int count, String name) {
		this.count = count;
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	@Override
	public String toString() {
		return "[" + name + " : " + count + "]";
	}
}
