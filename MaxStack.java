// 716. Max Stack --------- easy
// The difficult part of this question is design the popMax() function,
// and this function is why I think this question is harder than minStack.

class MaxStack {
    private Stack<Integer> stack;
    private Stack<Integer> max;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        max = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (max.isEmpty() || x > max.peek())
            max.push(x);
        else 
            max.push(max.peek());
    }
    
    public int pop() {
        max.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return max.peek();
    }
    
    public int popMax() {
        // A help stack store the numbers before find actual max
        Stack<Integer> help = new Stack<>();
        int maxNum = peekMax();
        while (top() != maxNum)
        {
            help.push(pop());
        }
        // Find the max, remove it
        pop();
        // Restore the stack
        while (!help.isEmpty())
        {
            push(help.pop());
        }
        return maxNum;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */