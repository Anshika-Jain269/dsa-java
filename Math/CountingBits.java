// Problem: 338. Counting Bits
//
// Approach:
// 1. Create an array of size n + 1.
// 2. For every number from 0 to n, count its set bits.
// 3. Use (num & 1) to check whether the last bit is 1.
// 4. Right shift the number by 1 to check the next bit.
// 5. Store the count of set bits in the result array.
//
// Time Complexity: O(n log n)
// Space Complexity: O(n)

class Solution {
    public int[] countBits(int n) {

        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {

            int num = i;
            int count = 0;

            while (num > 0) {

                int bit = num & 1;

                if (bit == 1) {
                    count++;
                }

                num = num >> 1;
            }

            arr[i] = count;
        }

        return arr;
    }
}
