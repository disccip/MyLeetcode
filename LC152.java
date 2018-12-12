// 152. Maximum Product Subarray ---------- medium

class LC152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == 0) 
            {
                max[i] = 0;
                min[i] = 0;
            }
            else if (nums[i] > 0)
            {
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(min[i - 1] * nums[i], nums[i]);
            }
            else
            {
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
            }
            maxProduct = Math.max(maxProduct, max[i]);
        }
        return maxProduct;
    }
}