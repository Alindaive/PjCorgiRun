/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pic.Resource;
import thegame.GameScreen;

/**
 *
 * @author Acer
 */
public class EnemyManegerBird {
    private List<Enemy> enemies1;
    private Random random;

    private BufferedImage imageBird1, imageBird2,imageBird3, imageBird4,imageBird5, imageBird6;
    private MainCharacter mainCharacter;
    private GameScreen gameScreen;
            
            
    public EnemyManegerBird(MainCharacter mainCharacter,GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.mainCharacter = mainCharacter;
        enemies1 = new ArrayList<Enemy>();
        imageBird1 = Resource.getResourceImage("Pic/Bird.png");
        imageBird2 = Resource.getResourceImage("Pic/Bird.png");
        imageBird3 = Resource.getResourceImage("Pic/Bird.png");
        imageBird4 = Resource.getResourceImage("Pic/Bird.png");
        imageBird5 = Resource.getResourceImage("Pic/Bird.png");
        imageBird6 = Resource.getResourceImage("Pic/Bird.png");
        random = new Random();
        
        Bird bird = new Bird(mainCharacter);
        enemies1.add(getRandomBird());
        random = new Random();
    }
    
    public void update(){
        for(Enemy e : enemies1){
            e.update();
            if(e.getBound().intersects(mainCharacter.getBound())){
                //mainCharacter.setAlive(false);
            }
        }
        Enemy fristEnemy = enemies1.get(0);
        if(enemies1.get(0).isOutofScreen()){
            enemies1.remove(fristEnemy);
            enemies1.add(getRandomBird());
        }
       
    }
    
    public void draw(Graphics g){
        for(Enemy e : enemies1 ){
            e.draw(g);
        }}
    
    private Bird getRandomBird(){
        Bird bird;
        bird = new Bird(mainCharacter);
        bird.setX(2500);
        bird.setY(100);
        if(random.nextBoolean()){
            bird.setImage(imageBird1);}
        if(random.nextBoolean()){
            bird.setImage(imageBird1);}
        if(random.nextBoolean()){
            bird.setImage(imageBird1);}
        if(random.nextBoolean()){
            bird.setImage(imageBird1);}
        if(random.nextBoolean()){
            bird.setImage(imageBird1);}
         
        else {
            bird.setImage(imageBird2);
        }
        return bird;
    }

    public void update(MainCharacter mainCharacter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}