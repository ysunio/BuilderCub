package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreOrderTest {

    @Test
    void recursive() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);

        PreOrder preOrder = new PreOrder();
        List<Integer> result = preOrder.recursive(root);

        Assertions.assertArrayEquals(result.toArray(), new Integer[]{1, 2, 4, 5, 3});
    }

    @Test
    void iterative() {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);

        PreOrder preOrder = new PreOrder();
        List<Integer> result = preOrder.iterative(root);
        Assertions.assertArrayEquals(result.toArray(), new Integer[]{1, 2, 4, 5, 3});
    }

}
