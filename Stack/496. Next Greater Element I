public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        Stack<Integer> helpStack = new Stack<>();
        int[] result = new int[findNums.length];
        for (int i : nums)
        {
            if (helpStack.isEmpty()) helpStack.push(i);
            else if (i < helpStack.peek()) helpStack.push(i);
            else 
            {
                while (!helpStack.isEmpty() && i > helpStack.peek()) 
                {
                    int j = helpStack.pop();
                    resultMap.put(j, i);
                }
                helpStack.push(i);
            }
        }
        while (!helpStack.isEmpty()) 
        {
            int l = helpStack.pop();
            resultMap.put(l, -1);
        }
        for (int i = 0; i < findNums.length; i++)
        {
            result[i] = resultMap.get(findNums[i]);
        }
        return result;
    }
}
