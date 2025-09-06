package com.buildercub.scenarios;

import java.util.*;

public class ColorSimilarity {

    static enum Colors{
        BLACK, BLUE, GREEN, RED, ORANGE, MAGENTA, YELLOW
    }

    static class Node{
        int id;
        Set<Colors> colors;

        Node(int id, Set<Colors> colors){
            this.id = id;
            this.colors = colors;
        }

        @Override
        public String toString(){
            return "Id: "+ this.id;
        }
    }

    public static void main(String[] args) {
        Node node0 = new Node(0, Set.of());
        Node node1 = new Node(1, Set.of(Colors.RED, Colors.GREEN, Colors.ORANGE, Colors.MAGENTA, Colors.YELLOW));
        Node node2 = new Node(2, Set.of(Colors.RED, Colors.GREEN));
        Node node3 = new Node(3, Set.of());
        Node node4 = new Node(4, Set.of(Colors.YELLOW, Colors.GREEN, Colors.BLACK, Colors.ORANGE));
        Node node5 = new Node(5, Set.of(Colors.GREEN, Colors.YELLOW));

        // Groups <Node0>, <Node1, Node2>, <Node3>, <Node4, Node5>;

        System.out.println("\nWith Union Find");
        List<List<Node>> similarityGroup = getSimilarNodes(List.of(node0, node1, node2, node3, node4, node5), 3);
        for(List<Node> nodeList : similarityGroup) System.out.println(nodeList);

        System.out.println("\nWith DFS");

        List<List<Node>> similarityGroup2 = getSimilarNodesDfs(List.of(node0, node1, node2, node3, node4, node5), 3);
        for(List<Node> nodeList : similarityGroup2) System.out.println(nodeList);
    }

    // O(N^2)
    private static List<List<Node>> getSimilarNodes(List<Node> nodes, int colorSizeThresholds) {
        UnionFind unionFind = new UnionFind(nodes.size());
        for(int idx = 0; idx < nodes.size(); idx++) {
            for (int idy = idx + 1; idy < nodes.size(); idy++) {
                Set<Colors> colorCopy = new HashSet<>(nodes.get(idx).colors);
                colorCopy.retainAll(nodes.get(idy).colors);
                if (colorCopy.size() >= colorSizeThresholds) unionFind.union(idx, idy);
            }
        }

        Map<Integer, Node> storeMapping = new HashMap<>();
        nodes.forEach(it -> storeMapping.put(it.id, it));

        Map<Integer, List<Node>> finalResult = new HashMap<>();
        for(int idx = 0; idx < nodes.size(); idx++){
            int root = unionFind.find(idx);
            finalResult.computeIfAbsent(root, K -> new ArrayList<>()).add(storeMapping.get(idx));
        }

        return new ArrayList<>(finalResult.values());
    }


    // UNION FIND

    static class UnionFind{

        int[] parentIdx;
        int[] rankOrder;

        UnionFind(int K){
            this.parentIdx = new int[K];
            this.rankOrder = new int[K];

            for(int idx = 0; idx < K; idx++){
                parentIdx[idx] = idx;
            }
        }

        void union(int x, int y){
            int X = find(x); int Y = find(y);
            if(X == Y) return; // They are Same

            if(rankOrder[X] > rankOrder[Y]){
                parentIdx[X] = Y;
            }else if(rankOrder[Y] > rankOrder[X])
                parentIdx[Y] = X;
            else {
                parentIdx[X] = Y; rankOrder[X]++;
            }
        }

        int find(int idx){
            if(idx != parentIdx[idx]){
                // Path Compression as Well as Finding
                parentIdx[idx] = find(parentIdx[idx]);
            }
            return parentIdx[idx];
        }

    }


    // O(N^2) using DFS
    private static List<List<Node>> getSimilarNodesDfs(List<Node> nodes, int colorSizeThresholds) {
        boolean[] isVisited = new boolean[nodes.size()];
        List<List<Node>> res = new ArrayList<>();
        for(int idx = 0; idx < nodes.size(); idx++){
            List<Node> group = new ArrayList<>();
            if(isVisited[idx]) continue;
            dfsForGroup(nodes, idx, isVisited, group, colorSizeThresholds);
            res.add(group);
        }
        return res;
    }

    private static void dfsForGroup(List<Node> nodes, int idx,  boolean[] isVisited, List<Node> group, int threshold){
        if(idx >= nodes.size() || isVisited[idx]) return;

        group.add(nodes.get(idx));
        isVisited[idx] = true;

        for(int tI = 0; tI < nodes.size(); tI++){
            if(isVisited[tI]) continue;
            if(isSimilar(nodes.get(idx), nodes.get(tI), threshold)) dfsForGroup(nodes, tI, isVisited, group, threshold);
        }

    }

    private static boolean isSimilar(Node node, Node node1, int threshold) {
        Set<Colors> aColors = new HashSet<>(node.colors);
        aColors.retainAll(node1.colors);
        return aColors.size() >= threshold;
    }


}
