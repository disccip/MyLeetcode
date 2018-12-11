// 763. Partition Labels --------- medium
// Scan through the string, update the last index of new character
// if the index equals to the index of the current character, 
// then it means we hit a split point

class LC763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        dfs(ret, S);
        return ret;
    }
    
    private void dfs(List<Integer> ret, String S)
    {
        if (S.length() == 0) return;
        HashSet<Character> set = new HashSet<>();
        int index = -1;
        for (int i = 0; i < S.length(); i++)
        {
            if (!set.contains(S.charAt(i)))
            {
                index = Math.max(index, S.lastIndexOf(S.charAt(i)));
                set.add(S.charAt(i));
            }
            
            if (index == i)
            {
                ret.add(i + 1);
                dfs(ret, S.substring(i + 1, S.length()));
                break;
            }
        }
    }
}