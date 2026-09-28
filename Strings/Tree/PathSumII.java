/**
 * LeetCode 113 - Path Sum II
 * Approach: DFS + Backtracking
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        dfs(root, path, ans, targetSum);
        return ans;
    }

    void dfs(TreeNode root, List<Integer> path,
             List<List<Integer>> ans, int targetSum) {

        if (root == null) {
            return;
        }

        path.add(root.val);
        targetSum -= root.val;

        // Check only at leaf nodes
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                ans.add(new ArrayList<>(path));
            }
        }

        dfs(root.left, path, ans, targetSum);
        dfs(root.right, path, ans, targetSum);

        // Backtrack
        path.remove(path.size() - 1);
    }
}
