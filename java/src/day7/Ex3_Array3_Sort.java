package day7;

public class Ex3_Array3_Sort {

	public static void main(String[] args) {
		/*버블 정렬을 이용한 배열 정렬 예제*/
		int arr[] = {10,15,5,18,20,1};
		
		for(int i = 0;i<arr.length-1;i++) {
			//i 가 0 일때 j는 4까지 , i가 1일때 j는 3까지, j는 2일 때 i는 2까지
			for(int j = 0; j<arr.length-1-i; j ++) {
				//앞 숫자가 크면 두수 교환
				if(arr[j] < arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					
				}
			}
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] +  " ");
		}
		

	}

}
