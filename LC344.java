// 344. Reverse String --------- easy

class LC344 {
    public String reverseString(String s) {
        // StringBuilder sb = new StringBuilder(s);
        // return sb.reverse().toString();
        char[] cs = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j)
        {
            swap(cs, i, j);
            i++;
            j--;
        }
        return new String(cs);
            
    }
    
    private void swap(char[] cs, int i, int j)
    {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}