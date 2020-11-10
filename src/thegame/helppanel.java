/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import pic.Resource;
import objectgame.helppic;

/**
 *
 * @author Acer
 */
public class helppanel extends JPanel{
    private helppic helpimage; 
     public helppanel() {
       helpimage = new helppic();
      
     }
     public void paint(Graphics g){
         helpimage.draw(g);
     }
     
}
