// 64. Minimum Path Sum --------- medium

class LC64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int[] memo = new int[grid[0].length + 1];
        memo[0] = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++)
            memo[i + 1] += (memo[i] == Integer.MAX_VALUE ? 0 : memo[i]) + grid[0][i];
        for (int i = 1; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                memo[j + 1] = Math.min(memo[j], memo[j + 1]) + grid[i][j];
            }
        }
        return memo[memo.length - 1];
    }
}