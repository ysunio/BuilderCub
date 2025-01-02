package Archieve._75.medium;

import Archieve._75.medium.Pseudo_Palindromic_BT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Pseudo_Palindromic_BTTest {

    @Test
    void pseudoPalindromicPaths() {
        Pseudo_Palindromic_BT.TreeNode root = new Pseudo_Palindromic_BT.TreeNode(1);
        root.left = new Pseudo_Palindromic_BT.TreeNode(2);
        root.right = new Pseudo_Palindromic_BT.TreeNode(1);
        root.right.left = new Pseudo_Palindromic_BT.TreeNode(1);
        assertEquals(1, Pseudo_Palindromic_BT.pseudoPalindromicPaths(root));
    }
}