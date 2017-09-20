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
import com.leetcode.service.tree.DeleteNode;
import com.leetcode.service.tree.WidthOfBinaryTree;
import com.leetcode.service.trie.PalindromePairs;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BiSolution<TreeNode, Integer, TreeNode> solution = new DeleteNode();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        solution.solve(root, 3);
    }
}
