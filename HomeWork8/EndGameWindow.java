package DaGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class EndGameWindow extends JFrame {
    private static Image DOT_O_WIN;
    private static Image DOT_X_WIN;
    private static Image nichia;



    public EndGameWindow() throws IOException {

        DOT_O_WIN = ImageIO.read(GameWindow.class.getResourceAsStream("DOT_O_WIN.png"));
        DOT_X_WIN = ImageIO.read(GameWindow.class.getResourceAsStream("DOT_X_WIN.png"));
        nichia = ImageIO.read(GameWindow.class.getResourceAsStream("nichia.png"));

        setBackground(Color.BLUE);
        setBounds(300, 300, 350, 250);
        ResultField resultField = new ResultField();
        add(resultField);
        if (GameWindow.isInitialised){
            if (Logic.checkWinLines(Logic.DOT_X) || Logic.checkWinLines(Logic.DOT_O) || Logic.isFull() ) {
                setVisible(true);
                return;
            }
        }
        setVisible(false);
    }
    static void player(Graphics g){
        g.drawImage(DOT_X_WIN, 0, 0, null);
    }
    static void ai(Graphics g){
        g.drawImage(DOT_O_WIN, 0, 0, null);
    }
    static void nichia(Graphics g){
        g.drawImage(nichia, 0, 0, null);
    }


}
