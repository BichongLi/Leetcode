package com.leetcode.service.stack;

import com.leetcode.service.BiSolution;

import java.util.List;
import java.util.Stack;

/**
 * User: BichongLi
 * Date: 8/8/2017
 * Time: 9:35 AM
 */
public class ExclusiveTime implements BiSolution<Integer, List<String>, int[]> {
    @Override
    public int[] solve(Integer n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        Log pre = null;
        int duration;
        for (String record : logs) {
            Log log = new Log(record);
            if (pre != null && !stack.isEmpty()) {
                duration = log.time - pre.time;
                res[stack.peek()] += duration;
            }
            if (log.isStart) stack.push(log.id);
            else stack.pop();
            pre = log;
        }
        return res;
    }

    private class Log {
        int id;
        boolean isStart;
        int time;

        Log(String record) {
            String[] parts = record.split(":");
            id = Integer.valueOf(parts[0]);
            if (parts[1].equals("start")) {
                isStart = true;
                time = Integer.valueOf(parts[2]);
            } else {
                isStart = false;
                time = Integer.valueOf(parts[2]) + 1;
            }
        }
    }
}
