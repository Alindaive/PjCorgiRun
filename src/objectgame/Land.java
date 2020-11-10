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
import pic.Resource;
import thegame.GameScreen;

/**
 *
 * @author Acer
 */
public class Land {
    
    private List<ImageLand> listImage;
    private BufferedImage ImageLand1;
    
    public Land(){
        ImageLand1 = Resource.getResourceImage("Pic/Land1.png");
        listImage = new ArrayList<ImageLand>();
        for(int i=0;i<2;i++){
            ImageLand imageLand = new ImageLand();
            imageLand.posX = (int)(i*ImageLand1.getWidth());
            imageLand.image = ImageLand1;
            listImage.add(imageLand);}
    }
    
    int countoutland =0;
    public void update(){
        for(ImageLand imageland : listImage){
            imageland.posX --;
            countoutland ++;
             if(resetland==true){
                 imageland.posX +=countoutland/2 ;
                 resetland=false;
                 countoutland =0;
                 
             }
        }
    }
    
    boolean resetland = false;
   
    public boolean resetland(){
        return(resetland = true);
    }
    
    public void draw(Graphics g){
        for(ImageLand imageLand:listImage){
            g.drawImage(imageLand.image, imageLand.posX, 325, null);
        }
    }

    public void clear(Land imageLand) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    private static class ImageLand {
        int posX;
        BufferedImage image;
        public ImageLand() {
        }
    }
       
}
