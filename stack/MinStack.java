package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> stack;
    int minimum;

    public MinStack() {
        stack = new ArrayDeque<>();
        minimum = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
          stack.push(val);
          minimum = val;
        } else {
          if (val < minimum) {
            int k = 2 * val - minimum;
            stack.push(k);
            minimum = val;
          } else {
            stack.push(val);
          }
        }
    }

    public void pop() {
      int k = stack.pop();
      if (k < minimum) {
        minimum = 2 * minimum - k;
      }
    }

    public int top() {
        int k  = stack.peek();
        if (k > minimum) return k;
        else return minimum;
    }

    public int getMin() {
        return minimum;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(43);
        System.out.println(minStack.top());
        minStack.push(-93);
        minStack.pop();
        System.out.println(minStack.top());
        minStack.push(47);
        minStack.push(62);
        System.out.println(minStack.getMin());
        minStack.push(68);
        minStack.push(50);

    }
}

