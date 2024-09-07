package com.kun.gen.dfsbfs;

import com.kun.gen.utils.BTreeUtils;
import com.kun.gen.utils.BinaryTreePrinter;
import com.kun.gen.utils.TreeNode;
import org.junit.jupiter.api.Test;



class BTreeUtilsTest {

    @Test
    void gen1() {
        Integer[] theArray = new Integer[]{1,2,3,4,null,null,6,5,null,null,7};
        TreeNode root = BTreeUtils.genTree(theArray);
        BinaryTreePrinter.printTree(root);

        assert true;
    }

    @Test
    void gen2() {
        Integer[] theArray = new Integer[]{1,null,2,3};
        TreeNode root = BTreeUtils.genTree(theArray);
        BinaryTreePrinter.printTree(root);

        assert true;
    }
    @Test
    void gen3() {
        Integer[] theArray = new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9};
        TreeNode root = BTreeUtils.genTree(theArray);
        BinaryTreePrinter.printTree(root);

        assert true;
    }
}