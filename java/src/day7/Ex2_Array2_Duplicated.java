package day7;

import java.util.Scanner;

public class Ex2_Array2_Duplicated {

	public static void main(String[] args) {
		int arr[] = {1,2,3};
		/*정수 num1을 입력 받고, 입력받은 정수가 배열에 있는지 없는지 확인하는 코드를 작성하세요.*/
		Scanner scan = new Scanner(System.in);
		int num;
			System.out.print("정수를 입력하세요 : ");
		num = scan.nextInt();
		int count = 0;
		for(int i = 0; i <arr.length; i++) {
			if (arr[i] == num ) {
				count++;
			}
		}
		if(count >=1) {
			System.out.println("배열 arr에는 "+ num +" 가 있습니다.");
		}else {
			System.out.println("배열 arr에는 "+ num +" 가 없습니다.");
		}
		
		int i;
		for(i = 0; i<arr.length; i++) {
			if(arr[i]==num) {
				break;
			}
		}
		if(i<arr.length) {
			System.out.println("배열 arr에는 "+ num +" 가 있습니다.");
		}else {
			System.out.println("배열 arr에는 "+ num +" 가 없습니다.");
		}
		
		
		//반복문에서 break를 만나면 i를 3보다 작고, break를 안만나면 i는 3인 특성을 이용.
		
		
		
		
		
		System.out.println(arr);
		double arr2[] = new double[2];
		System.out.println(arr2);
		scan.close();
		
	}
	
	
	

}
