// 735. Asteroid Collision ---------- medium

class LC735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int val : asteroids)
        {
            boolean destroyed = false;
            if (stack.isEmpty())
                stack.push(val);
            else
            {
                while (!stack.isEmpty() && val < 0 && stack.peek() > 0)
                {
                    if (Math.abs(val) > Math.abs(stack.peek())) stack.pop();
                    else if (Math.abs(val) < Math.abs(stack.peek())) 
                    {
                        destroyed = true;
                        break;
                    }
                    else 
                    {
                        stack.pop();
                        destroyed = true;
                        break;
                    }
                }
                if (!destroyed) stack.push(val);
            }
        }
        int[] ret = new int[stack.size()];
        for (int i = ret.length - 1; i >= 0; i--)
            ret[i] = stack.pop();
        return ret;
    }
}