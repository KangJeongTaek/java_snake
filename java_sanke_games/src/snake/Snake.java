package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import main.KeyHandler;
import main.PlayManager;

public class Snake{
    // public Block b[] = new Block[4];
    // public Block tempB[] = new Block[4];
    public ArrayList <Block> bl = new ArrayList<>();
    public ArrayList <Block> tempBl = new ArrayList<>();
    public boolean targetEat;
    int timer;
    int timer2;
    
    public Snake(){
        for(int i =0; i<5; i++){
            bl.add(i,new Block(Color.blue));
        }
        for(int i = 0; i<5; i ++){
            tempBl.add(i,new Block(Color.blue));
        }


    }
    public void setXY(int x, int y){
        for(int i =0;i<bl.size();i++){
            bl.get(i).x = x + Block.SIZE * i;
            bl.get(i).y = y;
        }
    }
    public void update(){
        if(KeyHandler.upPressed){
            if(timer == 4){
                bl.get(0).y -= Block.SIZE;
                bl.get(1).x = bl.get(0).x;
                bl.get(1).y = bl.get(0).y;
               
                
            }
        }  
        if(KeyHandler.leftPressed){
            bl.get(0).x -= Block.SIZE/4;
            int y = bl.get(0).y;
            for(int i = 1;i<bl.size(); i ++){
                if(bl.get(i).y<y){
                    bl.get(i).y += Block.SIZE /4;
                }else if (bl.get(i).y> y){
                    bl.get(i).y -= Block.SIZE/4;
                }else{
                    bl.get(i).x -= Block.SIZE /4;
                }
            }
        }
        if(KeyHandler.rightPressed){
            bl.get(0).x += Block.SIZE/4;
            int y = bl.get(0).y;
            for(int i = 1;i<bl.size(); i ++){
                if(bl.get(i).y<y){
                    bl.get(i).y += Block.SIZE /4;
                }else if (bl.get(i).y> y){
                    bl.get(i).y -= Block.SIZE/4;
                }else{
                    bl.get(i).x += Block.SIZE /4;
                }
            }
        }
        if(KeyHandler.downPressed){
            bl.get(0).y += Block.SIZE/4;
            int x = bl.get(0).x;
            for(int i = 1;i<bl.size(); i ++){
                if(bl.get(i).x<x){
                    bl.get(i).x += Block.SIZE /4;
                }else if (bl.get(i).x> x){
                    bl.get(i).x -= Block.SIZE/4;
                }else{
                    bl.get(i).y += Block.SIZE /4;
                }
            }
        }
   
        if(bl.get(0).y<=PlayManager.targetBlock_Y&&bl.get(0).y+Block.SIZE>=PlayManager.targetBlock_Y&& bl.get(0).x <= PlayManager.targetBlock_X&& bl.get(0).x +Block.SIZE>=PlayManager.targetBlock_X){
            System.out.println(PlayManager.targetBlock_X);
            targetEat = true;
        }
    }
        
    
        
    public void draw(Graphics2D g2){
        g2.setColor(bl.get(0).c);
        for(int i = 0; i<bl.size(); i ++){
            g2.fillRect(bl.get(i).x, bl.get(i).y, Block.SIZE, Block.SIZE);
        }
    }
}
