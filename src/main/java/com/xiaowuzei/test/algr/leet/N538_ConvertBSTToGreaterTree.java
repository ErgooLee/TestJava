package com.xiaowuzei.test.algr.leet;

public class N538_ConvertBSTToGreaterTree {

    public static void main(String[] args) {
//        System.out.println(new N538_ConvertBSTToGreaterTree().convertBST(
//                new TreeNode(5,
//                        new TreeNode(2, null, null),
//                        new TreeNode(13, null, null))));

//        System.out.println(new N538_ConvertBSTToGreaterTree().convertBST(
//                new TreeNode(2,
//                        new TreeNode(0,
//                                new TreeNode(-4, null, null),
//                                new TreeNode(1, null, null)),
//                        new TreeNode(3, null, null))));

        System.out.println(new N538_ConvertBSTToGreaterTree().convertBST(
                new TreeNode(1,
                        new TreeNode(0,
                                new TreeNode(-2, null, null),
                                null),
                        new TreeNode(4,
                                new TreeNode(3, null, null),
                                null))));
    }

    public TreeNode convertBST(TreeNode root) {
        resolve(root, 0);
        return root;
    }

    public int resolve(TreeNode root, int parentVal) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (right == null) {
            root.val += parentVal;
        } else {
            root.val += resolve(right, parentVal);
        }
        if (left == null) {
            return root.val;
        } else {
            return resolve(left, root.val);
        }
    }

}
