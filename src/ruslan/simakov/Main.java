package ruslan.simakov;

/** You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 *  (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *  The area of an island is the number of cells with a value 1 in the island.
 *  Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *  Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *  Output: 6
 *  Explanation: The answer is not 11, because the island must be connected 4-directionally.
 *
 *  Input: grid = [[0,0,0,0,0,0,0,0]]
 *  Output: 0
 *
 *  Constraints:
 *  m == grid.length
 *  n == grid[i].length
 *  1 <= m, n <= 50
 *  grid[i][j] is either 0 or 1
 */

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
    private int maxSquare = 0;
    private int iterationSquare = 0;
    public int maxAreaOfIsland(int[][] grid) {

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