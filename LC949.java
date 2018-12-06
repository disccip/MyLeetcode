// 949. Largest Time for Given Digits ------- easy

class LC949 {
    private String ret = "";
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        dfs(A, 0, "", new HashSet<Integer>());
        return ret.length() == 0 ? ret : ret.substring(0, 2) + ":" + ret.substring(2, 4);
    }
    
    private void dfs(int[] A, int pos, String temp, HashSet<Integer> set)
    {
        if (pos == 4)
        {
            if (isValid(temp) && larger(temp, ret))
                ret = temp;
            //System.out.println(temp);
            return;
        }
        
        for (int i = 0; i < A.length; i++)
        {
            if (set.contains(i)) continue;
            set.add(i);
            dfs(A, pos + 1, temp + A[i], set);
            set.remove(i);
        }
    }
    
    private boolean isValid(String s)
    {
        int hour = Integer.parseInt(s.substring(0, 2));
        int min = Integer.parseInt(s.substring(2, 4));
        if (hour < 0 || hour > 23 || min < 0 || min > 59) return false;
        return true;
    }
    
    private boolean larger(String a, String b)
    {
        if (a.length() == 0) return false;
        if (b.length() == 0) return true;
        int min1 = Integer.parseInt(a.substring(0, 2)) * 60 + Integer.parseInt(a.substring(2, 4));
        int min2 = Integer.parseInt(b.substring(0, 2)) * 60 + Integer.parseInt(b.substring(2, 4));
        if (min1 > min2) return true;
        return false;
    }
}