class Solution {

    // Start DFS traversal from root
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    // DFS helper: builds binary number along the path
    private int dfs(TreeNode root, int x) {

        if (root == null)
            return 0;  // No node → no contribution

        // Shift left and add current node value (0 or 1)
        x = (x << 1) | root.val;

        // If leaf node, return formed binary number
        if (root.left == null && root.right == null)
            return x;

        // Sum from left and right subtrees
        return dfs(root.left, x) + dfs(root.right, x);
    }
}