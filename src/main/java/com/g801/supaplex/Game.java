package com.g801.supaplex;

import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Elements.Murphy;
import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.States.MenuState;
import com.g801.supaplex.States.State;
import com.g801.supaplex.Viewer.GUI.LanternaGUI;
import com.g801.supaplex.Model.Size;

import java.io.IOException;
import java.util.Stack;

public class Game implements Runnable {

    private final LanternaGUI gui;
    private final Configuration configuration;
    private final MainMenu mainMenu;
    private final Stack<State> states;
    //Add a Muprhy or Display attribute

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
        this.configuration = Configuration.getInstance();

        this.gui = new LanternaGUI(new Size(150,50));
        this.mainMenu = new MainMenu();

        states = new Stack<>();
        states.push(new MenuState(mainMenu));
    }

    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 30;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0; // to allow CPU to catch up
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {

            long now = System.nanoTime(); //takes time to load from line 43 to this one


            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                try {
                    tick(now - lastTime);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
    private void tick(long time) throws IOException {
        states.peek().step(this, this.gui, time);
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

    public Configuration getConfiguration() {
        return configuration;
    }

    public static void main(String[] args) throws IOException {
        new Game().start();
    }

    //TODO
    public static void setMurphy(Murphy m){
        //Sets the Murphy field
    }
}

