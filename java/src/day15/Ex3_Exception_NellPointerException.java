package day15;

public class Ex3_Exception_NellPointerException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "abc";
		System.out.println(str1.charAt(0));
		String str2 = null;
		System.out.println(str2.charAt(0));//경고 표시,예외 발생
		/*예외가 자주 발생하는 경우 1 : 메소드를 호출하는 경우 메소드에서 null 처리를 안하면 발생할수 있음*/
		/*예외가 자주 발생하는 경우 2 : 클래스를 이용하여 배열을 만드는 경우. 각 값에 객체를 생성우 기능/멤버 변수를 호출해야하는데
		 * 객체 생성을 잊고서 기능을 호출하는 경우*/
		charAt(str2,0);//경고 표시가 안뜨고, 예외 발생
		String arr[] = new String[10];
		for(String tmp : arr) {
			System.out.println(tmp.charAt(0));
		}
	}
	public static void charAt(String str,int index) {
		System.out.println(str.charAt(index));
	}

}
