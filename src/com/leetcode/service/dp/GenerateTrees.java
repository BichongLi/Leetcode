package com.leetcode.service.dp;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * User: BichongLi
 * Date: 3/25/2017
 * Time: 2:35 PM
 */
public class GenerateTrees implements Solution<Integer, List<TreeNode>> {

    private List<TreeNode>[][] mem;

    @Override
    public List<TreeNode> solve(Integer n) {
        if (n < 1) return new ArrayList<>();
        init(n);
        return buildTree(1, n);
    }

    private void init(int n) {
        mem = new List[n + 2][n + 2];
    }

    private List<TreeNode> buildTree(int min, int max) {
        List<TreeNode> trees = new ArrayList<>();
        if (mem[min][max] != null) return mem[min][max];
        if (min > max) {
            trees.add(null);
            mem[min][max] = trees;
            return trees;
        }
        if (min == max) {
            trees.add(new TreeNode(min));
            mem[min][max] = trees;
            return trees;
        }

        List<TreeNode> leftTrees, rightTrees;
        for (int i = min; i <= max; i++) {
            leftTrees = buildTree(min, i - 1);
            rightTrees = buildTree(i + 1, max);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        mem[min][max] = trees;
        return trees;
    }
}
