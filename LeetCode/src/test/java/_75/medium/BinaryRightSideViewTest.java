package _75.medium;

import Archieve._75.medium.BinaryRightSideView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryRightSideViewTest {

    @Test
    void rightSideView() {

        BinaryRightSideView.TreeNode root = new BinaryRightSideView.TreeNode(10);
        root.left = new BinaryRightSideView.TreeNode(20);
        root.right = new BinaryRightSideView.TreeNode(30);
        root.right.left = new BinaryRightSideView.TreeNode(40);
        root.right.right = new BinaryRightSideView.TreeNode(50);

        assertArrayEquals(new Integer[]{10, 30, 50}, new BinaryRightSideView().rightSideView(root).toArray());
    }
}