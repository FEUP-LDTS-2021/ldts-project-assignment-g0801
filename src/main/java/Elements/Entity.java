package Elements;

import Elements.Model;
import Models.Sprite;

public class Entity extends Model {

    Entity(double x, double y){
        pos = new Position(x, y);
    }

    @Override
    Position getPos() {
        return null;
    }

    @Override
    Sprite getModel() {
        return null;
    }
}
