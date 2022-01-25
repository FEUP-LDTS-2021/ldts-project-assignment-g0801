package com.g801.supaplex.Model.Level;

import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Elements.*;
import com.g801.supaplex.Model.Models.*;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Viewer.GUI.GUI;
import java.io.FileNotFoundException;
import java.util.*;

public class Display {
    private static final Position blockSize = new Position(Sprite.width, Sprite.height);
    private Configuration configurations;
    private static List<Rock> rockList = new ArrayList<>();
    private static List<Scissors> scissorList = new ArrayList<>();
    private static Model[][] map;
    private static Murphy murphy;
    private static Integer infotronCount = 0;


    public Display() {
        configurations = Configuration.getInstance();
        murphy = null;
        render();
    }

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
    }

    public void update(Model m) {
        Position oldPosDown = new Position(m.getPos().getX(), m.getPos().getY() + 1);
        map[m.getPos().getY()][m.getPos().getX()] = m;
        map[m.getPos().getY() - 1][m.getPos().getX()] = new Base(oldPosDown);
    }

    public void updateRockRight(Model m) {

        Position oldPosLeft = new Position(m.getPos().getX() - 1, m.getPos().getY());
        Position oldPosDown = new Position(oldPosLeft.getUp().getX(), oldPosLeft.getUp().getY());
        map[m.getPos().getY()][m.getPos().getX()] = m;
        map[oldPosDown.getY()][oldPosDown.getX()] = new Base(oldPosDown);
    }

    public void updateRockLeft(Model m) {
        Position oldPosRight = new Position(m.getPos().getX() + 1, m.getPos().getY());
        Position oldPosDown = new Position(oldPosRight.getUp().getX(), oldPosRight.getUp().getY());
        map[m.getPos().getY()][m.getPos().getX()] = m;
        map[oldPosDown.getY()][oldPosDown.getX()] = new Base(oldPosDown);
    }

    public void updateScissor(Scissors m) {

        if (m.getDirection() == Scissors.Direction.RIGHT) {
            Position oldPosRight = new Position(m.getPos().getX() - 1, m.getPos().getY());
            map[m.getPos().getY()][m.getPos().getX() - 1] = new Base(oldPosRight);
        }
        else if (m.getDirection() == Scissors.Direction.LEFT) {
            Position oldPosLeft = new Position(m.getPos().getX() + 1, m.getPos().getY());
            map[m.getPos().getY()][m.getPos().getX() + 1] = new Base(oldPosLeft);
        }
        else if (m.getDirection() == Scissors.Direction.DOWN) {
            Position oldPosDown = new Position(m.getPos().getX(), m.getPos().getY() + 1);
            map[m.getPos().getY() - 1][m.getPos().getX()] = new Base(oldPosDown);
        }
        else {
            Position oldPosUp = new Position(m.getPos().getX(), m.getPos().getY() - 1);
            map[m.getPos().getY() + 1][m.getPos().getX()] = new Base(oldPosUp);
        }
        map[m.getPos().getY()][m.getPos().getX()] = m;
    }

    public void render () {
            endGame();
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

            for (int i = 0; i < gameMap.size(); i++) {
                String line = gameMap.get(i);
                for (int j = 0; j < line.length(); j++) {
                    Model load = new Model();
                    modelPos = new Position(j, i);
                    switch (line.charAt(j)) {
                        case 'K' -> {
                            load = new Wall(modelPos);
                            load.setSprite('K');
                        }
                        case 'W' -> load = new Wall(modelPos);
                        case ' ' -> load = new Base(modelPos);
                        case 'C' -> load = new Chip(modelPos);
                        case 'E' -> load = new EndBlock(modelPos);
                        case 'R' -> {
                            load = new Rock(modelPos);
                            rockList.add((Rock) load);
                        }
                        case 'X' -> {
                            load = new Scissors(modelPos);
                            scissorList.add((Scissors) load);
                        }
                        case 'M' -> {
                            load = new Murphy(modelPos);
                            murphy = (Murphy) load;
                            updateTopLeft();
                        }
                        case 'I' -> {
                            load = new Infotron(modelPos);
                            infotronCount++;
                        }
                    }
                    map[i][j] = load;
                }
            }
            configurations.updateSettings(murphy);
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

        public void decrementInfotronCount() {
            infotronCount--;
        }

        public void updateTopLeft () {
            configurations.updateSettings(getMurphy());
        }

        public Position getBlockSize() {
            return blockSize;
        }

        public Murphy getMurphy() {
            return murphy;
        }

        public void endGame() {
            map = null;
            murphy = null;
            scissorList.clear();
            rockList.clear();
            infotronCount = 0;
        }

    public Model[][] getMap() {
        return map;
    }

    public List<Rock> getRockList() {
        return rockList;
    }

    public List<Scissors> getScissorList() {
        return scissorList;
    }
}

