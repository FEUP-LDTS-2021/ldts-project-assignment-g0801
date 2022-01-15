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
    private static Integer infotronCount = 0;

    public Display() {

        configurations = Configuration.getInstance();
        murphy = null;
        render();
    }

    //Make this receive a movable and process according to instanceOf
    public List<Model> getAura(Movable m){
        //This is for Murphy and Scissors
        List<Model> ret = new ArrayList<Model>(4);
        //ret[0] = block above
        ret.set(0, map[m.getPos().getX()][m.getPos().getY()-1]);
        //ret[1] = block below
        ret.set(1, map[m.getPos().getX()][m.getPos().getY()+1]);
        //ret[2] = block to the left
        ret.set(2, map[m.getPos().getX()-1][m.getPos().getY()]);
        //ret[3] = block to the right
        ret.set(3, map[m.getPos().getX()+1][m.getPos().getY()]);
        //Over here we get rocks
        return ret;
    }

    private void update(Movable m, Position old){
        Position arrPos = new Position(old.getX(), old.getY());
        map[arrPos.getY()][arrPos.getX()] = new Base(old);
        arrPos = new Position(m.getPos().getX(), m.getPos().getY());
        map[arrPos.getY()][arrPos.getX()] = m;
        updateTopLeft();
        updateBottomLeft();
    }

    public void render(){

        LoadLevelBuild level = null;
        try {
            level = new LoadLevelBuild(configurations.getCurrentLevel());
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }

        ArrayList<String> gameMap = level.getLevelMap();
        Position bounds = configurations.getMapBounds(), modelPos;
        map = new Model[bounds.getY()][bounds.getX()];

        for(int i = 0; i < gameMap.size(); i++) {
            String line = gameMap.get(i);
            for(int j = 0; j < line.length(); j++){
                Model load = new Model();
                modelPos = new Position(i, j);
                switch(line.charAt(j)){
                    case 'K' -> {
                        load = new Wall(modelPos);
                        load.setSprite(SpriteFactory.factoryMethod('K'));
                    }
                    case 'W' -> load = new Wall(modelPos);
                    case ' ' -> load = new Base(modelPos);
                    case 'C' -> load = new Chip(modelPos);
                    case 'E' -> load = new EndBlock(modelPos);
                    case 'R' -> load = new Rock(modelPos);
                    case 'M' -> {
                        murphy = new Murphy(modelPos);
                        load = murphy;
                        configurations.updateSettings(murphy);
                    }
                    case 'I' -> {
                        load = new Infotron(modelPos);
                        infotronCount++;
                    }
                }
                map[i][j] = load;
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

    public Integer getInfotronCount() {
        return infotronCount;
    }

    public void updateTopLeft() {
        Position posM = murphy.getPos();
        Position position = new Position((posM.getX() / blockSize.getX()) - (configurations.getWidth() /  2) ,
                (posM.getY() / blockSize.getY()) - (configurations.getHeight() / 2));
        configurations.setDisplayTopleft(position);
    }

    public void updateBottomLeft() {
        Position posM = murphy.getPos();
        Position position = new Position((posM.getX() / blockSize.getX()) - (configurations.getWidth() /  2) ,
                (posM.getY() / blockSize.getY()) - (configurations.getHeight()));
    }

    public Position getBlockSize() {
        return blockSize;
    }

    public void endGame(){
        configurations = null;
        map = null;
        murphy = null;
    }
}
