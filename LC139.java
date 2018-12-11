// 139. Word Break ----------- medium

class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet(wordDict);
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for (int i = 0; i <= s.length(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (memo[j] && set.contains(s.substring(j, i)))
                {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }
}