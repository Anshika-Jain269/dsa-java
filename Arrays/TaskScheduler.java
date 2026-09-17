// Problem: 621. Task Scheduler
//
// Approach:
// 1. Count the frequency of each task using an array.
// 2. Find the maximum frequency among all tasks.
// 3. Count how many tasks have the maximum frequency.
// 4. Use the formula:
//    (maxFreq - 1) * (n + 1) + count
// 5. The answer cannot be smaller than the total number of tasks,
//    so return the maximum of tasks.length and the calculated result.
//
// Time Complexity: O(N)
// Space Complexity: O(1)
//
// N = number of tasks

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency of each task
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int i = 0; i < 26; i++) {
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        // Count tasks having maximum frequency
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxFreq) {
                count++;
            }
        }

        // Calculate minimum intervals
        int result = (maxFreq - 1) * (n + 1) + count;

        return Math.max(tasks.length, result);
    }
}
