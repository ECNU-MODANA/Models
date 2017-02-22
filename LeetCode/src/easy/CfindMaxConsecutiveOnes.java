package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CfindMaxConsecutiveOnes {
	 public static int findMaxConsecutiveOnes(int[] nums) {
		/* String conseString = "";
		 for (int i : nums) {
			conseString = conseString+i+"";
		}
		 if (conseString.length()<1) {
			return 0;
		 }
		 String[] conStrings = conseString.split("0");
		 List<Integer> lengths = new ArrayList<>();
		 for (String con : conStrings) {
			lengths.add(con.length());
		 }
		 Collections.sort(lengths);
	     return lengths.get(lengths.size()-1);*/
		 int maxcount = 0;
		 int count = 0;
		 for (int i : nums) {
			if (i==1) {
				count++;
			}
			if (i==0) {
				count = 0;
			}
			maxcount = Math.max(maxcount, count);
		}
		 return maxcount;
	 }
	 public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}
}
