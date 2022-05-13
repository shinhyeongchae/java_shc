package day12;

public class Ex2_Inheritance2 {

	public static void main(String[] args) {
		C c = new C();
		c.print();

	}

}
class A{
	public void print() {
		System.out.println("Hello");
	}
}
class B{
	public void print() {
		System.out.println("hi");
	}
}
/*클래스c는 클래스 A와 B를 동시에 상속받읈후없다.
 * 동시 상속이 가능하다면 클래스 C를 이용하여 생성한 객체에 print()를 호출했을때 A의 print()인지 
 * B의 print()인지 알수없다 => 그래서 동시 상속이 안됨*/
//class C extends A,B {
	class C extends A{
}
