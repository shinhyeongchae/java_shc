package day1;

public class Ex6_char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}  /* 문자 '' 안에 들어가는 한글자
	  	예외 :p .34 */
	
		char ch1 = '\t'; //tab키 만큼 공백
		char ch2 = '\n'; //엔터
		char ch3 = '\r'; //커서를 앞으로 이동
		char ch4 = '\"'; //"문자
		char ch5 = '\\'; // 문자
		char ch6 = '\\'; // /문자
		
		
		
		int num = 65;
		char ch9 = (char)num;
		System.out     .println(ch9);
		ch9 = (char)(num+1);
		System.out.println(ch9);
		
}
}