package com.g801.supaplex.Model.Level;


import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Elements.*;
import com.g801.supaplex.Model.Models.*;
import com.g801.supaplex.Model.Position;

import java.io.FileNotFoundException;
import java.util.*;

public class Display {
    private final SpriteFactory spriteFactory = new SpriteFactory();
    private static final Position blockSize = new Position(Sprite.width, Sprite.height);
    private Configuration configurations;
    private static Model[][] map;
    private static Murphy murphy;

    public Display() {
        configurations = Configuration.getInstance();
        murphy = null;
        render();

    }

    //Make this receive a movable and process according to instanceOf
    public static List<Model> getAura(Movable m){
        Position p = m.getPos();
        List<Model> ret = new ArrayList<Model>(4);
        Position point = new Position(p.getX()/blockSize.getX(), p.getY()/blockSize.getY());
        //ret[0] = block above
        ret.set(0, map[point.getX()][point.getY() - 1]);
        //ret[1] = block below
        ret.set(1, map[point.getX()][point.getY()+1]);
        //ret[2] = block to the left
        ret.set(2, map[point.getX()-1][point.getY()]);
        //ret[3] = block to the right
        ret.set(3, map[point.getX()+1][point.getY()]);

        return ret;
    }

    private void update(Movable m, Position old){
        Position arrPos = new Position(old.getX() / blockSize.getX(), old.getY() / blockSize.getY());
        map[arrPos.getY()][arrPos.getX()] = new Base(old);
        arrPos = new Position(m.getPos().getX() / blockSize.getX(), m.getPos().getY() / blockSize.getY());
        map[arrPos.getY()][arrPos.getX()] = m;
    }

    public void render(){
        LoadLevelBuild level = null;
        try {
            level = new LoadLevelBuild(configurations.getCurrentLevel());
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        Character[][] gameMap = level.getLevelMap();
        Position bounds = configurations.getMapBounds(),
                modelPos = null;
        Model load = null;
        for(int i = 0; i < bounds.getY(); i++) {
            map[i] = new Model[bounds.getX()];
            for(int j = 0; j < bounds.getX(); j++){
                modelPos = new Position(j * blockSize.getX(), i * blockSize.getY());
                switch(gameMap[i][j]){
                    case 'W' -> load = new Wall(modelPos);
                    case 'B' -> load = new Base(modelPos);
                    case 'C' -> load = new Chip(modelPos);
                    case 'E' -> load = new EndBlock(modelPos);
                    case 'M' -> {
                        murphy = new Murphy(modelPos);
                        load = murphy;
                    }
                    case 'I' -> load = new Infotron(modelPos);
                }
                map[i][j] = load;
                load = null;
            }
        }
    }

    public Model[][] getDisplayMap(){
        Integer x = configurations.getWidth();
        Integer y = configurations.getHeight();
        Integer yMin = configurations.getYmin();
        Integer xMin = configurations.getXmin();
        Model[][] ret = new Model[y][x];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++)
                ret[i][j] = map[yMin + i][xMin+j];
        }
        return ret;
    }

    public void endGame(){
        configurations = null;
        map = null;
        murphy = null;
    }
}
