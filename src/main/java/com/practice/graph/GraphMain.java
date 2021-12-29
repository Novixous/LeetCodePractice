package com.practice.graph;

public class GraphMain {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addEdge("3", "1");
        graph.addEdge("3", "4");
        graph.addEdge("4", "2");
        graph.addEdge("4", "5");
        graph.addEdge("1", "2");
        graph.addEdge("1", "0");
        graph.addEdge("0", "2");
        graph.addEdge("6", "5");
        graph.showConnections();
    }
}
