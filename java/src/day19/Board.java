package day19;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	private String type, title, content, writer;
	int num, view;
	private Date registerDate;
	

	private static int count = 0;
	//count = 등록된 게시글 개수
	
	public Board(String type, String title, String content, String writer) {
		this.type = type;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.num = ++count;
		this.registerDate = new Date();
	}
	
	public Board() {}
		
		public String getRegisterDate() {
			if(registerDate == null) {
				return null;
			}
			SimpleDateFormat foramt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return foramt.format(registerDate);
		}
		
		public void modify(String tilte, String content) {
			this.title = tilte;
			this.content = content;
		}
		
		public void detailPrint() {
			System.out.println("=================================");
			System.out.println("번호 : " + num);
			System.out.println("제목 : " + title); 
			System.out.println("작성자 : " + writer);
			System.out.println("작성일 : " + getRegisterDate());
			System.out.println("조회수 : " + view);
			System.out.println("내용 : " + content);
			System.out.println("=================================");
		}
		@Override
		public String toString() {
			DecimalFormat df = new DecimalFormat("000");
			return df.format(num) + "\t" + type + "\t" +title + "\t" + writer + "\t" + num +"\t"
				 + view + ", registerDate=" + registerDate + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)					return true;
			if (obj == null)					return false;
			if (getClass() != obj.getClass())	return false;
			Board other = (Board) obj;
			if (num != other.num)				return false;
			return true;
		}
		
	
		public void updateView() {
			view++;
		}

		public void setNum(int num2) {
			// TODO Auto-generated method stub
			
		}
		

	
}














	





