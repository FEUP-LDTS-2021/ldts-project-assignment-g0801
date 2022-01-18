package com.g801.supaplex.Model.Menu;

import com.g801.supaplex.Model.Image;
import com.g801.supaplex.Model.Models.SpriteFactory;
import com.g801.supaplex.Model.Position;

import java.util.List;

abstract public class Menu {

    public void createImages(List<Image> imagesList)  {

        SpriteFactory factory = new SpriteFactory();

        imagesList.add(new Image(new Position( 40, 5), factory.factoryMethod('I').getBitmap()));
        imagesList.add(new Image(new Position( 30, 10), factory.factoryMethod('I').getBitmap()));

        imagesList.add(new Image(new Position( 100, 5), factory.factoryMethod('I').getBitmap()));
        imagesList.add(new Image(new Position( 110, 10), factory.factoryMethod('I').getBitmap()));

        imagesList.add(new Image(new Position( 70, 25), factory.factoryMethod('M').getBitmap()));

        imagesList.add(new Image(new Position( 0, 45), factory.factoryMethod('W').getBitmap()));
        imagesList.add(new Image(new Position( 0, 40), factory.factoryMethod('W').getBitmap()));
        imagesList.add(new Image(new Position( 10, 45), factory.factoryMethod('W').getBitmap()));

        imagesList.add(new Image(new Position( 10, 40), factory.factoryMethod('X').getBitmap()));
        imagesList.add(new Image(new Position( 0, 35), factory.factoryMethod('X').getBitmap()));
        imagesList.add(new Image(new Position( 20, 45), factory.factoryMethod('X').getBitmap()));


        imagesList.add(new Image(new Position( 140, 35), factory.factoryMethod('X').getBitmap()));
        imagesList.add(new Image(new Position( 130, 40), factory.factoryMethod('X').getBitmap()));
        imagesList.add(new Image(new Position( 120, 45), factory.factoryMethod('X').getBitmap()));


        imagesList.add(new Image(new Position( 140, 45), factory.factoryMethod('W').getBitmap()));
        imagesList.add(new Image(new Position( 140,40), factory.factoryMethod('W').getBitmap()));
        imagesList.add(new Image(new Position( 130, 45), factory.factoryMethod('W').getBitmap()));

        imagesList.add(new Image(new Position( 60, 45), factory.factoryMethod('R').getBitmap()));
        imagesList.add(new Image(new Position( 70, 45), factory.factoryMethod('R').getBitmap()));
        imagesList.add(new Image(new Position( 70, 40), factory.factoryMethod('R').getBitmap()));
        imagesList.add(new Image(new Position( 80, 45), factory.factoryMethod('R').getBitmap()));
    }
}
