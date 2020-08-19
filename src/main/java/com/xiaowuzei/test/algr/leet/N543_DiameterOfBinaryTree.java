package com.xiaowuzei.test.algr.leet;

public class N543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        System.out.println(new N543_DiameterOfBinaryTree().diameterOfBinaryTree(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4, null, null),
                                new TreeNode(5, null, null)),
                        new TreeNode(3,
                                null, null))
        ));
    }

    public int diameterOfBinaryTree1(TreeNode root) {
        return resolve(root).diameter;
    }

    public Pair resolve(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = resolve(root.left);
        Pair right = resolve(root.right);
        int childDiameter = left.diameter > right.diameter ? left.diameter : right.diameter;
        int diameter = left.depth + right.depth;
        if (childDiameter > diameter) {
            diameter = childDiameter;
        }
        int depth = (left.depth > right.depth ? left.depth : right.depth) + 1;
        return new Pair(depth, diameter);
    }

    static class Pair {
        int depth;
        int diameter;

        public Pair(int depth, int diameter) {
            this.depth = depth;
            this.diameter = diameter;
        }
    }

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        int diameter = leftDepth + rightDepth;
        if (ans < diameter) {
            ans = diameter;
        }
        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }


}
