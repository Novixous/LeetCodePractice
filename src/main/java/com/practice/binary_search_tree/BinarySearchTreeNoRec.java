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

    boolean remove(T value) {
        if (this.root != null) {
            Node<T> currentNode = this.root;
            Node<T> parrentNode = null;
            while (currentNode != null) {
                if (value.compareTo(currentNode.getValue()) < 0) {
                    parrentNode = currentNode;
                    currentNode = currentNode.getLeft();
                } else if (value.compareTo(currentNode.getValue()) > 0) {
                    parrentNode = currentNode;
                    currentNode = currentNode.getRight();
                } else {
                    //Option 1: no right child
                    if (currentNode.getRight() == null) {
                        if (parrentNode == null) {
                            this.root = currentNode.getLeft();
                        } else {
                            if (currentNode.getValue().compareTo(parrentNode.getValue()) > 0) {
                                parrentNode.setRight(currentNode.getLeft());
                            } else if (currentNode.getValue().compareTo(parrentNode.getValue()) < 0) {
                                parrentNode.setLeft(currentNode.getLeft());
                            }
                        }
                    }
                    //option 2: right child does not have left child
                    else if (currentNode.getRight().getLeft() == null) {
                        currentNode.getRight().setLeft(currentNode.getLeft());
                        if (parrentNode == null) {
                            this.root = currentNode.getRight();
                        } else {
                            if (currentNode.getValue().compareTo(parrentNode.getValue()) > 0) {
                                parrentNode.setRight(currentNode.getRight());
                            } else if (currentNode.getValue().compareTo(parrentNode.getValue()) < 0) {
                                parrentNode.setLeft(currentNode.getRight());
                            }
                        }
                    }
                    //Option 3: Right child that has a left child
                    else {
                        Node<T> leftMost = currentNode.getRight().getLeft();
                        Node<T> leftMostParent = currentNode.getRight();
                        while (leftMost.getLeft() != null) {
                            leftMostParent = leftMost;
                            leftMost = leftMost.getLeft();
                        }
                        leftMostParent.setLeft(leftMost.getRight());
                        leftMost.setLeft(currentNode.getLeft());
                        leftMost.setRight(currentNode.getRight());
                        if (parrentNode == null) {
                            this.root = leftMost;
                        } else {
                            if (currentNode.getValue().compareTo(parrentNode.getValue()) > 0) {
                                parrentNode.setRight(leftMost);
                            } else if (currentNode.getValue().compareTo(parrentNode.getValue()) < 0) {
                                parrentNode.setLeft(leftMost);
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this.root);
    }
}
