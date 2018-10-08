package com.app;

public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        if (start <= maxIndex - 1) {
            root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        }
        if (maxIndex + 1 <= end) {
            root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        }
        return root;
    }

    private int findMaxIndex(int[] array, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }
}
