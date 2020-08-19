package com.xiaowuzei.test.algr.leet;

public class UnionFind {
    int[] parents;
    int[] weights;

    public UnionFind(int totalNodes) {
        parents = new int[totalNodes];
        weights = new int[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            parents[i] = i;
            weights[i] = 1;
        }
    }

    void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 == root2) {
            return;
        }
        int weight1 = weights[root1];
        int weight2 = weights[root2];
        if (weight1 >= weight2) {
            parents[root2] = root1;
            weights[root1] += weight2;
        } else {
            parents[root1] = root2;
            weights[root2] += weight1;
        }

    }

    int find(int node) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(4);
        unionFind.union(0, 1);
        unionFind.union(2, 3);
        unionFind.union(1, 3);
        System.out.println();
    }
}
