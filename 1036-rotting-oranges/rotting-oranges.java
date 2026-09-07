import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        // Find all rotten oranges and count fresh oranges
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }


        // No fresh oranges
        if (fresh == 0) {
            return 0;
        }


        int timer = 0;

        // Up, Down, Left, Right
        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };


        // BFS
        while (!q.isEmpty()) {

            int size = q.size();

            boolean foundFresh = false;


            // Process all oranges that are rotten at this minute
            for (int k = 0; k < size; k++) {

                int[] first = q.poll();

                int i = first[0];
                int j = first[1];


                // Check all four directions
                for (int[] d : dirs) {

                    int x = i + d[0];
                    int y = j + d[1];


                    // Check if position is valid and contains a fresh orange
                    if (x >= 0 && x < r &&
                        y >= 0 && y < c &&
                        grid[x][y] == 1) {

                        // Make the fresh orange rotten
                        grid[x][y] = 2;

                        // One less fresh orange
                        fresh--;

                        // Add newly rotten orange to queue
                        q.offer(new int[]{x, y});

                        foundFresh = true;
                    }
                }
            }


            // If at least one orange became rotten,
            // one minute has passed
            if (foundFresh) {
                timer++;
            }
        }


        // If fresh oranges are still remaining,
        // they cannot be reached
        if (fresh > 0) {
            return -1;
        }

        return timer;
    }
}