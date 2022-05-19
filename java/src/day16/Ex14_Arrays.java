package day16;

import java.util.Arrays;
import java.util.Comparator;

public class Ex14_Arrays {

	public static void main(String[] args) {
		Integer nums[] = {10,2,8,1,5};
		
		System.out.println("정렬전 배열 : ");
		for(int i = 0; i<nums.length; i++) {
			System.out.println(nums[i] + " ");
		}
		System.out.println();
		Arrays.sort(nums,new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {  
			return o2 - o1;
			}
		}); //정렬하기위해서 필요한 친구 , 단점은 오름차순으로뿐이 안된다.
		
		System.out.println("정렬후 배열 : ");
		for(int i = 0; i<nums.length; i++) {
			System.out.println(nums[i] + " ");
		}
		System.out.println();

		}
	} 
