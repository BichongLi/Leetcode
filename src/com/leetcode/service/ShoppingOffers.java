package com.leetcode.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * User: BichongLi
 * Date: 7/27/2017
 * Time: 10:01 AM
 */
public class ShoppingOffers implements TriSolution<List<Integer>, List<List<Integer>>, List<Integer>, Integer> {

    private int minCost;

    @Override
    public Integer solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        special = filterSpecial(price, special);
        minCost = Integer.MAX_VALUE;
        dfs(price, special, needs, 0);
        return minCost;
    }

    private List<List<Integer>> filterSpecial(List<Integer> price, List<List<Integer>> special) {
        Iterator<List<Integer>> iterator = special.iterator();
        while (iterator.hasNext()) {
            List<Integer> specialOffer = iterator.next();
            int originalPrice = 0;
            for (int i = 0; i < specialOffer.size() - 1; i++) {
                originalPrice += specialOffer.get(i) * price.get(i);
            }
            if (originalPrice < specialOffer.get(specialOffer.size() - 1)) iterator.remove();
        }
        return special;
    }

    private void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int cost) {
        boolean specialApplied = false;
        for (List<Integer> offer : special) {
            if (canApply(offer, needs)) {
                dfs(price, special, apply(offer, needs), cost + offer.get(offer.size() - 1));
                specialApplied = true;
            }
        }
        if (!specialApplied) {
            cost += IntStream.range(0, needs.size())
                    .map(i -> needs.get(i) * price.get(i))
                    .sum();
            minCost = minCost > cost ? cost : minCost;
        }
    }

    private boolean canApply(List<Integer> special, List<Integer> need) {
        for (int i = 0; i < need.size(); i++) {
            if (need.get(i) < special.get(i)) return false;
        }
        return true;
    }

    private List<Integer> apply(List<Integer> special, List<Integer> need) {
        List<Integer> left = new ArrayList<>();
        for (int i = 0; i < need.size(); i++) {
            left.add(need.get(i) - special.get(i));
        }
        return left;
    }
}
