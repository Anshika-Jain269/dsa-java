// Problem: 127. Word Ladder
//
// Approach:
// 1. Store all words in a HashSet for O(1) average lookup.
// 2. Use BFS because we need the shortest transformation sequence.
// 3. For every word, change each character from 'a' to 'z'.
// 4. If the new word exists in the HashSet, add it to the queue.
// 5. Remove the word from the Set when adding it to the queue
//    so that we do not visit it again.
// 6. Process the queue level by level and increase the level after
//    processing all words at the current level.
//
// Time Complexity: O(N × L × 26)
// Space Complexity: O(N)
//
// N = number of words
// L = length of each word

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Store all words for quick lookup
        Set<String> set = new HashSet<>(wordList);

        // If endWord is not present, transformation is impossible
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process all words at the current level
            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                // End word reached
                if (word.equals(endWord)) {
                    return level;
                }

                char[] chars = word.toCharArray();

                // Change each character
                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        chars[j] = c;

                        String newWord = new String(chars);

                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }

                    // Restore original character
                    chars[j] = original;
                }
            }

            level++;
        }

        return 0;
    }
}
