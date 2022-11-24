package com.sign.problems.grind75.g28KClosestPointsOrigin_973;

import java.util.Comparator;
import java.util.PriorityQueue;

class PL {
    int index;
    double length;

    PL(int index, double length) {
        this.index = index;
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}

public class KClosestPointsOrigin {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null) {
            return null;
        }
        if (k < 1 || k > points.length) {
            throw new RuntimeException("invalid k " + k);
        }
        PriorityQueue<PL> pq = new PriorityQueue<>(k, Comparator.comparing(PL::getLength).reversed());

        int i;
        for (i = 0; i < k; i++) {
            PL pl = new PL(i, calcLength(points[i]));
            pq.add(pl);
        }


        while (i < points.length) {
            double length = calcLength(points[i]);
            double currentMax = pq.peek().length;
            if (length < currentMax) {
                pq.remove();
                pq.add(new PL(i, length));
            }
            i++;
        }

        int[][] res = new int[k][2];
        int r = 0;
        while (!pq.isEmpty()) {
            PL max = pq.remove();
            res[r++] = points[max.index];
        }
        return res;
    }

    private double calcLength(int[] p) {
        return Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2));
    }
}

