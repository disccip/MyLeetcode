// 722. Remove Comments ------- medium
// This question itself is not hard to solve, but it really needs pay attention.
// There are four conditions needs to take care of,
// 1. found "//", ingore any characters remaining in current string
// 2. found "/*", start multiline comments mode, ingore characters until "*/" presents
// 3. found "*/", end multiline comments mode, append any characters remaining in current string
// 4. anything else, append the character into stringbuilder

class LC722 {
    public List<String> removeComments(String[] source) {
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inComment = false;
        for (int i = 0; i < source.length; i++)
        {
            String s = source[i];
            for (int j = 0; j < s.length(); j++)
            {
                if (inComment)
                {
                    if (s.charAt(j) == '*' && j < s.length() - 1 && s.charAt(j + 1) == '/')
                    {
                        j++;
                        inComment = false;
                    }
                }
                else
                {
                    if (s.charAt(j) == '/' && j < s.length() - 1 && s.charAt(j + 1) == '/')
                        break;
                    else if (s.charAt(j) == '/' && j < s.length() - 1 && s.charAt(j + 1) == '*')
                    {
                        inComment = true;
                        j++;
                    }
                    else
                        sb.append(s.charAt(j));
                }
            }
            if (!inComment && sb.length() > 0)
            {
                ret.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return ret;
    }
}