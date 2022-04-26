package day2;

public class Ex3_increase {

	public static void main(String[] args) {
		/* 증감 연산자 : 최종저긍로 1증가 또는 1감수
		 *전위형 : ++변수명, 증가 후에 동작
		 *후위형 : 변수명++, 동작 후에 증가*
		 */
	 int num1 = 10, num2 = 10;
			//num1 : 전위형, num12 : 후위형
			System.out.println(num1 + " , " + num2 );
	 		System.out.println(++num1 + " , " + num2++ );
	 		System.out.println(num1 + " , " + num2 );
			
	 		int unm3 = 10, num4 = 10;
	 		//num3 : 전위형, num4 : 후위형
	 		System.out.println(num3 + " , " + num4);
	 		num3++;
	 		System.out.println(num3 + " , " + num4);
	 		num4++;
	 		System.out.println(num3 + " , " + num4);
	 		
}

}
