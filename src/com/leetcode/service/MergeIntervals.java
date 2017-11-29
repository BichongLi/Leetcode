package com.leetcode.service;

import com.leetcode.model.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals implements Solution<List<Interval>, List<Interval>> {
    @Override
    public List<Interval> solve(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) return res;
        intervals.sort(Comparator.comparingInt(i -> i.start));
        Interval prev = intervals.get(0);
        int start = prev.start, end = prev.end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
