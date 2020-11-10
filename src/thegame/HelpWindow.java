/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thegame;

import java.awt.Graphics;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pic.Resource;


/**
 *
 * @author Acer
 */
public class HelpWindow extends JFrame{
    private helppanel helpimage;
    public HelpWindow(){ 
        setSize(500, 500);
        setTitle("Help");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        helpimage = new helppanel();
        add(helpimage);
    }
    
    public void display(){
        HelpWindow hw = new HelpWindow();
        hw.setVisible(true);
        
       
        
        
       
        
        
    }
 
}
