package day22;

public class Score {
/*성적과 학년 학기를 한번에 저장하기위해서 score라는 클래스를 만듬
 * 과목명 , 중간, 기말, 수행평가, 학년, 학기*/
	private String name; //필드
	private int midterm, finas, performanceAssessment, grade, term;
			/*중간고사*/	/*기말고사*/ /*수행평가*/			/*학년*/  /*학기*/
	
	
	public String getName() { /*Source -> Generate Getters and Setters..*/
		return name;
	}
	public int getMidterm() {
		return midterm;
	}
	public int getFinas() {
		return finas;
	}
	public int getPerformanceAssessment() {
		return performanceAssessment;
	}
	public int getGrade() {
		return grade;
	}
	public int getTerm() {
		return term;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMidterm(int midterm) {//중간고사
		if(midterm < 0 || midterm > 100) /*기말 중간, 수행평가는 0~100사의 정수이다 때문에 따로 기입(여기서 하지않으면 스캐너를통해서해야해서*/
			throw new RuntimeException("중간고사는 0~100사이의 정수를 입력하세요.");
		this.midterm = midterm;
	}
	public void setFinas(int finas) {//기말고사
		if(finas < 0 || finas > 100) /*기말 중간, 수행평가는 0~100사의 정수이다 때문에 따로 기입*/
			throw new RuntimeException("기말고사는 0~100사이의 정수를 입력하세요.");
		this.finas = finas;
	}
	public void setPerformanceAssessment(int performanceAssessment) {//수행평가
		if(performanceAssessment < 0 || performanceAssessment > 100) /*기말 중간, 수행평가는 0~100사의 정수이다 때문에 따로 기입*/
			throw new RuntimeException("수행평가는 0~100사이의 정수를 입력하세요.");
		this.performanceAssessment = performanceAssessment;
	}
	public void setGrade(int grade) {//학년
		if(grade < 1 || grade > 3) /*기말 중간, 수행평가는 0~100사의 정수이다 때문에 따로 기입*/
			throw new RuntimeException("학년은 1~3사이의 정수를 입력하세요");
		this.grade = grade;
	}
	public void setTerm(int term) {//학기
		if(term < 0 || term > 100) /*기말 중간, 수행평가는 0~100사의 정수이다 때문에 따로 기입*/
			throw new RuntimeException("학기는 1~2사이의 정수를 입력하세요");//Exception을 안하고 런타입으로하는이유는 throw를 입력안해도되서
		this.term = term;
	}
	//Source -> Generate Constructor using Fields...
	public Score(String name, int grade, int term, int midterm, int finas, int performanceAssessment) {
		this(grade, term, name);//this말고 Set를 쓴느이유는 ?
		setMidterm(midterm);
		setFinas(finas);
		setPerformanceAssessment(performanceAssessment);
	
	}
	public Score(int grade, int term, String name) {
		setGrade(grade);
		setTerm(term);
		this.name = name;
	}
	//Source -> Generate hashCode() and equals()...
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grade;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + term;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (grade != other.grade)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (term != other.term)
			return false;
		return true;
	}
	@Override
	public String toString() {
		double total = midterm * 0.4 + finas *0.5+performanceAssessment *0.1;
		return  grade + "학년 " + term + "학기" + name + "[중간 : "+ midterm + ", 기말 : " +finas +", 수행 : " + performanceAssessment + ", c총점 : " + total + "]";
	}
	
}
		








	
	
	
