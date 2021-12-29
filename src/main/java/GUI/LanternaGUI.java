package GUI;

import com.g10.supaplex.Size;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.MouseCaptureMode;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class LanternaGUI implements GUI {

    private final TerminalScreen screen;
    private final Size size;

    public LanternaGUI(Size size) throws IOException {
        this.size = size;
        Terminal terminal = createTerminal(size.getWidth(), size.getHeight());
        screen = createScreen(terminal);
    }

    private TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen screen;
        screen = new TerminalScreen(terminal);
        // Since we will not use the mouse cursor
        screen.setCursorPosition(null);
        screen.startScreen();
        // Allows resize of window
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

        terminalFactory.setTerminalEmulatorTitle("Supaplex");
        terminalFactory.setMouseCaptureMode(MouseCaptureMode.CLICK_RELEASE_DRAG_MOVE);
        return terminalFactory.createTerminal();
    }

    @Override
    public KEYACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return KEYACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return KEYACTION.CLOSE;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return KEYACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'p') return KEYACTION.PAUSE;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'r') return KEYACTION.RESTART;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'h') return KEYACTION.SKIP;
        if (keyStroke.isCtrlDown()) {
            if (keyStroke.getKeyType() == KeyType.ArrowUp) return KEYACTION.EAT_UP;
            if (keyStroke.getKeyType() == KeyType.ArrowDown) return KEYACTION.EAT_DOWN;
            if (keyStroke.getKeyType() == KeyType.ArrowRight) return KEYACTION.EAT_RIGHT;
            if (keyStroke.getKeyType() == KeyType.ArrowLeft) return KEYACTION.EAT_LEFT;
        } else {
            if (keyStroke.getKeyType() == KeyType.ArrowUp) return KEYACTION.UP;
            if (keyStroke.getKeyType() == KeyType.ArrowDown) return KEYACTION.DOWN;
            if (keyStroke.getKeyType() == KeyType.ArrowRight) return KEYACTION.RIGHT;
            if (keyStroke.getKeyType() == KeyType.ArrowLeft) return KEYACTION.LEFT;
        }
        if (keyStroke.getKeyType() == KeyType.Enter) return KEYACTION.SELECT;
        return KEYACTION.NONE;
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    @Override
    public Size getSize() {
        return this.size;
    }
}
