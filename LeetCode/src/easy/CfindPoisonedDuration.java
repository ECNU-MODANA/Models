package easy;

public class CfindPoisonedDuration {
	 public static int findPoisonedDuration(int[] timeSeries, int duration) {
		 if (timeSeries==null||timeSeries.length==0||timeSeries.length>10000||duration>10000000) {
			return 0;
		}
		 for (int i = 0; i < timeSeries.length; i++) {
			if (timeSeries[i]<0||timeSeries[i]>10000000) {
				return 0;
			}
		}
		 int rs = 0;
		 for (int i = 0; i < timeSeries.length-1; i++) {
			if (timeSeries[i+1]-timeSeries[i]<duration) {
				rs = rs + timeSeries[i+1]-timeSeries[i];
			}
			else{
				rs = rs + duration;
			}
		}
	        return rs+duration;
	    }
	 public static void main(String[] args) {
		int[] timeSeries = {1,2};
		System.out.println(findPoisonedDuration(timeSeries, 2));
	}
}
