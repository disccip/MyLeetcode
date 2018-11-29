// 364. Nested List Weight Sum II --------- medium
// With the discovery that 1*3 + 2*2 + 3*1(answer) = 1*4 + 2*4 + 3*4(unweighted sum * (max depth + 1)) - (1*1 + 2*2 + 3*3)(from Nested List Weight Sum I)
// so this question is nearly the same as Nested List Weight Sum I, just need to 
// record the unweight sum, max depth and weighted sum from Nested List Sum I

class LC364 {
    private int ret = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int[] val = dfs(nestedList, 1);
        int ret = val[1] * (val[2] + 1) - val[0];
        //System.out.printf("weight = %d, sum = %d, depth = %d\n", val[0], val[1], val[2]);
        return ret;
        
    }
    
    // int[] ret = {sum with weight, sum without weight, depth}
    private int[] dfs(List<NestedInteger> nestedList, int depth)
    {
        int weightSum = 0;
        int sum = 0;
        int d = depth;
        for (NestedInteger n : nestedList)
        {
            if (n.isInteger())
            {
                weightSum += depth * n.getInteger();
                sum += n.getInteger();
            }
            else
            {
                int[] ret = dfs(n.getList(), depth + 1);
                weightSum += ret[0];
                sum += ret[1];
                d = Math.max(d, ret[2]);
            }
        }
        return new int[]{weightSum, sum, d};
    }
    
}