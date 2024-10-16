import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


//This class creates the initial game "Play" option and image
public class Launch extends JPanel implements ActionListener {
    private JFrame frame;
    private JButton playButton;
    private Image backgroundImage;
    private static final int WINDOW_WIDTH = 800; // Set the width of the window
    private static final int WINDOW_HEIGHT = 600; // Set the height of the window
    Font MatrixFont;
    private JButton infoButton;

    public Launch() {
        // Load the background image
        try {
            backgroundImage = ImageIO.read(new File("_b35486c8-42a6-4f64-b4b0-30c60f537c6c.jpeg")); // Relative path from github file
        } catch (IOException e) {
            e.printStackTrace();
        }

        //creation of the matrix font and registering it
        try{
            MatrixFont = Font.createFont(Font.TRUETYPE_FONT, new File("Matrix-MZ4P.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Matrix-MZ4P.ttf")));
            
        } catch(Exception e){
            e.printStackTrace();
        }//end of try catch

        // Create the frame and button
        frame = new JFrame();
        playButton = new JButton("PLAY");

        //Create information button
        infoButton = new JButton("i");
        infoButton.setFont(MatrixFont);
        infoButton.setPreferredSize(new Dimension(20,20));
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new HowTo();
            }
        });

        // Create a JPanel for the background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        

        panel.setLayout(null); // Using null layout to manually position components
        playButton.setBounds(WINDOW_WIDTH / 2 - 100, WINDOW_HEIGHT / 2 - 20, 200, 40); // Center the button
        playButton.setFocusable(false);
        playButton.addActionListener(this);
        panel.add(playButton);
        

        //Brick breaker label
        JLabel label = new JLabel("BRICK BREAKER 1.10");
		label.setFont(MatrixFont);
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setBackground(Color.BLACK);
        int labelWidth = 400;  
        int labelHeight = 100; 
        int labelX = (WINDOW_WIDTH - labelWidth) / 2; 
        int labelY = 40; 
        label.setBounds(labelX, labelY, labelWidth, labelHeight);
        label.setHorizontalAlignment(SwingConstants.CENTER); 
        label.setVerticalAlignment(SwingConstants.CENTER); // Centre the text 
		panel.add(label);
        label.setVisible(true);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(infoButton);
        panel.add(buttonPanel);
        buttonPanel.setBounds(10,WINDOW_HEIGHT-40,20,20);
        

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton) {
            frame.dispose(); // Close the launch window
            Game.main(new String[]{}); // Start the game by calling the main method of the Game class
        }
    }

    public static void main(String[] args) {
        new Launch(); // Start the launch screen
        //new HowTo();
        

    }
    
}
