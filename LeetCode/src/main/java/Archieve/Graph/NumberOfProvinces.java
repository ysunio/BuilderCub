package Archieve.Graph;

import java.util.ArrayList;

/*
       Number of Provinces
       https://www.geeksforgeeks.org/problems/number-of-provinces/1?ref=header_search
*/
public class NumberOfProvinces {


    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int provinces = 0;
        int[] visited = new int[V];

        for (int vIdx = 0; vIdx < visited.length; vIdx++) {
            if (visited[vIdx] == 1) continue;
            provinces++;
            dfs(adj, vIdx, visited);
        }

        return provinces;
    }

    /*
        DFS on GraphIdx to Find Mark Visited Territory.
    */
    static void dfs(ArrayList<ArrayList<Integer>> adjM, int nodeIdx, int[] visited) {
        ArrayList<Integer> neighbourNodes = adjM.get(nodeIdx);
        visited[nodeIdx] = 1;
        for (int nextIdx = 0; nextIdx < neighbourNodes.size(); nextIdx++) {
            if (visited[nextIdx] == 1 || neighbourNodes.get(nextIdx) == 0) continue;
            dfs(adjM, nextIdx, visited);
        }
    }
};
