import com.g801.supaplex.Model.GUI.*;
import com.g801.supaplex.Model.Size;

import java.io.IOException;

public class TestScreen {

    private final GUI gui;

    public TestScreen() throws IOException {
        this.gui = new LanternaGUI(new Size(150,50));
    }

    public static void main(String[] args) throws IOException {
        TestScreen test = new TestScreen();
    }
}