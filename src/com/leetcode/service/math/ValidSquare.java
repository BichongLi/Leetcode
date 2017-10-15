package com.leetcode.service.math;

public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (valid(p1, p2, p3)) return valid(p4, p2, p3);
        if (valid(p1, p2, p4)) return valid(p3, p2, p4);
        if (valid(p1, p3, p4)) return valid(p2, p3, p4);
        return false;
    }

    private boolean valid(int[] p1, int[] p2, int[] p3) {
        int d1 = getDistance(p1, p2);
        int d2 = getDistance(p1, p3);
        return d1 != 0 && d2 != 0 && d1 == d2 && is90DegreeAngle(p1, p2, p3);
    }

    private int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    private boolean is90DegreeAngle(int[] p1, int[] p2, int[] p3) {
        if ((p1[0] == p2[0] && p1[1] == p3[1]) || (p1[1] == p2[1] && p1[0] == p3[0])) return true;
        if (p1[0] == p2[0] || p1[1] == p3[1]) return false;
        return ((p1[1] - p2[1]) * (p1[1] - p3[1])) == ((p1[0] - p2[0]) * (p1[0] - p3[0]) * -1);
    }
}
