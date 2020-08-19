package com.xiaowuzei.test.algr.leet;

public class N617_MergeTwoBinaryTrees {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1,
                new TreeNode(3, new TreeNode(2, null, null), null),
                new TreeNode(5, null, null));

        TreeNode root2 = new TreeNode(8,
                new TreeNode(10, null, new TreeNode(14, null, null)),
                new TreeNode(13, null, new TreeNode(17, null, null)));
        System.out.println(new N617_MergeTwoBinaryTrees().mergeTrees(root1, root2));
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        } else if (t1 == null) {
            t1 = t2;
        }
        return t1;
    }
}
