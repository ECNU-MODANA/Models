package easy;

public class CislandPerimeter {
	  public static int islandPerimeter(int[][] grid) {
		  int iland = 0;
		  int neb = 0;
		  for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
			  if (grid[i][j]==1) {
				iland++;
				if (i<grid.length-1&&grid[i+1][j]==1) {
					neb++;
				}
				if (j<grid[i].length-1&&grid[i][j+1]==1) {
					neb++;
				}
			 }
			}
		  }
	      return iland*4-neb*2;  
	  }
	  public static void main(String[] args) {
		 int[][] grid = {{0,1,1,0},{1,1,1,1},{0,1,0,0},{1,0,0,0}};
		System.out.println(islandPerimeter(grid));
	}
}
