package com.sign.problems.grind75.g34CourseSchedule_207;

import java.util.*;

public class CourseSchedule {
    Set<Integer> taken = new HashSet<>();
    Map<Integer, List<Integer>> adjMap = new HashMap<>();
    public boolean canFinish(int courses, int[][] prereq) {
        for (int[] prereqArr : prereq) {
            List<Integer> deps;
            if (adjMap.containsKey(prereqArr[0])) {
                deps = adjMap.get(prereqArr[0]);
            } else {
                deps = new ArrayList<>();
            }
            deps.add(prereqArr[1]);
            adjMap.put(prereqArr[0], deps);
        }


        for (int i = 0; i < courses; i++) {
            if (!dfs(i)) {
                cycleSet.clear();
                return false;
            }
        }
        return true;
    }

    Set<Integer> cycleSet = new HashSet<>();
    private boolean dfs(int i) {
        if (taken.contains(i)) {
            return true;
        }
        if (!adjMap.containsKey(i)) {
            taken.add(i);
            return true;
        }
        List<Integer> depsList = adjMap.get(i);
        if (depsList.isEmpty()) {
            taken.add(i);
            return true;
        }
        if (cycleSet.contains(i)) {
// cycle detected
            return false;
        }
        cycleSet.add(i);
        for (int dep : depsList) {
            if (!dfs(dep)) {
                return false;
            }
        }
        cycleSet.remove(i);
        taken.add(i);
        return true;
    }
}
