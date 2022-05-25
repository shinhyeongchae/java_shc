package day21;

public class Ex02_Lambda2 {

	public static void main(String[] args) {
		
		Test1 t1 = (int a)->{                     //매개변수가 하나인경우는 int a의 괄호와 int를 생략해도 상관없다
				System.out.println("테스트 : "+a);    
			};		//실행문이 하나라면 이줄에 있는 세미클론과 중괄호도 생략해도 상관없다.			
		t1.test(10);
			
		
		
		/*Test2 t2 = (int a, int b)->{
		 *  return a + b;*/
		
		Test2 t2 = (int a, int b)-> a+b;
		System.out.println(t2.sum(10, 20));
		
		
	}

}
@FunctionalInterface
interface Test1{
	void test(int a);
	//void test2(); //주석 해제하면 추상메소드가 2개라서 에러가 발생.
}
@FunctionalInterface
interface Test2{
	int sum(int a , int b);
	
}