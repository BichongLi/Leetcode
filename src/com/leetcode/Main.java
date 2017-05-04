package com.leetcode;

import com.leetcode.service.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BiSolution<String, List<String>, String> solution = new FindLongestWord();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(solution.solve("abpcplea", list));
    }
}
