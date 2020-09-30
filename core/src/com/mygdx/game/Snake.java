package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.LinkedList;

public class Snake{
	Texture snakeHead;
	Texture snakeBody;
	Texture snakeTail;
	SnakePart head;
	SnakePart tail;

	Snake(){
		snakeHead = new Texture("snakeHead.png");
		snakeTail = new Texture("snakeTail.png");
		snakeBody = new Texture("snakebody.png");
		head = new SnakePart(25,25);
		head.setNext(new SnakePart(24,25));
		tail = new SnakePart(23,25);
		head.next.prev = head;
		head.next.setNext(tail);
		tail.prev = head.next;
	}



	public void eat(){
		SnakePart temp;
		if (tail.getDir() == Direction.NORTH) {
			temp = new SnakePart(tail.getX(), tail.getY()-10);
			temp.setDirection(Direction.NORTH);
		}
		else if (tail.getDir() == Direction.SOUTH) {
			temp = new SnakePart(tail.getX(), tail.getY()+10);
			temp.setDirection(Direction.SOUTH);
		}
		else if (tail.getDir() == Direction.WEST) {
			temp = new SnakePart(tail.getX()+10, tail.getY());
			temp.setDirection(Direction.WEST);
		}
		else{
			temp = new SnakePart(tail.getX()-10, tail.getY());
		}
		temp.prev = tail;
		tail.next = temp;

		tail = temp;
	}




	public void move(){
		SnakePart newHead;
		if (head.getDir() == Direction.NORTH) {
			newHead = new SnakePart(head.getX(), head.getY()+1);
			newHead.setDirection(Direction.NORTH);
		}
		else if (head.getDir() == Direction.SOUTH) {
			newHead = new SnakePart(head.getX(), head.getY()-1);
			newHead.setDirection(Direction.SOUTH);
		}
		else if (head.getDir() == Direction.WEST) {
			newHead = new SnakePart(head.getX()-1, head.getY());
			newHead.setDirection(Direction.WEST);
		}
		else{
			newHead = new SnakePart(head.getX()+1, head.getY());
			newHead.setDirection(Direction.EAST);
		}
		newHead.next = head;
		head.prev = newHead;
		head = newHead;
		SnakePart newTail = tail.prev;
		newTail.next = null;
		tail = newTail;
	}
}
