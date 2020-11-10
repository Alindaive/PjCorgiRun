package thegame;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThegameWindow extends JFrame {
    
    private GameScreen gameScreen;
    
    public ThegameWindow(){
       super("CORGI RUNS");//ชื่อหน้าต่าง
       setSize(1500,750);//ขนาดหน้าต่าง(x,y)(กว้าง/สูง)
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ปิดช่องoutputเมื่อกดปิด
       gameScreen = new GameScreen();//สร้าง
       add(gameScreen);//เพิ่มgamescreenในThegameWindow
       addKeyListener(gameScreen);//เพิ่มในKeyListenerในgameScreen
    }
    
    public void starGame(){
        gameScreen.startGame();
    }
    
    
    public static void main(String[] args) {
       ThegameWindow gw = new ThegameWindow();
       gw.setVisible(true);
       gw.starGame();
    }
    
}
