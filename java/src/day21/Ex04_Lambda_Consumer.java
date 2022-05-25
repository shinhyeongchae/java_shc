package day21;

import java.util.function.Consumer;

public class Ex04_Lambda_Consumer {

	public static void main(String[] args) {
		//Consumer는 인터페이스를 통해서 람다식을 표현한 예제
	Consumer<String>consumer = (String str)->System.out.println(str);
	consumer.accept("안녕");

	
	Point pt = new Point();
	Consumer<Point> ptConsumer = (Point pt1)->System.out.println(pt1.x + ", "+ pt1.y);
	ptConsumer.accept(pt);
	
	System.out.println(pt);
	}

}
class Point{
	int x,y;
	
	
	
	
	@Override
	public String toString() {
		return x +","+ y;
	}
}



