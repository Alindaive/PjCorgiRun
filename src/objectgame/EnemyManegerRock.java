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
public class EnemyManegerRock {
    private List<Enemy> enemies;
    private Random random;

    private BufferedImage imageRocks1, imageRocks2,imageRocks3, imageRocks4,imageRocks5, imageRocks6;
    private MainCharacter mainCharacter;
    private GameScreen gameScreen;
            
            
    public EnemyManegerRock(MainCharacter mainCharacter,GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.mainCharacter = mainCharacter;
        enemies = new ArrayList<Enemy>();
        imageRocks1 = Resource.getResourceImage("Pic/Rock1.png");
        imageRocks2 = Resource.getResourceImage("Pic/Rock2.png");
        imageRocks3 = Resource.getResourceImage("Pic/Rock3.png");
        imageRocks4 = Resource.getResourceImage("Pic/Rock4.png");
        imageRocks5 = Resource.getResourceImage("Pic/Rock5.png");
        imageRocks6 = Resource.getResourceImage("Pic/Rock6.png");
        random = new Random();
        
        Rocks rock = new Rocks(mainCharacter);
        enemies.add(getRandomRock());
        random = new Random();
    }
    
    public void update(){
        for(Enemy e : enemies){
            e.update();
            if(e.isOver()){
                gameScreen.setScore(10);
            }
            if(e.getBound().intersects(mainCharacter.getBound())){
                mainCharacter.setAlive(false);
            }
        }
        Enemy fristEnemy = enemies.get(0);
        if(enemies.get(0).isOutofScreen()){
            enemies.remove(fristEnemy);
            enemies.add(getRandomRock());
        }
       
    }
    
    public void draw(Graphics g){
        for(Enemy e : enemies ){
            e.draw(g);
        }}
    
    private Rocks getRandomRock(){
        Rocks rock;
        rock = new Rocks(mainCharacter);
        rock.setX(1400);
        rock.setY(480);
        if(random.nextBoolean()){
            rock.setImage(imageRocks1);}
        if(random.nextBoolean()){
            rock.setImage(imageRocks2);}
        if(random.nextBoolean()){
            rock.setImage(imageRocks3);}
        if(random.nextBoolean()){
            rock.setImage(imageRocks4);}
        if(random.nextBoolean()){
            rock.setImage(imageRocks5);}
        
        else {
            rock.setImage(imageRocks6);
        }
        return rock;
    }

    public void update(MainCharacter mainCharacter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}