package day4;

public class Ex7_OverFlow {

	public static void main(String[] args) {
		/*정수에서 표현범위를 넘어가는 경우 발생
		 * 
		 * 
		 * 
		 * */
		
		byte num = 127;
		//byte로 표현가능한 가장 큰 정수 127에 1을 더하면 128이 아닌 -128에 저장
		//byte는 128을 표현할수 없기 때문에
		//이러한 현상을 오버플로우라고함.
		num = (byte)(num + 1);
		System.out.println(num);
		//byte로 표현 가능한 가장 작은 정수 -128어ㅔ   1을 빼면 -129가 아닌 127이 됨.
		//언더 플러오라고 함
		num = (byte)(num - 1);
		System.out.println(num);
	
	}

}
