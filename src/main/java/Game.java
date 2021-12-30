import com.g801.supaplex.Model.GUI.*;
import com.g801.supaplex.Model.Size;

import java.io.IOException;
import java.sql.SQLOutput;

public class Game implements Runnable {

    private final GUI gui;

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
        this.gui = new LanternaGUI(new Size(150,50));
    }

    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 30.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0; // to allow CPU to catch up
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running) {
//            System.out.println("Working??");
            long now = System.nanoTime(); //takes time to load from line 43 to this one
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
        stop();
    }

    // EVERYTHING THAT UPDATES
    private void tick() {

    }
    // EVERYTHING THAT IS RENDERED (PROBABLY BOTH WILL BE PUT SOMEWHERE ELSE)
    private void render() {

    }

    public static void main(String[] args) throws IOException {
        Game test = new Game();
        test.start();
        test.run();
    }
}