package thegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import objectgame.Clounds;
import objectgame.Bgstatefrist;
import objectgame.Overstate;
import objectgame.EnemyManegerRock;
import objectgame.Land;
import objectgame.MainCharacter;
import objectgame.Rocks;
import objectgame.EnemyManegerBird;
import objectgame.Bird;

public class GameScreen extends JPanel implements Runnable, KeyListener{
    public static final int GAME_FIRST_STATE =0;
    public static final int GAME_PLAY_STATE =1;
    public static final int GAME_OVER_STATE =2;
    public static final float GRAVITY = (float) 0.5; //cast to float/ตั้งค่าแรงโน้มถ่วง
    public static final float GROUND =  600;//เส้นพื้น
    private MainCharacter mainCharacter;//เรียกใช้class MainCharater แล้วให้มีObject ชื่อ mainchacracter
    private Land land;
    private Clounds clound;
    private Bgstatefrist bgst1;
    private Overstate bgst3;
    private Rectangle rect;
    private EnemyManegerRock enemiesManager;
    private EnemyManegerBird enemiesManager1;
    private Bird bird;
    private HelpWindow helpscreen;
    private int i=0;
    private int gameState;
    private int score;
    
    private Thread thread;
    public GameScreen(){
        //setBackground(Color.RED); //สีแบลคกราว
        helpscreen = new HelpWindow();
        thread = new Thread(this);
        mainCharacter = new MainCharacter();//สร้างObjectชื่อ
        land = new Land();
        clound = new Clounds();
        bgst1 = new Bgstatefrist();
        bgst3 = new Overstate();
        enemiesManager = new EnemyManegerRock(mainCharacter,this);
        //enemiesManager1 = new EnemyManegerBird(mainCharacter,this);
    }
    
    public void startGame(){
        thread.start();
    }

    @Override
    public void run() {
       while(true){
           try {
                update();
                repaint();//วาดใหม่/รีเฟรช
                Thread.sleep(20);//ทำให้มันช้า
           } catch (InterruptedException ex) {
               Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
    public void update(){
        switch(gameState){
            case GAME_PLAY_STATE:
                mainCharacter.update();//ให้Objectที่สร้าในคลาส เรียกmedthod .update
                land.update();
                enemiesManager.update();
                //enemiesManager1.update();
                if(!mainCharacter.getAlive()){
                    gameState = GAME_OVER_STATE;
                }
                break;}
    }
    
    public void setScore(int score){
        this.score += score;
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());//ทำให้ไม่เป็นภาพซ้อนกัน
        g.setColor(Color.red);
        g.drawRect(0,(int) GROUND, getWidth(), 0);//วาดเส้นพื้นสีแดง
        
        switch(gameState){
            case GAME_FIRST_STATE:
                //DrawAllFont(g);
                bgst1.draw(g);
                mainCharacter.draw(g);//ให้Object(mainCharacter)ที่สร้าในคลาสนี้ เรียกmedthod .draw() ที่สร้างใน(objectgame.MainCharacter)ต้องอิมพอด;
                Font ggg = new Font("Showcard gothic",Font.LAYOUT_LEFT_TO_RIGHT,80); 
                g.setFont(ggg);
                g.setColor(Color.pink);
                int Show =0;
                try {
                   Show = ReadScore();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);}
                String ShowTotalScore = String.valueOf(Show);
                g.drawString(ShowTotalScore,1025,180);  
                break;
            case GAME_PLAY_STATE:
                clound.draw(g);//ให้Object(clound)ที่สร้าในคลาสนี้ เรียกmedthod .draw() ที่สร้างใน(objectgame.Clounds)ต้องอิมพอด
                land.draw(g);//ให้Object(land)ที่สร้าในคลาสนี้ เรียกmedthod .draw() ที่สร้างใน(objectgame.Land)ต้องอิมพอด
                enemiesManager.draw(g);
                //enemiesManager1.draw(g); //นก
                mainCharacter.draw(g);//ให้Object(mainCharacter)ที่สร้าในคลาสนี้ เรียกmedthod .draw() ที่สร้างใน(objectgame.MainCharacter)ต้องอิมพอด;
                Font ttt = new Font("Showcard gothic",Font.BOLD,80); 
                g.setFont(ttt);
                g.setColor(Color.yellow);
                String ShowSCORE =String.valueOf(score);
                g.drawString("EXP "+String.format("%4s",ShowSCORE), 975, 100);
                break;
             case GAME_OVER_STATE:
                Font ppp = new Font("Showcard gothic",Font.LAYOUT_LEFT_TO_RIGHT,80); 
                g.setFont(ppp);
                g.setColor(Color.black);
                g.drawString("GAME OVER", 475, 225);
                bgst3.draw(g);
        }
    }

    public void DrawAllFont(Graphics g){
        int p =0,u=0;
                String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
                for ( int i = 0; i < fonts.length; i++ ){
                  Font ttt = new Font(fonts[i],Font.BOLD,10); 
                  g.setFont(ttt);
                  g.drawString(fonts[i],u,p);
                  p+=20;
                  if(i%30==0){
                     u+=150;
                     p=0;
                  }     
                }
    }
    
    
    public void WriteTotalScore() throws FileNotFoundException{
        int Totalscore = ReadScore();
        try (PrintWriter fw = new PrintWriter("TotalScore.txt")) {
            fw.print(Totalscore+score);
            
        }
    }
    
    
    public int ReadScore() throws FileNotFoundException{
      try (Scanner pp = new Scanner(new FileReader("TotalScore.txt"))) {
            String firstLine = pp.nextLine();
            int Totalscore = Integer.parseInt(firstLine);
       
           return Totalscore;
        
    }}
    
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) { //รันmethod เมือกดE
        //mainCharacter.jump();//ให้Objectที่สร้าในคลาส เรียกmedthod .jump
        switch(e.getKeyCode()){
            case KeyEvent.VK_CONTROL:
                if(gameState==GAME_FIRST_STATE){
                      helpscreen.display();
                }
            break;
            case KeyEvent.VK_ENTER:
                if(gameState==GAME_FIRST_STATE){
                    mainCharacter.setCharacter();
                    mainCharacter.update();
                }
            break;
            case KeyEvent.VK_SPACE:
                if(gameState==GAME_FIRST_STATE){
                    gameState =GAME_PLAY_STATE;}
                if(gameState==GAME_PLAY_STATE){
                    mainCharacter.jump();}//ให้Objectที่สร้าในคลาส เรียกmedthod .jump
                if(gameState==GAME_OVER_STATE){
                    gameState =GAME_FIRST_STATE;
                    mainCharacter.setAlive(true);
                    mainCharacter.setY(250);
                    try {
                    WriteTotalScore();}
                    catch (IOException ex) {
                    Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);}
                    score = 0;
                    land.resetland();
                    
                    }
                    break;
                }
        }
        
    

    @Override
    public void keyReleased(KeyEvent e) { //รันmethod เมือปล่อยE
        System.out.println("Key released");
    }
    
}
