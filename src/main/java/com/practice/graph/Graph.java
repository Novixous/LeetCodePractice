package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Graph<T> {
    private int numberOfNodes = 0;
    private HashMap<T, List<T>> adjacentList = new HashMap<>();

    public void addVertex(T node) throws Exception {
        if (adjacentList.containsKey(node)) {
            throw new Exception("Vertex already existed!");
        }
        this.numberOfNodes++;
        this.adjacentList.put(node, new ArrayList<>());
    }

    public void addEdge(T node1, T node2) {
        try {
            if (!adjacentList.containsKey(node1)) {
                addVertex(node1);
            }
            if (!adjacentList.containsKey(node2)) {
                addVertex(node2);
            }
            if (!adjacentList.get(node1).contains(node2) && !adjacentList.get(node2).contains(node1)) {
                adjacentList.get(node1).add(node2);
                adjacentList.get(node2).add(node1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showConnections() {
        adjacentList.keySet().forEach(key -> {
            System.out.println(String.format("%s: %s", key.toString(),
                    adjacentList.get(key).stream().map(Objects::toString).collect(Collectors.joining(","))));
        });
    }

}
