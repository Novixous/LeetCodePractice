package com.practice.binary_search_tree;

import com.google.gson.Gson;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        Gson gson = new Gson();
        // write your code here
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(12);
        binarySearchTree.insert(1);
        binarySearchTree.insert(7);
        binarySearchTree.insert(13);
        Node<Integer> node = binarySearchTree.lookup(6);
        System.out.println(gson.toJson(node));
        System.out.println(binarySearchTree.toJson());
    }
}
