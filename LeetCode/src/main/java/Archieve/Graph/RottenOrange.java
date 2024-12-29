package Archieve.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {

        Queue<Coordinate> queue = new LinkedList<>();
        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid[0].length; y++)
                if (grid[x][y] == 2) queue.add(new Coordinate(x, y));

        if (queue.size() == 0) return 0;

        int len = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Coordinate cN = queue.poll();

                int[] rC = new int[]{1, 0, -1, 0};
                int[] cC = new int[]{0, 1, 0, -1};

                for (int idx = 0; idx < 4; idx++) {
                    int nextRow = cN.x + rC[idx];
                    int nextCol = cN.y + cC[idx];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length) continue;
                    if (grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        queue.add(new Coordinate(nextRow, nextCol));
                    }
                }

                size--;
            }
            len++;
        }

        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid[0].length; y++)
                if (grid[x][y] == 1) return -1;

        return len;
    }
}
