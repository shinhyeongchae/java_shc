package day18;

public class Student implements Cloneable{
		private int grade, classNum, num;
		private String name;
		private int kor, eng, math;
		
			//수정하려고 만듬
		public void modify(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		public Student(int grade, int classNum, int num, String name, int kor, int eng, int math) {
			this.grade = grade;
			this.classNum = classNum;
			this.num = num;
			modify(name,kor,eng,math);
		}
		public Student() {} //복사기능에서 생성자가 없기때문에 여기다가 만들어줌.
		
		@Override
		public String toString() {
			return "Student [" + grade + "학년" + classNum + "반" + num + "번" + name + "] 국어 :"
					+ kor + "영어" + eng + "수학" + math;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (classNum != other.classNum)
				return false;
			if (grade != other.grade)
				return false;
			if (num != other.num)
				return false;
			return true;
		}
		
		
		//복사
		@Override
		public Student clone() { //클래스들은 다 대문자로 시작합니다. 객체들은 소문다입니다, 그러면 오타를 줄일수가 있습니다.
			try {
				Student std = (Student)super.clone();
				std.name = new String(name);//뉴스트링으로 만들면 새로운 참조변수를 만들어줌.
				return std;
			}catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
			//return std; => 할필요가없음. 도달할수없기때문에 위의 return null;이 실행되기 때문입니다.
		}

		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		public int getClassNum() {
			return classNum;
		}

		public void setClassNum(int classNum) {
			this.classNum = classNum;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}
			
				
}
		
		
		
