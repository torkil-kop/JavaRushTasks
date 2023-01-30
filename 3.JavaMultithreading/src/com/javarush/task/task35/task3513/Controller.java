package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
    private Model model;
    private View view;
    private static final int WINNING_TILE = 2048;

    public Controller(Model model) {
        this.model = model;
        view = new View(this);
    }

    public Tile[][] getGameTiles(){
       return model.getGameTiles();
    }
    public int getScore(){
        return model.score;
    }
    public void resetGame(){
        model.score = 0;
        view.isGameLost = false;
        view.isGameWon = false;
        model.resetGameTiles();
    }

    @Override
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
          resetGame();
      }
      else if (!model.canMove()) {
            view.isGameLost = true;
        } else if (!view.isGameLost && !view.isGameWon) {

          switch (e.getKeyCode()){
              case KeyEvent.VK_LEFT:
                  model.left();
                  break;
              case KeyEvent.VK_RIGHT:
                  model.right();
                  break;
              case KeyEvent.VK_UP:
                  model.up();
                  break;
              case KeyEvent.VK_DOWN:
                  model.down();
                  break;
              case KeyEvent.VK_Z:
                  model.rollback();
                  break;
              case KeyEvent.VK_R:
                  model.randomMove();
              case KeyEvent.VK_A:
                  model.autoMove();
                  break;
          }

      }
      if (model.maxTile == WINNING_TILE){
          view.isGameWon = true;
      }
      view.repaint();
    }

    public View getView() {
        return view;
    }
}
/*
Ну а теперь, самое главное! Для того чтобы иметь возможность обрабатывать пользовательский ввод,
необходимо переопределить метод keyPressed с одним параметром типа KeyEvent.

Логика метода должна быть следующей:
1. Если была нажата клавиша ESC - вызови метод resetGame.
2. Если метод canMove модели возвращает false - установи флаг isGameLost в true.
3. Если оба флага isGameLost и isGameWon равны false - обработай варианты движения:
а) для клавиши KeyEvent.VK_LEFT вызови метод left у модели;
б) для клавиши KeyEvent.VK_RIGHT вызови метод right у модели;
в) для клавиши KeyEvent.VK_UP вызови метод up у модели;
г) для клавиши KeyEvent.VK_DOWN вызови метод down у модели.
4. Если поле maxTile у модели стало равно WINNING_TILE, установи флаг isGameWon в true.
5. В самом конце, вызови метод repaint у view.

P.S. Для получения кода нажатой клавиши используй метод getKeyCode класса KeyEvent.
 */