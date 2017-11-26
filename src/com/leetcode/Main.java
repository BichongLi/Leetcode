package com.leetcode;

import com.leetcode.service.ReverseWords;
import com.leetcode.service.Solution;
import com.leetcode.service.math.MaximumSwap;

public class Main {

    public static void main(String[] args) {
        Solution<char[], Void> solution = new ReverseWords();
        solution.solve("the sky is blue".toCharArray());
    }
}
