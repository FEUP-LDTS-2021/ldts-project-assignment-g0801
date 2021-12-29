package Models;

public class Sprite {
    static int height = 5;
    static int width = 10;
    Pixel[][] bitmap;

    Sprite(){
       bitmap = new Pixel[height][width];
    }

    void base(){
        Pixel black = new Pixel("0x000000", 'B');
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++)
                bitmap[i][j] = black;
        }
    }

}
