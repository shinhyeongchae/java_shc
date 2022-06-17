package db;

public class StudentVo {
	private String st_num;
	private String St_name;
	private String st_pr_num;
	public String getSt_num() {
		return st_num;
	}
	//getter 와 setter
	public String getSt_name() {
		return St_name;
	}
	public String getSt_pr_num() {
		return st_pr_num;
	}
	public void setSt_num(String st_num) {
		this.st_num = st_num;
	}
	public void setSt_name(String st_name) {
		St_name = st_name;
	}
	public void setSt_pr_num(String st_pr_num) {
		this.st_pr_num = st_pr_num;
	}
	//toString
	@Override
	public String toString() {
		return "Student [st_num=" + st_num + ", St_name=" + St_name + ", st_pr_num=" + st_pr_num + "]";
	}
	//useFiled
	public StudentVo(String st_num, String st_name, String st_pr_num) {
		this.st_num = st_num;
		St_name = st_name;
		this.st_pr_num = st_pr_num;
	}
	
	
}
