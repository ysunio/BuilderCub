package Archieve._75.easy;

import Archieve._75.easy.MaxDepthTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDepthTreeTest {

    @Test
    void maxDepth() {
        MaxDepthTree.TreeNode root = new MaxDepthTree.TreeNode(3);
        root.left = new MaxDepthTree.TreeNode(9);
        root.right = new MaxDepthTree.TreeNode(20);
        root.right.left = new MaxDepthTree.TreeNode(15);
        root.right.right = new MaxDepthTree.TreeNode(7);

        MaxDepthTree maxDepthTree = new MaxDepthTree();
        assertEquals(3, maxDepthTree.maxDepth(root));
    }
}