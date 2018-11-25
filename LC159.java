// 159. Longest Substring with At Most Two Distinct Characters
class LC159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Use hashmap to store the frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, unique = 2, max = 0;
        // Scan through the whole string, each time encounter a character
        // check whether the total unique character is exceeding the limit
        // if exceeded, start from index left, decrease its frequency by 1,
        // if the number of unique character is still more than the limit, repeat
        for (int right = 0; right < s.length(); right++)
        {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > unique)
            {
                char d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                if (map.get(d) == 0)
                    map.remove(d);
                left++;
            }
            // Don't forget to update the valid substring length
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}