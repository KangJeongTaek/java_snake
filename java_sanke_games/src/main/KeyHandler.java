package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public static boolean upPressed, downPressed,leftPressed,rightPressed,pausePressed;

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP){
            downPressed = false;
            rightPressed = false;
            leftPressed = false;
            upPressed = true;
        }
        if(code == KeyEvent.VK_DOWN){
            upPressed = false;
            rightPressed = false;
            leftPressed = false;
            downPressed = true;
        }
        if(code == KeyEvent.VK_RIGHT){
            leftPressed = false;
            upPressed = false;
            downPressed = false;
            rightPressed = true;
        }
        if(code == KeyEvent.VK_LEFT){
            upPressed = false;
            downPressed = false;
            rightPressed = false;
            leftPressed = true;
        }
        if(code == KeyEvent.VK_SPACE){
            if(pausePressed == false){
                pausePressed = true;
            }else{
                pausePressed = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
