package ruslan.simakov;

public class Main {

    public static void main(String[] args) {
	new Solution().maxAreaOfIsland(new int[][]{
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}});
    }
}

class Solution {
    private static int maxSquare = 0;
    private static int iterationSquare = 0;
    public int maxAreaOfIsland(int[][] grid) {
        maxSquare = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    squareCalculateRecursivly(grid, i, j);
                } else {
                    continue;
                }

                if(iterationSquare > maxSquare) {
                    maxSquare = iterationSquare;
                }
                iterationSquare = 0;
            }
        }
        return maxSquare;
    }

    private void squareCalculateRecursivly(int[][] grid, int i, int j) {
        iterationSquare++;
        grid[i][j] = 0;
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            squareCalculateRecursivly(grid, i, j - 1);
        }
        if (j + 1  < grid[i].length && grid[i][j + 1] == 1) {
            squareCalculateRecursivly(grid, i, j + 1);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            squareCalculateRecursivly(grid, i - 1, j);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            squareCalculateRecursivly(grid, i + 1, j);
        }
    }
}