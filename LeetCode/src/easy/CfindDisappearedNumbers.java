package easy;

import java.util.ArrayList;
import java.util.List;

public class CfindDisappearedNumbers {
	 public static List<Integer> findDisappearedNumbers(int[] nums) {
		/* int maxValue =  0;
		 int minValue = 65534;
		 for (int i : nums) {
			if (i>maxValue) {
				maxValue = i;
			}
			if (i<minValue) {
				minValue = i;
			}
		}*/
		/*List<Integer> rs = new ArrayList<>();
		for (int i = 1; i <= nums.length; i++) {
			boolean flag = true;
			for (int num : nums) {
				if (num==i) {
					flag = false;
				}
			}
			if (flag) {
				rs.add(i);
			}
			
		}
		return rs;*/
		 List<Integer> rs = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
		    int val = Math.abs(nums[i])-1;
		    if (nums[val]>0) {
				nums[val] = -nums[val];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]>0) {
				rs.add(i+1);
			}
		}
		return rs;
	    }
	 public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1,6};
		List<Integer> rIntegers = findDisappearedNumbers(nums);
		for (Integer integer : rIntegers) {
			System.out.println(integer);
		}
	}
}
