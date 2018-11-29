// 12. Integer to Roman ---------- medium
class LC12 {
    public static final String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++)
        {
            while (num >= values[i])
            {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}