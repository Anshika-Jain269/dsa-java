// Problem: 648. Replace Words
//
// Approach:
// 1. Store all dictionary words in a HashSet.
// 2. Split the sentence into individual words.
// 3. For every word, generate prefixes from left to right.
// 4. If a prefix exists in the dictionary, use it as the replacement.
// 5. If no prefix is found, keep the original word.
// 6. Join all words to form the final sentence.
//
// Time Complexity: O(n * L²)
// Space Complexity: O(n * L)
//
// n = number of words in the sentence
// L = maximum length of a word

import java.util.*;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {

        Set<String> set = new HashSet<>(dictionary);

        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();

        for (String word : words) {

            String replacement = word;

            for (int i = 1; i <= word.length(); i++) {

                String prefix = word.substring(0, i);

                if (set.contains(prefix)) {
                    replacement = prefix;
                    break;
                }
            }

            if (ans.length() > 0) {
                ans.append(" ");
            }

            ans.append(replacement);
        }

        return ans.toString();
    }
}
