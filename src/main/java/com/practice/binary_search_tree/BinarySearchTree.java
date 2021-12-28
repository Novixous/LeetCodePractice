package com.practice.binary_search_tree;

import com.google.gson.Gson;

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
}
