package com.g801.supaplex;

import com.g801.supaplex.Model.GUI.*;
import com.g801.supaplex.Model.*;

import java.io.IOException;

public class Game {

    private final GUI gui;

    public Game() throws IOException {
        this.gui = new LanternaGUI(new Size(150,50));
    }

    public static void main(String[] args) throws IOException {
        Game test = new Game();
    }
}