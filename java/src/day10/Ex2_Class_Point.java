package day10;

public class Ex2_Class_Point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Point1{
	static String dimensionaL = "이차원 " ;
	int x , y;
	public Point1(int x, int y) {
		
		x = x;
		y = y;
		//내 필드 x, y에 매개변수 x,y의 값을 저장
		this.x =x;
		this.y =y;
		//this 중복되지않게 하기위해서
		// this 는 객체 메소드와 생성자에서 사용
		//this()[생성자] 이미 만들어진 생성자를 호출하면 코드가 줄어드는 경우 사용 는 내 생성자 this [객체] 
		//활용하면 코드를 줄일수있기때문에 사용
		//this()는생성자에서 첫번째줄에서 사용
		}
	
	public Point1() {
		this(0,0);
	}
	public void print() {
			System.out.println("차원 : " + dimensionaL);
	}
}