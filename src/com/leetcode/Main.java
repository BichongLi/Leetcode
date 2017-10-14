package com.leetcode;

import com.leetcode.service.Solution;
import com.leetcode.service.math.LexicalOrder;
import com.leetcode.service.math.SingleNumber;
import com.leetcode.service.math.TriangleNumber;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution<int[], Integer> solution = new TriangleNumber();
        solution.solve(new int[]{2, 3, 2, 4});
    }
}
