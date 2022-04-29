package day5;

import java.util.Scanner;

public class Ex8_NestedLoop3 {

	public static void main(String[] args) {
		/*1부터 100사이의 모든 소수를 출력하는 코드를 작성하세요.*/
		 
		
		Scanner scan = new Scanner(System.in);
		int num,count,i;
		for(num=2; num<=100;num++) {
				count=0;
			for(i=2;i<num;i++)
				if(num%i==0)
					count=1;
			if(count==0)
				System.out.println(" 소수는  :  " + num);
				
		}
		       scan.close();
	}
	{
		int num = 4;
		int count = 0;
		//1부터 num사이의 num의 약수 개수
		for(int i = 1; i<=num; i++) {
				//i가 num의 약수이다 => num를 i로 나누었을 때 나머지가  0과 같다	
				if(num%i==0) {
						count++;
					}
		
		 }
		//약수의 개수를 이용하여 소수인지 판별
		if(count==2) {
			 System.out.println(num + " ");
	}
   }
}
