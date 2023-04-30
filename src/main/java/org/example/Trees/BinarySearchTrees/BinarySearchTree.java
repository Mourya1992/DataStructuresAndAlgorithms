package org.example.Trees.BinarySearchTrees;

import org.example.Linkedlists.Node;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    public TreeNode buildTree(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (root.getData() > value) {
            root.setLeftNode(buildTree(root.getLeftNode(), value));
        } else {
            root.setRightNode(buildTree(root.getRightNode(), value));
        }
        return root;

    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeftNode());
        System.out.print(root.getData() + " ");
        inOrderTraversal(root.getRightNode());
    }

    public boolean searchkey(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (key < root.getData()) {
            return searchkey(root.getLeftNode(), key);
        } else if (key == root.getData()) {
            return true;
        } else {
            return searchkey(root.getRightNode(), key);
        }
    }

    public TreeNode inorderSuccessor(TreeNode node) {
        TreeNode is = node;
        while (node.getLeftNode() != null) {
            is = node.getLeftNode();
        }
        return is;
    }

    public TreeNode deleteNode(TreeNode node, int data) {

        if (data < node.getData()) {
            node.setLeftNode(deleteNode(node.getLeftNode(), data));
        } else if (data > node.getData()) {
            node.setRightNode(deleteNode(node.getRightNode(), data));
        } else {
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                //Case one Leaf node
                return null;
            } else if (node.getLeftNode() == null) {
                //case two having only one branch
                return node.getRightNode();
            } else if (node.getRightNode() == null) {
                //case two having only one branch
                return node.getLeftNode();
            } else {
                //having two branches
                TreeNode is = inorderSuccessor(node.getRightNode());
                node.setData(is.getData());
                node.setRightNode(deleteNode(node.getRightNode(), is.getData()));
                return node;
            }

        }
        return node;
    }

    public void printListElements(List<Integer> newList) {
        newList.forEach(element -> System.out.print(element + " "));
    }

    public void printAllThePaths(TreeNode root, List<Integer> newList) {
        if (root == null) {
            return;
        }
        newList.add(root.getData());
        if (root.getRightNode() == null && root.getLeftNode() == null) {
            printListElements(newList);

        }
        printAllThePaths(root.getLeftNode(), newList);
        printAllThePaths(root.getRightNode(), newList);
        newList.remove(newList.size() - 1);

    }

    public void printInRange(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.getData() >= x && root.getData() <= y) {
            printInRange(root.getLeftNode(), x, y);
            System.out.print(root.getData() + " ");
            printInRange(root.getRightNode(), x, y);
        } else if (y <= root.getData()) {
            printInRange(root.getLeftNode(), x, y);
        } else if (x >= root.getData()) {
            printInRange(root.getRightNode(), x, y);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        System.out.println("hi");
        int[] list = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        TreeNode root = null;
        for (int i = 0; i < list.length; i++) {
            root = binarySearchTree.buildTree(root, list[i]);
        }
        binarySearchTree.inOrderTraversal(root);
        System.out.println(binarySearchTree.searchkey(root, 3));
        // binarySearchTree.deleteNode(root,3);
        //  System.out.println("after deletion..");
        //  binarySearchTree.inOrderTraversal(root);
        // binarySearchTree.printInRange(root,10,11);\
        binarySearchTree.printAllThePaths(root, new ArrayList<>());
    }
}
