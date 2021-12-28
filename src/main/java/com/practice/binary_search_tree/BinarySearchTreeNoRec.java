package com.practice.binary_search_tree;

import com.google.gson.Gson;

public class BinarySearchTreeNoRec<T extends Comparable<T>> {
    Node<T> root;

    void insert(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node<T> currentNode = this.root;
            while (true) {
                if (value.compareTo(currentNode.getValue()) < 0) {
                    if (currentNode.getLeft() == null) {
                        currentNode.setLeft(newNode);
                        return;
                    }
                    currentNode = currentNode.getLeft();
                } else if (value.compareTo(currentNode.getValue()) > 0) {
                    if (currentNode.getRight() == null) {
                        currentNode.setRight(newNode);
                        return;
                    }
                    currentNode = currentNode.getRight();
                }
            }
        }
    }

    Node<T> lookup(T value) {
        if (this.root != null) {
            Node<T> currentNode = this.root;
            while (currentNode != null) {
                if (value.compareTo(currentNode.getValue()) < 0) {
                    currentNode = currentNode.getLeft();
                } else if (value.compareTo(currentNode.getValue()) > 0) {
                    currentNode = currentNode.getRight();
                } else {
                    return currentNode;
                }
            }
        }
        return null;
    }

    String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this.root);
    }
}
