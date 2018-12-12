// 96. Unique Binary Search Trees ----------- medium

class LC96 {
    public int numTrees(int n) {
        // proved that this n^3 complexity, something like (1/6)n^3 + 2n^2 - n + 3
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            memo[i][i] = 1;
        for (int i = 0; i <= n; i++)
        {
            memo[i][0] = 1;
            memo[0][i] = 1;
        }
        for (int j = 2; j <= n; j++)
        {
            for (int i = j - 1; i >= 1; i--)
            {
                int sum = 0;
                for (int k = i - 1; k <= j - 1; k++)
                {
                    if (k == (i - 1))
                        sum += memo[k + 2][j];
                    else if (k == (j - 1))
                        sum += memo[i][k];
                    else
                        sum += memo[i][k] * memo[k + 2][j];
                }
                memo[i][j] = sum;
            }
        }
        return memo[1][n];
    }
}

// An updated version, F(i) = j:0->i - 1 sum(F(j) * F(i - j - 1))
// Time complexity O(n^2)
class LC96 {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        for (int i = 1; i <= n; i++)
        {
            int sum = 0;
            for (int j = 0; j < i; j++)
            {
                sum += memo[j] * memo[i - j - 1];
            }
            memo[i] = sum;
        }
        return memo[n];
    }
}