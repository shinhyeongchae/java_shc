package day5;

public class Ex2_Random {

	public static void main(String[] args) {
		/*0 <= math.random() < 1(실수)
		 * */
		int  min = 1, max = 10;
		int r;
		for(int i = 1; i<= 10; i++) {
			r = (int)(Math.random() * (max-min+1)+ min);
			System.out.print(r + " ");
		
		}
	}

}
