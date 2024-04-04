package main;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        JFrame windows = new JFrame("snake_games");
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.setResizable(false);
        
        GamePanel gp = new GamePanel();
        windows.add(gp);
        windows.pack();
        windows.setLocationRelativeTo(null);
        windows.setVisible(true);
        
        gp.launchGame();
    }
}
