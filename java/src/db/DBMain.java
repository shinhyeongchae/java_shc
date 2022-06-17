package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DBMain {
	Connection con;
	public static void main(String[] args) {
		Connection con = null;
		connect(con);
		DBDao dbDao = new DBDao();
		List<StudentVo> list = dbDao.selectStudent();
		Scanner scan = new Scanner(System.in);
		
		/*
		//insert를 이용한 예제
		System.out.println("추가 학생 학번 : ");
		String st_num = scan.next();
		System.out.println("추가 학생 이름 : ");
		String st_name = scan.next();
		System.out.println("추가 학생 지도교수 번호 : ");
		String st_pr_num = scan.next();
		*/
		
		/*
		if(dbDao.insertStudent(st_num, st_name, st_pr_num) == 1) {
			System.out.println("추가에 성공했습니다.");
			
		}else {
			System.out.println("추가에 실패했습니다.");
		}
		*/
		System.out.println("수정 학생 학번 : ");
		String st_num = scan.next();
		System.out.println("수정 학생 이름 : ");
		String st_name = scan.next();
		if(dbDao.updateStudentName(st_num, st_name) == 1) {
			System.out.println("수정에 성공했습니다.");
		}else {
			System.out.println("수정에 실패했습니다.");
		}
		scan.close();
	}
	public static void connect(Connection con) {
		//String url = "jdbc:mysql://localhost:3306/데이터베이스명";
		String url = "jdbc:mysql://localhost:3306/university?serberTimeZone=Asia/Seoul";
		String user = "root"; //아이디를 모르기때문에
		String pw = "cjgreen";
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driverName); 
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("DB 연결에 성공했습니다.");
		}catch(ClassNotFoundException e) {
			//Class.forName(driveName); 에서 예외가 발생
			System.out.println(driverName + "클래스를 찾을 수 없습니다.");
		}catch(SQLException e) {
			//Class.DriveManger.getConnection(url, user, pw); 에서 예외가 발생
			//1. 없는 DB에 접근할 때 2. id/pw가 틀렸을 때
			System.out.println("DB 연결에 실패했습니다.");
		}catch(Exception e) {
			
		}
	}
}

