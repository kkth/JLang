package com.kun.gen.dfsbfs;
import java.util.*;

public class BinaryTreePrinter {

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        int maxLevel = getMaxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        if (level < maxLevel) {
            for (int i = 1; i <= edgeLines; i++) {
                for (int j = 0; j < nodes.size(); j++) {
                    printWhitespaces(firstSpaces - i);

                    if (nodes.get(j) == null) {
                        printWhitespaces(edgeLines + edgeLines + i + 1);
                        continue;
                    }

                    if (nodes.get(j).left != null)
                        System.out.print("/");
                    else
                        printWhitespaces(1);

                    printWhitespaces(i + i - 1);

                    if (nodes.get(j).right != null)
                        System.out.print("\\");
                    else
                        printWhitespaces(1);

                    printWhitespaces(edgeLines + edgeLines - i);
                }

                System.out.println();
            }
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int getMaxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(getMaxLevel(node.left), getMaxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<TreeNode> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(5), null), null),
                new TreeNode(3,
                        new TreeNode(6, null,
                                new TreeNode(7)), null));

        printTree(root);
    }
}
