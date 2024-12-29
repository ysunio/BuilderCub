package Archieve.Graph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], visited, newColor);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int oldColour, boolean[][] visited, int newColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length) return;
        if (visited[x][y] || image[x][y] != oldColour) return;
        visited[x][y] = true;

        if (image[x][y] == oldColour) image[x][y] = newColor;
        else return;

        int[] xC = new int[]{-1, 0, 1, 0};
        int[] yC = new int[]{0, -1, 0, 1};

        for (int id = 0; id < 4; id++)
            dfs(image, x + xC[id], y + yC[id], oldColour, visited, newColor);
    }
}
