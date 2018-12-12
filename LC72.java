// 72. Edit Distance ---------- hard

class LC72 {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++)
        {
            memo[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++)
        {
            memo[0][i] = i;
        }
        
        for (int i = 0; i < word1.length(); i++)
        {
            for (int j = 0; j < word2.length(); j++)
            {
                if (word1.charAt(i) == word2.charAt(j))
                    memo[i + 1][j + 1] = memo[i][j];
                else
                {
                    memo[i + 1][j + 1] = Math.min(memo[i][j], Math.min(memo[i][j + 1], memo[i + 1][j])) + 1;
                }
            }
        }
        return memo[word1.length()][word2.length()];
    }
}