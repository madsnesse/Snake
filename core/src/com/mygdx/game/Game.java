package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Board;
import com.mygdx.game.Snake;

import java.util.Timer;

public class Game extends InputAdapter implements ApplicationListener {
    private SpriteBatch batch;
    private BitmapFont font;
    private Board board;
    private int gametime;
    private Long lastMove;

    @Override
    public void create() {
        gametime = 0;
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        board = new Board(50, 50);
        Gdx.input.setInputProcessor(this);
        batch.begin();
        board.render(batch);
        batch.end();
        lastMove = System.currentTimeMillis();
    }



    @Override
    public boolean keyUp(int keycode){
        switch (keycode){
            case Input.Keys.UP:
                board.changeDir(Direction.NORTH);
                break;
            case Input.Keys.DOWN:
                board.changeDir(Direction.SOUTH);
                break;
            case Input.Keys.LEFT:
                board.changeDir(Direction.WEST);
                break;
            case Input.Keys.RIGHT:
                board.changeDir(Direction.EAST);
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resize(int i, int i1) {

    }

    //IMPORTANT
    //An object has to be initialized before being rendered
    @Override
    public void render() {
        Long currentTime = System.currentTimeMillis();
        if (currentTime - 100 > lastMove){
            lastMove = currentTime;
            board.moveSnake();
        }

        batch.begin();
        board.render(batch);
        batch.end();

    }

    @Override
    public void resume() {

    }

    /**
     * Is called when application is destroyed
     */
    //TODO Randomly crashes when exiting application
    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public Board getBoard(){
        return board;
    }

}
