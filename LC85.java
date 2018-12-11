// 85. Maximal Rectangle ------------ hard

class LC85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] memo = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            // for each row, imaging every column is like a rectangle with width = 1
            // if the current cell is '0', then the rectangle in the related column
            // will be 0, since it can never be part of the maximal rectangle
            for (int j = 0; j < matrix[0].length; j++)
            {
                memo[j] = matrix[i][j] == '0' ? 0 : memo[j] + 1;
            }
            
            // use a stack to store the index, if current height is larger than the peek
            // of the stack then push the related index into the stack, otherwise
            // we need to pop out the index until the current height is larger than the 
            // peek or the peek is -1. The reason to use this special structure is that 
            // we are trying to find out how far the height of the peek of the stack 
            // can "spread" out to the right. If we encountered a height that is less than the 
            // stack peek height, it means this peek height can only spread to the location of
            // the height we encountered, i.e. we find a rectangle.
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int j = 0; j < memo.length; j++)
            {
                while (stack.peek() != -1 && memo[j] < memo[stack.peek()])
                {
                    int height = stack.pop();
                    int left = stack.peek();
                    int right = j;
                    int area = (right - left - 1) * memo[height];
                    max = Math.max(max, area);
                }
                stack.push(j);
            }
            
            // In case there is an ascending order remain in the stack
            while (stack.peek() != -1)
            {
                int j = stack.pop();
                int left = stack.peek();
                int right = memo.length;
                int area = (right - left - 1) * memo[j];
                max = Math.max(max, area);
            }
        }
        return max;
    }
}