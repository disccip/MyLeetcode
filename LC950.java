// 950. Reveal Cards In Increasing Order -------- medium

class LC950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--)
        {
            if (queue.isEmpty()) queue.offer(deck[i]);
            else
            {
                int num = queue.poll();
                queue.offer(num);
                queue.offer(deck[i]);
            }
        }
        int[] ret = new int[deck.length];
        for (int i = deck.length - 1; i >= 0; i--)
            ret[i] = queue.poll();
        return ret;
    }
}