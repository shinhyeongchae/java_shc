package day16;

public class Ex05_String {

	public static void main(String[] args) {
		String str = "Hello world world";
		String search = "wo";
		//- indexOf()
		//    일치하는 문자열이 없으면  -1, 있으면 시작번지
		// 	  여려개 있 어서도 처음 시작하는 번지를 찾음
		//- 문자열.(검색어, 시작번지)4
		//      문자열에서 시작번지부터 검색어를 찾아 있으면 시작번지, 없으면 -1
		int index = str.indexOf(search);
		//System.out.println(index);
		if(index >= 0) {
			System.out.println(str + "문자열에 " + search + "문자열은 " + index+"번지에 있습니다");
			index = str.indexOf(search, index+1+search.length());
			if(index >= 0 ) {
				System.out.println(str + "문자열에 " + search + "문자열은 " + index+"번지에 2개있습니다");
			}else {
				System.out.println(str + "문자열에 " + search + "문자열은 1개있습니다");
			}
		}else {
			System.out.println(str + "문자열에 " + search + "문자열은 " + "없습니다");

		}
		System.out.println(str.lastIndexOf(search));
		System.out.println(str.contains(search));
	}

}
