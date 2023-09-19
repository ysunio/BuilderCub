package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

    List<Integer> recursive(TreeNode<Integer> root) {
        List<Integer> listOfNodes = new ArrayList<>();
        recursiveHelper(root, listOfNodes);
        return listOfNodes;
    }

    List<Integer> iterative(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> callStack = new Stack<>();
        List<Integer> listOfNodes = new ArrayList<>();
        callStack.add(root);
        while (!callStack.isEmpty()) {
            TreeNode<Integer> currentRoot = callStack.pop();
            listOfNodes.add(currentRoot.value);
            if (currentRoot.right != null) callStack.push(currentRoot.right);
            if (currentRoot.left != null) callStack.push(currentRoot.left);
        }
        return listOfNodes;
    }

    private void recursiveHelper(TreeNode<Integer> root, List<Integer> list) {
        if (root == null) return;
        list.add(root.value);
        if (root.left != null) recursiveHelper(root.left, list);
        if (root.right != null) recursiveHelper(root.right, list);
    }
}
