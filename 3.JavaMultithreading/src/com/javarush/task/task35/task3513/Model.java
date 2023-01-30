package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int score;
    protected  int maxTile;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;


    public Model() {
        resetGameTiles();
    }
    private List<Tile> getEmptyTiles(){
       final List<Tile> emptyTile = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()){
                    emptyTile.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTile;
    }
    private void addTile(){
       List<Tile> list = getEmptyTiles();
        if (!list.isEmpty()) {
            Tile newTile = list.get((int) (Math.random() * list.size()));

            newTile.value = (Math.random() < 0.9 ? 2 : 4);
        }
    }
     void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }
    private boolean compressTiles(Tile[] tiles){
        Tile[] oldTile = Arrays.copyOf(tiles, tiles.length);
        int insertPosition = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (!tiles[i].isEmpty()) {
                if (i != insertPosition) {
                    tiles[insertPosition] = tiles[i];
                    tiles[i] = new Tile();
                }
                insertPosition++;
            }
        }
        return !Arrays.equals(oldTile, tiles);
    }

    private boolean mergeTiles(Tile[] tiles){
//        Tile[] oldTile = Arrays.copyOf(tiles, tiles.length);
        boolean result = false;
        LinkedList<Tile> tilesList = new LinkedList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].isEmpty()) {
                continue;
            }

            if (i < FIELD_WIDTH - 1 && tiles[i].value == tiles[i + 1].value) {
                int updatedValue = tiles[i].value * 2;
                if (updatedValue > maxTile) {
                    maxTile = updatedValue;
                }
                score += updatedValue;
                tilesList.addLast(new Tile(updatedValue));
                tiles[i + 1].value = 0;
                result = true;
            } else {
                tilesList.addLast(new Tile(tiles[i].value));
            }
            tiles[i].value = 0;
        }

        for (int i = 0; i < tilesList.size(); i++) {
            tiles[i] = tilesList.get(i);
        }
        return result;
    }

    private Tile[][] rotateClockwise(Tile[][] tiles) {
        final int N = tiles.length;
        Tile[][] result = new Tile[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                result[c][N - 1 - r] = tiles[r][c];
            }
        }
        return result;
    }

    public void left() {
        if (isSaveNeeded){
            saveState(gameTiles);
        }
        boolean moveFlag = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                moveFlag = true;
            }
        }
        if (moveFlag) {
            addTile();
            isSaveNeeded = true;
        }
    }

    public void right() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    public void up() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }
    private int getEmptyTilesCount() {
        return getEmptyTiles().size();
    }

    private boolean isFull() {
        return getEmptyTilesCount() == 0;
    }
    boolean canMove() {
        if (!isFull()) {
            return true;
        }

        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                Tile t = gameTiles[x][y];
                if ((x < FIELD_WIDTH - 1 && t.value == gameTiles[x + 1][y].value)
                        || ((y < FIELD_WIDTH - 1) && t.value == gameTiles[x][y + 1].value)) {
                    return true;
                }
            }
        }
        return false;
    }
    private void saveState(Tile[][] tiles){
        Tile[][] newTile =  new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                newTile[i][j] = new Tile(tiles[i][j].value);
            }
        }
//        for (int i = 0; i < newTile.length ; i++) {
//            for (int j = 0; j < newTile[i].length; j++) {
//                newTile[i][j].value = tiles[i][j].value;
//            }
//        }
        previousStates.push(newTile);
//        previousStates.push(tiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }
    public void rollback(){
        if (!previousStates.isEmpty() && !previousScores.isEmpty()){
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }
    public void randomMove(){
        int  n = (int) (Math.random() * 4);
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }
    private boolean hasBoardChanged() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value != previousStates.peek()[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }
    private MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency = new MoveEfficiency(-1, 0, move);
        move.move();
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTilesCount(), score, move);
        }
        rollback();
        return moveEfficiency;
    }
     void autoMove(){
        PriorityQueue<MoveEfficiency> queue= new PriorityQueue<>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        queue.peek().getMove().move();
    }
}
/*
Начнем с простого, реализуем метод randomMove в классе Model, который будет вызывать один из методов движения случайным образом.
Можешь реализовать это вычислив целочисленное n = ((int) (Math.random() * 100)) % 4.
Это число будет содержать целое псевдослучайное число в диапазоне [0..3], по каждому из которых можешь вызывать один из методов left, right, up, down.

Не забудь добавить в метод keyPressed класса Controller вызов метода randomMove по нажатию на клавишу R (код - KeyEvent.VK_R).

P.S. Проверку корректности работы метода randomMove оставляю полностью под твою ответственность, проверю только наличие вызова метода Math.random().
 */