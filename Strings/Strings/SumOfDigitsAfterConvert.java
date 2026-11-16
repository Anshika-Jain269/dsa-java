
# Sum of Digits of String After Convert

## Approach
1. Repeat the grouping process while the length of the string is greater than `k`.
2. Create a `StringBuilder` to store the transformed string.
3. Divide the string into consecutive groups of at most `k` characters.
4. For each group:
   - Calculate the sum of its digits.
   - Append the calculated sum to the `StringBuilder`.
5. Convert the `StringBuilder` into a string and use it for the next iteration.
6. Continue until the string length becomes less than or equal to `k`.
7. Return the final string.

## Java Code
```java
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;

                for (int j = i; j < s.length() && j < i + k; j++) {
                    sum += s.charAt(j) - '0';
                }

                sb.append(sum);
            }

            s = sb.toString();
        }

        return s;
    }
}
```

## Complexity Analysis
- **Time Complexity:** O(n logₖ n), where `n` is the initial length of the string. Each transformation processes the current string, and its length reduces across iterations.
- **Space Complexity:** O(n), for the StringBuilder used to construct the transformed string.

## Key Concepts
- String Manipulation
- StringBuilder
- Nested Loops
- Digit Sum
- Iterative Processing
```
