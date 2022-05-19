package day16;

public class Ex07_String_Replace {

	public static void main(String[] args) {
		
		//replace 예제
		
		String str = "I love C" ;
		System.out.println(str);
	
		str = str.replace("C", "jAVA");
		System.out.println(str);
		
		
		str = str + ". JAVA is programing languge";
		System.out.println(str);
		
		str = str.replace( "jAVA","C");
		System.out.println(str);
	}

}
