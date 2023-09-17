package Challenges_2023.Sept;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class ShortestPathOfAll {

    static class Pair{
        int first;
        int second;
        Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
    static class Node{
        int node;
        int dis;
        int mask;

        Node(int node, int dis, int mask){
            this.node = node;
            this.dis = dis;
            this.mask = mask;
        }
    }

    public int shortestPathLength(int[][] graph) {
        Queue<Node> nodesQueue = new LinkedList<>();
        Set<Pair> visitedSet = new HashSet<>();
        int totalNodes = graph.length;
        if(totalNodes == 1) return 0;

        for(int v = 0 ; v < totalNodes; v++ ){
            int mask = 1 << v;
            nodesQueue.add(new Node(v, 0, mask));
            visitedSet.add(new Pair(v, mask));
        }

        int allMask = (1 << totalNodes) - 1;

        while(!nodesQueue.isEmpty()){
            Node currentNode = nodesQueue.poll();
            int v = currentNode.node;
            int dis = currentNode.dis;
            int mask = currentNode.mask;
            if(mask == allMask) return dis;

            for(int neigh : graph[v]){
                int newMask = (mask | 1 << neigh);
                Pair nVis = new Pair(neigh, newMask);
                if(!visitedSet.contains(nVis)){
                    visitedSet.add(nVis);
                    nodesQueue.add(new Node(neigh, dis + 1, newMask));
                }
            }
        }

        return -1;
    }
}
