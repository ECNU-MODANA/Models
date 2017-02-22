package easy;

public class CfindComplement {
	
public static int findComplement(int num) {
	String binaryNum = Integer.toBinaryString(num);
	char[] charNum = binaryNum.toCharArray();
	for (int i = 0; i < charNum.length; i++) {
		if (charNum[i]=='1') {
			charNum[i]='0';
		}
		else if (charNum[i]=='0') {
			charNum[i]='1';
		}
	}
	binaryNum = String.valueOf(charNum);
    return Integer.parseInt(binaryNum, 2);
    }
public static void main(String[] args) {
	System.out.println(findComplement(1));
}
}
