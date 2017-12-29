package com.mohammed.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

import com.mohammed.game.entity.mob.Player;
import com.mohammed.game.graphics.Screen;
import com.mohammed.game.graphics.SpriteSheet;
import com.mohammed.game.input.Keyboard;
import com.mohammed.game.input.Mouse;
import com.mohammed.game.level.Level;
import com.mohammed.game.level.TileCoordinate;

public class Game extends Canvas implements Runnable{
   /**
    * ©Mohammed Qureshi 2014-2015
    */
   
   /*
    * All Textures Are Designed By Mohammed Faisal Qureshi.
    */	
   private static final long serialVersionUID = 1L;

   private static int WIDTH = 317; //317
   private static int HEIGHT = 170; //170
   private static int scale = 4;
   private static int Health = 112;
   private static int Money = 0;
   public static String title = "The Kings Land";

   private Thread gamethread;
   private JFrame frame;
   private Keyboard key;
   private Level level;
   private Player player;
   private Screen screen;
   private boolean running = false;

   private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
         BufferedImage.TYPE_INT_RGB);
   
   private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
         .getData();

   public Game() {
      Dimension size = new Dimension(WIDTH * scale, HEIGHT * scale);
      setPreferredSize(size);
      screen = new Screen(WIDTH, HEIGHT);
      frame = new JFrame();
      key = new Keyboard();
      level = Level.spawn;
      TileCoordinate playerSpawn = new TileCoordinate(20,20);
      player = new Player(playerSpawn.x(),playerSpawn.y(),key);
      level.add(player);
      
      addKeyListener(key);
      
      Mouse mouse = new Mouse();
      addMouseListener(mouse);
      addMouseMotionListener(mouse);
   }
   
   public static int getWindowWidth(){
      return WIDTH * scale;
   }
   
   public static int getWindowHeight(){
      return HEIGHT * scale;
   }
   
   public synchronized void start() {
      running = true;
      gamethread = new Thread(this, "Display");
      gamethread.start();
   }

   public synchronized void stop() {
      running = false;
      try {
         gamethread.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public void run() {
      long lastTime = System.nanoTime();
      long timer = System.currentTimeMillis();
      final double ns = 1000000000.0 / 60.0;
      double delta = 0;
      int frames = 0;
      int updates = 0;
      
      requestFocus();
      
      while (running) {
         long now = System.nanoTime();
         delta += (now - lastTime) / ns;
         lastTime = now;
         while (delta >= 1) {
            update();
            updates++;
            delta--;
         }

         render();
         frames++;

         if (System.currentTimeMillis() - timer > 1000) {
            timer += 1000;
            //System.out.println(updates + " ups, " + frames + " fps");
            frame.setTitle(title + "  |  " + updates + " ups, " + frames
                  + " fps");
            // ALT + 124 = |
            updates = 0;
            frames = 0;
         }
         
      }
      stop();
   }
   
   public void update() {
      key.update();
      level.update();
   }

   public void render() {
      BufferStrategy bs = getBufferStrategy();
      if (bs == null) {
         createBufferStrategy(3);
         return;
      }

      screen.clear();
      double xScroll = player.getX() - screen.Width/2;
      double yScroll = player.getY() - screen.Height/2;
      level.render((int)xScroll, (int)yScroll, screen);
      
      //Place Holders - Inventory - Menu
      screen.renderSheet(0, 30, SpriteSheet.inventory, false);
      screen.renderSheet(282, 5, SpriteSheet.Player_Profile, false);
      ////////////////////////////////////////////////////////
      for (int i = 0; i < pixels.length; i++) {
         pixels[i] = screen.pixels[i];
      }
      Graphics g = bs.getDrawGraphics();
      g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
      //Font
      g.setColor(Color.WHITE);
      g.setFont(new Font("Century Gothic",0, 20));
      // Cords Of Player - Top Right
      g.drawString("X: " + player.getX() + ", Y: " + player.getY(), 750, 25);
      //Cords Of Player
      
      //Money Method
      g.setColor(Color.BLUE);
      g.setFont(new Font("Century Gothic" ,0, 20));
      g.drawString("Coin's" , 4, 595);
      
      g.setColor(Color.GREEN);
      g.fillRect(80, 580, 100, 15);
      
      g.setColor(Color.BLACK);
      g.drawRect(80, 580, 100, 15);
      
      g.setFont(new Font("Century Gothic" ,0, 16));
      g.drawString("£"+Money , 82, 594);
      
      if(key.increaseMoney){
    	  Money = Money + 1;
      }
      if(key.decreaseMoney){
    	  Money = Money - 1;
      }
      
      if(Money <= 0){
    	  Money = 0;
      }
      if(Money >= 10000){
    	  Money = 10000;
      }
      
      //Change Health
      g.setColor(Color.GRAY);
      g.fillRect(1132, 156,  112, 12);
      g.setColor(Color.RED);
      //          N/A  N/A  Heath N/A
      g.fillRect(1132, 156,  Health, 12);
      
      if(key.increasehealth){
    	  Health = Health + 1;
      }
      if(key.decreasehealth){
    	  Health = Health - 1;
      }
      if(Health <= 0){
    	  Health = 0;
    	  g.setColor(Color.BLACK);
    	  g.setFont(new Font("Century Gothic" ,0, 100));
    	  g.drawString("GAME OVER", WIDTH/2*scale-250, HEIGHT/2*scale);
      }
      if(Health >= 112){
    	  Health = 112;
      }
      
      
      g.dispose();
      bs.show();

   }

   public static void main(String args[]) {
      Game game = new Game();
      game.frame.setResizable(false);
      game.frame.setTitle(Game.title);
      game.frame.add(game);
      game.frame.pack();
      game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      game.frame.setLocationRelativeTo(null);
      game.frame.setVisible(true);
      game.start();
   }
}
