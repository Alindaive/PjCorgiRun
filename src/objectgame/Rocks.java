/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import pic.Resource;



/**
 *
 * @author Acer
 */
public class Rocks extends Enemy {
    private BufferedImage image;
    private int posX,posY;
    private Rectangle rect;
    private MainCharacter mainCharacter;
    
    public Rocks(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
        image = Resource.getResourceImage("Pic/Rock1.png");
        posX = 750;
        //posY = 435;
        rect = new Rectangle();
    }
    
    public void update(){
        posX -=10;
        rect.x = posX;
        rect.y = posY;
        rect.width = image.getWidth();
        rect.height = image.getHeight();
    }
    
    @Override
    public Rectangle getBound(){
        return rect;
    }
    
    @Override
    public void draw(Graphics g){
        g.drawImage(image, posX, posY, null);
    }
    
    public void setX(int x){
        posX=x;
    }
    
    public void setY(int y){
       posY =y;
    }
    
    public void setImage(BufferedImage image){
    this.image = image;
    }
    
    @Override
    public boolean isOutofScreen(){
        return (posX +image.getWidth()<0);
    }

    public boolean isOver(){
        return(mainCharacter.getX() > posX);
    }
    }