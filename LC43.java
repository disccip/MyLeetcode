// 43. Multiply Strings ---------- medium

class Solution {
    public String multiply(String num1, String num2) {
        int[] memo = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--)
        {
            for (int j = num1.length() - 1; j >= 0; j--)
            {
                int sum = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                int p1 = i + j, p2 = i + j + 1;
                sum += memo[p2];
                memo[p2] = sum % 10;
                memo[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int m : memo)
            if (sb.length() != 0 || m != 0)
                sb.append(String.valueOf(m));
        return sb.length() == 0 ? "0" : sb.toString();
    }
}