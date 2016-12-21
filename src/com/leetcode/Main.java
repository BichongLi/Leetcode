package com.leetcode;

import com.leetcode.service.ArithmeticSlices;
import com.leetcode.service.CountingBits;
import com.leetcode.service.Solution;
import com.leetcode.service.SortCharactersByFrequency;

public class Main {

    public static void main(String[] args) {
        Solution<String, String> solution = new SortCharactersByFrequency();
        System.out.println(solution.solve("abbbaacacf"));
    }
}
