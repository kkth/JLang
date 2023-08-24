package com.kun;

import static org.junit.jupiter.api.Assertions.*;

class BTreesTest {

    @org.junit.jupiter.api.Test
    void buildFromBFS() {
        Integer[] bfs = new Integer[]{10,5,15,3,7,null,18};
        TreeNode root = BTrees.buildFromBFS(bfs);
        System.out.println("hello");
    }
}