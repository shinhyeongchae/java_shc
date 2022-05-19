package day17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Ex12_Set_Lotto {

	public static void main(String[] args) {
	/*	Set를 이용하여 1~45사이의 중복되지 않은 숫자 6개를 저장하고, 출력하는 코드를 작성하세요 .*/
		
		Set<Integer>lotto = new HashSet<Integer>();
		int min =1, max = 10;	
		while (lotto.size() < 6) {
				lotto.add((int)(Math.random() * (max - min + 1 ) + min));
					
					
		  }
			 System.out.println();
			 Iterator<Integer> it = lotto.iterator();
			 while(it.hasNext()) {
				 Integer tmp = it.next();
				 System.out.println(tmp + " ");
			 }
			 
			 System.out.println();
			 /*스캐너를 이용한 정수를 6 개 입력받고, 중복되지 않은 숫자 6개를 입력할때까지 , 범위는 로또와 같음*/
			Set<Integer> user =  new HashSet<Integer>();
			Scanner scan = new Scanner(System.in);
			while(user.size() < 6) {
				
				int num = scan.nextInt();
				if(num >= min && num <= max) {
					user.add(num);
				}
			}
			System.out.println(user);
				/*로또와 user에서 일치하는 숫자의 개수를 세서 출력하세요.*/
			int count = 0;
		for(Integer tmp : lotto) {
			if(user.contains(tmp)) {
				count++;
			}
			
		}
		System.out.println(count + "개있습니다.");
	}
}

				
			
			
		
			
			
			
			
			
