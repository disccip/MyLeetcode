// 198. House Robber ------- easy

class LC198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int twoDays = nums[0], oneDay = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++)
        {
            int temp = Math.max(oneDay, twoDays + nums[i]);
            twoDays = oneDay;
            oneDay = temp;
        }
        return Math.max(twoDays, oneDay);
    }
}