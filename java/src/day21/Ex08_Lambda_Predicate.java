package day21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Ex08_Lambda_Predicate {

	public static void main(String[] args) {
		List<Student> list  = new ArrayList<Student>();
		list.add(new Student(1,1,1,100,90,80,"홍길동"));
		list.add(new Student(1,1,1,80,90,100,"임꺽정"));
		list.add(new Student(1,2,3,20,30,40,"제임스"));
		list.add(new Student(1,2,4,40,40,100,"파티"));
		
		

		System.out.println("1학년학생들의 평균 : " + avg(list,s->s.getGrade()==1));//230
		System.out.println("1학년1반학생들의 평균 : " + avg(list,s->s.getGrade()==1 && s.getClassNum()==1));//230
		System.out.println("1학년2반학생들의 평균 : " + avg(list,s->s.getGrade()==1 && s.getClassNum()==2));//230
		System.out.println("1학년1반1번학생의 평균 : " + avg(list,s->s.getGrade()==1 && s.getClassNum()==1 && s.getNum()==1));//230
		
	
		
	}


public static double avg(List<Student>list, Predicate<Student> function) {
	int sum = 0;
	int count = 0;
	for(int i = 0 ; i<list.size();i++) {
		Student tmp = list.get(i);
		if(function.test(tmp)) {
			count++;
			sum+=tmp.getEng() + tmp.getKor() + tmp.getMath();
		}
		
	}
	return sum/(double)(3 * count);
}
	
}