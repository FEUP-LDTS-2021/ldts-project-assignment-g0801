package com.g801.supaplex.Model.Elements;
import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Position;

public abstract class Model {
    Position pos;
    Sprite model;

    abstract Position getPos();
    abstract Sprite getModel();
}

