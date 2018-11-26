// 93. Restore IP Addresses
// DFS/backtracking idea, check if each split is valid, if it is,
// continue to next split

class LC93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        backtracking(ret, "", s, 0, 0);
        return ret;
    }
    
    private void backtracking(List<String> list, String temp, String s, int index, int count)
    {
        if (count == 4 && index == s.length())
        {
            list.add(temp);
            return;
        }
        
        if (count > 4 || index > s.length()) return;
        for (int i = 1; i < 4; i++)
        {
            if (index + i > s.length()) break;
            String str = s.substring(index, index + i);
            if (isValid(str))
            {
                backtracking(list, temp + str + (count == 3 ? "" : "."), s, index + i, count + 1);
            }
        }
        
    }
    
    private boolean isValid(String s)
    {
        if (s.charAt(0) == '0' && s.length() > 1) return false;
        int val = Integer.parseInt(s);
        if (val < 0 || val > 255) return false;
        return true;
    }
}