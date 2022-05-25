package day21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex03_Lambda3 {

	public static void main(String[] args) {
		List<Integer>list = new ArrayList<Integer>();
		
		list.add(141);
		list.add(231);
		list.add(12);
		list.add(14);
		list.add(17);
		list.add(54);
		list.add(22);
		
		
	//1번과 2번은 똑같은 결과를 출력하지만 2번은 람다식을 통해서 간결하고 쉬운 코드를 구현할 수 있다.	
		
	/*1번*/	list.sort(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a-b;
			}
		});
		 
	/*2번*/	list.sort((Integer a, Integer b)->a-b);
		  		System.out.println(list);
		

	}

}
