package day4;

public class Ex3_For3_Alphabet {

	public static void main(String[] args) {
		/*반목문을 이용하여 a부터 z까지 출력하는 코드를 작성하세요
		 * 반복횟수 ; 26
		 * i는 0부터 26보다 작을때까지 1씩 증가*/
		//실행문 : (char)('a'+1)
		//반복문 종료후 : 없음
		
		
		/*for(int i = 65; i<=91; i++) {
			System.out.println((char)i);*/
		
		int i=0;
		for(i=0 ; i<26; i++) {
				System.out.print((char)('A'+i));
		}
		
		System.out.println();
		char j;
		
		for(j = 'a'; j <= 'z'; j++) {
			System.out.print(j);
		}
	
			int num1 = 1;
			char ch1 = 'a' + 1; //리터럴 상수1은 char타이비여서 타입변환이 발생하지 않음.
			char ch2 = (char) + num1;//num1의 1은 int타입이여서 타입변환이 발생하고, 자동타입변환이 되지않은 상황이여서 에러가 발생함.
				
	
	
	
	
	
	
	
	
	 
	}
		
	
	
	
	}
		
		
		
		
		
		
		
		
	

