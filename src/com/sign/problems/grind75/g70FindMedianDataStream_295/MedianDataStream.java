package com.sign.problems.grind75.g70FindMedianDataStream_295;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianDataStream {
    PriorityQueue<Integer> left;		// maxHeap
    PriorityQueue<Integer> right;		// minHeap

    MedianDataStream() {
        left = new PriorityQueue<>(Comparator.reverseOrder());
        right = new PriorityQueue<>();
    }
    public void addNum(int num) {
        if (left.isEmpty()) {
            left.add(num);
            return;
        }
        if (num <= left.peek()) left.add(num);
        else right.add(num);
        balance(left, right);
    }

    private void balance(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (Math.abs(left.size() - right.size()) <= 1) return;

        if (left.size() > right.size()) {
            int num = left.remove();
            right.add(num);
        } else {
            int num = right.remove();
            left.add(num);
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (double) ((left.peek() + right.peek()) / 2.0);
        }
        if (left.size() > right.size()) {
            return (double) left.peek();
        }
        return (double) right.peek();
    }
}
