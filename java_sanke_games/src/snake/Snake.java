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

    public Snake(){
        for(int i =0; i<5; i++){
            bl.add(i,new Block(Color.blue));
        }
        for(int i = 0; i<5; i ++){
            tempBl.add(i,new Block(Color.blue));
        }
        // b[0] = new Block(Color.BLUE);
        // b[1] = new Block(Color.BLUE);
        // b[2] = new Block(Color.blue);
        // b[3] = new Block(Color.blue);
        // tempB[0] = new Block(Color.BLUE);
        // tempB[1] = new Block(Color.blue);
        // tempB[2] = new Block(Color.blue);
        // tempB[3] = new Block(Color.blue);

    }
    public void setXY(int x, int y){
        for(int i =0;i<bl.size();i++){
            bl.get(i).x = x + Block.SIZE * i;
            bl.get(i).y = y;
        }
        // b[0].x = x;
        // b[0].y = y;
        // b[1].x = x + Block.SIZE;
        // b[1].y = y;
        // b[2].x = x + Block.SIZE *2;
        // b[2].y = y;
        // b[3].x = x + Block.SIZE *3;
        // b[3].y = y;
    }
    public void update(){
        if(KeyHandler.upPressed){
            bl.get(0).y -= Block.SIZE/4;
            for(int i = 1;i<bl.size(); i ++){
                if(bl.get(i).x<bl.get(0).x){
                    bl.get(i).x += Block.SIZE /4;
                }else if (bl.get(i).x> bl.get(0).x){
                    bl.get(i).x -= Block.SIZE/4;
                }else{
                    bl.get(i).y -= Block.SIZE /4;
                }
            }
            // b[0].y -= Block.SIZE/4;
            // for(int i = 1 ; i<b.length;i++){
            //     if(b[i].x < b[0].x){
            //         b[i].x += Block.SIZE /4;
            //     }else if(b[i].x > b[0].x){
            //         b[i].x -= Block.SIZE /4;
            //     }
            //     else{
            //         b[i].y -= Block.SIZE /4;
            //     }
            // } 
        }
        if(KeyHandler.leftPressed){
            bl.get(0).x -= Block.SIZE/4;
            for(int i = 1;i<bl.size(); i ++){
                if(bl.get(i).y<bl.get(0).y){
                    bl.get(i).y += Block.SIZE /4;
                }else if (bl.get(i).y> bl.get(0).y){
                    bl.get(i).y -= Block.SIZE/4;
                }else{
                    bl.get(i).x -= Block.SIZE /4;
                }
            }
        }
        if(KeyHandler.rightPressed){
            bl.get(0).x += Block.SIZE/4;
            for(int i = 1;i<bl.size(); i ++){
                if(bl.get(i).y<bl.get(0).y){
                    bl.get(i).y += Block.SIZE /4;
                }else if (bl.get(i).y> bl.get(0).y){
                    bl.get(i).y -= Block.SIZE/4;
                }else{
                    bl.get(i).x += Block.SIZE /4;
                }
            }
        }
        if(KeyHandler.downPressed){
            bl.get(0).y += Block.SIZE/4;
            for(int i = 1;i<bl.size(); i ++){
                if(bl.get(i).x<bl.get(0).x){
                    bl.get(i).x += Block.SIZE /4;
                }else if (bl.get(i).x> bl.get(0).x){
                    bl.get(i).x -= Block.SIZE/4;
                }else{
                    bl.get(i).y += Block.SIZE /4;
                }
            }
        }
        if(bl.get(0).x == PlayManager.targetBlock_X && bl.get(0).y == PlayManager.targetBlock_Y);
            bl.add(PlayManager.targetBlock);
            targetEat = true;
    }
        
    
        
    public void draw(Graphics2D g2){
        g2.setColor(bl.get(0).c);
        for(int i = 0; i<bl.size(); i ++){
            g2.fillRect(bl.get(i).x, bl.get(i).y, Block.SIZE, Block.SIZE);
        }
    }
}
