package day6;

public class Ex2_Break {

	public static void main(String[] args) {
		/**/
			
		
		int i, j;
		for(i=1 ;i<=5 ;i++) {
			for(j=1;i<=5;j++) {
				System.out.println(i + " , "+j);
				if(j==3) {
					break;//여기서 break;는 가장 가까운 반복문을 빠져나감
				}
			}
			//break를 만나면 이위치로 이동.
		}
		System.out.println("------------------------------");
		out:for(i=1 ;i<=5 ;i++) {
			for(j=1;i<=5;j++) {
				System.out.println(i + " , "+j);
				if(j==3) {
					break out;
				}
			}
		}
	}
}