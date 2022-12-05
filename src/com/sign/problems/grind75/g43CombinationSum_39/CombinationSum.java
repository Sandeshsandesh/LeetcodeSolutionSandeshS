package com.sign.problems.grind75.g43CombinationSum_39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, candidates, 0, target, new ArrayList<>());
        return res;

    }

    private void dfs(int sum, int[] arr, int index, int target, List<Integer> path) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) return;

        while (index < arr.length) {
  /*          List<Integer> newPath = new ArrayList<>(path);
            newPath.add(arr[index]);*/
            path.add(arr[index]);
            dfs(sum + arr[index], arr, index++, target, path);
            path.remove(path.size() - 1);
        }
    }

}
