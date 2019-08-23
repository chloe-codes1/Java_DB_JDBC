package util;

public class Sort {

	public static int[] sort(int[] nums) { // int type의 배열을 받아서 int type 배열을 return 하겠다

	// 배열 원본은 변경이 되지 않도록 하고
	// 오름차순으로 정렬된 int[]를 리턴한다.
		
		int[] copy = new int[nums.length]; 
					//새로운 배열을 원본과 크기 똑같게 만듦
		
		System.arraycopy(nums, 0, copy, 0, nums.length);
					// 복사해놓음 -> 원본을 보존하기 위해! (주소 공유하지 않도록!)

		//복사본 Int[] copy를 sort함
		
		int count = 0;
		//정렬 알고리즘
		for (int i = 0; i < copy.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < copy.length; j++) {
				if (copy[min] > copy[j]) {
					min = j;
				}
			}
			if (i != min) {

				int temp = copy[i];
				copy[i] = copy[min];
				copy[min] = temp;
				count++;
			}
		}
		return copy;
	}
}