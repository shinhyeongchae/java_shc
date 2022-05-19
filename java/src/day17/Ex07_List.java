package day17;

import java.util.*;

public class Ex07_List {

		
	public static void main(String[] args) {
		ArrayList<Integer> list1= new ArrayList<Integer>();	
		Vector<Integer>list2 = new Vector<Integer>();
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		
		
		list1.add(10);
		list1.add(20);
		list1.add(0,30);
		list1.add(20);
		list4.addAll(list1);
		list1.set( 0, 3);
		
		
		System.out.println("list1" +list1);
		System.out.println("list의 0번지 값 : "+list1.get(0));
		System.out.println("list4 : " + list4);
		System.out.println("list1에 30이 있는가? : " + list1.contains(30));
		System.out.println("list1에 10 있는가 ? : "+ list1.indexOf(10)+"번지");
		System.out.println("list1에 있는 원소 개수 : " + list1.size()+"개");
		System.out.println("list4: " + list4);
		Integer num = list4.remove(0);
		System.out.println("list4에서 제거한 0번지의 값 : " + num);
		System.out.println("list4 : " + list4);
		System.out.println("list4에서 제거한 20을 제거했는가 ? :" + list4.remove((Integer)20));
		System.out.println("list :" + list4);
		list4.clear();
		System.out.println("list4 : " +  list4);
		
		
		
	}
}
		
		
		
