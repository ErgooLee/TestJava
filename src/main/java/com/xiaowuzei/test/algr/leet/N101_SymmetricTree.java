package com.xiaowuzei.test.algr.leet;

public class N101_SymmetricTree {

    public static void main(String[] args) {

    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        invertTree(root.left);
        return same(root.left, root.right);
    }

    public boolean same(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {
            return root1.val == root2.val && same(root1.left, root2.left) && same(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
