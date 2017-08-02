package com.leetcode.service.dp;

import com.leetcode.service.BiSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * User: BichongLi
 * Date: 8/2/2017
 * Time: 9:31 AM
 */
public class CanIWin implements BiSolution<Integer, Integer, Boolean> {

    private Map<Integer, Boolean> dp;
    private boolean[] used;

    @Override
    public Boolean solve(Integer maxChoosableInteger, Integer desiredTotal) {
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        used = new boolean[maxChoosableInteger + 1];
        dp = new HashMap<>();
        return dfs(desiredTotal);
    }

    private boolean dfs(int desiredTotal) {
        if (desiredTotal <= 0) return false;
        int key = usedToInt();
        if (!dp.containsKey(key)) {
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (!dfs(desiredTotal - i)) {
                        dp.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            dp.put(key, false);
        }
        return dp.get(key);
    }

    private int usedToInt() {
        int res = 0;
        for (int i = 1; i < used.length; i++) {
            res = res << 1;
            res = used[i] ? res | 1 : res;
        }
        return res;
    }
}
