package com.leetcode.service.tree;

import com.leetcode.model.TreeNode;
import com.leetcode.service.Solution;

import java.util.*;

/**
 * User: BichongLi
 * Date: 3/28/2017
 * Time: 9:29 AM
 */
public class FindFrequentTreeSum implements Solution<TreeNode, int[]> {

    private Map<Integer, Integer> treeSumFrequencyMap;
    private int maxOccur;

    @Override
    public int[] solve(TreeNode root) {
        if (root == null) return new int[0];
        treeSumFrequencyMap = new HashMap<>();
        maxOccur = 0;
        dfs(root);
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : treeSumFrequencyMap.entrySet()) {
            if (entry.getValue() == maxOccur) {
                maxOccur = entry.getValue();
                resultList.add(entry.getKey());
            }
        }
        int[] result = new int[resultList.size()];
        int index = 0;
        for (Integer sum : resultList) {
            result[index++] = sum;
        }
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int treeSum = leftSum + rightSum + root.val;
        int occur = treeSumFrequencyMap.containsKey(treeSum) ? treeSumFrequencyMap.get(treeSum) + 1 : 1;
        maxOccur = occur > maxOccur ? occur : maxOccur;
        treeSumFrequencyMap.put(treeSum, occur);
        return treeSum;
    }
}
