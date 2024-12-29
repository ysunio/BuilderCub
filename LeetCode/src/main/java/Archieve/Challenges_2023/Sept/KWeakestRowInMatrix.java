package Archieve.Challenges_2023.Sept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KWeakestRowInMatrix {

    static class Node {
        int index;
        int value;

        Node(int i, int v) {
            this.index = i;
            this.value = v;
        }

        @Override
        public String toString() {
            return index + "-- " + value;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        k = k % (mat.length + 1);

        List<Node> rowRank = new ArrayList<>();

        int rI = 0;
        for (int idx = 0; idx < mat.length; idx++) {
            int totalOnes = 0;
            for (int idy = 0; idy < mat[0].length; idy++) {
                totalOnes += mat[idx][idy];
            }
            rowRank.add(new Node(idx, totalOnes));
        }

        rowRank.sort((a, b) -> a.value - b.value);

        int[] indexRes = new int[k];
        for (int idx = 0; idx < k; idx++) {
            indexRes[idx] = rowRank.get(idx).index;
        }

        return indexRes;
    }
}




// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/?envType=daily-question&envId=2023-09-18
