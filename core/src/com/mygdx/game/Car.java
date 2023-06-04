package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Car {
    Texture img;
    Vector2 position;
    float vx;
    float gravity;


    public Car(){
        img = new Texture("car1.png");
        position = new Vector2(100,270);
        vx = 0;
       // gravity = - 0.7f;
    }

    public void render(SpriteBatch batch){
        batch.draw(img, position.x, position.y);
    }

    public void update(){

        if (Gdx.input.isTouched()){
            int x=Gdx.input.getX();
            if(x>position.x) vx=10;
            else vx=-10;
        }

        position.x += vx;
    }

    public void recreate(){
        position = new Vector2(100,380);
        vx = 0;
    }
}
