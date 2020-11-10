/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pic.Resource;

/**
 *
 * @author Acer
 */
public class Bgstatefrist {
    private BufferedImage bgImage, textImage , powerImage,namegame;

    public Bgstatefrist() {
        bgImage = Resource.getResourceImage("Pic/bg1111.png");
        textImage = Resource.getResourceImage("Pic/textbox1.png");
        namegame = Resource.getResourceImage("Pic/namegame11.png");
        //powerImage = Resource.getResourceImage("Pic/power.gif");
    }
    
    public void draw(Graphics g){
        g.drawImage(bgImage, 0, 10, null);
        g.drawImage(textImage, 950, 0, 400, 250, null);
        g.drawImage(namegame, 20, 40, 800, 250, null);
        //g.drawImage(powerImage, 100, 250, null);
    }
    
}