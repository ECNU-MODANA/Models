package easy;

import java.util.ArrayList;
import java.util.List;

public class CfindDuplicates {
	 public static List<Integer> findDuplicates(int[] nums) {
		 List<Integer> rIntegers = new ArrayList<>();
	       for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i])-1;
			if (nums[index]<0) {
				rIntegers.add(Math.abs(index+1));
			}
			nums[index] = -nums[index];
		}
	       return rIntegers;
	    }
	 public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		for (int i : findDuplicates(nums)) {
			System.out.println(i);
		}
	}
}
