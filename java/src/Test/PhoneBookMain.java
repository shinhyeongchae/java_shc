package Test;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PhoneBookManager ph = new PhoneBookManager(scan);
		ph.run();	
		scan.close();
	}
}
