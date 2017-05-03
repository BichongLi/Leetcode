package com.leetcode.service;

/**
 * User: BichongLi
 * Date: 5/3/2017
 * Time: 9:21 PM
 */
public class LicenseKeyFormatting implements BiSolution<String, Integer, String> {
    @Override
    public String solve(String S, Integer K) {
        S = S.replace("-", "");
        if (K >= S.length()) return S.toUpperCase();
        int firstSeq = S.length() % K;
        String res = "";
        if (firstSeq > 0) res = S.substring(0, firstSeq).toUpperCase();
        for (int i = 0; i < S.length() / K; i++) {
            if (res.length() == 0) res = S.substring(firstSeq + i * K, firstSeq + (i + 1) * K).toUpperCase();
            else res = res + "-" + S.substring(firstSeq + i * K, firstSeq + (i + 1) * K).toUpperCase();
        }
        return res;
    }
}
