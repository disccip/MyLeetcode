// 10. Regular Expression Matching ------- hard

class LC10 {
    public boolean isMatch(String s, String p) {
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        memo[0][0] = true;
        for (int i = 0; i < p.length(); i++)
        {
            if (p.charAt(i) == '*' && memo[0][i - 1])
                memo[0][i + 1] = true;
        }
        
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < p.length(); j++)
            {
                if (s.charAt(i) == p.charAt(j))
                    memo[i + 1][j + 1] = memo[i][j];
                else if (p.charAt(j) == '.')
                    memo[i + 1][j + 1] = memo[i][j];
                else if (p.charAt(j) == '*')
                {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.')
                        memo[i + 1][j + 1] = memo[i + 1][j - 1];
                    else
                        memo[i + 1][j + 1] = memo[i][j + 1] || memo[i + 1][j] || memo[i + 1][j - 1];
                }
            }
        }
        return memo[s.length()][p.length()];
    }
}