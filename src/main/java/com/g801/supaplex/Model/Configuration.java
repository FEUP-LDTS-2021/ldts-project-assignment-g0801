package com.g801.supaplex.Model;

public class Configuration {

    int currentLevel;
    int NUM_LEVELS;

    public Configuration(int totalLevels) {
        this.currentLevel = 1;
        this.NUM_LEVELS = totalLevels;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void increaseCurrentLevel() {
        if (currentLevel == NUM_LEVELS) {
            currentLevel = 1;
        }
        else currentLevel++;
    }

    public void lowerCurrentLevel() {
        if (currentLevel == 1) {
            currentLevel = NUM_LEVELS;
        } else currentLevel--;
    }
}
