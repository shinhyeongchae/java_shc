package day11;
/*학생 클래스를 작성하세요.
 * -필드 : 이름,학년,반,번호,국어,영어,수학 성적
 * -기능 : 
 *     -학생 정보를 출력하는 기능
 *     -학년, 반 , 번호가 주어졌을 때 일치하는지 확인하는 기능
 *     -주어진 이름, 국어, 영어, 수학점수로 수정하는 기능
 *     -생성자  : 이름, 학년, 반 , 번호, 국어, 영어, 수학, 성적이 주어졌을 때 초기화하는 생성자*/
public class Ex6_Student {
	private String name;
	private int grade,classnum,num;
	private double kor, eng, math;//정수로 할지 실수로 할지 타입을  고민해서 해야함.
	
	public void print() {
		System.out.println("========================");
		System.out.println(grade + "학년" + classnum + "반"+ num + "번"+name);
		System.out.println("국어 : " + kor + "영어 :"+eng+"수학 : " +math);
		System.out.println("========================");
	}
	/*기능
	 * 학년, 반 , 번호가 주어졌을 때 일치하는지 확인하는 기능
	 * 매개변수 : 학년, 반, 번호=> int grade, int classnum, int num
	 * 리턴타입 : 일치여부  boolean
	 * 메소드명 : equal*/
	public boolean equal(int grade, int classnum, int num) {
		if(this.grade !=grade) {
			return false;
		}
		if(this.classnum!=classnum) {
			return false;
		}
		if(this.num != num) {
			return false;
		}
		return true;
		
}

/*기능 ㅣ 주어진 이름 국어 영어 수학 점수로 수정하는 메소드
 * 매개변수 이름 국어 영어 수학 =>double  kor, double eng , double math
 * 리턴타입 ; 없음 void
 * 메소드명 ; modify*/
	public void modify(String name,double kor, double eng, double math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
	}
	//우클릭 > source > generate constructor using fieldes
	public Ex6_Student(String name, int grade, int classnum, int num, double kor, double eng, double math) {
		this.name = name;
		this.grade = grade;
		this.classnum = classnum;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
}