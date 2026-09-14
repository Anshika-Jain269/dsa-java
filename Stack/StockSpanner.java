// Problem: 901. Online Stock Span
//
// Approach:
// 1. Use a Stack to store {price, span}.
// 2. For every new price, start the span from 1.
// 3. If the top price is less than or equal to the current price,
//    its span can be included in the current span.
// 4. Pop that element and add its span.
// 5. Continue until we find a greater price.
// 6. Push the current {price, span} into the stack.
//
// Time Complexity:
// next() -> O(1) amortized
//
// Space Complexity: O(n)

import java.util.*;

class StockSpanner {

    Stack<int[]> s = new Stack<>();

    public StockSpanner() {
    }

    public int next(int price) {

        int span = 1;

        while (!s.isEmpty()) {

            int[] top = s.peek();

            if (top[0] <= price) {
                span += top[1];
                s.pop();
            } else {
                break;
            }
        }

        int[] arr = {price, span};
        s.push(arr);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 *
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
