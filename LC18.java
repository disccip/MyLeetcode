// 18. 4Sum ---------- medium
// 3sum + 2sum

class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++)
        {
            if (i == 0 || (nums[i] != nums[i - 1]))
            {
                for (int j = i + 1; j < nums.length - 2; j++)
                {
                    if (j == i + 1 || (nums[j] != nums[j - 1]))
                    {
                        int sum = target - nums[i] - nums[j];
                        int start = j + 1, end = nums.length - 1;
                        while (start < end)
                        {
                            if (nums[start] + nums[end] == sum)
                            {
                                Integer[] temp = {nums[i], nums[j], nums[start], nums[end]};
                                ret.add(new ArrayList<>(Arrays.asList(temp)));
                                while (start < end && nums[start] == nums[start + 1]) start++;
                                while (start < end && nums[end] == nums[end - 1]) end--;
                                start++;
                                end--;
                            }
                            else if (nums[start] + nums[end] > sum) end--;
                            else start++;
                        }
                    }
                }
            }
        }
        return ret;
    }
}