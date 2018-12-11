// 63. Unique Paths II --------- medium

class LC63 {
    // Can be optimized to O(n) space complexity
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] memo = new int[rows][cols];
        memo[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < cols; i++)
            memo[0][i] = obstacleGrid[0][i] == 1 ? 0 : memo[0][i - 1];
        for (int i = 1; i < rows; i++)
            memo[i][0] = obstacleGrid[i][0] == 1 ? 0 : memo[i - 1][0];
        for (int i = 1; i < rows; i++)
        {
            for (int j = 1; j < cols; j++)
            {
                memo[i][j] = obstacleGrid[i][j] == 1 ? 0 : memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[rows - 1][cols - 1];
    }
}