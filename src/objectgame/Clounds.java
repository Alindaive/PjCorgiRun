/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objectgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pic.Resource;

/**
 *
 * @author Acer
 */
public class Clounds {
    private BufferedImage cloudImage;

    public Clounds() {
        cloudImage = Resource.getResourceImage("Pic/Cloundy-2.jpg");
    }
    
    public void draw(Graphics g){
        g.drawImage(cloudImage, 0, 0, null);
    }
    
}
