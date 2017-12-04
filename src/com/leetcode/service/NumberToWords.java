package com.leetcode.service;

import java.util.HashMap;
import java.util.Map;

public class NumberToWords implements Solution<Integer, String> {

    private static String[] separators = new String[] {"Thousand", "Million", "Billion"};
    private static Map<Integer, String> belowTenMap;
    private static Map<Integer, String> overTensMap;
    private static Map<Integer, String> tensMap;

    static {
        overTensMap = new HashMap<>();
        overTensMap.put(2, "Twenty");
        overTensMap.put(3, "Thirty");
        overTensMap.put(4, "Forty");
        overTensMap.put(5, "Fifty");
        overTensMap.put(6, "Sixty");
        overTensMap.put(7, "Seventy");
        overTensMap.put(8, "Eighty");
        overTensMap.put(9, "Ninety");
        tensMap = new HashMap<>();
        tensMap.put(10, "Ten");
        tensMap.put(11, "Eleven");
        tensMap.put(12, "Twelve");
        tensMap.put(13, "Thirteen");
        tensMap.put(14, "Fourteen");
        tensMap.put(15, "Fifteen");
        tensMap.put(16, "Sixteen");
        tensMap.put(17, "Seventeen");
        tensMap.put(18, "Eighteen");
        tensMap.put(19, "Nineteen");
        belowTenMap = new HashMap<>();
        belowTenMap.put(1, "One");
        belowTenMap.put(2, "Two");
        belowTenMap.put(3, "Three");
        belowTenMap.put(4, "Four");
        belowTenMap.put(5, "Five");
        belowTenMap.put(6, "Six");
        belowTenMap.put(7, "Seven");
        belowTenMap.put(8, "Eight");
        belowTenMap.put(9, "Nine");
    }

    @Override
    public String solve(Integer num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        String[] parts = new String[5];
        while (num > 0) {
            int tmp = num - num / 1000 * 1000;
            parts[index++] = translateThreeDigits(tmp);
            num /= 1000;
        }
        sb.append(parts[index - 1]);
        if (index > 1) sb.append(" ").append(separators[index - 2]);
        for (int i = index - 2; i >= 0; i--) {
            if (parts[i] == null) continue;
            if (i == 0) sb.append(" ").append(parts[i]);
            else sb.append(" ").append(parts[i]).append(" ").append(separators[i - 1]);
        }
        return sb.toString();
    }

    private String translateThreeDigits(int num) {
        if (num == 0) return null;
        if (num < 10) return belowTenMap.get(num);
        else if (num < 20) return tensMap.get(num);
        else {
            StringBuilder sb = new StringBuilder();
            int overHundred = num / 100;
            if (overHundred > 0) sb.append(belowTenMap.get(overHundred)).append(" Hundred");
            int overTens = (num - overHundred * 100) / 10;
            if (overTens == 1) {
                int tens = num - overHundred * 100;
                sb.append(" ").append(tensMap.get(tens));
                return sb.toString();
            } else if (overTens > 1) {
                if (sb.length() > 0) sb.append(" ");
                sb.append(overTensMap.get(overTens));
            }
            int belowTens = num - num / 10 * 10;
            if (belowTens > 0) sb.append(" ").append(belowTenMap.get(belowTens));
            return sb.toString();
        }
    }
}
