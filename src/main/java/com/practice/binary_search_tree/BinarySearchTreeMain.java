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
        List<Integer> inputs = Arrays.asList(41, 20, 65, 11, 29, 32, 50, 91, 72, 99, 15, 14, 13, 70, 68, 66, 71, 69);
        inputs.stream().forEach(number -> {
            binarySearchTree.insert(number);
            binarySearchTreeNoRec.insert(number);
        });

        Node<Integer> node = binarySearchTree.lookup(11);
        System.out.println(gson.toJson(node));
        System.out.println(binarySearchTree.toJson());
        Node<Integer> nodeNoRec = binarySearchTreeNoRec.lookup(11);
        System.out.println(gson.toJson(nodeNoRec));
        System.out.println(binarySearchTreeNoRec.toJson());

        System.out.println(gson.toJson(node).equals(gson.toJson(nodeNoRec)));
        System.out.println(binarySearchTree.toJson().equals(binarySearchTreeNoRec.toJson()));

        binarySearchTreeNoRec.remove(15);
        binarySearchTreeNoRec.remove(72);
        System.out.println(binarySearchTreeNoRec.toJson());
        binarySearchTreeNoRec.remove(70);
        System.out.println(binarySearchTreeNoRec.toJson());
        binarySearchTreeNoRec.remove(65);
        System.out.println(binarySearchTreeNoRec.toJson());
    }
}
