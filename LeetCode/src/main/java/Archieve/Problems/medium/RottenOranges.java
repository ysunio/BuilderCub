package Archieve.Problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    static class Coord {
        int x;
        int y;

        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        }));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Coord> queue = new LinkedList<>();
        int currentMinutes = 0;
        for (int idx = 0; idx < grid.length; idx++) {
            for (int idy = 0; idy < grid[0].length; idy++) {
                if (grid[idx][idy] == 2)
                    queue.add(new Coord(idx, idy));
            }
        }

        while (!queue.isEmpty()) {
            currentMinutes++;
            int currentSize = queue.size();
            while (currentSize-- != 0) {
                Coord rotten = queue.poll();
                int idx = rotten.x;
                int idy = rotten.y;
                // Right
                if (idy + 1 < grid[0].length && grid[idx][idy + 1] == 1) {
                    grid[idx][idy + 1] = 2;
                    queue.add(new Coord(idx, idy + 1));
                }
                // Left
                if (idy - 1 >= 0 && grid[idx][idy - 1] == 1) {
                    grid[idx][idy - 1] = 2;
                    queue.add(new Coord(idx, idy - 1));
                }
                // Top
                if (idx - 1 >= 0 && grid[idx - 1][idy] == 1) {
                    grid[idx - 1][idy] = 2;
                    queue.add(new Coord(idx - 1, idy));
                }
                // Down
                if (idx + 1 < grid.length && grid[idx + 1][idy] == 1) {
                    grid[idx + 1][idy] = 2;
                    queue.add(new Coord(idx + 1, idy));
                }
            }
        }

        for (int idx = 0; idx < grid.length; idx++) {
            for (int idy = 0; idy < grid[0].length; idy++) {
                if (grid[idx][idy] == 1) return -1;
            }
        }

        return Math.max(currentMinutes - 1, 0);
    }
}
