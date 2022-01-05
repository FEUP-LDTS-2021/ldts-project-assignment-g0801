package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Menu.Elements.Image;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private final List<Image> textImagesList;

    public enum Option {START, LEVEL, EXIT}

    public String[] optString = {"START", "SELECT LEVEL", "QUIT"}; // GET THE STRING ASSOCIATED TO THE ENUMERATOR

    Option selected;

    Option[] options = Option.values();

    private int currentSelect;

    public MainMenu() {
        this.selected = Option.START;
        this.textImagesList = new ArrayList<>();
        createImages();
    }

    public int getPosElem(Option target) {
        int i = 0;
        for (; options[i] != target; i++);
        return i;
    }

    public String enumToString(Option menuOption) {
        int pos = getPosElem(menuOption);
        return optString[pos];
    }

    public void setSelected(Option selected) {
        this.selected = selected;
    }

    public Option[] getOpt() {
        return options;
    }

    public Option getCurrentSelect() {
        return selected;
    }

    public String[] getOptString() {
        return optString;
    }

    public void upButton() {
        if (selected == Option.START) selected = Option.EXIT;
        else {
            int i = getPosElem(selected);
            i--;
            selected = options[i];
        }
    }

    public void downButton() {
        if (selected == Option.EXIT) selected = Option.START;
        else {
            int i = getPosElem(selected);
            i++;
            selected = options[i];
        }
    }

    public void createImages() {

        SpriteFactory factory = new SpriteFactory();

        textImagesList.add(new Image(new Position( 40, 5), factory.factoryMethod('I').getBitmap()));
        textImagesList.add(new Image(new Position( 30, 10), factory.factoryMethod('I').getBitmap()));

        textImagesList.add(new Image(new Position( 100, 5), factory.factoryMethod('I').getBitmap()));
        textImagesList.add(new Image(new Position( 110, 10), factory.factoryMethod('I').getBitmap()));

        textImagesList.add(new Image(new Position( 70, 25), factory.factoryMethod('M').getBitmap()));

        textImagesList.add(new Image(new Position( 0, 45), factory.factoryMethod('W').getBitmap()));
        textImagesList.add(new Image(new Position( 0, 40), factory.factoryMethod('W').getBitmap()));
        textImagesList.add(new Image(new Position( 10, 45), factory.factoryMethod('W').getBitmap()));

        textImagesList.add(new Image(new Position( 10, 40), factory.factoryMethod('X').getBitmap()));
        textImagesList.add(new Image(new Position( 0, 35), factory.factoryMethod('X').getBitmap()));
        textImagesList.add(new Image(new Position( 20, 45), factory.factoryMethod('X').getBitmap()));


        textImagesList.add(new Image(new Position( 140, 35), factory.factoryMethod('X').getBitmap()));
        textImagesList.add(new Image(new Position( 130, 40), factory.factoryMethod('X').getBitmap()));
        textImagesList.add(new Image(new Position( 120, 45), factory.factoryMethod('X').getBitmap()));


        textImagesList.add(new Image(new Position( 140, 45), factory.factoryMethod('W').getBitmap()));
        textImagesList.add(new Image(new Position( 140,40), factory.factoryMethod('W').getBitmap()));
        textImagesList.add(new Image(new Position( 130, 45), factory.factoryMethod('W').getBitmap()));

        textImagesList.add(new Image(new Position( 60, 45), factory.factoryMethod('C').getBitmap()));

        textImagesList.add(new Image(new Position( 80, 45), factory.factoryMethod('C').getBitmap()));
    }
    public List<Image> getTextImagesList() {
        return textImagesList;
    }
}
