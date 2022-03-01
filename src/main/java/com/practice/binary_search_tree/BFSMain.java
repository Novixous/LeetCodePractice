package com.practice.binary_search_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BFSMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);
        List<Integer> result = tree.breathFirstSearch();
        System.out.println(result.stream().map(integer -> integer.toString()).collect(Collectors.joining(", ")));
        result = tree.breathFirstSearchRec(new LinkedList<>(Collections.singletonList(tree.getRoot())), new ArrayList<>());
        System.out.println(result.stream().map(integer -> integer.toString()).collect(Collectors.joining(", ")));
        result = tree.DFSInOrder();
        System.out.println(result.stream().map(integer -> integer.toString()).collect(Collectors.joining(", ")));
        result = tree.DFSPreOrder();
        System.out.println(result.stream().map(integer -> integer.toString()).collect(Collectors.joining(", ")));
        result = tree.DFSPostOrder();
        System.out.println(result.stream().map(integer -> integer.toString()).collect(Collectors.joining(", ")));
    }

}
