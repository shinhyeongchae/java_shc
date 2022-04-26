package day2;

public class Ex6_Logic {

	public static void main(String[] args) {
		/* 
		 * 
		 * 
		 * 
		 * 결과 값이 참또는 거짓 => 조건식
		 */
		
		
		/*성적이 A학점인가? A학점의 기준 90점이상이고 100점이하
		score가 90점 이상이고, score가 100점 이하이다
		score가 90점이상 && score가 100점 이하
		score >= 90 && score <= 100 
		*/
			
		int score = 105;
		System.out.println(score + "점은 A학점인가?"+ (score >= 90 && score <= 100));
		/*잘못된 성적인가? 유효한 성적은 성적이 0점이상 100점이하
		 * 잘못된 성적은 성적이 0점 미만이거나 100점 초과
		 * 성적이 0점미만 || 성적이 100점 초과
		 * score  < 0 || score > 100
		 * 
		 * */
		System.out.println(score + "점은 잘못된 성적 인가?"+ (score >= 0 || score <= 100));
		 
		/*유효한 성적인가? 잘못된 성적의 반대
		 * 
		 */
		System.out.println(score + "점은 유효한 성적 인가?"+ !(score >= 0 || score <= 100));
		
	
	}

}
