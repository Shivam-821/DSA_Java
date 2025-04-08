// Problem Statement: You are given an N x M binary matrix grid, where 0 represents a sea cell and 1 represents a land cell. A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid. Find the number of land cells in the grid for which we cannot walk off the boundary of the grid in any number of moves.

// to all those one which is connected to boundry for that one we can go out of the boundary.
class Solution {
    public static void dfs(int[][] grid, int[][] vis, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;
        vis[r][c] = 1;

        int[] drow = {-1, 0, 1, 0}; // Fixed direction array
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i];
            int ncol = c + dcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(grid, vis, nrow, ncol);
            }
        }
    }

    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        // Perform DFS on boundary land cells
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) dfs(grid, vis, i, 0);
            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0) dfs(grid, vis, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0) dfs(grid, vis, 0, j);
            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0) dfs(grid, vis, n - 1, j);
        }

        // Count enclosed land cells
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

class NoOfEnclaves {
    public static void main(String[] args) {
        int grid[][] = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        Solution ob = new Solution();
        int ans = ob.numberOfEnclaves(grid);
        System.out.println(ans);
    }
}
