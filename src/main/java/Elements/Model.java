package Elements;
import Models.Sprite;

public abstract class Model {
    Position pos;
    Sprite model;

    abstract Position getPos();
    abstract Sprite getModel();
}
