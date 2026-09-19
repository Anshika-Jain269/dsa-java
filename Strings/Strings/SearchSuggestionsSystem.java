// Problem: 1268. Search Suggestions System
//
// Approach:
// 1. Sort the products lexicographically.
// 2. Build a Trie using the sorted products.
// 3. Each Trie node stores up to 3 product suggestions.
// 4. While inserting, add a product to the node's suggestion list
//    only if the list contains fewer than 3 products.
// 5. Traverse the Trie according to each character of searchWord.
// 6. For every character, add the corresponding suggestions to the answer.
// 7. If the prefix does not exist, add empty lists for the remaining
//    characters.
//
// Time Complexity: O(P log P + P × L)
// Space Complexity: O(P × L)
//
// P = number of products
// L = maximum length of a product

import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(
        String[] products, String searchWord) {

        Arrays.sort(products);

        // Trie Node
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            List<String> suggest = new ArrayList<>();
        }

        TrieNode root = new TrieNode();

        List<List<String>> ans = new ArrayList<>();

        // Build Trie
        for (String product : products) {

            TrieNode node = root;

            for (char ch : product.toCharArray()) {

                int index = ch - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];

                // Store at most 3 suggestions
                if (node.suggest.size() < 3) {
                    node.suggest.add(product);
                }
            }
        }

        // Search for each prefix
        TrieNode node = root;

        for (int i = 0; i < searchWord.length(); i++) {

            char ch = searchWord.charAt(i);
            int index = ch - 'a';

            if (node.children[index] == null) {

                // No products match this or any longer prefix
                for (int j = i; j < searchWord.length(); j++) {
                    ans.add(new ArrayList<>());
                }

                break;
            }

            node = node.children[index];

            ans.add(node.suggest);
        }

        return ans;
    }
}
