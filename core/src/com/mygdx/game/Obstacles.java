package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {
    class WallPair{
        Vector2 position;
        float speed;
        int offset;
        Rectangle emptySpace;


        public WallPair(Vector2 pos){
            position = pos;
            speed = 2;
            offset = new Random().nextInt(500);
            emptySpace = new Rectangle(position.y, position.x - offset + 300, 50, betweenDistance);
        }

        public void update(){
            position.y -= speed;
            if(position.y < -50){
                position.y = 800;
                offset = new Random().nextInt(250);
            }
            emptySpace.y = position.y;
        }
    }

    static WallPair[] obs;
    Texture txt;
    int betweenDistance;
    public Obstacles(){
        txt = new Texture("wall.jpg");
        obs = new WallPair[4];
        betweenDistance = 50;
        int startPosX = 0;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2( 300,startPosX));
            startPosX += 220;
        }

    }

    public void render(SpriteBatch batch){
        for (int i = 0; i < obs.length; i++) {
            batch.draw(txt, obs[i].position.y, obs[i].position.x - obs[i].offset);
            batch.draw(txt, obs[i].position.y, obs[i].position.x + betweenDistance + txt.getHeight() - obs[i].offset);
        }
    }

    public void update(){
        for (int i = 0; i < obs.length; i++) {
            obs[i].update();
        }
    }

    public void recreate(){
        int startPosX = 0;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(300, startPosX));
            startPosX += 220;
        }
    }
}
