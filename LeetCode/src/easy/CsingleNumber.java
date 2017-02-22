package easy;

public class CsingleNumber {
	 public static int singleNumber(int[] nums) {
		   int single = 0;
		   for (int i : nums) {
			single = single ^ i;
		}
		   return single;
	 }
	 public static void main(String[] args) {
		 int[] nums = {1,1,2,3,4,2,3};
		System.out.println(singleNumber(nums));
	}
}
