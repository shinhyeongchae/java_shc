package day21;

import java.util.function.Supplier;

public class Ex05_Lambda_Supplier {

	public static void main(String[] args) {
		int min = 1, max = 10;
		Supplier<Integer> su = ()->(int)(Math.random()*(max - min + 1) + min); //단 min,max수정이 안된다 final이 붙었기때문
		
		for(int i = 0; i<10; i++) {
			System.out.println(su.get());
		}

	}
	public static int random(int min, int max) {
		return (int)(Math.random()*(max - min + 1) + min);
	}

}
