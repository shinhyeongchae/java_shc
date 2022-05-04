package day8;

public class Ex8_Method6_Array {

	public static void main(String[] args) {
		/* 
		 * 기능 : 정수형 배열이 주어졌을 때, 주어진 배열의 값을 콘솔에 출력하는 코드
		 * 매개변수 : 정수형 배열 =>int num[]
		 * 리턴타입 : 없데 리턴타입이 알려줄필요가없데~
		 * 메소드명 : printArray
		 * */
		int arr[] = {1,2,3,4,5,6};
		int num = 4;
		printArray(arr);
		System.out.println(cotains(arr,num));
		System.out.println(cotains(arr,7,num));
		
		
	}
	
	public static void printArray(int num[]) {
		if(num == null || num.length ==0) {
			System.out.println("출력할 배열이 없습니다.");
			return;
		}
		for(int i = 0; i< num.length;i++) {
			System.out.print(num[i] + " ");
			
		}
			System.out.println();
	
	}
	/*기능 :  정수형 배열에 정수 num가 있는지 없는지 알려주는 메소드
	 *{1,2,3,4,5}에 6이 있는지 없는지 확인하여 있다 없다를 알려주는 메소드
	 *매개변수 : 정수형 배열, 정수 num =>int arr[], int  num 
	 *리턴타입 : 해당 숫자가 있는지 없는지 => boolean
	 *메소드명 : contains*/
	public static boolean cotains(int arr[],int num) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		int count = 0;
		for(int tmp : arr) {
			if(tmp == num) {
				return true;
				}
		  }
		return false;
	 }	
	/*기능 :  정수형 배열에서 처음부터 n개중에서 정수 num가 있는지 없는지 알려주는 메소드
	 *매개변수 :  정수형 배열, 정수n , 정수 num => int arr[n], int num, 
	 *리턴타입 :  해당 num가 있는지 없는지를 알려줘야하기때문에 위처럼 boolean을 사용하여야한다.
	 * 	*메소드명 : contains*/
	
	public static boolean cotains(int arr[],int n,int num) {
		//배열이 잘못되거나 비교 갯수가 잘못되서 비교할 필요가 없는 경우
		if(arr == null || arr.length == n || n<=0 )  {
			return false;
		}
	 if(arr.length < n) {
		 n = arr.length;
	 }
	 for(int i = 0; i<n;i++) {
		 if(arr[i] == num) {
			 return true;
			 
				 }
	 }
	 	return false;
	}
				
}		
		

