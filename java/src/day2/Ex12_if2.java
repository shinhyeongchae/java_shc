package day2;

public class Ex12_if2 {

	public static void main(String[] args) {
		/*num가 짝수이면 짝수라고 출력하고, 짝수가 아니면 홀수라고 출력하는 코드를 if문을 이용하여 작성해보세요
		 * */
		
		
		int num = 4;
		if(num % 2== 0) {
			 System.out.println(num + "은 짝수");
		}
		if(num % 2 != 0) {
			System.out.println(num + "는 홀수");
		}
		if(num % 2 == 0) {
			System.out.println(num + "은 짝수");
			
		}
	}

}
