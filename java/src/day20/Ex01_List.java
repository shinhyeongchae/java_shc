package day20;

import java.util.ArrayList;
import java.util.List;

public class Ex01_List {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>(); //<> 안에는 내가 관리하고싶은 클래스
						// 만약에 <> 안에 아무것도 안쓰면 Object가 자동으로 들어옴 
		Point pt = new Point();
		list.add(pt);
		list.add(new Point());
		list.add("123");
		
		list.indexOf(pt); //참조 변수를 직접 넣어줬기 때문에 리스트에 있는 객체와pt가 같은
		//객체를 직접 공유하고있기때문에 그래서 equals 를 오버라이딩을 안해도 가능
		
		for(Object tmp : list) {
			if(tmp instanceof Point) {
			Point p = (Point)tmp;
			System.out.println(p.x + "," + p.y);
		}else {
			System.out.println(tmp);
		}
	}
	/*	-indexOf, contains, containsAll, remove 등을 이용할 때 (오버라이딩)이 필요한 메소드 : 
	 * 		Point 클래스의 equals가 필요함 
	 * 	-equals를 오버라이딩을 안하면 Object의 equals가 호출이 되고, 이때 equals는 주소를 비교하고
	 * 	(같은 객체를 두 참조변수가 공유하는지를 확인)*/	
		list.indexOf(list);
	}
		

}

class Point{
	int x,y;

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}*/ //해쉬코드는 굳이 필요없음.

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}
