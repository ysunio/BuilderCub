package com.buildercub.scenarios;

import java.util.*;

public class Recommendation {

    static class Node{
        String name;
        List<Node> neighbours;

        public Node(String name) {
            this.name = name;
            this.neighbours = new ArrayList<>();
        }

        void addNeighbour(Node ng){
            this.neighbours.add(ng);
        }
    }

    public static void main(String[] args) {
        HashMap<String, Node> graph = new HashMap<>();
        Node A = new Node("A"); graph.put("A", A);
        Node B = new Node("B"); graph.put("B", B);
        Node C = new Node("C"); graph.put("C", C);
        Node D = new Node("D"); graph.put("D", D);
        Node E = new Node("E"); graph.put("E", E);
        Node F = new Node("F"); graph.put("F", F);

        A.addNeighbour(B);
        B.addNeighbour(A);
        B.addNeighbour(C);
        C.addNeighbour(D);
        C.addNeighbour(E);
        E.addNeighbour(F);
        D.addNeighbour(F);


        System.out.println(getPathBetweenNodes(graph, "A", "F"));
    }

    static List<String> getPathBetweenNodes(HashMap<String, Node> graph, String source, String destinations){

        Set<Node> isVisited = new HashSet<>();
        Node sourceNode = graph.get(source);
        Queue<Node> queue = new LinkedList<>();
        queue.add(sourceNode);

        Map<Node, Node> parentChild = new HashMap<>();

        while (!queue.isEmpty()){

            Node currentNode = queue.poll();
            isVisited.add(currentNode);
            for(Node ng : currentNode.neighbours){
                if(isVisited.contains(ng)) continue;
                queue.add(ng); // Add to Queue
                parentChild.put(ng, currentNode); // Parent Child Mapping
                if(ng.name.equals(destinations)) return buildParentPath(parentChild, ng, source);
            }

        }

        return new ArrayList<>();
    }

    private static List<String> buildParentPath(Map<Node, Node> parentChild, Node currentNode, String source) {
        List<String> path = new ArrayList<>();
        path.add(currentNode.name);

        while (!currentNode.name.equals(source)){
            path.add(parentChild.get(currentNode).name);
            currentNode = parentChild.get(currentNode); // Traversing till Source Found
        }

        return path.reversed();
    }


}
