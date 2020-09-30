package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public class Board {
    private final int width;
    private final int height;
    private Snake snake;
    private Texture food = new Texture("food.png");
    private Texture tile = new Texture("tile.png");
    private Texture snakeHead = new Texture("snakehead.png");
    private Texture snakeBody = new Texture("snakebody.png");
    private Texture snakeTail = new Texture("snaketail.png");
    private int foodY;
    private int foodX;


    public void changeDir(Direction newDir) {
        snake.head.setDirection(newDir);
    }


    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        Random random = new Random();
        this.foodX = random.nextInt(width);
        this.foodY = random.nextInt(height);
        snake = new Snake();

    }

    public void render (SpriteBatch batch) {
        for (int y=0; y < height; y++) {
            for (int x=0; x < width; x++) {
                batch.draw(tile, x*10,y*10);
                if (y == foodY && x == foodX)batch.draw(food, x*10, y*10);
            }
        }
        //batch.draw(snakeHead, snake.head.getX()*10, snake.head.getY()*10);
        batch.draw(new TextureRegion(snakeHead), snake.head.getX()*10, snake.head.getY()*10, 0, 0, 10, 10, 1, 1, snake.head.getDirection());

        SnakePart current = snake.head.next;
        while (current.hasNext()){
            //batch.draw(snakeBody, current.getX()*10,current.getY()*10);
            batch.draw(new TextureRegion(snakeBody), current.getX()*10, current.getY()*10, 0, 0, 10, 10, 1, 1, current.getDirection());
            current = current.next;
        }
        batch.draw(new TextureRegion(snakeTail), snake.tail.getX()*10, snake.tail.getY()*10, 0, 0, 10, 10, 1, 1, snake.tail.getDirection());
    }


    public void moveSnake() {
        if (snake.head.getX() == foodX && snake.head.getY() == foodY){
            snake.eat();
            snake.eat();
            snake.eat();
        }
        snake.move();
    }

}


