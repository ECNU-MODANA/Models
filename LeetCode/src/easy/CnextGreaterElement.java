package easy;

import java.util.ArrayList;
import java.util.List;

public class CnextGreaterElement {
public static int[] nextGreaterElement(int[] findNums, int[] nums) {
	   List<Integer> rsList = new ArrayList<>();
       for (int i = 0; i < findNums.length; i++) {
    	   int flag = 0;
		   for (int j = 0; j < nums.length; j++) {
			 if (findNums[i]==nums[j]) {
				 for (int j2 = j; j2 < nums.length; j2++) {
					if (nums[j2]>nums[j]) {
						rsList.add(nums[j2]);
						flag = 1;
						break;
					}
				}
			 }
		}
		if (flag==0) {
			rsList.add(-1);
		}
	   }
	   int[] rs=new int[rsList.size()];
	   for (int i = 0; i < rsList.size(); i++) {
		rs[i] = rsList.get(i);
	  }
	   return rs;
    }
public static void main(String[] args) {
	int[] findNums = {1,3,5,2,4};
	int[] nums = {6,5,4,3,2,1,7};
	int[] res = nextGreaterElement(findNums, nums);
	for (int i : res) {
		System.out.println(i);
	}
}
}
