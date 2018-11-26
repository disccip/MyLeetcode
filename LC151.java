// 151. Reverse Words in a String

// First method, split the string with delimiter as space
// then use stringbuilder to rebuild the string
public class LC151 {
    public String reverseWords(String s)
    {
        String[] strs = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--)
        {
            sb.append(strs[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

// Second method, actually we can also clean the leading or trailing
// space inside method cleanSpace, but I just use trim to do the job:)
public class LC151 {
    public String reverseWords(String s) {
        char[] crry = s.trim().toCharArray();
        reverse(crry, 0, crry.length - 1);
        int start = 0;
        for (int i = 0; i < crry.length; i++)
        {
            if (crry[i] == ' ')
            {
                reverse(crry, start, i - 1);
                start = i + 1;
                continue;
            }
        }
        reverse(crry, start, crry.length - 1);
        return cleanSpace(crry);
    }
    
    private void reverse(char[] crry, int start, int end)
    {
        while (start < end)
        {
            char c = crry[start];
            crry[start] = crry[end];
            crry[end] = c;
            start++;
            end--;
        }
    }
    
    private String cleanSpace(char[] crry)
    {
        int i = 0, j = 0;
        while (i < crry.length)
        {
            while (i < crry.length - 1 && crry[i] == ' ' && crry[i + 1] == ' ') 
                i++;
            crry[j] = crry[i];
            j++;
            i++;
        }
        return String.valueOf(crry).substring(0, j);
    }
}