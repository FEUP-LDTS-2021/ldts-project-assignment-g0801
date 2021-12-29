package Models;

public class Pixel {
    String colorCode;
    char symb;

    Pixel(String cc, char s){
        colorCode = cc;
        symb = s;
    }

    String getCode(){
        return colorCode;
    }

    char getSymb(){
        return symb;
    }
}
