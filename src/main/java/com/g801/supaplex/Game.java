package com.g801.supaplex;

import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.States.MenuState;
import com.g801.supaplex.States.State;
import com.g801.supaplex.Viewer.GUI.LanternaGUI;
import com.g801.supaplex.Model.Size;

import java.io.IOException;
import java.util.Stack;

public class Game implements Runnable {

    private final LanternaGUI gui;
    private final MainMenu mainMenu;
    private final Stack<State> states;
    private int currentLevel;
    private final int TOTAL_LEVELS = 5;

    private boolean running = false;
    private Thread thread;

    private synchronized void start() {
        // Deal with loose thread
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running)
            return;

        running = false;

        try {
            // Needs try catch because throwing all thread together may not work
            thread.join(); // joins all threads and waits for them to die
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public Game() throws IOException {
        this.currentLevel = 1;
        this.gui = new LanternaGUI(new Size(150,50));
        this.mainMenu = new MainMenu();

        states = new Stack<>();
        states.push(new MenuState(mainMenu));
    }

    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0; // to allow CPU to catch up
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {

            long now = System.nanoTime(); //takes time to load from line 43 to this one

            try {
                states.peek().step(this, gui, now);
            } catch (IOException e) {
                e.printStackTrace();
            }
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " Ticks, FPS: " + frames);
                // Resetting
                updates = 0;
                frames = 0;
            }

        }
        stop();    }

    // EVERYTHING THAT UPDATES
    private void tick() {

    }

    // EVERYTHING THAT IS RENDERED (PROBABLY BOTH WILL BE PUT SOMEWHERE ELSE)
    private void render() {

    }

    public void pushState(State state) {
        states.push(state);
    }
    public void popState() {
        states.pop();
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void increaseCurrentLevel() {
        if (currentLevel == TOTAL_LEVELS) {
            currentLevel = 1;
        }
        currentLevel++;
    }

    public void lowerCurrentLevel() {
        if (currentLevel == 1) {
            currentLevel = TOTAL_LEVELS;
        }
        currentLevel--;
    }

    public static void main(String[] args) throws IOException {
        Game test = new Game();
        test.start();
    }
}

