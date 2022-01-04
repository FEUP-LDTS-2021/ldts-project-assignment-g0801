package com.g801.supaplex.Controller;

import com.g801.supaplex.Game;
import com.g801.supaplex.Viewer.GUI.GUI;

import java.io.IOException;

public abstract class Controller<T> {


    private T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return this.model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public abstract void execute(Game game, GUI.KEYACTION keyaction, long time) throws IOException;
}