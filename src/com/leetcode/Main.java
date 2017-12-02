package com.leetcode;

import com.leetcode.service.*;
import com.leetcode.service.binarysearch.Search33;
import com.leetcode.service.math.MaximumSwap;

public class Main {

    public static void main(String[] args) {
        Solution<char[], Integer> solution = new Compress();
        solution.solve(new char[]{'a', 'b', 'b'});
    }
}
