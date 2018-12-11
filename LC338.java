// 338. Counting Bits -------- medium

class LC338 {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        ret[1] = 1;
        for (int j = 1; j <= num; j <<= 1)
        {
            for (int i = 0; i < j; i++)
            {
                if (i + j > num)
                    return ret;
                ret[j + i] = ret[i] + 1;
            }
        }
        return ret;
    }
}