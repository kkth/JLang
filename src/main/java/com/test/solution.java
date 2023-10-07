package com.test;


import java.util.*;

class solution {
    public static void main(String[] args) {
        solution s = new solution();
        int[] persons = new int[]{1, 2, 98, 3};
        s.allAlignments(100, persons);
    }

    void allAlignments(int width, int[] persons) {
        int len = persons.length;
        List<Integer> l  = new ArrayList<>();
        for (int person : persons) l.add(person);

        Deque<List<Integer>> queue = new ArrayDeque<>();
        Set<List<Integer>> visited = new HashSet<>();
        queue.add(l);
        while (!queue.isEmpty()) {
            List<Integer> curArrange = queue.poll();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (curArrange.get(i) + curArrange.get(j) <= width) {
                        boolean blocked = false;
                        for (int m = i + 1; m < j; m++)
                            if (((curArrange.get(m) + curArrange.get(i)) > width) || ((curArrange.get(m) + curArrange.get(j)) > width)) {
                                blocked = true;
                            }

                        if (!blocked) {
                            List<Integer> newArrange = new ArrayList<>();
                            for(int m = 0;m<curArrange.size();m++){
                                newArrange.add(curArrange.get(m));
                            }
                            newArrange.set(i, curArrange.get(j));
                            newArrange.set(j, curArrange.get(i));

                            if (!visited.contains(newArrange)) {
                                queue.add(newArrange);
                                visited.add(newArrange);

                                System.out.println(Arrays.toString(newArrange.toArray()));
                            }
                        }
                    }

                }

            }

        }

    }
}
