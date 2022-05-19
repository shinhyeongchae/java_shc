package day17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex10_Set_Test1 {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<10;i++) {
			int r = ((int)(Math.random()*(9-1+1)+1));
			System.out.println(r + " : " + set.add(r));
			
		}
		
		//set의 특징은 중복을 제거하는 역할을 한다, 순서는 보장하지 못한다. null도 저장할수있지만 하나의 null만 저장할수있다.
		
		System.out.println(set);
		System.out.println("1삭제 ?  "+set.remove(1));
		System.out.println(set);
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.println(tmp + " ");
			
		}
		System.out.println();
	}

}
