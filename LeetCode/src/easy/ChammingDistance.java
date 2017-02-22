package easy;

public class ChammingDistance {
public static int hammingDistance(int x, int y) {
	String xString = Integer.toBinaryString(x);
	String yString = Integer.toBinaryString(y);
	String xStr = "";
	String yStr = "";
	int dis = 0;
	if (xString.length()>yString.length()) {
		dis = xString.length() - yString.length();
		for (int i = 0; i < dis; i++) {
			yStr = yStr + "0";
		} 
		yStr = yStr + yString;
		xStr = xString;
	}
	else if (xString.length()<yString.length()) {
		dis = yString.length() - xString.length();
		for (int i = 0; i < dis; i++) {
			xStr = xStr + "0";
		} 
		xStr = xStr + xString;
		yStr = yString;
	}
	else{
		xStr = xString;
		yStr = yString;
	}
	char[] xChars = xStr.toCharArray();
	char[] yChars = yStr.toCharArray();
	int count = 0;
	for (int i = 0; i < xChars.length; i++) {
		if (xChars[i]!=yChars[i]) {
			count ++;
		}
	}
        return count;
    }
public static void main(String[] args) {
	System.out.println(hammingDistance(4, 4));
}
}
