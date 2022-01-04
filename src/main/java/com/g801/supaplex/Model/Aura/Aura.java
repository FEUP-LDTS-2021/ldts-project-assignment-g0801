package com.g801.supaplex.Model.Aura;

import com.g801.supaplex.Model.Level.Display;
import com.g801.supaplex.Model.Level.GameScreen;
import com.g801.supaplex.Model.Models.Model;
import com.g801.supaplex.Model.Position;

import java.util.ArrayList;
import java.util.List;

public class Aura{
    private static List<Model> aura = new ArrayList<>(4);

    public void update(Position p){
        aura = Display.getAura(p);
    }
}