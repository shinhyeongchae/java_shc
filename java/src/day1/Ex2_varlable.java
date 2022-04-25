package day1;

public class Ex2_varlable 

{public static void main(String[] args) {
			
			//변수 초기화 방법1(변수 선언 및 초기화 : 선언과 초기화를 같이 하는 방법)
			//타입 변수명 = 초기값;
			//변수 초기화 방법2(변수 선언 후 초기화)
			//byte num1;
			
			byte num1 = 1; //심진수 1을 저장
			short num2 = 020; //8진수 20을 저장, 십진수로 16
			int num3 = 0x2F; //16진수 2F를 저장, 십진수로 47
			long num4 = 10L; //십진수10을 저장, long 자료형은 뒤에 L이나 1을 붙여야함
			
			System.out.println("십진수 1 : " + num1);
			System.out.println("8진수 20 : " + num2);
			System.out.println("16진수 2F : " + num3);
			//문자는 한글자를 의미.'1'은 있음. '11'은 없음. ''로 감싼다.
			//문자열은 0글자이상을 의미. ""로 감싼다. 
			char ch = 'a'; //문자a를 저장
			
			float num5 = 1.23f; //실수 1.23을 저장, float 형이면 뒤에 f나 F를 붙여야함
			double num6 = 3.14; //실수 3.14를 저장
			
			boolean isTrue = true ; //참을 저장
			
			// int nuum1;//중복선언으로 인ㄴ해 에러 발생
		   //int 1um; //첫문자가 숫자이어서 에러 발생
			//int int; //예약어(키워드) 사용하여 에러발생
			int $num7;
			$num7 = 7;
			//int %num8;//_ 또는 $가 아니기 때문에 에러 발생
			
						}

			}	
