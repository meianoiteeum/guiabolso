package br.com.guiabolso.utils;

import java.util.Random;

public class StringUtils {
    private static int MAX = 122;
    private static int MIN = 97;
    private static int MAXLENGHT = 60;
    private static int MINLENGHT = 10;

    public String getDescricao(){
        int lenght = getLenght();
        int space = lenght/6;
        char[] characteres = new char[lenght];

        for(int i = 0; i < lenght; i++){
            int charactere = getChar();
            if(i == space){
                characteres[i] = ' ';
                space = (space + space);
                continue;
            }else if(i%2 == 0){
                characteres[i] = (char) getVogal();
                continue;
            }
            characteres[i] = (char) charactere;
        }

        return new String(characteres);
    }

    private int getChar() {
        return new Random().nextInt((MAX - MIN) + 1) + MIN;
    }

    private int getVogal(){
        char[] vogais = {'a','e','i','o','u'};
        return vogais[new Random().nextInt((4 - 1) + 1) + 1];
    }

    private int getLenght(){
        return new Random().nextInt((MAXLENGHT - MINLENGHT) + 1) + MINLENGHT;
    }
}
