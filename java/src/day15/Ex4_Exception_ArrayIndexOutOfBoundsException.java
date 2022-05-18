package day15;

public class Ex4_Exception_ArrayIndexOutOfBoundsException {

	public static void main(String[] args) {
		int arr [] = {1,2,3,4,5};
		//0번지에~ 크기 -1번지까지 해야하는데 실수로 0번지~크기 번지까지 하는경우. 가장흔하게 실수하는경우
		for(int i = 0; i<=arr.length; i++) {
			//System.out.println(arr[i]);//예외 발생
			//콘솔창에 오류가 났을때 Array가 뜬다면 배열의 문제.
		}
		//변수를 이용하여 배열을 제어하는 경우 변수의 값이 배열의 크기를 넘지 않도록 해야하는데 넘는 경우 발생할수있음.
		int num = 10;
		for(int i = 0; i<num; i++){
			System.out.println(arr[i]);
		}

	}

}
