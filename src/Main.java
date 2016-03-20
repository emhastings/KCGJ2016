import java.io.File;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame{
   
    static {
        //System.out.println(System.getProperty("java.library.path"));
        System.setProperty("java.library.path", new File("native").getAbsolutePath());
        //System.getProperty("java.library.path")+File.pathSeparator+new File("native").getAbsolutePath());
        System.out.println(System.getProperty("java.library.path"));
    }
    
   public static final String gamename = "MyGameName";
   public static final int play = 0;
   public static final int xSize = 400;
   public static final int ySize = 300;
   
   public Main(String gamename){
      super(gamename);
      this.addState(new Play());
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
      this.getState(play).init(gc, this);
      this.enterState(play);
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Main(gamename));
         appgc.setDisplayMode(xSize, ySize, false);
         appgc.setTargetFrameRate(60);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }
}