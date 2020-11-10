

package objectgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pic.Resource;

/**
 *
 * @author Acer
 */
public class helppic {
    private BufferedImage help,namegame;

    public  helppic() {
        help = Resource.getResourceImage("Pic/helppic.png");
    }
    
    public void draw(Graphics g){
        g.drawImage(help, -5, -10, null);
        //g.drawImage(powerImage, 100, 250, null);
    }
    
}

 
