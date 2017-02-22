package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CfindWords {
	 public static String[] findWords(String[] words) {
		 List<String> rList = new ArrayList<>();
		 String line1 = "QWERTYUIOP";
		 String line2 = "ASDFGHJKL";
		 String line3 = "ZXCVBNM";
		 for (String word : words) {
			Set<Integer> reSet = new HashSet<>();
			char[] inputWordChar = word.toUpperCase().toCharArray();
			for (int i = 0; i < inputWordChar.length; i++) {
				if (line1.contains(inputWordChar[i]+"")) {
					reSet.add(1);
				}
				else if (line2.contains(inputWordChar[i]+"")) {
					reSet.add(2);
				}
				else if (line3.contains(inputWordChar[i]+"")) {
					reSet.add(3);
				}
				else {
					try {
						throw new Exception("字符输入异常");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if (reSet.size()==1) {
				rList.add(word);
			}
		 }
		 int size=rList.size(); 
		 String[] array = (String[])rList.toArray(new String[size]);
	     return array; 
	 }
	 public static void main(String[] args) {
		 String[] test = {"Hello", "Alaska", "Dad", "Peace","qw"};
		 String [] rs = findWords(test);
		 for(int i=0;i<rs.length;i++){ 
		      System.out.println(rs[i]); 
		 } 
	}
}
