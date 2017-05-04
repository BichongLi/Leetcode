package com.leetcode.service;

import com.leetcode.model.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * User: BichongLi
 * Date: 5/4/2017
 * Time: 9:35 AM
 */
public class FindRightInterval implements Solution<Interval[], int[]> {
    @Override
    public int[] solve(Interval[] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
        int[] res = new int[intervals.length];
        Arrays.fill(res, -1);
        int lo, hi, mid, nextLarge;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].end > intervals[intervals.length - 1].start) continue;
            if (map.containsKey(intervals[i].end)) {
                res[map.get(intervals[i].start)] = map.get(intervals[i].end);
                continue;
            }
            lo = 0;
            hi = intervals.length - 1;
            nextLarge = -1;
            while (lo <= hi) {
                mid = (lo + hi) / 2;
                if (intervals[i].end == intervals[mid].start) {
                    res[map.get(intervals[i].start)] = map.get(intervals[mid].start);
                    break;
                } else if (intervals[i].end < intervals[mid].start) {
                    nextLarge = intervals[mid].start;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            if (res[map.get(intervals[i].start)] == -1) res[map.get(intervals[i].start)] = map.get(nextLarge);
        }
        return res;
    }
}
