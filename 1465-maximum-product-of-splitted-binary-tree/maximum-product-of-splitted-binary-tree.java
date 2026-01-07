class Solution {
    private long maxProduct = 0;
    private long totalSum = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        computeProduct(root);
        return (int)(maxProduct % MOD);
    }

    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    private long computeProduct(TreeNode node) {
        if (node == null) return 0;

        long left = computeProduct(node.left);
        long right = computeProduct(node.right);

        long subSum = node.val + left + right;

        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }
}
