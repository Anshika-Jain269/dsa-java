import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];

        // Stores the complete word when this node represents
        // the end of a word
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        List<String> ans = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;

        // Create Trie root
        TrieNode root = new TrieNode();

        // Insert all words into the Trie
        for (String word : words) {

            TrieNode node = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            // Store complete word at the end node
            node.word = word;
        }

        // Start DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    public void dfs(char[][] board, int i, int j,
                    TrieNode node, List<String> ans) {

        // Boundary check
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length) {
            return;
        }

        char ch = board[i][j];

        // Already visited cell
        if (ch == '#') {
            return;
        }

        int index = ch - 'a';

        // Current character is not a valid Trie path
        if (node.children[index] == null) {
            return;
        }

        // Move to the next Trie node
        node = node.children[index];

        // Complete word found
        if (node.word != null) {
            ans.add(node.word);

            // Prevent adding the same word again
            node.word = null;
        }

        // Mark current cell as visited
        board[i][j] = '#';

        // Explore four directions
        dfs(board, i + 1, j, node, ans);
        dfs(board, i - 1, j, node, ans);
        dfs(board, i, j + 1, node, ans);
        dfs(board, i, j - 1, node, ans);

        // Backtrack: restore original character
        board[i][j] = ch;
    }
}
