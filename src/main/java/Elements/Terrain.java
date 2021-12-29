package Elements;
import Models.Sprite;

public class Terrain extends Model{
    Terrain(double x, double y){
        pos = new Position(x, y);
    }

    Position getPos(){
        return pos;
    }

    Sprite getModel(){
        return model;
    }

    void setModel(Sprite s){
        model = s;
    }
}

