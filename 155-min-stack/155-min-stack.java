import java.util.Stack;

class MinStack {

    minElem min;
    Stack<Integer> stack;
    
    class minElem {
        int val;
        minElem prev;

        minElem(int val, minElem prev) {
            this.val = val;
            this.prev = prev;
        }
    }

    public MinStack() {
        stack = new Stack<>();
        min = new minElem(Integer.MAX_VALUE, null);
    }
    
    public void push(int val) {
        stack.push(val);
        
        if (val <= min.val) {
            minElem temp = min;
            min = new minElem(val, temp);
        }
    }
    
    public void pop() {
        int elem = stack.pop();

        if (elem == min.val) min = min.prev;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */