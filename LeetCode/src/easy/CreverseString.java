package easy;

public class CreverseString {
public static String reverseString(String s) {
	char[] sChars = s.toCharArray();
	char[] newS = new char[sChars.length];
	for (int i = 0; i < sChars.length; i++) {
		newS[i] = sChars[sChars.length-1-i];
	}
	String sString = String.valueOf(newS);
    return sString; 
    }
public static void main(String[] args) {
	System.out.println(reverseString("hello"));
}
}
