class Solution {

    public int minPathSum(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;


        // Step 1: Calculate the first row
        for (int i = 1; i < c; i++) {

            grid[0][i] = grid[0][i] + grid[0][i - 1];

        }


        // Step 2: Calculate the first column
        for (int i = 1; i < r; i++) {

            grid[i][0] = grid[i][0] + grid[i - 1][0];

        }


        // Step 3: Calculate all remaining cells
        for (int i = 1; i < r; i++) {

            for (int j = 1; j < c; j++) {

                grid[i][j] = grid[i][j] +
                        Math.min(grid[i - 1][j], grid[i][j - 1]);

            }
        }


        // Step 4: Return bottom-right cell
        return grid[r - 1][c - 1];

    }
}