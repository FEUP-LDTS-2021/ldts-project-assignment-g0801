package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Elements.*;
import com.g801.supaplex.Model.Models.*;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Viewer.GUI.GUI;

import javax.accessibility.AccessibleTable;
import java.io.FileNotFoundException;
import java.util.*;

public class Display {
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

//    public static List<Model> getAura(Movable m){
//        //This is for Murphy and Scissors
//        Position p = m.getPos();
//        List<Model> ret = new ArrayList<Model>(4);
//        Position point = new Position(p.getX()/blockSize.getX(), p.getY()/blockSize.getY());
//        //ret[0] = block above
//        ret.set(0, map[point.getX()][point.getY() - 1]);
//        //ret[1] = block below
//        ret.set(1, map[point.getX()][point.getY()+1]);
//        //ret[2] = block to the left
//        ret.set(2, map[point.getX()-1][point.getY()]);
//        //ret[3] = block to the right
//        ret.set(3, map[point.getX()+1][point.getY()]);
//        //Over here we get rocks
//        return ret;
//    }

    public void update(Movable m, GUI.KEYACTION keyaction){

        switch (keyaction) {
            case DOWN -> {
                Position oldPosDown = new Position(m.getPos().getX(), m.getPos().getY() - 1);
                map[m.getPos().getY()][m.getPos().getX()] = m;
                map[m.getPos().getY() - 1][m.getPos().getX()] = new Base(oldPosDown);
            }
            case UP -> {
                Position oldPosUp = new Position(m.getPos().getX(), m.getPos().getY() + 1);
                map[m.getPos().getY()][m.getPos().getX()] = m;
                map[m.getPos().getY() + 1][m.getPos().getX()] = new Base(oldPosUp);
            }

            case LEFT -> {
                Position oldPosLeft = new Position(m.getPos().getX() - 1, m.getPos().getY());
                map[m.getPos().getY()][m.getPos().getX()] = m;
                map[m.getPos().getY()][m.getPos().getX() + 1] = new Base(oldPosLeft);
            }
            case RIGHT -> {
                Position oldPosRight = new Position(m.getPos().getX() + 1, m.getPos().getY());
                map[m.getPos().getY()][m.getPos().getX()] = m;
                map[m.getPos().getY()][m.getPos().getX() - 1] = new Base(oldPosRight);
            }
        }

        updateTopLeft();
    }

    public void render () {

            LoadLevelBuild level = null;
            try {
                level = new LoadLevelBuild(configurations.getCurrentLevel());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            assert level != null;
            ArrayList<String> gameMap = level.getLevelMap();
            Position bounds = configurations.getMapBounds(), modelPos;
            map = new Model[bounds.getY()][bounds.getX()];
            ArrayList<ArrayList<Model>> map1 = new ArrayList<>();
            for (int i = 0; i < gameMap.size(); i++) {
                String line = gameMap.get(i);
                for (int j = 0; j < line.length(); j++) {
                    Model load = new Model();
                    modelPos = new Position(i, j);
                    switch (line.charAt(j)) {
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

        public Model[][] getDisplayMap () {

            Integer x = configurations.getWidth();
            Integer y = configurations.getHeight();
            Integer yMin = configurations.getYmin();
            Integer xMin = configurations.getXmin();
            Model[][] ret = new Model[y][x];

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++)
                    ret[i][j] = map[yMin + i][xMin + j];
            }

            return ret;
        }

        public Integer getInfotronCount () {
            return infotronCount;
        }

        public void updateTopLeft () {
            configurations.updateSettings(murphy);
        }

        public Position getBlockSize() {
            return blockSize;
        }

        public Murphy getMurphy() {
            return murphy;
        }

        public void endGame() {
            configurations = null;
            map = null;
            murphy = null;
        }
}

