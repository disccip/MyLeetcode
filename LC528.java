// 528. Random Pick with Weight
/* First of all, I came up with an idea that create an array to store the number, 
   which the count of numbers is their weight, i.e. if w[7] = 5, then there will be 
   five "7" in the array. Each call of pickIndex() will generate a random number 
   based on the total length of the array. 
   But this solution got MLE error for the last three test cases.
   Then I think about how to reduce the memory usage, and figured out that I don't 
   need to maintain that number array, I can use intervals to represent it, 
   then I came up with the idea of prefix sum the weight array. Now the memory usage reduced to O(N). 
   But I use linear search to find the proper index, which is a little bit slow, 
   then I changed the code to use binary search to speed up the call. */

class LC528 {
    private int[] weight;
    private Random random = new Random();
    
    public Solution(int[] w) {
        weight = new int[w.length];
        weight[0] = w[0];
        for (int i = 1; i < w.length; i++)
        {
            weight[i] = weight[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int index = random.nextInt(weight[weight.length - 1]);
        int ret = Arrays.binarySearch(weight, index);
        //System.out.printf("index = %d, ret = %d\n", index, ret);
        ret = ret < 0 ? Math.abs(ret) - 1 : ret;
        if (weight[ret] == index) ret++;
        return ret;
    }
}