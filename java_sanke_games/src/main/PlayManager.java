package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import snake.Block;
import snake.Snake;

public class PlayManager {
    final int WIDTH = GamePanel.WIDTH;
    final int HEIGHT = GamePanel.HEIGHT;
    // 블록 스네이크 설정
    Snake snake;
    public static Block targetBlock;
    final int SNAKE_START_X;
    final int SNAKE_START_Y;
    public static int targetBlock_X;
    public static int targetBlock_Y;
    boolean game_over;
    Random random = new Random();

    public PlayManager(){
        snake = new Snake();
        SNAKE_START_X = GamePanel.WIDTH/2;
        SNAKE_START_Y = GamePanel.HEIGHT/2 + Block.SIZE;
        snake.setXY(SNAKE_START_X, SNAKE_START_Y);

        //타겟 블록 생성
        target();
 
    }
    // 먹고난 스네이크 다시 그리기
    public void nextSnake(){
        snake.setXY(snake.bl.get(0).x, snake.bl.get(0).y);
    }

    public void target(){
        targetBlock = new Block(Color.red);
        targetBlock_X = random.nextInt(WIDTH);
        targetBlock_Y = random.nextInt(HEIGHT);
        targetBlock.setXY(targetBlock_X,targetBlock_Y);
    }
    public void update(){
        snake.update();
    }

    public void draw(Graphics2D g2){
        // 시작 스네이크 그리기
        snake.draw(g2);

        // 랜덤 블록 그리기
        if(snake.targetEat == false){
            targetBlock.draw(g2);
        }
        //게임 정지
        g2.setColor(Color.yellow);
        g2.setFont(g2.getFont().deriveFont(50f));
        if(KeyHandler.pausePressed){
            g2.drawString("PAUSE",WIDTH/2 - 50,HEIGHT/2);

        // 타겟을 먹었다면
        }
        if(snake.targetEat){
            snake.bl.addLast(targetBlock);
            snake.targetEat = false;
            nextSnake();
            target();
        }

        // 게임 오버
        if(game_over){
            g2.drawString("Game Over", WIDTH/2 - 50, HEIGHT/2);
        }
    }
}
