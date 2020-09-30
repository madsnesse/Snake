package com.mygdx.game;

public class SnakePart {
    private int x;
    private int y;
    private Direction dir;
    SnakePart next = null;
    SnakePart prev = null;

    SnakePart(int x, int y){
        setX(x);
        setY(y);
        this.dir = Direction.EAST;
    }
    public boolean hasNext(){
        return next != null;
    }
    public void setNext(SnakePart s){
        this.next = s;
    }
    public SnakePart getNext(){return this.next;}

    public void setPrev(SnakePart s){this.prev = s;}
    public SnakePart getPrev (){return this.prev;}

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setDirection(Direction d){
        this.dir = d;
    }
    public Direction getDir(){
        return this.dir;
    }
    public int getDirection(){
        switch (dir){
            case NORTH:
                return 90;
            case WEST:
                return 180;
            case SOUTH:
                return 270;
            default:
                return 0;
        }
    }
}
