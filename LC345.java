// 345. Reverse Vowels of a String

class LC345 {
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        HashSet<Character> set = new HashSet<>(Arrays.asList(vowels));
        int j = cs.length - 1;
        for (int i = 0; i < j; i++)
        {
            if (!set.contains(cs[i])) continue;
            while (j > i && !set.contains(cs[j]))
            {
                j--;
            }
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
            j--;
        }
        return new String(cs);
    }
}