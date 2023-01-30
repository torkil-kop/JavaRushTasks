package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

/* 
Цвета радуги
*/

public class RainbowGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(10, 7);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 10; j++) {
                switch (i) {
                    case 0:
                        setCellColor(j, i, Color.RED);
                        break;
                    case 1:
                        setCellColor(j, i, Color.ORANGE);
                        break;
                    case 2:
                        setCellColor(j, i, Color.YELLOW);
                        break;
                    case 3:
                        setCellColor(j, i, Color.GREEN);
                        break;
                    case 4:
                        setCellColor(j, i, Color.BLUE);
                        break;
                    case 5:
                        setCellColor(j, i, Color.INDIGO);
                        break;
                    case 6:
                        setCellColor(j, i, Color.VIOLET);
                        break;


                }

            }
        }
    }
}
/*
Color.RED
Color.ORANGE
Color.YELLOW
Color.GREEN
Color.BLUE
Color.INDIGO
Color.VIOLET
 */