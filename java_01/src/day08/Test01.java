package day08;

import java.util.Arrays;

import util.MyUtil;

public class Test01 {

	public static void main(String[] args) {
 		
		//util.MyUtil.max() Test 하기
		
 			int[] src = {10,20,5,2,100,100000};
 			
 			int result = MyUtil.max(src);
 			
 			System.out.println(Arrays.toString(src));
 			System.out.println(result);
 			
 			System.out.println(MyUtil.max(1,100,10000,1000000));
 			System.out.println(MyUtil.min(100,200,4,90,800));
 			System.out.println(MyUtil.max(new int[] {100, 5000, 6000}));
 			System.out.println(MyUtil.min(new int[] {500,20,180,94}));
 			
 				//->가변인자라서 배열도 처리가능하다!
	}
}
