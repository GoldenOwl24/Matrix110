import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        JFrame wnd = new JFrame();
        Gameplay gamePlay = new Gameplay(); 
        wnd.setBounds(10, 10, 1000, 800); // Dimensions of the window
        wnd.setTitle("Brick Breaker Matrix v1.10");
        wnd.setResizable(false);
        wnd.setVisible(true);
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wnd.setLocationRelativeTo(null); // Center the window on the screen
        wnd.add(gamePlay); 
    }
}