package com.xiaowuzei.test.algr.leet;

import java.util.HashMap;
import java.util.Map;

public class N337_HouseRobberIII {

    private static TreeNode root1;
    private static TreeNode root2;
    private static TreeNode root3;

    static {
        root1 = new TreeNode(3,
                new TreeNode(2,
                        null,
                        new TreeNode(3, null, null)),
                new TreeNode(3,
                        null,
                        new TreeNode(1, null, null)));

        root2 = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(5,
                        null,
                        new TreeNode(1, null, null)));


        root3 = new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3, null, null),
                                null),
                        null),
                null);
    }


    public static void main(String[] args) {
        System.out.println(new N337_HouseRobberIII().rob(root1));
        System.out.println(new N337_HouseRobberIII().rob(root2));
        System.out.println(new N337_HouseRobberIII().rob(root3));
    }

    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob1(TreeNode root) {
        if (root == null) return 0; // 利用备忘录消除重叠子问题
        if (memo.containsKey(root))
            return memo.get(root); // 抢，然后去下下家
        int do_it = root.val
                + (root.left == null ?
                0 : rob1(root.left.left) + rob1(root.left.right))
                + (root.right == null ?
                0 : rob1(root.right.left) + rob1(root.right.right));
        int not_do = rob1(root.left) + rob1(root.right);
        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }

    public int rob(TreeNode root) {
        int[] ret = dp(root);
        return Math.max(ret[0], ret[1]);
    }

    public int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int not_do = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int do_it = root.val + left[0] + right[0];
        return new int[]{not_do, do_it};
    }
}
