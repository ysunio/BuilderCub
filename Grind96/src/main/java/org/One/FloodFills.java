package org.One;

public class FloodFills {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        track(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }


    public void track(int[][] image, int sr, int sc, int newColor,int oldColor) {
        if(sr<0 || sc<0 || sr>=image.length || sc >= image[0].length)
            return;

        if(image[sr][sc]==newColor){
            return;
        }

        if(image[sr][sc]!=oldColor)
            return;

        image[sr][sc] = newColor;

        track(image,sr,sc+1,newColor,oldColor);
        track(image,sr+1,sc,newColor,oldColor);
        track(image,sr,sc-1,newColor,oldColor);
        track(image,sr-1,sc,newColor,oldColor);
    }
}
