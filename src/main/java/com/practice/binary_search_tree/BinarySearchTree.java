package com.practice.binary_search_tree;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    void insert(T value) {
        root = insertRec(root, value);
    }

    Node<T> insertRec(Node<T> root, T value) {
        if (root == null) {
            root = new Node<>(value);
            return root;
        }
        if (value.compareTo(root.getValue()) < 0) {
            root.setLeft(insertRec(root.getLeft(), value));
        } else if (value.compareTo(root.getValue()) > 0) {
            root.setRight(insertRec(root.getRight(), value));
        }
        return root;
    }

    Node<T> lookup(T value) {
        return lookupRec(root, value);
    }

    Node<T> lookupRec(Node<T> root, T value) {
        if (root == null) {
            return null;
        }
        if (root.getValue().compareTo(value) == 0) {
            return root;
        } else if (value.compareTo(root.getValue()) < 0) {
            return lookupRec(root.getLeft(), value);
        } else {
            return lookupRec(root.getRight(), value);
        }
    }

    String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this.root);
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public List<T> breathFirstSearch() {
        Node<T> currentNode = root;
        List<T> result = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.poll();
            result.add(currentNode.getValue());
            if(currentNode.getLeft() != null){
                queue.add(currentNode.getLeft());
            }
            if(currentNode.getRight() != null){
                queue.add(currentNode.getRight());
            }
        }
        return result;
    }

    public List<T> breathFirstSearchRec(Queue<Node<T>> queue, List<T> list){
        if(queue.size() == 0){
            return list;
        }
        Node<T> currentNode = queue.poll();
        list.add(currentNode.getValue());
        if(currentNode.getLeft() != null){
            queue.add(currentNode.getLeft());
        }
        if(currentNode.getRight() != null){
            queue.add(currentNode.getRight());
        }
        return breathFirstSearchRec(queue, list);
    }
}
