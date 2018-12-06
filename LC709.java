// 709. To Lower Case ------- easy

class LC709 {
    public String toLowerCase(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++)
        {
            if (cs[i] - 'A' >= 0 && cs[i] - 'A' < 26)
                cs[i] = (char) (cs[i] - 'A' + 'a');
        }
        return new String(cs);
    }
}