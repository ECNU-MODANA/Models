package easy;

import java.util.ArrayList;
import java.util.List;

public class CfizzBuzz {
	 public static List<String> fizzBuzz(int n) {
		 List<String> rStrings = new ArrayList<>();
	        for (int i = 1; i <= n; i++) {
				if (i%3==0&&i%5!=0) {
					rStrings.add("Fizz");
				}
				else if (i%5==0&&i%3!=0) {
					rStrings.add("Buzz");
				}
				else if (i%3==0&&i%5==0) {
					rStrings.add("FizzBuzz");
				}
				else {
					rStrings.add(i+"");
				}
			}
	        return rStrings;
	 }
	 public static void main(String[] args) {
		List<String> rList = fizzBuzz(15);
		for (String string : rList) {
			System.out.println(string);
		}
	}
}
