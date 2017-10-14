package com.leetcode.service.greedy;

import com.leetcode.model.Interval;
import com.leetcode.service.Solution;

import java.util.Arrays;

public class EraseOverlapIntervals implements Solution<Interval[], Integer> {
    @Override
    public Integer solve(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1.end == i2.end ? i2.start - i1.start : i1.end - i2.end);
        int count = 0, i = 0, j;
        while (i < intervals.length) {
            for (j = i + 1; j < intervals.length; j++) {
                if (intervals[j].start < intervals[i].end) count++;
                else break;
            }
            i = j;
        }
        return count;
    }
}
