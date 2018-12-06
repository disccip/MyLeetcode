// 244. Shortest Word Distance II -------- medium
// First this problem can be easily reduced to find minimum absolute
// different between two sorted array. Then I was thinking about BFS to find the minimum distance,
// but I got a TLE error. Later I came up the idea as follows.
// Complexity: O(M + N) space, O(M + N) time

class WordDistance {
    private HashMap<String, List<Integer>> map;
    private int length;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        length = words.length;
        for (int i = 0; i < words.length; i++)
        {
            String s = words[i];
            if (!map.containsKey(s))
                map.put(s, new ArrayList<>());
            map.get(s).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> w1 = map.get(word1);
        List<Integer> w2 = map.get(word2);
        int diff = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < w1.size() && j < w2.size())
        {
            if (Math.abs(w1.get(i) - w2.get(j)) < diff)
                diff = Math.abs(w1.get(i) - w2.get(j));
            if (w1.get(i) > w2.get(j)) j++;
            else i++;
        }
        return diff;
    }
}