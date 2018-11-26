// 16. 3Sum Closest ------- medium
// Frist of all it was pretty easy to come up with a brute force solution, 
// since there are O(n^3) possible number pairs, so the total time complexity
// is O(n^3), then we can think about how to optimize it.
// Then I came up with an idea that first sort the total array, cost O(nlogn),
// then iterate through the array, each iteration pick the very front value in
// the array, say A, then we need to find the closest sum of target - A in remaining
// array, now we reduce the problem very similar to 2Sum(with sorted input). Now the problem is how to 
// find the "closest sum".
//
// The idea of finding the closest sum is like following, maintain a variable called delta, 
// it will record the smallest absolute value between target - A and sum, which means the closet number 
// to target - A. At the end simply return target + A.

class LC16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++)
        {
            int val = target - nums[i];
            int start = i + 1, end = nums.length - 1;
            while (start < end)
            {
                int sum = nums[start] + nums[end];
                if (sum > val)
                {
                    end--;
                }
                else if (sum < val)
                {
                    start++;
                }
                else
                {
                    return target;
                }
                // if this sum is closer to target - nums[i], update it
                if (Math.abs(delta) > Math.abs(sum - val))
                    delta = sum - val;
            }
        }
        return target + delta;
    }
}