package com.practice.binary_search_tree;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        Gson gson = new Gson();
        // write your code here
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        BinarySearchTreeNoRec<Integer> binarySearchTreeNoRec = new BinarySearchTreeNoRec<>();
        List<Integer> inputs = Arrays.asList(5,6,4,12,1,7,13);
        inputs.stream().forEach(number -> {
            binarySearchTree.insert(number);
            binarySearchTreeNoRec.insert(number);
        });

        Node<Integer> node = binarySearchTree.lookup(6);
        System.out.println(gson.toJson(node));
        System.out.println(binarySearchTree.toJson());
        Node<Integer> nodeNoRec = binarySearchTreeNoRec.lookup(6);
        System.out.println(gson.toJson(nodeNoRec));
        System.out.println(binarySearchTreeNoRec.toJson());

        System.out.println(gson.toJson(node).equals(gson.toJson(nodeNoRec)));
        System.out.println(binarySearchTree.toJson().equals(binarySearchTreeNoRec.toJson()));
        
    }
}
