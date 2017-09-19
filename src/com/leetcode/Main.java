package com.leetcode;

import com.leetcode.model.TreeNode;
import com.leetcode.service.BiSolution;
import com.leetcode.service.Solution;
import com.leetcode.service.TriSolution;
import com.leetcode.service.bfs.SurroundedRegions;
import com.leetcode.service.graph.CalcEquation;
import com.leetcode.service.graph.FindItinerary;
import com.leetcode.service.graph.FindMinHeightTrees;
import com.leetcode.service.search.FindOrder;
import com.leetcode.service.search.LongestIncreasingPath;
import com.leetcode.service.tree.AddOneRow;
import com.leetcode.service.tree.WidthOfBinaryTree;
import com.leetcode.service.trie.PalindromePairs;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<TreeNode, Integer> solution = new WidthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        solution.solve(root);
    }
}
